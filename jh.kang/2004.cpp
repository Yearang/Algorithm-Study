#include<stdio.h>
#include<algorithm>
using namespace std;
int main(){
    int n,m;
    scanf("%d %d",&n,&m);// m에 작은수를 저장하는게 이득
    m=min(m,n-m);
    if(n>=1000 && m>=20){
        int five=0;
        int start;
        for(int i=n-m+1;i<n-m+6;i++){
            if(i%5==0) start=i;
        }
        int tmp;
        printf("%d",start);
        for(int i=start;i<=n;i+=5){
            tmp=i;
            while(tmp%5==0){
                tmp/=5;
                five++;
            }
        }
        for(int i=10;i<=m;i+=5){
            tmp=i;
            while(tmp%5==0){
                tmp/=5;
                five--;
            }
        }
        printf("%d",five);
    }
    else{
        int five=0;
        int two=0;
        int tmp;
        for(int i=n-m+1;i<=n;i++){
            tmp=i;
            while(tmp%5==0){
                five++;
                tmp/=5;
            }
            while(tmp%2==0){
                two++;
                tmp/=2;
            }
        }
        for(int i=2;i<=m;i++){
            tmp=i;
            while(tmp%5==0){
                five--;
                tmp/=5;
            }
            while(tmp%2==0){
                two--;
                tmp/=2;
            }
        }
        printf("%d",min(two,five));
    }
}