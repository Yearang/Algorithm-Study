#include<stdio.h>
#include<algorithm>
#include<string.h>
#include<map>
using namespace std;
int main(){
    int tmp[3];
    map<char,int>m;
    for(int i=0;i<3;i++)scanf("%d",&tmp[i]);
    sort(tmp,tmp+3);
    m['A']=tmp[0];
    m['B']=tmp[1];
    m['C']=tmp[2];
    char sentence[3];
    scanf("%s",sentence);
    for(int i=0;i<strlen(sentence);i++){
        printf("%d ",m[sentence[i]]);
    }
}