package challenges.june2021;
public class MinCostClimbingStairs {
    static class Solution {
        public int minCostClimbingStairs(int[] cost) {
            int i=cost.length, res=0;
            while (i > 1) {
                if (cost[i-2] <= cost[i-1])
                    i -= 2;
                else
                    i -= 1;
                
                res += cost[i];
            }
            return res;        
        }
    }

    public static void main(String[] args) {
        // int cost[] = {10,15,20};
        // int cost[] = {1,100,1,1,1,100,1,1,100,1};
        int cost[] = {1,10,5,4,15,6,10,11,10,6,10};
        System.out.println("Answer: " + new Solution().minCostClimbingStairs(cost));
    }    
}
