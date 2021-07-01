package practice;

import java.util.LinkedList;
import java.util.Queue;

import DataStructures.BinaryTree.BinaryTree;
import DataStructures.BinaryTree.TreeNode;

public class Temp {
    static class Solution {
        public boolean isBST(Integer[] nums) {
            return false;
        }

        public TreeNode createBinaryTreeFromArray(Integer[] input) {
            int i = 0;
            Queue<TreeNode> q = new LinkedList<>();
            TreeNode root = new TreeNode(input[i++]); // is is now 1
            q.add(root);
            while (!q.isEmpty() && i < input.length) {
                TreeNode node = q.poll();
                if (node == null)
                    continue;
                if (i < input.length) {
                    // if (input[i] != null)
                        node.left = new TreeNode(input[i]);
                    q.add(node.left);
                    i++;
                }
                if (i < input.length) {
                    // if (input[i] != null)
                        node.right = new TreeNode(input[i]);
                    q.add(node.right);
                    i++;
                }
            }
            return root;
        }
    }
    public static void main(String[] args) {
        Integer nums[] = {8,5,11,null,null,10,12,7,null};
        BinaryTree tree = new BinaryTree(new Solution().createBinaryTreeFromArray(nums));
        tree.printLevelOrder();
        tree.printInorder();
        // System.out.println("BST: " + new Solution().isBST(nums));
    }
}
