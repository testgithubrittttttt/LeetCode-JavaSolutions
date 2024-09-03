import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean leftToRight = true;//the first level (root level) will be traversed from left to right.

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            LinkedList<Integer> currentLevel = new LinkedList<>();//store the values of the nodes at the current level.

            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();

                // Add the current node's value to the current level based on the direction
                if (leftToRight) {//we add the current node's value to the end of the currentLevel list (standard left-to-right traversal).
                    currentLevel.addLast(currentNode.val);
                } else {// we add the current node's value to the front of the currentLevel list (reverse order for right-to-left traversal).
                    currentLevel.addFirst(currentNode.val);
                }

                // Add the children of the current node to the queue
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);// we add it to the queue for the next level.
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }

            // After finishing the current level, add it to the result list
            result.add(currentLevel);
            // Switch the direction for the next level
            leftToRight = !leftToRight;
        }

        return result;
    }
}
