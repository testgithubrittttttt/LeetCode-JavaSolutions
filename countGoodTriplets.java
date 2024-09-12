class Solution {
    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int count = 0;
        int n = arr.length;
        for (int i=0;i<n-2;i++) {
            for (int j=i+1;j<n-1;j++) {
                int first=Math.abs(arr[i]-arr[j]);//we are finding the absolute difference betwwen the two variables
                if(first<=a){//checking the condition
                for (int k=j+1;k<n;k++) {
                    int sec=Math.abs(arr[j]-arr[k]);
                    int third=Math.abs(arr[i]-arr[k]);
                    if(sec<=b && third<=c){//checking the other two conditions.
                        count++;
                    }
                }
                }
            }
        }

        return count;
    }
}