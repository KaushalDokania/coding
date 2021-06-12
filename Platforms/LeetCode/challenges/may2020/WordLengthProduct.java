import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class WordLengthProduct {
    static class Solution {
        int maxProd=0;
        private boolean areUnique(String s1, String s2) {
            for (int i=0; i<s1.length(); ++i) {
                if (s2.indexOf(s1.charAt(i)) >= 0)
                    return false;
            }
            return true;
        }

        private int findMaxProd(List<String> list) {
            int prod=0;
            for (int i=1; i<list.size(); ++i) {
                if (areUnique(list.get(i), list.get(i-1))) {
                    prod = list.get(i).length() * list.get(i-1).length();
                }
                if (prod > maxProd) {
                    System.out.println("new max: " + prod);
                    maxProd = prod;
                }
            }
            return prod;
        }

        public int maxProduct(String[] words) {
            List<String> list = Arrays.asList(words);
            System.out.println(list);
            Collections.sort(list, (a,b) -> a.length() != b.length() ? -Integer.compare(a.length(), b.length()) :  a.compareTo(b));
            System.out.println(list);

            findMaxProd(list);
            return this.maxProd;
        }
    }
    public static void main(String[] args) {
        String words[] = new String[]{"abcw","bafc","foo","xy","bar","xtfn","abcdef", "uisupif"};
        System.out.println("Answer: " + new Solution().maxProduct(words));
    }
}
