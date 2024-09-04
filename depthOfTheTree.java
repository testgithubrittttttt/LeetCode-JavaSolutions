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
    public int maxDepth(TreeNode root) {
      // Base case: if the node is null, return 0
        if (root == null) {
            return 0;
        }

        // Recursively find the depth of the left and right subtrees
        int leftDepth = maxDepth(root.left);//left mai jatte jao jab tak voh null na ho jae
        int rightDepth = maxDepth(root.right);//jab hogya null=left then right ke liye check kro.jab yeh zero hogya then answer nikalo.

        // The maximum depth is 1 plus the greater depth of the two subtrees
        return 1 + Math.max(leftDepth, rightDepth);  
    }
}