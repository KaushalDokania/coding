package DataStructures.BinaryTree;

import java.util.Arrays;

/* Binary Tree Inorder traversal withrout recursion without stack */
public class MorrisTraversal {

    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode() {}

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public void morrisTraversal(TreeNode root) {
        TreeNode pre = null;                    // predecessor node
        while (root != null) {
            if (root.left != null) {
                // connect threading for root
                pre = root.left;
                while (pre.right != null && pre.right != root)
                    pre = pre.right;
                
                if (pre.right == null) {        // construct the threading
                    pre.right = root;
                    root = root.left;
                } else {                        // the threading already exists
                    pre.right = null;
                    System.out.println(root.val);
                    root = root.right;
                }
            } else {
                System.out.println(root.val);
                root = root.right;
            }
        }
    }

    public static void main(String[] args) {
        String str = "lsdnflk";
        Arrays.asList(1,2);    
    }
}
