class Solution {
public:
    int brokenCalc(int startValue, int target) {
        int result=0;
        while(target>startValue)
        {
            result++;//yeh eslie bahaya kyu ki same nhi hai toh ek baar toh operation lgega he atleast
            //for even case
            if(target%2==0)//multiple hai agr toh osko
                target=target/2;//otni baar he divide bhi kro
            else//for odd cases
                target+=1;
        }
        result=result+(startValue-target);//at the end applyting the - operation.
        return result;
    }
};