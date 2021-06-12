import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class Temp {

    static class Test {
        private String inputFile = "/mnt/d/input.txt";
        private HashMap<Input, Answer> testSuite = new HashMap<>();

        //------------------ Modify this section -------------------
        // Structure Input, Answer as per requirement
        static class Input {
            String str; Integer k;
            public Input(String s, Integer num) { this.str = s; this.k = num; }
        }
        static class Answer {
            Integer len;
            public Answer(int l) {this.len = l;}
        }

        // Implement the below function as per inputs
        public boolean isEqual(Answer output, Answer answer) {
            return output.len == answer.len;
        }
        //-----------------------------------------------------------

        public void initTestSuite() {
            Scanner sc;
            try {
                sc = new Scanner(new File(inputFile));
                while (sc.hasNextLine()) {
                    Input in = new Input(sc.next(), sc.nextInt());
                    Answer out = new Answer(sc.nextInt());
                    testSuite.put(in, out);
                }
                sc.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }            
        }

        public void runTest() {
            this.initTestSuite();
            Solution sol = new Solution();
            for (Input in: this.testSuite.keySet()) {
                Answer output = new Answer(sol.function(in.str, in.k));         // function call
                if (!isEqual(output, this.testSuite.get(in))) {
                    System.out.println("Test FAILED for input { " + in.str + ", " + in.k + "}");
                    System.out.println("Expected: " + this.testSuite.get(in).len + ", got: " + output.len);
                    return;
                }
            }
        }

    }

    static class Solution {
        public int function(String s, int k) {
            return maxlen;
        }
    
    public static void main(String[] args) {
        new Test().runTest();
    }
}
class Template {
    
}
