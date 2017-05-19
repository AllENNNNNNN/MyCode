#include<signal.h>
#include<stdio.h>
void sigintctl(int signo)
{
  printf("\nKb interruptet!\n");
  sleep(1);
  printf("\nQuit\n");
  remove("test.txt");
  printf("test.txt has been deleted\n");
  exit(0);
}
int main()
{
  FILE *f=fopen("test.txt","wb");
  if(f)
  {
  printf("test.txt has been created!\n");
  }
  else
  {
  printf("can't create test.txt");
  }
  fclose(f);
  signal(SIGINT,sigintctl);
  while(getchar()!='q');
  remove("test.txt");
  printf("test.txt has been deleted\n");
}
