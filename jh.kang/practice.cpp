#include<stdio.h>
#include<vector>
using namespace std;
int main(){
    vector<int>vec;
    for(int i=0;i<10;i++)
        vec.push_back(i);
    for(int i=0;i<10;i++)
        printf("%d",vec[i]);
}
