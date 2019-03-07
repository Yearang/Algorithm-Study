#include<stdio.h>
#include<algorithm>
using namespace std;
int dp[100001][3];  //i번째 j번노드 지나는 최소값
int map[100001][3];
int main(){
    int t=1;
    while(1){
        int n;
        scanf("%d",&n);
        if(n==0) break;
        for(int i=1;i<=n;i++){
            for(int j=0;j<3;j++){
                scanf("%d",&map[i][j]);
            }
        }
        dp[1][0]=987654321;
        dp[1][1]=map[1][1];
        dp[1][2]=map[1][1]+map[1][2];
        for(int i=2;i<=n;i++){
            dp[i][0]=min(dp[i-1][1],dp[i-1][0])+map[i][0];
            dp[i][1]=min(min(dp[i-1][1],dp[i-1][2]),min(dp[i][0],dp[i-1][0]))+map[i][1];
            dp[i][2]=min(min(dp[i-1][1],dp[i-1][2]),dp[i][1])+map[i][2];
        }
        printf("%d. %d\n",t++,dp[n][1]);
    }
}