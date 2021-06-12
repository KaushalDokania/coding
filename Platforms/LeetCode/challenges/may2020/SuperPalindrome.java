public class SuperPalindrome {

    static class Solution {

        boolean isPalindrome(long number) {
            long num=number, n=0;
            while (num!=0) {
                n = n*10 + num%10;
                num /= 10;
            }
            return n==number;
        }

        boolean isPalindrome2(long number) {
            long num=number, n=0;
            long sqr, square, s=0;
            square = number * number;
            sqr = square;

            while (true) {
                if (num==0)
                    break;
                
                if (num!=0) {
                    n = n*10 + num%10;
                    num /= 10;
                }
                if (sqr!=0) {
                    s = s*10 + sqr%10;
                    sqr /= 10;
                }
            }
            if (n!=number)
                return false;
            while (sqr!=0) {
                s = s*10 + sqr%10;
                sqr /= 10;
            }
            return s==square;
        }

        public int superpalindromesInRange(String sL, String sR) {
            long L = Long.valueOf(sL);
            long R = Long.valueOf(sR);
            int MAGIC = 100000;
            int ans = 0;
    
            // count odd length;
            for (int k = 1; k < MAGIC; ++k) {
                StringBuilder sb = new StringBuilder(Integer.toString(k));
                for (int i = sb.length() - 2; i >= 0; --i)
                    sb.append(sb.charAt(i));
                long v = Long.valueOf(sb.toString());
                v *= v;
                if (v > R) break;
                if (v >= L && isPalindrome(v)) ans++;
            }
    
            // count even length;
            for (int k = 1; k < MAGIC; ++k) {
                StringBuilder sb = new StringBuilder(Integer.toString(k));
                for (int i = sb.length() - 1; i >= 0; --i)
                    sb.append(sb.charAt(i));
                long v = Long.valueOf(sb.toString());
                v *= v;
                if (v > R) break;
                if (v >= L && isPalindrome(v)) ans++;
            }
    
            return ans;
        }
    }

    public static void main(String[] args) {
        // System.out.println("Palindrome " + new Solution().isPalindrome(121));
        System.out.println("Number of super-palindromes: " + new Solution().superpalindromesInRange("4", "1000"));
    }
    
}
