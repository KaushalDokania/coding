import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Temp2 {

    static class Solution {
        private int[] intersect2(int[] nums1, int[] nums2) {             // nums1 > nums2
            int count[]  = new int[1001];
            List<Integer> list = new ArrayList<>();
            for (Integer n: nums1) {            // iterate the larger array and prepare the set
                count[n]++;
            }
            for (Integer n: nums2) {
                if (count[n] > 0) {
                    count[n]--;
                    list.add(n);
                }
            }
            return list.stream().mapToInt(i -> i).toArray();
        }

        public int[] intersect(int[] nums1, int[] nums2) {
            if (nums1.length > nums2.length) {
                return intersect2(nums1, nums2);
            } else {
                return intersect2(nums2, nums1);
            }
        }
    }
    
    public static void main(String[] args) {
        int nums1[]={1,2,2,1}, nums2[]={2,2};
        // int nums1[]={4,9,5}, nums2[]={9,4,9,8,4};
        // int nums1[]={3,1,2}, nums2[]={1,1};
        int res[] = new Solution().intersect(nums1, nums2);
        for (Integer n: res) {
            System.out.print(n + ", ");
        }
    }
}
