#include<stdio.h>
#include<vector>
#include<algorithm>
#include<queue>
using namespace std;
vector<pair<int,int>>vec[10001];    //e,time
pair<int,int> ans[10001];   //time,nums
int visited[10001]={0,};
int main(){
    int n,m;
    scanf("%d %d",&n,&m);
    int s,e,t;  //start,end,time
    for(int i=0;i<m;i++) {
        scanf("%d %d %d",&s,&e,&t);
        visited[e]++;
        vec[s].push_back(pair<int,int>(e,t));
    }
    scanf("%d %d",&s,&e);
    queue<int>qi;
    for(int i=0;i<n;i++){
        ans[i]=pair<int,int>(0,0);
    }
    ans[s]=pair<int,int>(0,0);
    qi.push(s);
    while(!qi.empty()){
        int cur=qi.front();
        qi.pop();
        for(int i=0;i<vec[cur].size();i++){
            int tmp=vec[cur][i].first;
            visited[tmp]--;
            if(!visited[tmp]) qi.push(tmp);
            if(ans[tmp].first<ans[cur].first+vec[cur][i].second){
                ans[tmp].first=ans[cur].first+vec[cur][i].second;
                ans[tmp].second=ans[cur].second+1;
            }
            else if(ans[tmp].first==ans[cur].first+vec[cur][i].second){
                ans[tmp].second=(ans[cur].second+1)+ans[tmp].second;
            }
        }
    }
    printf("%d\n%d",ans[e].first,ans[e].second);
}