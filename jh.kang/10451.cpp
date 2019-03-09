#include<stdio.h>
int main(){
    int t;
    scanf("%d",&t);
    while(t--){
        int n;
        int arr[1001];
        int visit[1001]={0,};
        scanf("%d",&n);
        for(int i=1;i<=n;i++) scanf("%d",&arr[i]);
        int ans=0;
        for(int i=1;i<=n;i++){
            if(visit[i]) continue;
            ans++;
            int cur=arr[i];
            visit[cur]=1;
            do{
                visit[arr[cur]]=1;
                cur=arr[cur];
            }while(cur!=i);
        }
        printf("%d\n",ans);
    }    
}