import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class FruitBasket {
    static class Solution {
        // 1,1,2,2,3,2,2
        public int totalFruit(int[] tree) {
            int maxCount=-1;
            HashSet<Integer> set = new HashSet<>();
            for (int i=0,j=-1; i<tree.length; ++i) {
                if (set.add(tree[i]) && set.size() == 1)
                    j = i;
                if (set.size() > 2) {
                    set.remove(tree[j]);
                    while (!set.contains(tree[j]))
                        j++;
                }                
                maxCount = (maxCount > (i-j+1)) ? maxCount : (i-j+1);
            }
            return maxCount;
        }

        public int totalFruit2(int[] tree) {
            int count=0, maxCount=-1;
            List<Integer> list = new ArrayList<>();
            for (int i=0,j=-1; i<tree.length; ++i) {
                if (!list.contains(tree[i])) {
                    if (list.size() < 2) {
                        list.add(tree[i]);
                        j = i;
                    } else {
                        // reset to last j and reiterate
                        list.clear();
                        i = j - 1;      // as ++i will shift it by 1 index
                        j = -1;
                        count = 0;
                        continue;
                    }
                }
                // tree is of current choice
                count++;
                maxCount = (maxCount > count) ? maxCount : count;
            }
            return maxCount;
        }
    }

    public static void main(String[] args) {
        int tree[] = new int[]{
            // 1,2,2,3,2,2
            3,3,3,1,2,1,1,2,3,3,4
            // 0,1,2,2
        };
        
        System.out.println("Answer: " + new Solution().totalFruit(tree));   
    }
}
