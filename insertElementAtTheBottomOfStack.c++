#include <iostream>
#include <stack>
using namespace std;

public void solve(stack<int>& s, int element){
    if(s.empty()){
        s.push(element);//this is the case when we don't have any element in stack so the number which is at the top is also at the bottom because it is alone.
    }
    int num=s.top();//this is our else case in which ek ek karke joh phele se elements hai onhe nikalo
    s.pop();//by pop method
    solve(s,element);//recursive call lgao kyuki jab khatam hogaa stack than push kardenge ek tarah se new element
    s.psuh(num)//feer vapis se bharte rho.
}
int main(){
}