import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Temp1 {

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

        public void testSortedSquares(Map<int[], int[]> testSuite) {
            System.out.println("Running tests");
            Solution sol = new Solution();         

            for (Map.Entry<int[], int[]> tc: testSuite.entrySet()) {
                int[] input, output, answer;
                input = tc.getKey();
                output = sol.sortedSquares(tc.getKey());
                answer = tc.getValue();
                
                System.out.print("for " + Arrays.toString(input));
                System.out.println(" => " + Arrays.toString(output));

                if (!isCorrectOutput(output, answer)) {
                    System.out.println("Test FAILED for " + Arrays.toString(tc.getKey()));
                    return;
                }
            }
            System.out.println("\nAll tests PASSED");
        }
    }

    static class Solution {

        public int[] sortedSquares(int[] nums) {
            int i, j, k=0;
            int[] squares = new int[nums.length];
            if (nums.length==0)
                return squares;
            for (i=0; i<nums.length; ++i) {
                if (nums[i] >= 0) {
                    break;
                } 
            }
            if (i==0) {                 // all positives, as i didn't increase or all negatives as iterated over entire array
                for (i=0; i<nums.length; ++i) {
                    squares[i] = nums[i] * nums[i];
                }
            }
            else if (i==nums.length) {                 // all positives, as i didn't increase or all negatives as iterated over entire array
                for (i=nums.length-1; i>=0; --i) {
                    squares[nums.length-i-1] = nums[i] * nums[i];
                }
            }
            else {
                k = 0;
                j = i;          // first positive index
                i--;            // last negative index
                while (i >= 0 && j < nums.length) {
                    if (Math.abs(nums[j]) < Math.abs(nums[i])) {
                        squares[k++] = nums[j] * nums[j];
                        j++;
                    } else {
                        squares[k++] = nums[i] * nums[i];
                        i--;
                    }
                }
                while (i >= 0) {
                    squares[k++] = nums[i] * nums[i];
                    i--;
                }
                while (j < nums.length) {
                    squares[k++] = nums[j] * nums[j];
                    j++;                }
            }
            
            return squares;
        }
    }
    
    public static void main(String[] args) {
        Map<int[], int[]> testSuite = new HashMap<>();
            testSuite.put(new int[]{}, new int[]{});
            testSuite.put(new int[]{0}, new int[]{0});
            testSuite.put(new int[]{-1}, new int[]{1});
            testSuite.put(new int[]{0 ,2}, new int[]{0, 4});
            testSuite.put(new int[]{-3, 0 ,2}, new int[]{0, 4, 9});
            testSuite.put(new int[]{-4, -1, 0, 3, 10}, new int[]{0,1,9,16,100,1000});
        new Test().testSortedSquares(testSuite);
    }
}
