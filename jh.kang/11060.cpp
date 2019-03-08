#include<stdio.h>
#include<algorithm>
using namespace std;
#define inf 987654321
int main(){
    int n;
    int arr[2001];
    int dp[2001];
    scanf("%d",&n);
    for(int i=0;i<n;i++){
        scanf("%d",&arr[i]);
        dp[i]=inf;
    }
    dp[0]=0;
    for(int i=0;i<n;i++){
        for(int j=i+1;j<=i+arr[i];j++){
            dp[j]=min(dp[i]+1,dp[j]);
        }
    }
    if(dp[n-1]==inf) {printf("-1\n");}
    else {printf("%d",dp[n-1]);}
}