import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchSuggestion {
    static class Solution {
        public List<List<String>> suggestedProducts(String[] products, String searchWord) {
            List<List<String>> res = new ArrayList<>();
            Arrays.sort(products);
            System.out.println(Arrays.asList(products));
            
            for (int j=0, start=0; j < searchWord.length(); ++j) {
                List<String> list = new ArrayList<>();
                String prefix = searchWord.substring(0, j+1);
                
                int i=start;
                while (i < products.length && !products[i].startsWith(prefix))
                    i++;
                
                start = i;
                while (i < products.length && products[i].startsWith(prefix) && list.size()<3)
                    list.add(products[i++]);
                
                res.add(list);
            }
            return res;
        }
    }
    public static void main(String[] args) {
        // String products[] = {"mobile","mouse","moneypot","monitor","mousepad"}, searchWord="mouse";
        String products[] = {"havana"}, searchWord="havana";
        // String products[] = {"mobile","mouse","monica","moneypot", "kaushal", "aniket", "zombie", "lucy", "kavita", "luciana", "monitor","mousepad"}, searchWord="mouse";
        System.out.println("Answer: " + new Solution().suggestedProducts(products, searchWord));
    }
}
