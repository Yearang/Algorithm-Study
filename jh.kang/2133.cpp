#include<stdio.h>
int main(){
    int n;
    scanf("%d",&n);
    if(n%2!=0) printf("0\n");
    else{
        int dp[31]; //2Xn 채우는 경우의수
        dp[1]=1;
        dp[2]=2;
        for(int i=3;i<31;i++)
            dp[i]=dp[i-1]+dp[i-2];
        printf("%d",dp[n]*2-1);
    }
}