package DataStructures.BST;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import DataStructures.BinaryTree.TreeNode;

public class BalanceBST {

    static class Solution {
        public int height(TreeNode root) {
            if (root == null)
                return 0;
            int lh = height(root.left);
            int rh = height(root.right);
            return (lh > rh) ? lh + 1 : rh + 1;
        }
        
        public TreeNode sortedArrayToBalancedBSTUtil(List<Integer> inorder, int start, int end) {
            if (start > end)
                return null;
            int mid = start + (end - start)/2;
            TreeNode root = new TreeNode(inorder.get(mid));
            root.left = sortedArrayToBalancedBSTUtil(inorder, start, mid-1);
            root.right = sortedArrayToBalancedBSTUtil(inorder, mid+1, end);
            return root;
        }

        public TreeNode sortedArrayToBalancedBST(List<Integer> inorder) {
            return sortedArrayToBalancedBSTUtil(inorder, 0, inorder.size()-1);
        }

        public void getInorder(TreeNode root, List<Integer> list) {
            if (root == null)
                return;
            getInorder(root.left, list);
            list.add(root.data);
            getInorder(root.right, list);
        }

        public TreeNode balanceBST(TreeNode root) {
            List<Integer> inorder = new ArrayList<>();
            getInorder(root, inorder);
            System.out.println("inorder: " + inorder);
            return sortedArrayToBalancedBST(inorder);
        }
    }

    public static void main(String[] args) {
        Integer input[] = {10,5,15,null,null,13,17,11,null,16,30};
        int arr[] = {1,2,3,4,5,6,7,8,9};
        BinarySearchTree bst = new BinarySearchTree(input);

        System.out.println("Level Order: " + bst.levelOrderIterative());
        
        bst.root = new Solution().balanceBST(bst.root);

        System.out.println("Level Order: " + bst.levelOrderIterative());
        bst.printInorder();
    }
}
