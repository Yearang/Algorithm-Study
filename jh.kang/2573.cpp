#include<stdio.h>
#include<queue>
using namespace std;
int nmap[301][301];
int cmap[301][301];
int dirx[4]={1,0,0,-1};
int diry[4]={0,1,-1,0};
int n,m;
bool comp(){
    queue<pair<int,int>>qi;
    int visit[301][301]={0,};
    for(int i=0;i<n;i++){
        for(int j=0;j<m;j++)
            if(cmap[i][j]) qi.push(pair<int,int>(i,j));
    }
    while(!qi.empty()){
        int cury=qi.front().first;
        int curx=qi.front().second;
        qi.pop();
        printf("y:%d x:%d",cury,curx);
        visit[cury][curx]=1;
        for(int i=0;i<4;i++){
            if(cury+diry[i]<0 || cury+diry[i]>=n || curx+dirx[i]>=m || curx+dirx[i]<0 || visit[cury+diry[i]][curx+dirx[i]]) continue;
            qi.push(pair<int,int>(cury+diry[i],curx+dirx[i]));
        }
    }
    for(int i=0;i<n;i++)
        for(int j=0;j<m;j++)
            if(cmap[i][j] && !visit[i][j]) return false;
    return true;
}
int main(){
    int day=0;
    scanf("%d %d",&n,&m);
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                scanf("%d",&cmap[i][j]);
            }
        }
    while(comp()){
        bool nonchange=true;
        printf("%d\t",day);
        day++;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                nmap[i][j]=cmap[i][j];
                for(int k=0;k<4;k++){
                    if(i+diry[k]<0 || i+diry[k]>=n || j+dirx[k]<0 || j+dirx[k] >=m || cmap[i+diry[k]][j+dirx[k]]) continue;
                    nonchange=false;
                    if(nmap[i][j]> 0)
                        nmap[i][j]--;
                    else 
                        nmap[i][j]=0;
                }
            }
        }
        for(int i=0;i<n;i++)
            for(int j=0;j<m;j++)
                cmap[i][j]=nmap[i][j];
        if(nonchange){
            printf("0\n");
            return 0;
        }
    }
    printf("%d\n",day);
}