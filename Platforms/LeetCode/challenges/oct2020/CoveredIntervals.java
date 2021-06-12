import java.util.*;

// Optimized solution: https://leetcode.com/explore/featured/card/october-leetcoding-challenge/559/week-1-october-1st-october-7th/3483/discuss/878271/100-efficient-code-and-easy-to-understand-solution
class CoveredIntervals {
    static class Solution {
        Set<Integer[]> set = new HashSet<>();
        Set<Integer[]> countSet = new HashSet<>();

        private boolean covered(Integer[] pair1, Integer[] pair2) {
            int x1=pair1[0], x2=pair1[1];
            int y1=pair2[0], y2=pair2[1];
            if (y1 <= x1 && y2 >= x2)
                return true;
            return false;
        }

        public int removeCoveredIntervals(int[][] intervals) {
            for (int p[]: intervals) {
                Integer pair[] = new Integer[]{p[0], p[1]};
                set.add(pair);
                countSet.add(pair);
            }

            for (Integer pair[]: set) {
                for (Integer tmpPair[]: set) {
                    
                    if (pair.equals(tmpPair))
                        continue;
                    
                    if (covered(pair, tmpPair))
                        countSet.remove(pair);
                    else if(covered(tmpPair, pair))
                        countSet.remove(tmpPair);
                }
            }
            return countSet.size();
        }
    }

    public static void main(String args[]) {
        // int intervals[][] = {{1,4}, {3,6}, {2,8}};
        // int intervals[][] = {{1,4}, {2,3}};
        // int intervals[][] = {{0,10}, {5,12}};
        // int intervals[][] = {{3,10}, {4,10}, {5,11}};
        int intervals[][] = {{1,2}, {1,4}, {3,4}};
        Solution obj = new Solution();
        int count = obj.removeCoveredIntervals(intervals);
        
        /* System.out.println("---");
        for (Integer p[]: countSet) {
            System.out.println(Arrays.toString(p));
        } */
        System.out.println("intervals = " + count);
    }
}