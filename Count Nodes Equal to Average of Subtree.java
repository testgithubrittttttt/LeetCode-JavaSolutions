/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private int count = 0;

    public int averageOfSubtree(TreeNode root) {
        dfs(root);
        return count;
    }

    private int[] dfs(TreeNode node) {
        if (node == null) {
            return new int[]{0, 0}; // {sum, count}
        }

        int[] left = dfs(node.left);
        int[] right = dfs(node.right);

        int sum = left[0] + right[0] + node.val;
        int numOfNodes = left[1] + right[1] + 1;

        if (node.val == sum / numOfNodes) {
            count++;
        }

        return new int[]{sum, numOfNodes};
    }
}
