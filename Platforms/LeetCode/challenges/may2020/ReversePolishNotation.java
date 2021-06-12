import java.util.Stack;

public class ReversePolishNotation {
    static class Solution {
        public int evalRPN(String[] tokens) {
            Stack<Integer> stk = new Stack<>();
            for (String t: tokens) {
                System.out.println("Parsing " + t);
                System.out.println("t==\"+\":  " + (t=="+"));
                if (t.equals("+") || t.equals("-") || t.equals("*") || t.equals("/")) {
                    Integer op1, op2;
                    op2 = stk.pop();
                    op1 = stk.pop();
                    switch (t) {
                        case "+": stk.push(op1 + op2);break;
                        case "-": stk.push(op1 - op2);break;
                        case "*": stk.push(op1 * op2);break;
                        case "/": stk.push(op1 / op2);break;
                    }
                } else {
                    stk.push(Integer.parseInt(t));
                }
            }
            return stk.peek();
        }
    }
    public static void main(String[] args) {
        String tokens[] = new String[]{"2","1","+","3","*"};
        // String tokens[] = new String[]{"4","13","5","/","+"};
        // String tokens[] = new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        System.out.println("Answer: " + new Solution().evalRPN(tokens));
    }
}
