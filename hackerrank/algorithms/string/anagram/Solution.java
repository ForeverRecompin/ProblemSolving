import java.io.*;
import java.util.*;

class Solver {
    private StringBuilder sb = new StringBuilder();
    
    public void solve(InputReader in, PrintWriter out) {
        int tc = in.ni();
        for (int i = 0; i < tc; ++i) {
            String s = in.ns();
            int lenS = s.length();
	    po(s);
            if (lenS % 2 != 0) {
                po(-1);
            } else {
                String s1 = s.substring(0, lenS/2);
                String s2 = s.substring(lenS/2);
                int[] cf1 = getCharFreq(s1);
                int[] cf2 = getCharFreq(s2);
                int cost = 0;
		po(Arrays.toString(cf1));
		po(Arrays.toString(cf2));
                for (int j = 0; j < cf1.length; ++j) {
                    if (cf1[j] < cf2[j]) {
                        cost += cf2[j] - cf1[j];
                    }
                }
                po(cost);
            }
        }
        out.println(sb.toString());
    }
    
    private int[] getCharFreq(String s) {
        int[] charFreq = new int[26];
        Arrays.fill(charFreq, 0);
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            ++charFreq[c - 'a'];
        }
        return charFreq;
    }
    
    private void po(Object o) {
        sb.append("" + o + "\n");
    }
}

public class Solution {
    public static void main(String[] args) {
        InputStream is;
	try {
	    is = new FileInputStream("in");
	    //is = System.in;
	} catch (FileNotFoundException e) {
	    throw new RuntimeException(e);
	}
        InputReader in = new InputReader(is);
        OutputStream os = System.out;
        PrintWriter out = new PrintWriter(os);
        new Solver().solve(in, out);
        out.close();
    }
}

class InputReader {
    private StringTokenizer t;
    private BufferedReader br;
    
    public InputReader(InputStream is) {
        br = new BufferedReader(new InputStreamReader(is));
        t = null;
    }
    
    public String ns() {
        while (t == null || !t.hasMoreTokens()) {
            try {
                t = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return t.nextToken();
    }
    
    public int ni() {
        return Integer.parseInt(ns());
    }
}
