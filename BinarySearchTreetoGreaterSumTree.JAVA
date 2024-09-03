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
    private int sum = 0;

    public TreeNode bstToGst(TreeNode root) {
        reverseInorderTraversal(root);
        return root;
    }

    private void reverseInorderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        reverseInorderTraversal(node.right);
        sum += node.val;
        node.val = sum;
        reverseInorderTraversal(node.left);
    }
}

//WORKFLOW = 
// Start from the root and traverse to the rightmost node.
// Process the rightmost node by updating its value with the cumulative sum.
// Move to the parent node, update its value with the new cumulative sum.
// Continue this process until all nodes are processed.