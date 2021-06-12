import java.util.*;

// Optimised Java solution: https://leetcode.com/problems/3sum/discuss/866492/14-ms-Optimized-Java-Solution

class ThreeSum {
    public Set<List<Integer>> twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        Set<List<Integer>> sumPairs = new HashSet<>();

        System.out.println("target = " + target);

        for (int i=0; i<nums.length; ++i) {
            if (nums[i] ==  -target)
                continue;
            Integer num2 = target - nums[i];
            if (map.containsKey(num2)) {                // sum pair found
                System.out.println("target = " + target + ": (" + nums[i] + ", " + num2 + ")");
                List<Integer> pair = new ArrayList<>();
                pair.add(nums[i]);
                pair.add(num2);
                sumPairs.add(pair);
            }
            map.put(nums[i], i);
        }
        return sumPairs;
    }

    public Set<List<Integer>> twoSumByIndex(int[] nums, int targetIndex) {
        HashMap<Integer, Integer> map = new HashMap<>();
        Set<List<Integer>> sumPairs = new HashSet<>();

        int target = -nums[targetIndex];
        System.out.println("target = " + target);

        for (int i=0; i<nums.length; ++i) {
            if (i == targetIndex)
                continue;
            Integer num2 = target - nums[i];
            if (map.containsKey(num2)) {                // sum pair found
                System.out.println("target = " + target + ": (" + nums[i] + ", " + num2 + ")");
                List<Integer> pair = new ArrayList<>();
                pair.add(nums[i]);
                pair.add(num2);
                sumPairs.add(pair);
            }
            map.put(nums[i], i);
        }
        return sumPairs;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3)
            return new ArrayList<>();
        Set<List<Integer>> tripletsSet= new HashSet<>();

        for (int i=0; i<nums.length; ++i) {
            System.out.println("nums[" + i + "]=" + nums[i]);
            Set<List<Integer>> triplets = twoSumByIndex(nums, i);
            if (triplets.isEmpty())
                continue;
            for (List<Integer> list: triplets) {
                list.add(nums[i]);
                Collections.sort(list);
                tripletsSet.add(list);
                //System.out.println(tripletsSet);
            }
        }
        //System.out.println(tripletsSet);
        return new ArrayList<>(tripletsSet);
    }

    public static void main(String args[]) {
        // int nums[] = new int[] {-1,0,1,2,-1,-4};
        // int nums[] = new int[] {-1,0,1,2,-1,-4,-2,-3,3,0,4};
        // int nums[] = new int[] {2,9,4,11,15,7};
        // int nums[] = new int[] {};
        // int nums[] = new int[] {1,2,-2,-1};
        int nums[] = new int[] {};
        ThreeSum obj = new ThreeSum();

        System.out.println(Arrays.toString(nums));


        // Set<List<Integer>> sumPairs = obj.twoSum(nums, -1);
        //System.out.println(sumPairs);

        // List<List<Integer>> list = obj.threeSum1(nums, 2);
        // //System.out.println(list);

        List<List<Integer>> list2 = obj.threeSum(nums);
        System.out.println(list2);

    }
}