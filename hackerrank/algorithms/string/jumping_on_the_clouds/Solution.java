import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int c[] = new int[n];
        for(int c_i=0; c_i < n; c_i++){
            c[c_i] = in.nextInt();
        }
        int jumps = 0;
        int i;
        for (i = 1; i < c.length - 1; ++i) {
            int el1 = c[i];
            int el2 = c[i + 1];
            //System.out.println("el1: " + el1 + ", " + "el2: " + el2);
            if (el1 == 0 && el2 == 0 || el1 == 1 && el2 == 0) {
                i += 2;
            } else if (el1 == 0 && el2 == 1) {
                i += 1;
            }
            --i; // loop auto-increments by 1
            ++jumps;
        }
        System.out.println(jumps + n - i);
    }
}
