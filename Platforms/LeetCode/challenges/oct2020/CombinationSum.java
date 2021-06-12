// import java.util.ArrayList;
// import java.util.HashMap;
import java.util.*;

public class CombinationSum {

    HashMap<Integer, SortedSet<Integer>> map = new HashMap<>();

    /* private void traverse(int candidates[], int target) {
        List<Set<Integer>> list = new ArrayList<>();

        for (int i=0; i<candidates.length/2; ++i) {
            list.addAll(c)
            if (map.containsKey(target-candidates[i])
            traverse(candidates[i], target);
        }

        if (map.containsKey(key) || map.containsKey(target-key)) {

        }

        if (target%key == 0) {

        }
        traverse((target-1));
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        SortedSet<Integer> set;
        Arrays.sort(candidates);
        // Set<List<Integer>> list = new ArrayList<>();

        System.out.println(Arrays.toString(candidates));
        map.put(0, 0);
        for (Integer n: candidates) {               // initializing the map
            set = new TreeSet<Integer>();
            set.add(n);
            map.put(n, set);
        }
        for (int i=0; i<candidates.length; ++i) {
            traverse(candidates[i], target);
        }
        return null;
    } */

    public static void main(String args[]) {
        // int nums[] = {2,3,6,7};
        // CombinationSum obj = new CombinationSum();
        // List<List<Integer>> list = obj.combinationSum(nums, 7);
        // System.out.println(list);
    }
}
