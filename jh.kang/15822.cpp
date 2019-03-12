#include<stdio.h>
typedef long long ll;
int main(){
    int l;
    char sentence[51];
    scanf("%d",&l);
    scanf("%s",sentence);
    ll m=1;
    ll total=0;
    for(int i=0;i<l;i++){
        total+=(sentence[i]-96)*m;
        total%=1234567891;
        m*=31;
        m%=1234567891;
    }
    printf("%lld",total);
}