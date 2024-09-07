#include <iostream>
#include <stack>
using namespace std;

class operations{
    public:
       int *arr;//basically we want arr
       int top;//initially we put top = -1 which means currently is empty
       int size;

       operations(int size){
       this.size -> size;
       arr = new int[size];
       top=-1;
       }
       void push(int element){//push tab he hogaa jab koi hum element dalenge
           if(size-top > 1){//eska matlab hai ki available hai space for pushing the element
              top++;
              arr[top] = element;
           }
           else{//agr ab dala toh stack overflow hojaega because we don't have space in array.
              cout<< "stack overflow happens" << endl;
           }
       }
       void pop(){
        if(top>=0){//matlab ki kuch toh present ho pop karne ke liye
          top--;
        }
        else{
            cout<< "stack underflow happens" << endl;
        }
       }
       void peek(){
        if(top >= 0){//basically peek tab hi hogaa jab kuch hoo stack main and honne ke baad bhi stack ke size se jytada na hoo .
          return arr[top];
        }
        else{
          cout << "Stack is empty" << endl;//there is not top currently
          return -1;
        }
       }
       void isEmpty(){
        if(top == -1){
            cout << "stack is empty" << endl;
        }
        else{
            cout << "there is something that's why stack is not empty"
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