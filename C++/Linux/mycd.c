#include<stdio.h>
#include<stdlib.h>
#include<unistd.h>


void conver(char s[],char *a[10])
{

int i=0,j=0,k=0;
		for ( i= 0; s[i] ; i++)
		{
			if(s[i]==' ')
			{
				j++;
				a[j][k]='\0';
				k=0;
				continue;
			}
			else
			{
				a[j][k++]=s[i];
			}
		}
                a[++j]=NULL;
                   for(int i=0;a[i];i++) printf("%s\n",a[i]);
}
int main()
{
char *argus[10];
for(int i=0;i<10;i++)
{
  argus[i]=(char *)malloc(sizeof(char)*10);
		memset(argus[i],0,10);
}
printf("entering main process--\n");
char s[255];
char *envp[]={0,NULL};
gets(s);
conver(s,argus);
while(strcmp(argus[0],"logout"))
{
  int pid=fork();
if(pid<0)
{
perror("Fork failed!\n");
exit(1);
}
else if(pid==0)
{
char path[20]="/bin/";
if(strcmp(argus[0],"cd")!=0)
strcat(path,argus[0]);
else
strcpy(path,argus[0]);
if(execv(path,argus)==-1)
perror("error:\n");
printf("has done\n");
exit(0);
}
else
{
wait((int *)0);
gets(s);
for(int i=0;i<10;i++)
{
free(argus[i]);
 argus[i]=(char *)malloc(sizeof(char)*10);
memset(argus[i],0,10);
}
conver(s,argus);
}
}

printf("exiting main process ---\n");
return 0;
}
