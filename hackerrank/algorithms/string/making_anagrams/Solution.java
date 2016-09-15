import java.io.*;
import java.util.*;

class Solver {
    private StringBuilder sb = new StringBuilder();
    
    public void solve(InputReader in, PrintWriter out) {
        String a = in.gs();
        String b = in.gs();
        int[] aFreq = new int[26];
        int[] bFreq = new int[26];
        for (char c : a.toCharArray()) {
            ++aFreq[c - 'a'];
        }
        for (char c : b.toCharArray()) {
            ++bFreq[c - 'a'];
        }
        int cost = 0;
        for (int i = 0; i < 26; ++i) {
            cost += (Math.abs(aFreq[i] - bFreq[i]));
        }
        po(cost);
        out.println(sb);
    }
    
    private void po(Object o) {
        sb.append("" + o).append("\n");
    }
}

public class Solution {
    public static void main(String[] args) {
        InputStream is = System.in;
        OutputStream os = System.out;
        InputReader in = new InputReader(is);
        PrintWriter out = new PrintWriter(os);
        new Solver().solve(in, out);
        out.close();
    }
}

class InputReader {
    private final BufferedReader br;
    private StringTokenizer t;
    
    public InputReader(InputStream is) {
        br = new BufferedReader(new InputStreamReader(is));
    }
    
    public String gs() {
        while (t == null || !t.hasMoreTokens()) {
            try {
                t = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                throw new RuntimeException();
            }
        }
        return t.nextToken();
    }
}
