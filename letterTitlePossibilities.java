class Solution {
    public int numTilePossibilities(String tiles) {
        // purpose of this array is to count the occurrences of each letter in the tiles
        int[] count = new int[26];
        for (char c : tiles.toCharArray())
            count[c - 'A']++;//increments the count at the index corresponding to the letter c. The expression c - 'A' converts the character c into its corresponding index (e.g., 'A' -> 0, 'B' -> 1, ..., 'Z' -> 25).
        return dfs(count);//recursive function designed to explore all possible sequences.
    }

    int dfs(int[] arr) {
        int sum = 0;
        for (int i = 0; i < 26; i++) {
            if (arr[i] == 0)// it means there are no more tiles of this letter, so it skips that letter.
                continue;
            sum++;//This accounts for the sequence that can be created by adding this letter.
            arr[i]--;
            sum += dfs(arr);//After the recursive call, arr[i] is incremented back by 1 to restore the original state, allowing other sequences to be explored.
            arr[i]++;
        }
        return sum;
    }
}