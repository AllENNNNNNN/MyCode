function [] = ResizeImage ()  %����m��ʾ�����
file_path = 'D:\DataSet\����\�м䳵��\';
file_new_path = 'D:\DataSet\����\64\';
img_path_list = dir (strcat(file_path,'*.jpg'));
img_num = length (img_path_list);
for i=1:img_num
    image_name = img_path_list(i).name;
    image = imread(strcat(file_path,image_name));
    image1 = imresize(image,[64 64]);
    imwrite(image1 ,strcat(file_new_path,image_name)); 
end
end
