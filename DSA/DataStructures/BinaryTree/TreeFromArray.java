package DataStructures.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class TreeFromArray {
    static class TreeNode {
        int data;
        TreeNode left, right;
        TreeNode() {}
        TreeNode(int data) {
            this.data = data;
            left = right = null;
        }
    }

    static void printInorder(TreeNode root) {
        if (root == null)
            return;
        printInorder(root.left);
        System.out.print(root.data + ", ");
        printInorder(root.right);
    }

    static TreeNode createTreeFromLevelOrderArray(int[] input) {
        int i = 0;
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode root = new TreeNode(input[i++]);           // is is now 1
        q.add(root);
        while (!q.isEmpty() && i < input.length) {
            TreeNode node = q.poll();
            if (node == null)
                continue;
            if (i < input.length) {
                if (input[i] != -1)
                    node.left = new TreeNode(input[i]);
                q.add(node.left);
                i++;
            }
            if (i < input.length) {
                if (input[i] != -1)
                    node.right = new TreeNode(input[i]);
                q.add(node.right);
                i++;
            }
        }
        return root;
    }

    public static void main(String[] args) {
        // int arr[] = {1,2,3,-1,-1,-1,-1};              // -1 means null node
        int arr[] = {1,4,3,2,4,2,5,-1,-1,-1,-1,-1,-1,4,6,1};              // -1 means null node

        TreeNode root = createTreeFromLevelOrderArray(arr);
        
        printInorder(root);
        
    }
}
