import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeProgram {
    // Node class
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // BinaryTree class
    static class BinaryTree {
        Node root;
        
        int height() {
            return height(this.root);
        }

        int height(Node root) {
            if (root==null)
                return 0;
            int lh = height(root.left);
            int rh = height(root.right);
            return (rh>lh) ? rh+1 : lh+1;
        }

        void printLevel(Node root, int level) {
            if (root==null)
                return;
            if (level==0)
                System.out.print(root.data + ", ");
            else {
                this.printLevel(root.left, level-1);
                this.printLevel(root.right, level-1);
            }
        }

        void printLevelOrder (Node rooot) {
            for (int i=0; i<height(); ++i) {
                printLevel(root, i);
                System.out.println();
            }
        }

        /* level order traversal without recursion */
        public List<List<Integer>> levelOrder(Node root) {
            List<List<Integer>> result = new LinkedList<>();
            if(root == null)
                return result;
            Queue<Node> q = new LinkedList<>();
            q.offer(root);
            while(!q.isEmpty()){
                int size = q.size();
                List<Integer> currList = new LinkedList<>();
                for(int i=0;i<size;i++){
                    Node curr = q.poll();
                    currList.add(curr.data);
                    if(curr.left!=null)
                        q.offer(curr.left);
                    if(curr.right!=null)
                        q.offer(curr.right);
                }
                result.add(currList);
            }
            return result;
        }
    }

    public static void main(String args[]) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(10);
        tree.root.left = new Node(20);
        tree.root.right = new Node(30);
        tree.root.left.left = new Node(40);
        tree.root.left.right = new Node(50);
        tree.root.right.left = new Node(60);
        tree.root.right.right = new Node(70);
        tree.root.left.left.left = new Node(80);

        System.out.println(tree.height());
        tree.printLevelOrder(tree.root);

        Queue<Node> q = new LinkedList<>();
        q.po
    }
}
