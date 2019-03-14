#include<stdio.h>
#include<algorithm>
using namespace std;
struct country{
    int n,g,s,b;
    country(int n, int g,int s,int b):n(n),g(g),s(s),b(b){};
    country();
}arr[1001];
bool operator < (const country &a, const country &b){
    if(a.g!=b.g) return a.g < b.g;
    else if(a.s!=b.s) return a.s<b.s;
    else if(a.b!=b.b) return a.b<b.b;
}
int main(){
    int n,k;
    scanf("%d %d",&n,&k);
    int x,y,z,o;
    for(int i=0;i<n;i++){
        for(int j=0;j<n;j++){
            scanf("%d %d %d %d",&x,&y,&z,&o);
            arr[x]=country(x,y,z,o);
        }
    }
    sort(arr,arr+n);
    for(int i=0;i<n;i++){
        if(arr[i].n==k){
            
        }
    }
}