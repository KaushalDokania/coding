import java.util.*;
// b-a = k => a = b-k
// a - b = k => a = b + k
class DiffPairs {
    static class Solution {
        HashSet<Integer> hashSet = new HashSet<>();
        Set<Set<Integer>> diffPair = new HashSet<>();

        public int findPairs(int[] nums, int k) {
            // int count = 0;
            for (Integer n: nums) {
                if (!hashSet.contains(n) || k==0) {
                    if (hashSet.contains(n-k))
                        diffPair.add(new HashSet<>(Arrays.asList(n-k, n)));
                    if (hashSet.contains(n+k))
                        diffPair.add(new HashSet<>(Arrays.asList(n+k)));
                    hashSet.add(n);
                }
            }
            return diffPair.size(); 
        }
    }

    public static void main(String args[]) {
        int nums[] = {3,1,4,1,5}, k=2;
        //Map<Integer, Integer> map = new HashMap();
        //map.get
        // int nums[] = {1,2,4,4,3,3,0,9,2,3}, k=3;
        // int nums[] = {1,1,1,1,1}, k=0;
        // int nums[] = {-1,-2,-3}, k=1;
        // int nums[] = {1,2,3,4,5}, k=1;
        // int nums[] = {6,3,5,7,2,3,3,8,2,4}, k=2;
        
        Solution sol = new Solution();
        System.out.println("k-diff = " + sol.findPairs(nums, k));
    }
}