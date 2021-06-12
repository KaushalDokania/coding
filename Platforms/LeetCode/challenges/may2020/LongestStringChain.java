import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

class LongestStringChain {
    static class Solution {
        public boolean isPredecessor(String str1, String str2) {
            StringBuilder sb2;
            for (int i=0; i<str2.length(); ++i) {
                sb2 = new StringBuilder(str2);
                sb2.deleteCharAt(i);
                if (sb2.toString().equals(str1))
                    return true;
            }
            return false;
        }

        public int longestStrChain(String[] words) {
            int res = 1;
            HashMap<String, Integer> map = new HashMap<>();
            // Sort by length
            Collections.sort(Arrays.asList(words), new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return o1.length() - o2.length();
                }
            });

            System.out.println(map);
            // HashMap<Integer, String> map = new HashMap<>();
            for (int i=0; i<words.length; ++i) {
                if (words[i].length()==1)
                    map.put(words[i], 1);
                else {
                    int predChain=0, temp;
                    for (int j=i-1; j>=0 && words[i].length()-words[j].length()<=1; --j) {
                        temp = 0;
                        if (isPredecessor(words[j], words[i])) {
                            temp = (map.get(words[j]) == null) ? 0 : map.get(words[j]);
                            predChain = (predChain > temp) ? predChain : temp;
                        }
                    }
                    map.put(words[i], predChain+1);
                    res = (predChain+1 > res) ? predChain+1 : res;
                }
            }
            System.out.println(map);
            return res;
        }
    }

    public static void main(String args[]) {
        // String input[] = {"a","b","ba","bca","bda","bdca"};
        String input[] = {"xbc","pcxbcf","xb","cxbc","pcxbc"};
        // System.out.println(new Solution().isPredecessor("abc", "abcs"));
        System.out.println("Answer: " + new Solution().longestStrChain(input));
    }
}