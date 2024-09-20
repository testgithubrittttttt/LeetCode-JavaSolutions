import java.util.Scanner;

public class inhabitantOfTheDeepSea {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt(); // Number of test cases

        while (t-- > 0) {
            int n = scanner.nextInt(); // Number of ships
            long k = scanner.nextLong(); // Number of attacks
            int[] a = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }

            int left = 0;
            int right = n - 1;
            int sunkShips = 0;

            boolean leftTurn = true; // Start attacking from the left

            while (k > 0 && left <= right) {
                if (leftTurn) {
                    if (a[left] <= k) {
                        // If current ship at left can be sunk
                        k -= a[left];
                        sunkShips++;
                        left++;
                    } else {
                        // Attack remaining attacks, reduce k by a[left]
                        k = 0;
                    }
                } else {
                    if (a[right] <= k) {
                        // If current ship at right can be sunk
                        k -= a[right];
                        sunkShips++;
                        right--;
                    } else {
                        // Attack remaining attacks, reduce k by a[right]
                        k = 0;
                    }
                }
                leftTurn = !leftTurn; // Alternate turns
            }

            System.out.println(sunkShips);
        }

        scanner.close();
    }
}
