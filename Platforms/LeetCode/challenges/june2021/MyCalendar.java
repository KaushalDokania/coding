package challenges.june2021;

import java.util.Arrays;
import java.util.HashMap;

public class MyCalendar {
    HashMap<Integer, Integer> bookings = new HashMap<>();

    public MyCalendar() {
            
    }
    
    public boolean book(int start, int end) {
        System.out.print("New booking: [" + start  + ", " + end + "): ");
        
        for (Integer s: bookings.keySet()) {
            if (start >= s && start <= bookings.get(s))
                return false;
            else if (end-1 >= s && end <= bookings.get(s))
                return false;
            else if (s >= start && s < end)
                return false;
            else if( bookings.get(s) >= start && bookings.get(s) < end)
                return false;
        }
        bookings.put(start, end-1);
        return true;
    }

    public static void main(String[] args) {
        int arr[][] = {{47,50},{33,41},{39,45},{33,42},{25,32},{26,35},{19,25},{3,8},{8,13},{18,27}};
        MyCalendar cal = new MyCalendar();
        for (int[] b: Arrays.asList(arr)) {
            System.out.println(cal.book(b[0], b[1]));    
        }
        
        // System.out.println(cal.book(15, 25));
        // System.out.println(cal.book(20, 30));
        
    }    
}
