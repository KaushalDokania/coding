package challenges.june2021;
import java.util.Arrays;

public class ConstructBinaryTree {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    
    static class Solution {

        public void buildTree2(TreeNode node, int[] pre, int[] in, int low1, int high1, int low2, int high2) {
            if (low1 < 0 || low2 < 0 || high1 >=pre.length || high2 >= in.length)
                return;
            int k = Arrays.binarySearch(in, pre[low1]);             // k is the index of the next node as per in[] array
            int lcount = k - low2;                               // number of elements in left sub array
            
            node = new TreeNode(in[k]);                             // next node
            buildTree2(node.left, pre, in, low1+1, low1+lcount-1, low2, k-1);
            buildTree2(node.right, pre, in, low1+lcount, high1, k+1, high2);
            
        }

        public TreeNode buildTree(int[] preorder, int[] inorder) {
            TreeNode root = null;
            buildTree2(root, preorder, inorder, 0, preorder.length-1, 0, inorder.length-1);
            return root;
        }

        public void inOrder(TreeNode root) {
            if (root == null)
                return;
            inOrder(root.left);
            System.out.print(root.val + ",");
            inOrder(root.right);
        }

        public void preOrder(TreeNode root) {
            if (root == null)
                return;
                System.out.print(root.val + ",");
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    

    public static void main(String[] args) {
        int preorder[] = {8,9,6,12,5,7,4,10,11,2,3,15,13,14};
        int inorder[] = {6,12,9,5,8,11,10,4,2,7,3,13,15,14};
        
        TreeNode root = new Solution().buildTree(preorder, inorder);

        System.out.print("Inorder: ");new Solution().inOrder(root);
        System.out.println();
        System.out.print("Preorder: ");new Solution().preOrder(root);
        System.out.println();
        /* TreeNode root, node;
        node = root = new TreeNode(8);
        node.left = new TreeNode(9);
        node.right = new TreeNode(7);

        node = root.left;
        node.left = new TreeNode(6);
        node.right = new TreeNode(5);

        node = root.right;
        node.left = new TreeNode(4);
        node.right = new TreeNode(3);

        node = root.left.left;
        node.right = new TreeNode(12);

        node = root.right.left;
        node.left = new TreeNode(10);
        node.right = new TreeNode(2);

        node = root.right.right;
        node.right = new TreeNode(15);

        node = root.right.left.left;
        node.left = new TreeNode(11);

        node = root.right.right.right;
        node.left = new TreeNode(13);
        node.right = new TreeNode(14); */

        
    }
}
