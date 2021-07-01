package DataStructures.BST;

import DataStructures.BinaryTree.TreeNode;

public class PredecessorSuccessor {
    TreeNode prev = null, pred = null, succ = null;

    void findPredSucc(TreeNode root, int key) {
        if (root == null)
            return;
        
        if (pred != null && succ != null)
            return;
        
        findPredSucc(root.left, key);
        
        if (root.data == key)                   // current is key, prev is the predecessor
            this.pred = prev;
        if (prev != null && prev.data == key)   // prev was key, so curr is successor
            this.succ = root;
        prev = root;                            // visited the current node
        findPredSucc(root.right, key);
    }

    public static void main(String[] args) {
        //          10
        //      5       15
        //    2   6        17
        int input[] = {10,5,15,2,6,-1,17};
        BinarySearchTree bst = new BinarySearchTree();
        bst.createTreeFromLevelOrderArray(input);

        bst.printLevelOrder();
        bst.printInorder();

        PredecessorSuccessor ans = new PredecessorSuccessor();
        ans.findPredSucc(bst.root, 6);
        System.out.println("\n");
        if (ans.pred == null)
            System.out.println("predecessor is null");
        else
            System.out.println("pred: " + ans.pred.data);
        if (ans.succ == null)
            System.out.println("successor is null");
        else
            System.out.println("successor: " + ans.succ.data);
    }
}
