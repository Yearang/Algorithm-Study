#include<stdio.h>
#include<vector>
using namespace std;
vector<int>curans;
int len;
bool check(int k){
    int curlen=curans.size();
    //printf("\nk: %d\n",k);
    if(k<=0) return true;
    //for(int i=0;i<curlen;i++) printf("%d",curans[i]);
    for(int i=0;i<k;i++){
        if(curans[curlen-1-i]!=curans[curlen-1-k-i]) return check(k-1);
    }
    return false;
}
void backtracking(int n,int val){
    //printf("backtrack: %d %d\n",n,val);
    if(n>len || val >3 ) return;
    curans.push_back(val);
    if(check(n>>1)){
        backtracking(n+1,1);
    }
    else{
        curans.pop_back();
        backtracking(n,val+1);
        return;
    }
    if(curans.size()==len) return;
    curans.pop_back();
    backtracking(n,val+1);
}
int main(){
    scanf("%d",&len);
    backtracking(1,1);  //1짜리,
    for(int i=0;i<len;i++){
        printf("%d",curans[i]);
    }
}