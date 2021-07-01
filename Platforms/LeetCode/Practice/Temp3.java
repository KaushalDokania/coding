import java.util.ArrayList;
import java.util.List;

public class Temp3 {
    static class Solution {
        char nums[][] = {
            {},{},
            {'a', 'b', 'c'},
            {'d', 'e', 'f'},
            {'g', 'h', 'i'},
            {'j', 'k', 'l'},
            {'m', 'n', 'o'},
            {'p', 'q', 'r', 's'},
            {'t', 'u', 'v'},
            {'w', 'x', 'y', 'z'}
        };
    
        List<String> list = new ArrayList<>();

        public void dfs(String digits, int dgtIdx, int chIdx, String str) {
    
            if (str.length() == digits.length() && !str.isEmpty()) {
                list.add(str);
                return;
            }
    
            if (dgtIdx != digits.length()) {
                int digit = digits.charAt(dgtIdx) - '0';
                if (chIdx != nums[digit].length) {
                    String s = str + nums[digit][chIdx];
                    dfs(digits, dgtIdx + 1, 0, s);
                    dfs(digits, dgtIdx, chIdx + 1, str);
                }
            }
            return;
        }
    
        public List<String> letterCombinations(String digits) {
            dfs(digits, 0, 0, "");
            return list;
        }
    }

    public static void main(String[] args) {
     
        System.out.println(new Solution().letterCombinations("97"));
     
    }
}
