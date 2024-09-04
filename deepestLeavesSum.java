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
 //BFS involves traversing the tree level by level. Using BFS, we can track nodes at each depth level. By the time we reach the last level (deepest leaves), we can sum the values of these nodes.
 import java.util.*;
 class Solution {
     public int deepestLeavesSum(TreeNode root) {
         if (root == null) {
             return 0;
         }
 
         Queue<TreeNode> queue = new LinkedList<>();
         queue.offer(root);
         int sum = 0;
 
         while (!queue.isEmpty()) {
             sum = 0;  // Reset sum for each level
             int levelSize = queue.size();
 
             for (int i = 0; i < levelSize; i++) {
                 TreeNode node = queue.poll();
                 sum += node.val;
 
                 if (node.left != null) {
                     queue.offer(node.left);
                 }
                 if (node.right != null) {
                     queue.offer(node.right);
                 }
             }
         }
 
         return sum;
     }
 }
 