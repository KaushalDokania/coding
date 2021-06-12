import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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

        public TreeNode getTree() {
            TreeNode root, node;
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
            node.right = new TreeNode(14);

            return root;
        }
    
        int preIndex = 0;
        HashMap<Integer, Integer> inMap = new HashMap<>();

        public void buildMap(int[] inorder) {
            for (int i=0; i<inorder.length; ++i) {
                inMap.put(inorder[i], i);
            }
        }

        public TreeNode buildTree(int[] pre, int[] in, int start, int end) {
            if (start > end)
                return null;
            
            TreeNode node = new TreeNode(pre[preIndex++]);                             // next node

            if (start == end)               // no children
                return node;

            int inIndex = inMap.get(node.val);

            node.left = buildTree(pre, in, start, inIndex-1);
            node.right = buildTree(pre, in, inIndex+1, end);
            
            return node;
        }

        public TreeNode buildTree(int[] preorder, int[] inorder) {
            buildMap(inorder);
            return buildTree(preorder, inorder, 0, inorder.length-1);
        }

    }

    

    public static void main(String[] args) {
        int preorder[] = {8,9,6,12,5,7,4,10,11,2,3,15,13,14};
        int inorder[] = {6,12,9,5,8,11,10,4,2,7,3,13,15,14};

        TreeNode root = new Solution().buildTree(preorder, inorder);
        // TreeNode root = new Solution().getTree();

        System.out.print("Preorder=> ");new Solution().preOrder(root);
        System.out.println();
        System.out.print("Inorder=> ");new Solution().inOrder(root);
        System.out.println();
        

        

        
    }
}
