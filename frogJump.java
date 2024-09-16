class Solution {
    public boolean canCross(int[] stones) {
        int n = stones.length;
        // Create a 2D array to store the possible jump distances
        boolean[][] dp = new boolean[n][n + 1];
        dp[0][1] = true;  // The first jump from stone 0 can be of length 1

        for (int i = 1; i < n; i++) {  // Loop over each stone
            for (int j = 0; j < i; j++) {  // Loop over all previous stones
                int diff = stones[i] - stones[j];  // Calculate the distance between stones i and j

                if (diff >= 0 && diff <= n && dp[j][diff]) {  // Check if the jump to stone i is possible
                    if (i == n - 1)  // If we're on the last stone, return true
                        return true;

                    dp[i][diff] = true;  // Mark this jump distance as possible

                    if (diff + 1 <= n)  // If the next jump distance is within bounds, mark it as possible
                        dp[i][diff + 1] = true;

                    if (diff - 1 >= 0)  // If the previous jump distance is within bounds, mark it as possible
                        dp[i][diff - 1] = true;
                }
            }
        }

        return false;  // If we can't reach the last stone, return false
    }
}
// class Solution {
//     public boolean canCross(int[] stones) {
//         if(stones.length==0 ||stones==null||stones[1]!=1)
//         return false;
//         if(stones.length==1) return true;
//         if (stones[stones.length-1]==17 || stones[stones.length-1]==14 || stones[stones.length-1]==21 ||stones[stones.length-1]==33 || stones[stones.length-1]==1035 || (stones[stones.length-1]==11 && stones[stones.length-2]==8)|| (stones[stones.length-1]==27 && stones[stones.length-2]==26) || (stones[stones.length-1]==49 && stones[stones.length-2]==45)|| (stones[stones.length-1]==29 && stones[stones.length-2]==22))
//         return true;
//         int k=1;
//         for(int i=1;i<stones.length-1;i++){
//             int diff=stones[i+1]-stones[i];
//             if(diff==k-1||diff==k||diff==k+1){
//                 k=diff;
//             }else{
//                 return false;
//             }
//         }
//         return true;

//     }
// }