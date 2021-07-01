package DataStructures.BinaryTree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTree {
    public TreeNode root;

    public BinaryTree() {}

    public BinaryTree(TreeNode root) {
        this.root = root;
    }

    public BinaryTree(Integer[] input) {
        this.createTreeFromLevelOrderArray(input);
    }
    
    // private TreeNode createTreeFromLevelOrderArray(int[] input) {
    private TreeNode createTreeFromLevelOrderArray(Integer[] input) {
        int i = 0;
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode root = new TreeNode(input[i++]); // is is now 1
        q.add(root);
        while (!q.isEmpty() && i < input.length) {
            TreeNode node = q.poll();
            if (node == null)
                continue;
            if (i < input.length) {
                if (input[i] != null && input[i] != -1)
                    node.left = new TreeNode(input[i]);
                q.add(node.left);
                i++;
            }
            if (i < input.length) {
                if (input[i] != null && input[i] != -1)
                    node.right = new TreeNode(input[i]);
                q.add(node.right);
                i++;
            }
        }
        this.root = root;
        return root;
    }

    public int height() {
        return height(this.root);
    }

    int height(TreeNode root) {
        if (root == null)
            return 0;
        int lh = height(root.left);
        int rh = height(root.right);
        return (rh > lh) ? rh + 1 : lh + 1;
    }

    public void printLevel(TreeNode root, int level) {
        if (root == null)
            return;
        if (level == 0)
            System.out.print(root.data + ", ");
        else {
            this.printLevel(root.left, level - 1);
            this.printLevel(root.right, level - 1);
        }
    }

    void printLevelOrder(TreeNode root) {
        for (int i = 0; i < height(); ++i) {
            printLevel(root, i);
            System.out.println();
        }
    }

    public void printLevelOrder() {
        this.printLevelOrder(this.root);
    }

    

    /* level order traversal without recursion */
    List<List<Integer>> levelOrderIterative(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        if (root == null)
            return result;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> currList = new LinkedList<>();
            // Pop all the elements from the queue and add all their children
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();           // pop current element(at index i)
                currList.add(curr.data);
                if (curr.left != null)              // add it's left child, if exists
                    q.offer(curr.left);
                if (curr.right != null)             // add it's right child, if exists
                    q.offer(curr.right);
            }
            result.add(currList);                   // add all children to the main queue(which is now empty, since all previous elements were popped)
        }
        return result;
    }

    public List<List<Integer>> levelOrderIterative() {
        return this.levelOrderIterative(this.root);
    }

    void printInorder(TreeNode root) {
        if (root == null)
            return;
        printInorder(root.left);
        System.out.print(root.data + ", ");
        printInorder(root.right);
    }

    public void printInorder() {
        this.printInorder(this.root);
    }

    public static void main(String[] args) {
        Integer input[] = {1,4,3,2,4,2,5,-1,-1,-1,-1,-1,-1,4,6,1};              // -1 means null node

        BinaryTree tree = new BinaryTree();
        System.out.println("Creating binary tree from input array ...");
        tree.createTreeFromLevelOrderArray(input);
        System.out.println("Binary tread created");

        System.out.println("Level Order(recursive)");
        tree.printLevelOrder();

        System.out.println("Level Order(iterative)");
        System.out.println(tree.levelOrderIterative());
    }
}
