class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        for(int i=0;i<n;i++){
            if(citations[i]>=n-i){
                return n-i;
            }
        }
        return 0;
    }
}