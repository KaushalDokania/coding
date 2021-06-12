public class MaximumErasureValue {

    static class Solution {
        
        public boolean bsearch(int[] nums, int low, int high, int target) {
            int mid = (low + high)/2;
            if (nums[mid] == target)
                return true;
            else if (nums[mid] < target) {
                if (target <= nums[high-1])                // target in all ascending right subarray
                    // binarySearch(mid+1, length-1)
                else
                    bsearch(nums, mid+1, high, target);

            }
            else if (nums[mid] > target) {
                if (target > nums[low])                 // target in all ascending left subarray
                    // binarySearch(low, mid-1)
                else
            }
            return false;
        }
        public boolean search(int[] nums, int target) {
            return false;
        }
    }
    
    public static void main(String[] args) {
        // int nums[] = new int[]{2,5,6,0,0,1,2}, target=0;
        int nums[] = new int[]{2,5,6,7,0,1,2}, target=6;
        // int nums[] = new int[]{2,5,6,7,8,1,2}, target=8;
        // int nums[] = new int[]{2,5,6,7,0,1,2}, target=0;
        System.out.println("Answer: " + new Solution().search(nums, target));
        String str = "abcsd234ASDF";
        str.toLowerCase();
    }
}
