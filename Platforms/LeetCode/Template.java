import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Template {

    /* static class Test {
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
                Answer output = new Answer(sol.characterReplacement(in.str, in.k));
                if (!isEqual(output, this.testSuite.get(in))) {
                    System.out.println("Test FAILED for input { " + in.str + ", " + in.k + "}");
                    System.out.println("Expected: " + this.testSuite.get(in).len + ", got: " + output.len);
                    return;
                }
            }
        }

    }
 */
    
    static class Solution {
        public int longestConsecutive(int[] nums) {
            int max=0;
            HashMap<Integer, Integer> map = new HashMap<>();
            HashMap<Integer, HashSet<Integer>> sequenceMap = new HashMap<>();
            
            for (int i=0; i<nums.length; ++i) {
                if (map.containsKey(nums[i]))
                    continue;
                if (map.containsKey(nums[i] + 1)) {
                    Integer start = map.get(nums[i]+1);
                    
                    HashSet<Integer> seq = new HashSet<>();
                    seq.addAll(sequenceMap.get(nums[i]+1));
                    seq.add(nums[i]);
                    sequenceMap.put(nums[i], seq);
                    if (sequenceMap.get(nums[i]).size() > max)
                        max = sequenceMap.get(nums[i]).size();
                    sequenceMap.remove(nums[i]+1);
                }
                if (map.containsKey(nums[i] - 1)) {
                    Integer start = map.get(nums[i]-1);
                    if (sequenceMap.containsKey(nums[i])) {
                        sequenceMap.get(start).addAll(sequenceMap.get(nums[i]));
                        sequenceMap.remove(nums[i]);
                    }
                    else
                        sequenceMap.get(start).add(nums[i]);
                    
                    if (sequenceMap.get(start).size() > max)
                        max = sequenceMap.get(start).size();
                }
                map.put(nums[i], nums[i]);
            }
            return max;
        }
    }
    
    public static void main(String[] args) {
        int nums[] = {100,4,200,1,3,2};
        System.out.println("Answer: " + new Solution().longestConsecutive(nums));
    }
}
