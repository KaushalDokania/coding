import java.util.Arrays;
import java.util.HashMap;

public class NextPermutation {
    static class Solution {
        public void nextPermutation(int[] nums) {
            HashMap<Integer, Integer> visited = new HashMap<>();
            int sorted[] = nums.clone();
            Arrays.sort(sorted);

            for (int i=nums.length-1; i>=0; --i) {
                if ()
            }

            System.out.println("This is nextPermutaion");
        }
    }

    public static void main(String[] args) {
        int nums[] = new int[]{1, 2, 3};
        new Solution().nextPermutation(nums);
        for (Integer n: nums) {
            System.out.print(n);
        }
    }
}