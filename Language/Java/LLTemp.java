import java.util.LinkedList;

class LLTemp {
    public static void main(String args[]) {
        LinkedList<Integer> ll = new LinkedList<Integer>();
        ll.add(10);
        ll.add(20);
        ll.add(30);
        ll.add(40);

        ll.add(2, 100);
        
        System.out.println(ll);
    }
}