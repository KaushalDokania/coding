package Platforms.LeetCode.challenges.june2021;

import java.util.Arrays;

public class MatchstickSquare {
    static class Solution {
        private boolean dfs(int[] nums, int[] sums, int index, int target) {
            if (index == nums.length)
                return true;
            for (int i=0; i<4; ++i) {
                if (sums[i] + nums[index] <= target) {
                    sums[i] += nums[index];
                    if (dfs(nums, sums, index+1, target))
                        return true;
                    sums[i] -= nums[index];
                }
            }
            return false;
        }

        public boolean makesquare(int[] nums) {
            if (nums == null || nums.length < 4) return false;
            int sum = 0;
            for (Integer n: nums) {sum += n;}
            if (sum % 4 != 0) return false;                 // solution not possible
            Arrays.sort(nums);
            return dfs(nums, new int[4], 0, sum/4);
        }

        private void reverse(int[] nums) {
            int i = 0, j = nums.length - 1;
            while (i < j) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++; j--;
            }
        }
    }

    public static void main(String[] args) {
        int matchsticks[] = {1,1,2,2,2};
        System.out.println("Answer:" + new Solution().makesquare(matchsticks));
    }
}