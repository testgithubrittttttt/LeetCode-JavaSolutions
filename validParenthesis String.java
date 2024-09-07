class Solution {
    public boolean checkValidString(String s) {

        char[] arr= s.toCharArray();
        int countLeft=0,countStar=0,n=s.length();
        for(int i=0;i<n;i++) {
            if(arr[i]=='*') countStar++;
            else if(arr[i]=='(') countLeft++;
            else if(arr[i]==')') {
                if(countLeft==0 && countStar==0) return false;//f both countLeft and countStar are zero, it means there's no unbalanced ( or * available to balance the ), hence return false.
                else if(countLeft==0) countStar--;//
                else countLeft--;//If countLeft is not zero, decrement countLeft (a matching ( found for )).
            }
        }
        countStar=0;
        countLeft=0; //as countRight = countLeft (used as countRight here): Tracks the number of unbalanced ).
        for(int i=n-1;i>=0;i--) {
            if(arr[i]=='*') countStar++;
            else if(arr[i]==')') countLeft++;
            else if(arr[i]=='(') {
                if(countLeft==0 && countStar==0) return false;
                else if(countLeft==0) countStar--;
                else countLeft--;
            }
        }
        return true;
    }
}
