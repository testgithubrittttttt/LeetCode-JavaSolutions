#include <iostream>
#include <stack>
using namespace std;

int main(){
    String str = "hello";//string whose reverse we want to put in below
    String answer = " ";//which is this one
    stack<char> my_stack;//making a stack for push and pop operations to do
    for(int i=0;i<str.length();i++){
        char ch=str[i];//we one by one take charcters in ch and 
        my_stack.push(ch);//then pushing it into the stack so that when we pop we get the reverse string(LIFO OPERATION FOLLOWED BY STACK)
    }
    while(!my_stack.empty()){//until the stack is not empty keep on iterating
        char ch=my_stack.top();//top values are putting in the ch
        answer.push_back(ch);//because from pop operation the top most is removed
        s.pop();//one by one we ger the charcters.
    }
    return 0;
}