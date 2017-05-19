#include<sys/types.h>
//#include<unisted.h>
#include<stdio.h>
//#define BUFSIZ 255;



int main()
{
int res;
pid_t pid;
int fd[2],n;
char buf[BUFSIZ];
    //初始化信号量对象

if(pipe(fd))
{
printf("Faild!\n");
exit(-1);
}
pid=fork();
if(pid==-1)
{
printf("Faild2!\n");
close(fd[0]);
close(fd[2]);
exit(-2);
}
if(pid==0)
{
while(1){

close(fd[1]);
//wait((int *)0);
n=read(fd[0],buf,BUFSIZ-1);
buf[n]='\0';
printf("parednt:%s\n",buf);

}
}
else
{

while(1){
close(fd[0]);
fgets(buf,BUFSIZ,stdin);
write(fd[1],buf,BUFSIZ-1);


}
printf("exit");
}
}

