class Solution {
    public boolean checkIfCanBreak(String s1, String s2) {

        // Step 1: Convert the strings to char arrays and sort them
        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        // Step 2: Check if one string can break the other
        boolean s1BreaksS2 = true;
        boolean s2BreaksS1 = true;

        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] < arr2[i]) {
                s1BreaksS2 = false;
            }
            if (arr2[i] < arr1[i]) {
                s2BreaksS1 = false;
            }
        }

        // Step 3: Return true if either s1 can break s2 or s2 can break s1
        return s1BreaksS2 || s2BreaksS1;
    }
}