import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {

    public int romanToInt_optimal(String s) {
        Map<Character, Integer> map = initRomanMap();
        int lastValue = Integer.MIN_VALUE;
        int number = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            int currValue = map.get(s.charAt(i));
            int sign = (currValue >= lastValue) ? 1 : -1; 
            number += sign * currValue;
            lastValue = currValue;
        }
        return number;
    }
    
    public Map<Character, Integer> initRomanMap() {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        return map;
    }

    public static int romanToInt(String s) {
        int value = 0;  

        char arr[] = s.toCharArray();

        for (int i=0; i<arr.length; ++i) {
            switch (arr[i]) {
                case 'M': value += 1000; break;
                case 'D': value += 500; break;
                case 'C':
                    if (i+1<arr.length && (arr[i+1] == 'D' || arr[i+1] == 'M'))
                        value -= 100;
                    else
                        value += 100;
                    break;
                case 'L': value += 50; break;
                case 'X':
                    if (i+1<arr.length && (arr[i+1] == 'L' || arr[i+1] == 'C'))
                        value -= 10;
                    else
                        value += 10;
                    break;
                case 'V': value += 5; break;
                case 'I':
                    if (i+1<arr.length && (arr[i+1] == 'V' || arr[i+1] == 'X'))
                        value -= 1;
                    else
                        value += 1;
                    break;
            }
        }

        return value;
    }

    public static void main(String args[]) {
        int num = romanToInt("XLIV");
        System.out.println("Number: " + num);
    }
}