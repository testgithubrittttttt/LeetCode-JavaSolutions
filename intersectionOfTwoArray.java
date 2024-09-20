class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();//for finding the unique hashset is one of the aproaches to follow
        for (int num : nums1) {
            set1.add(num);//ess line se humare pass set1 mai saree unique elements honge num1 ke
        }
    // oper jaisa same he ab hum ek or baar kaam karenge num2 ke liye
        Set<Integer> intersection = new HashSet<>();
        for (int num : nums2) {
            if (set1.contains(num)) {//checking ki set1 ka koi element num of num2 hai 
                intersection.add(num);//agr hai then we are dding it in our answer array(intersection)
            }
        }

        int[] result = new int[intersection.size()];//
        // Convert the result set to an array
        int i = 0;
        for (int num : intersection) {
            result[i++] = num;
        }

        return result;
    }
}