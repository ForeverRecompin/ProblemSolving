import java.io.*;
import java.util.*;

class Solver {
    private static StringBuilder sb = new StringBuilder();
    
    public void solve(InputReader in, PrintWriter out) {
        long n = in.gl();
        List<Long> nums = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            nums.add(in.gl());
        }
        Collections.sort(nums);
        long diff = Long.MAX_VALUE;
        for (int i = 0; i < nums.size() - 1; ++i) {
            long diffHere = Math.abs(nums.get(i) - nums.get(i + 1));
            if (diffHere < diff) {
                diff = diffHere;
            }
        }
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < nums.size() - 1; ++i) {
            long diffHere = Math.abs(nums.get(i) - nums.get(i + 1));
            if (diffHere == diff) {
                s.append(nums.get(i) + " " + nums.get(i + 1) + " ");
            }
        }
        po(s);
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
    private StringTokenizer t;
    private BufferedReader br;
    
    public InputReader(InputStream is) {
        t = null;
        br = new BufferedReader(new InputStreamReader(is));
    }
    
    public String gs() {
        while (t == null || !t.hasMoreTokens()) {
            try {
                t = new StringTokenizer(br.readLine());
            } catch (IOException ioe) {
                throw new RuntimeException();
            }
        }
        return t.nextToken();
    }
    
    public long gl() {
        return Long.parseLong(gs());
    }
}
