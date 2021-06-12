package practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class Temp {
    static class Solution {
        public int[] rearrangeBarcodes(int[] barcodes) {
            int[] res = new int[barcodes.length];
            Map<Integer, Integer> map = new HashMap<>();

            for (Integer n: barcodes) {
                if (!map.containsKey(n))
                    map.put(n, 1);
                else
                    map.put(n, map.get(n)+1);
            }

            Map<Integer, Integer> sortedMap = 
                map.entrySet().stream()
                .sorted(Entry.comparingByValue())
                .collect(Collectors.toMap(Entry::getKey, Entry::getValue,
                                    (e1, e2) -> e1, LinkedHashMap::new));

            List<Integer> keys = new ArrayList<>(sortedMap.keySet());
            int i=keys.size()-1, j=keys.size()-2, k=0;
            while (k < res.length) {
                if (k < res.length) {             // read i++
                    int count = sortedMap.get(keys.get(i));
                    res[k++] = keys.get(i);
                    sortedMap.put(keys.get(i), --count);
                    // if (count == 0)
                    //     i -= 2;
                    while (sortedMap.get(keys.get(i))==0 || i==j)
                        i--;
                }
                if (k < res.length) {                    // read j--
                    int count = sortedMap.get(keys.get(j));
                    res[k++] = keys.get(j);
                    sortedMap.put(keys.get(j), --count);
                    // if (count == 0)
                    //     j -= 2;
                    while (sortedMap.get(keys.get(j))==0 || i==j)
                        j--;
                }
            }
            return res;
        }
    }
    public static void main(String[] args) {
        // int barcodes[] = {1,1,1,1,2,2,3,3};
        // int barcodes[] = {2,2,1,3};
        // int barcodes[] = {1};
        // int barcodes[] = {1,1,1,2,2,2,3,3,3,4,4,4,4,5,5,5,5,6,6,7,8,8,8,9,9,10,11,16,19,21,21,23,22};
        // int barcodes[] = {1,9,6,3,10,3,4,5,3};
        // int barcodes[] = {1,6,3,6,3,6,3,6,5,6};
        int barcodes[] = {1,1,1,1,2,2,3,3};
        for (Integer n: new Solution().rearrangeBarcodes(barcodes)) {
            System.out.print(n + ", ");
        }
    }
}
