public class redundantBrackets {
    public static void redundant_Bracket(string &s){
        Stack<Character> stack= new Stack<>();
        for(int i=0;i<s.length;i++){
            char ch=s[i];
            if(ch=="("||ch=="+"||ch=="-"||ch=="*"||ch=="/"){
                stack.push(ch);
            }
            else{//ab yha pe matlab nikalta hai ki humme closing bracket mil gya hai
                if(ch==")"){
                    boolean isRedundant = true;
                }
                else{
                    while(s.empty()!="("){
                        char top=st.top();
                        if(top=="+"||top=="-"||top=="*"||top=="/"){
                            isRedundant = false;
                        }
                        st.pop();
                    }
                    if(isRedundant=true){
                        return true;
                    }
                    st.pop();
                }
            }
        }
        return false;
    }
    public static void main(String args[]){

    }
}
