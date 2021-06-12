import java.io.StringBufferInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class FindAndReplacePattern {
    static class Solution {
        public List<String> findAndReplacePattern(String[] words, String pattern) {
            List<String> res = new ArrayList<>();
            for (String word: words) {
                if (word.equals(pattern)) {
                    res.add(word);
                    continue;
                }

                HashMap<Character, Character> wordToPattern = new HashMap<>();
                HashMap<Character, Character> patternToWord = new HashMap<>();
                StringBuilder w = new StringBuilder(word);

                for (int i=0; i<pattern.length(); ++i) {            // assuming word and pattern are of same length
                    Character wChar=w.charAt(i), ptnChar=pattern.charAt(i);
                    if (!wordToPattern.containsKey(wChar)
                            && !patternToWord.containsKey(ptnChar)) {

                        patternToWord.put(ptnChar, wChar);
                        wordToPattern.put(wChar, ptnChar);

                        w.setCharAt(i, pattern.charAt(i));

                    } else if (patternToWord.containsKey(ptnChar) && patternToWord.get(ptnChar).equals(wChar)) {
                        w.setCharAt(i, pattern.charAt(i));
                    }  else if (wordToPattern.containsKey(wChar) && wordToPattern.get(wChar).equals(ptnChar)) {
                        w.setCharAt(i, pattern.charAt(i));
                    }
                    
                }
                if (pattern.equals(w.toString()))
                    res.add(word);
            }
            return res;
        }
    }
    public static void main(String[] args) {
        // String words[] = {"abc","deq","mee","aqq","dkd","ccc"}, pattern="abb";
        // String words[] = {"a","b","c"}, pattern="a";
        // String words[] = {"abc","cba","xyx","yxx","yyx"}, pattern="abc";
        String words[] = {"abc","cba","xyx","yxx","yyx"}, pattern="aba";
        System.out.println("ANswer: " + new Solution().findAndReplacePattern(words, pattern));
    }
}
