#include<stdio.h>
#include<vector>
#define MAX_LENGTH 20
using namespace std;
struct CourseEntry {
    char name[MAX_LENGTH]; //과목의 이름
    struct CourseEntry* prerequisites; //선수 과목들
    int n_prerequisites; //선수 과목의 수
    float difficulty; //과목의 난이도
};
int main(){
    CourseEntry t1,t2,t3;
    t1.prerequisites = &t2;
    t1.prerequisites = &t3;
     
}
