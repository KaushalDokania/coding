package DataStructures.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class InorderTraversal {
    static class TreeNode {
        int data;
        TreeNode left, right;
      
        TreeNode(int item)
        {
            data = item;
            left = right = null;
        }
    }

    public static void inorderTraversal(TreeNode root) {
        if (root == null)
            return;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            System.out.print(node.data + ", ");
            if (node.left != null)
                q.add(node.left);
            if (node.right != null)
                q.add(node.right);
        }
    }

    public static void main(String[] args) {
        TreeNode node, root;
        root = new TreeNode(1);
        
        node = root;
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);

        node = root.left;
        node.left = new TreeNode(4);
        node.right = new TreeNode(5);

        node = root.right;
        node.left = new TreeNode(6);
        node.right = new TreeNode(7);

        node = root.left.left;
        node.left = new TreeNode(8);
        node.right = new TreeNode(9);

        node = root.left.right;
        node.left = new TreeNode(10);
        node.right = new TreeNode(11);

        node = root.right.left;
        node.left = new TreeNode(12);
        node.right = new TreeNode(13);

        node = root.right.right;
        node.left = new TreeNode(14);
        node.right = new TreeNode(15);

        inorderTraversal(root);
    }
}
