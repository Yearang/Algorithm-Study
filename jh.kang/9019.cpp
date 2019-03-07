#include<stdio.h>
#include<queue>
#include<vector>
using namespace std;
int D(int n){
    return (n<<1) >10000 ? (n<<1) %10000 : n<<1;
}
int S(int n){
    return n==0 ? 9999 : n-1;
}
int L(int n){
    if(n==0) return 0;
    int n1=n%10;
    int n2=(n/10)%10;
    int n3=(n/100)%10;
    int n4=n/1000;
    return n4+n1*10+n2*100+n3*1000;
}
int R(int n){
    if(n==0) return 0;
    int n1=n%10;
    int n2=(n/10)%10;
    int n3=(n/100)%10;
    int n4=n/1000;
    return n2+n3*10+n4*100+n1*1000;
}
struct node{
    int val;
    int route;
    node(int val,int route): val(val), route(route){}
};
int main()
{
    int t;
    scanf("%d",&t);
    while(t--){
        int a,b;    //before ,after
        int visit[10000]={0,};
        int ans;
        scanf("%d %d",&b,&a);
        queue<node>qi;
        qi.push(node(b,0));
        visit[b]=1;
        while(!qi.empty()){
            int cur=qi.front().val;
            int curroute=qi.front().route;
            //printf("%d\n",cur);

            if(cur==a){
                ans=curroute;
                break;
            }
            qi.pop();
            int d=D(cur);
            int s=S(cur);
            int l=L(cur);
            int r=R(cur);
            if(!visit[d])
            {    
                qi.push(node(d,curroute*5+1));
                visit[d]=1;
            }
            if(!visit[s])
            {    
                qi.push(node(s,curroute*5+2));
                visit[s]=1;
            }
            if(!visit[l])
            {    
                qi.push(node(l,curroute*5+3));
                visit[l]=1;
            }
            if(!visit[r])
            {    
                qi.push(node(r,curroute*5+4));
                visit[r]=1;
            }
        }
        vector<char>vec;
        while(ans){
            switch(ans%5){
                case 1:
                    vec.push_back('D');
                    break;
                case 2:
                    vec.push_back('S');
                   break;
                case 3:
                    vec.push_back('L');
                    break;
                case 4:
                    vec.push_back('R');
                    break;
            }
            ans/=5;
        }
        while(!vec.empty()){
            printf("%c",vec.back());
            vec.pop_back();
        }
        printf("\n");
    }
}