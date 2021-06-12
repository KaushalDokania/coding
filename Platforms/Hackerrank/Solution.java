import java.io.*;
//import java.security.*;
//import java.text.*;
import java.util.*;
//import java.util.concurrent.*;
//import java.util.regex.*;

public class Solution {

    // Complete the countingValleys function below.
    static int countingValleys(int n, String s) {
        int level=0, valley_count=0;
        System.out.println("n: " + n);
        System.out.println("s:  " + s);
        for (Character ch: s.toCharArray()) {
            if (ch=='U')
                level++;
            if (ch=='D')
                level--;
            if (level==0 && ch=='U')                // Valley ends with U and level will be 0
                valley_count++;
        }
        return valley_count;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //int n = scanner.nextInt();
        //String s = scanner.nextLine();
        int result = countingValleys(8, "UDDDUDUU");
        System.out.print(result);
        scanner.close();
    }
}
