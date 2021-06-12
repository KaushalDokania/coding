import java.util.HashMap;

public class IntegerToRoman {

    public static HashMap<Integer, Character> initRomanMap() {
        HashMap<Integer, Character> map = new HashMap<>();
        map.put(1, 'I');
        map.put(5, 'V');
        map.put(10, 'X');
        map.put(50, 'L');
        map.put(100, 'C');
        map.put(500, 'D');
        map.put(1000, 'M');
        return map;
    }

    static String intoToRoman(Integer number) {
        HashMap<Integer, Character> map = initRomanMap();
        String str = "";
        int level=1000, num = number;

        while(num != 0) {
            int r = num/level;
            if (r==4 || r==9) {
                str += map.get(level);
                str += map.get(level*(r+1));
                num -= level*r;
                level /= 10;
                continue;
            }
            else if (r >= 5) {
                str += map.get(level*5);
                num -= level*5;
                r -= 5;
            }
            while (r>0) {
                str += map.get(level);
                num -= level;
                r--;
            }
            level /= 10;
        }
        return str;
    }

    public static void main(String[] args) {
        System.out.println("Roman: " + intoToRoman(789));
    }
    
}
