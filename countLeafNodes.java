class BinaryTreeNode<T> {
    T val;
    BinaryTreeNode<T> left;
    BinaryTreeNode<T> right;

    BinaryTreeNode(T val) {
        this.val = val;
        left = null;
        right = null;
    }
}

class Solution {

    // Method to count the number of leaf nodes
    public int noOfLeafNodes(BinaryTreeNode<Integer> root) {
        int[] cnt = new int[1];  // Using an array to allow the count to be modified within the helper method
        inorder(root, cnt);
        return cnt[0];
    }

    // Helper method to perform in-order traversal
    private void inorder(BinaryTreeNode<Integer> root, int[] count) {
        // Base case: If the node is null, return
        if (root == null) {
            return;
        }

        // Recursively traverse the left subtree
        inorder(root.left, count);

        // Check if the current node is a leaf node
        if (root.left == null && root.right == null) {
            count[0]++;
        }

        // Recursively traverse the right subtree
        inorder(root.right, count);
    }
}
