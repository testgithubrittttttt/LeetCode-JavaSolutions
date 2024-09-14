public class Solution {
    public int twoEggDrop(int n) {
        int x = 1;
        while (x * (x + 1) / 2 < n) {//This sum represents the total number of floors you can cover with x moves in the worst case.
            x++;
        }
        return x;
    }
}
