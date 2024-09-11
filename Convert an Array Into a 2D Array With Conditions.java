class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        int[]counts=new int[201];
        List<List<Integer>>result=new ArrayList<>();
        for(int num:nums){
            if(result.size()<=counts[num]){
                result.add(new ArrayList<>());//we need to add a new row to accommodate this number.
            }
            result.get(counts[num]++).add(num);
        }
        return result;
    }
}