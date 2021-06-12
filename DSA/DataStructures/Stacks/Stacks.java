import java.util.Stack;

class Stacks {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);
        stack.push(60);
        System.out.println("Top of stack is" + stack.peek());
        System.out.println(stack.pop() + " has been popped.");
        System.out.println("Top of stack is" + stack.peek());
        stack.push(100);
        stack.push(200);
        stack.push(300);
        stack.push(400);
        System.out.println("Top of stack is" + stack.peek());
        System.out.println(stack.pop() + " has been popped.");
        System.out.println("Top of stack is" + stack.peek());
    }
}