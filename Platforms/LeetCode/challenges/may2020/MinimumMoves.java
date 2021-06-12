import java.util.Arrays;
import java.util.Map;

public class MinimumMoves {
    static class Test {
        public boolean isCorrectOutput(int output[], int answer[]) {
            if (output.length != answer.length)
                return false;
            for (int i=0; i<output.length; ++i) {
                if (output[i] != answer[i]) {
                    return false;
                }
            }
            return true;
        }

        public void testSortedSquares(Map<int[], Integer> testSuite) {
            System.out.println("Running tests");
            Solution sol = new Solution();         

            for (Map.Entry<int[], Integer> tc: testSuite.entrySet()) {
                int[] input;
                Integer output, answer;
                input = tc.getKey();
                output = sol.minMoves2(tc.getKey());
                answer = tc.getValue();
                
                System.out.print("for " + Arrays.toString(input));
                System.out.println(" => " + output);

                if (output!=answer) {
                    System.out.println("Test FAILED for " + Arrays.toString(tc.getKey()));
                    return;
                }
            }
            System.out.println("\nAll tests PASSED");
        }
    }
    static class Solution {
        public int minMoves2(int[] nums) {
            int count = 0;
            int mid = nums.length/2;
            Arrays.sort(nums);
            for (int i=0; i<nums.length; ++i) {
                count += Math.abs(nums[mid]-nums[i]);
            }
            return count;
        }
    }

    public static void main(String args[]) {
        System.out.println("Answewr: " + new Solution().minMoves2(new int[]{1,10,2,9}));
    }
}
