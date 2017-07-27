function [ numberofcars ] = NightDetect(fileName,position)
%UNTITLED �˴���ʾ�йش˺�����ժҪ
%   �˴���ʾ��ϸ˵��
addpath('./resouce');
addpath('./image')
tracks = initializeTracks();
nextId=1;
obj=SetUpSystemObject();
Count=obj.reader.NumberOfFrame;
for ii=1:Count
    frame=obj.reader.read(ii);
    [centroids, bboxes] = detectObjects(frame);
    predicNewLocationOfTracks();
    [assignments,unassignedTracks,unassignedDetections]=detectionToTrackAssigment();
    updateAssignedTracks();
    updateUnassignedTracks();
    
    deleteLostTracks();
    
    createNewTracks();
    for j=1:length(tracks)
        bbox=tracks(j).bbox;
        lable=tracks(j).id;
        videoFrame = insertObjectAnnotation(videoFrame, 'rectangle',bbox,lable,'Color','red'); %�����ٽ����ʾ����
    end
   % imshow(videoFrame);
    [~,name,~]=fileparts(fileName);
     imwrite(videoFrame,['./image/Result',name,num2str(ii),'.jpg']);
    
    % imshow(frame);
end

CountOfCar=0;
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
    function obj=SetUpSystemObject()
        
        obj.reader=VideoReader(fileName);
        obj.detector = vision.ForegroundDetector('NumGaussians', 3, ...
            'NumTrainingFrames', 40, 'MinimumBackgroundRatio', 0.7);
        obj.blobAnalyser = vision.BlobAnalysis('BoundingBoxOutputPort', true, ...
            'AreaOutputPort', true, 'CentroidOutputPort', true, ...
            'MinimumBlobArea', 50);
        obj.position =position;
    end
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
    function tracks = initializeTracks()
        % create an empty array of tracks
        tracks = struct(...
            'id', {}, ...
            'bbox', {}, ...
            'kalmanFilter', {}, ...
            'age', {}, ...
            'totalVisibleCount', {}, ...
            'consecutiveInvisibleCount', {});
    end
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
    function [centroids, bboxes] = detectObjects(frame)
        R=frame(:,:,1);
        G=frame(:,:,2);
        B=frame(:,:,3);
        [m,n,c]=size(frame);
        for i=1:m
            for j=1:n
                C(i,j)=R(i,j)-max(G(i,j),B(i,j))-2*abs(G(i,j)-B(i,j));
            end
        end
        
        % subplot(121), imshow(C);
        thresh=graythresh(C);
        gray=im2bw(C,thresh);
        %   subplot(122) , imshow(gray);
        
        [area, centroids, bboxes] = obj.blobAnalyser.step(gray); %���Ƶ������Ϣ
        
        videoFrame=insertShape(frame,'Rectangle',obj.position,'LineWidth', 5);
        %   videoFrame=insertShape(videoFrame,'Rectangle',bboxes,'LineWidth', 2);
        
        lightbboxes=zeros(0,4);             %��ʼ��ÿ������⵽�ĳ��Ƶ� bbox centoid
        lightcentroids=zeros(0,2);
        lightarea=zeros(0,1);
        
        j=1;
        [m,n]=size(bboxes);
        
        for i=1:m              %������������Ȧ�еķ�����������ͨ����ֵ��lightcentroids��lightbboxes��ɸѡ
            if(bboxes(i,2)>obj.position(2)&&bboxes(i,2)<(obj.position(2)+obj.position(4))&&single(bboxes(i,3))/single(bboxes(i,4))<3&&single(bboxes(i,3))/single(bboxes(i,4))>1/3)
                lightcentroids(j,:)=centroids(i,:);
                lightbboxes(j,:)=bboxes(i,:);
                lightarea(j,:)=area(i,:);
                j=j+1;
            end
        end
        car=zeros(0,4);
        n=1;
        
        videoFrame=insertShape(videoFrame,'Rectangle',lightbboxes,'LineWidth', 2,'Color','Red');%��ʱlightbboxes��ɸѡ�����ĵ�������
        [m,~]=size(lightbboxes);
        flag=ones(1,m);
        for i=1:m-1         %����ƥ��  ����car��ʾ����⵽�ĳ���
            for j=i+1:m;
                d=lightcentroids(j,1)-lightcentroids(i,1);%�������ƺ������
                k=lightarea(j,:)/lightarea(i,:);%���������
                if(flag(i)&flag(j)&d< 280)  %ƥ�䵽
                    w=lightbboxes(j,1)+lightbboxes(j,3)-lightbboxes(i,1); %��������������Χ��Ŀ��
                    h=max(lightbboxes(i,4),lightbboxes(j,2)+lightbboxes(j,4)-lightbboxes(i,2));%�߶�
                    car(n,:)=[lightbboxes(i,1),lightbboxes(i,2),w,h];%����car
                    flag(i)=0;
                    flag(j)=0;
                    n=n+1;
                end
            end
        end
        
        bboxes=car;     %��car��ֵ��bboxes
        centroids=[bboxes(:,1)+bboxes(:,3)/2,bboxes(:,2)+bboxes(:,4)/2];  %����ͼ��
        videoFrame=insertShape(videoFrame,'Rectangle',bboxes,'LineWidth', 2);
        
        %    subplot(121),imshow(videoFrame);
        %   subplot(122),imshow(gray);
        
        
        
    end
    function predicNewLocationOfTracks()
        for i=1:length(tracks)
            bbox=tracks(i).bbox;
            predictedCentroid=predict(tracks(i).kalmanFilter);
            predictedpoint=[predictedCentroid(1)-bbox(3)/2,predictedCentroid(2)-bbox(4)/2];
            tracks(i).bbox=[predictedpoint,bbox(3:4)];
        end
    end
    function [assignments,unassignedTracks,unassignedDetections]=detectionToTrackAssigment()
        nTracks=length(tracks);
        nDetections=size(centroids,1);
        cost=zeros(nTracks,nDetections);
        for i=1:nTracks    %���㻨�Ѿ���
            cost(i,:)=distance(tracks(i).kalmanFilter,centroids);
        end
        costOfNonAssignment=40;
        [assignments,unassignedTracks,unassignedDetections]=assignDetectionsToTracks(cost,costOfNonAssignment);
        %������
        
    end
    function updateAssignedTracks()
        numAssignedTracks=size(assignments,1);
        for i=1:numAssignedTracks
            trackIdx=assignments(i,1);
            detectionIdx=assignments(i,2);
            centroid=centroids(detectionIdx,:);
            bbox=bboxes(detectionIdx,:);
            correct(tracks(trackIdx).kalmanFilter,centroid);
            tracks(trackIdx).bbox=bbox;
        end
    end
    function updateUnassignedTracks()
        for i=1:length(unassignedTracks)
            ind=unassignedTracks(i);
            tracks(ind).age=tracks(ind).age+1;
            tracks(ind).consecutiveInvisibleCount=tracks(ind).consecutiveInvisibleCount+1;
            %����Ŀ��û��ûƥ����������֡��
        end
    end
    function deleteLostTracks()
        if isempty(tracks)
            return ;
        else
            invisibleForTooLong=1;
            
            for i=1:length(unassignedTracks)
                ind=unassignedTracks(i);
                if(tracks(ind).consecutiveInvisibleCount> invisibleForTooLong|tracks(ind).bbox(1,2)>(obj.position(1,2)+obj.position(1,4)))
                    %��Ŀ��δ���ֵ�֡���������Ŀ�겻�������߿���ʱ��ɾ��Ŀ��
                    tracks=tracks(~ind);
                end
            end
        end
    end
    function createNewTracks()
        centroids=centroids(unassignedDetections,:);
        bboxs=bboxes(unassignedDetections,:);
        
        for i=1:size(centroids,1)
            centroid=centroids(i,:);
            bbox=bboxs(i,:);
            if(bbox(1,2)>obj.position(1,2)+30) %�˴�Ϊ�˷�ֹ�Ѿ����������߿��б�����֮��Ŀ�궪ʧ�����������ֶ������ظ�����
                return;
            end
            kalmanFilter=configureKalmanFilter('ConstantVelocity',centroid,[200,50],[100,25],200);
            newTrack=struct('id',nextId,'bbox',bbox,'kalmanFilter',kalmanFilter,...
                'age',1,'totalVisibleCount',1,'consecutiveInvisibleCount',0);
            tracks(end+1)=newTrack;
            nextId=nextId+1;
        end
    end



numberofcars=nextId-1;
end

