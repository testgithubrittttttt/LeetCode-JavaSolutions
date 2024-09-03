import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int d) {
        data = d;//this will stores the value of the data of the nodes.
        left = right = null;//this basically helps in making binary tree which have the value for the left and right nodes
    }
}

public class BinaryTree {

    // Method to build tree recursively
    static Node buildTree(Node root, Scanner sc) {
        System.out.println("Enter the data: ");
        int data = sc.nextInt();
        root = new Node(data);//we use the above constructor for putting values in root and making its branches with left and right node

        if(data == -1) {
            return null;
        }

        System.out.println("Enter data for inserting in left of " + data);
        root.left = buildTree(root.left, sc);
        System.out.println("Enter data for inserting in right of " + data);
        root.right = buildTree(root.right, sc);
        return root;
    }

    // Method to perform level order traversal = Performs a level-order traversal (breadth-first search) of the binary tree.
    static void levelOrderTraversal(Node root) {
        if (root == null) return;

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while (!q.isEmpty()) {
            Node temp = q.poll();

            if (temp == null) {//eska matlab ek level complete ho chuka hai
                System.out.println();
                if (!q.isEmpty()) {
                    q.add(null);
                }
            } else {
                System.out.print(temp.data + " ");
                if (temp.left != null) {
                    q.add(temp.left);
                }
                if (temp.right != null) {
                    q.add(temp.right);
                }
            }
        }
    }

    // Inorder traversal
    static void inorder(Node root) {
        if (root == null) return;
        // basically we are following the route of left node then right = refer the notes
        inorder(root.left);//left
        System.out.print(root.data + " ");//node value
        inorder(root.right);//right value
    }

    // Preorder traversal
    static void preorder(Node root) {
        if (root == null) return;
        // basically we are following the route of node left then right = refer the notes
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    // Postorder traversal
    static void postorder(Node root) {
        if (root == null) return;
        // basically we are following the rout of left right and node = refer the notes
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data + " ");
    }

    // Method to build tree from level order input
    static void buildFromLevelOrder(Node root, Scanner sc) {
        Queue<Node> q = new LinkedList<>();

        System.out.println("Enter data for root");
        int data = sc.nextInt();
        root.data = data;

        q.add(root);

        while (!q.isEmpty()) {
            Node temp = q.poll();

            System.out.println("Enter left node for: " + temp.data);
            int leftData = sc.nextInt();

            if (leftData != -1) {
                temp.left = new Node(leftData);
                q.add(temp.left);
            }

            System.out.println("Enter right node for: " + temp.data);
            int rightData = sc.nextInt();

            if (rightData != -1) {
                temp.right = new Node(rightData);
                q.add(temp.right);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Node root = new Node(-1);

        buildFromLevelOrder(root, sc);
        levelOrderTraversal(root);
        // Example input: 1 3 5 7 11 17 -1 -1 -1 -1 -1 -1 -1

        /*
        // Creating a Tree
        root = buildTree(root, sc);
        // Example input: 1 3 7 -1 -1 11 -1 -1 5 17 -1 -1 -1
        // Level order traversal
        System.out.println("Printing the level order traversal output");
        levelOrderTraversal(root);

        System.out.println("Inorder traversal is: ");
        inorder(root);

        System.out.println("\nPreorder traversal is: ");
        preorder(root);

        System.out.println("\nPostorder traversal is: ");
        postorder(root);
        */
    }
}
