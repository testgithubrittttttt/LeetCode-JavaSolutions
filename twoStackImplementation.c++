#include <iostream>
#include <stack>
using namespace std;

class twoStack{
    public:
       int *arr;//basically we want arr
       int top1;//initially we put top = -1 which means currently is empty we iterate it rom left to right
       int top1;//initially we put top = -size which means currently is empty this from right to left
       int size;

       twoStack(int size){
       this.size -> size;
       arr = new int[size];
       top=-1;
       top2=size;
       }
      void push1(int element){//push tab he hogaa jab koi hum element dalenge
          if(top2 - top1 > 1){//eska matlab hai ki kum se kum ek ka toh difference honna chahiye
            top1 ++;
            arr[top1] = element;
          }
          else{//agr ab dala toh stack overflow hojaega because we don't have space in array.
            cout<< "stack overflow happens" << endl;
          }
      }
      void push2(int element){//push tab he hogaa jab koi hum element dalenge
           if(top2 - top1 > 1){//eska matlab hai ki available hai space for pushing the element
              top2 --;//kyu ki ek tarah se hum piche ja rhe hai start point tak ke liye
              arr[top2] = element;
           }
       }
       void pop1(){
        if(top1>=0){//matlab ki kuch toh present ho pop karne ke liye
          int ans = arr[top1];
          top--;
          return ans;
        }
       }
       void pop2(){
        if(top2<size){//matlab ki kuch toh present ho pop karne ke liye
          int ans = arr[top2];
          top2--;
          return ans;
        }
        else{
            cout<< "stack underflow happens" << endl;
        }
       }
}
int main(){
    Stack st(5);//this is basically our creation or initialisation of stack in c++;
    //push operation.
    st.push(2);
    st.push(3);
    cout<<"print the top number in stack = "<< st.peek() << endl;
    //pop operation.
    st.pop();
    cout<<"print the top number in stack = "<< st.peek() << endl;
    return 0;
    // if(st.empty()){
    //     cout <<"the stack is currently empty bro" << endl;
    // }
    // else{
    //     cout<<"you can put numbers whatsoever you want to"<< endl;
    // }
    
    // cout<< "the length of the stack currently is = " << st.size() << endl;

    // return 0;
}