class Solution {
    public ListNode insertGreatestCommonDivisors(ListNode head) {
       ListNode temp=head;//this is basically apna joh gcd ke baad vala node
       ListNode prev=head;//this is basically pana gcd se phele vala node
       if(head==null||head.next==null){
        return head;//agr head tak he hai LL then head he answer hai
       }
       while(temp!=null && temp.next!=null){//loop chalani hai jaba tak null na mille this is the basic and base condition for every LL
        prev=temp;//move prev to the current temp
        if(temp.next!=null)
        temp=temp.next;
        int x=prev.val,y=temp.val;
        int ans=greatestCMD(x,y);
        ListNode newNode=new ListNode(ans);
        prev.next=newNode;
        newNode.next=temp;

       }
       return head;

    }
    private int greatestCMD(int a,int b){
        int x=Math.min(a,b);//The GCD of two numbers cannot be larger than the smaller of the two numbers. Hence, we start by finding the smaller value of a and b using Math.min(a, b) and store it in x.

        for(int i=x;i>1;i--){
            if(a%i==0 && b%i==0){
                return i;//joh common aya voh othaliya
            }
        }
        return 1;
    }
}


// WE CAN SLO USE THIS function to find gcd = 
private int greatestCMD(int a, int b) {
    while (b != 0) {
        int temp = b;
        b = a % b;
        a = temp;
    }
    return a;//if b becomes zero.S
}