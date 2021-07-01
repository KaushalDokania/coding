package DataStructures.BST;

import DataStructures.BinaryTree.BinaryTree;
import DataStructures.BinaryTree.TreeNode;

public class BinarySearchTree extends BinaryTree { 
    public BinarySearchTree() {}
    
    public BinarySearchTree(Integer[] input) {
        super(input);
    }

    TreeNode insertInOrder(TreeNode root, int data) {
        if (root == null)
            return new TreeNode(data);              // root is null so creating and returning the root node
        
        if (data < root.data)
            root.left = insertInOrder(root.left, data);
        else if (data > root.data)
            root.right = insertInOrder(root.right, data);
        
        return root;
    }

    TreeNode delete(TreeNode root, int data) {
        if (root == null)
            return null;
        
        if (data < root.data)
            root.left = delete(root.left, data);
        else if (data > root.data)
            root.right = delete(root.right, data);
        else {          // root.data == data
            if (root.left == null)              // left child or both children are null
                return root.right;
            else if (root.right == null)        // only right child is null
                return root.left;
            
            // both children are present
            root.data = minValue(root.right);

            root.right = delete(root.right, root.data);
        }
        return root;
    }

    int minValue(TreeNode root) {
        while (root.left != null) {
            root = root.left;
        }
        return root.data;
    }

    public int minValue() {
        return this.minValue(super.root);
    }

    public static void main(String[] args) {
        // int input[] = {10,5,15,3,6,12,20};              // -1 means null node
        Integer input[] = {10,5,15,null,null,13,17,11,null,16,30};
        // int input[] = {10,5,15,-1,-1,13,17,11,-1,16,30};
        System.out.println("Creating binary tree from input array ...");
        BinarySearchTree tree = new BinarySearchTree(input);
        // tree.createTreeFromLevelOrderArray(input);
        // System.out.println("Binary tread created");

        // System.out.println("Level Order(recursive):");
        // tree.printLevelOrder();

        System.out.print("Level Order(iterative): ");
        System.out.println(tree.levelOrderIterative());

        System.out.print("Inorder: ");
        tree.printInorder();
        
        // System.out.println("Minimum: " + tree.minValue());

        // System.out.println("Deleting 3");
        // tree.delete(tree.root, 3);
        // System.out.print("Level Order: ");
        // System.out.println(tree.levelOrderIterative());
    }
}
