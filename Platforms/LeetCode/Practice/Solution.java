import java.util.HashMap;

public class Solution {

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        int i,j;
        HashMap<Integer, Integer> numsMap = new HashMap<>();
        for (i=0; i<nums.length; ++i) {
            if (numsMap.containsKey(nums[i])
                    && (i-numsMap.get(nums[i]) <= k)) {
                        return true;
            } else {
                numsMap.put(nums[i], i);
            }
        }
        return false;
    }

    public static void main(String args[]) {
        int nums[] = {1,2,3,1};
        int k = 2;

        // Solution here
        System.out.println("Answer: " + containsNearbyDuplicate(nums, k));
    } 
    
    String str = "loveleetcode";
    for (char c: str) {
        if (str.contains(c))
        str.replace(arg0, arg1)
            System.out.println("");
    }
}
