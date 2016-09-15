import java.io.*;
import java.util.*;

class Solver {
    private StringBuilder sb = new StringBuilder();
    
    public void solve(InputReader in, PrintWriter out) {
        String s = in.gs();
        int[] alphaFreq = new int[26];
        Arrays.fill(alphaFreq, 0);
        for (char c : s.toCharArray()) {
            ++alphaFreq[c - 'a'];
        }
        int counter = 0;
        for (int el : alphaFreq) {
            if (el % 2 != 0) {
                ++counter;
            }
            if (counter > 1) {
                break;
            }
        }
        po(counter == 1  || counter == 0 ? "YES" : "NO");
        out.println(sb);
    }

    // Process Output
    private void po(Object o) {
        sb.append("" + o).append("\n");
    }
}

public class Solution {
    public static void main(String[] args) {
        InputStream is = System.in;
        OutputStream os = System.out;
	boolean needFileInput = true;
	if (needFileInput) {
	    try {
		is = new FileInputStream("in");
	    } catch (FileNotFoundException fnfe) {
		throw new RuntimeException(fnfe);
	    }
	}
        InputReader in = new InputReader(is);
        PrintWriter out = new PrintWriter(os);
        new Solver().solve(in, out);
        out.close();
    }
}

class InputReader {
    private BufferedReader br;
    private StringTokenizer t;
    
    public InputReader(InputStream is) {
        br = new BufferedReader(new InputStreamReader(is));
        t = null;
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
}
