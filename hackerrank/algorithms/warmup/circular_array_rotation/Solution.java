import java.io.*;
import java.util.*;
import java.math.*;

class Solver {
    private StringBuilder sb = new StringBuilder();

    public void solve(InputReader in, PrintWriter out) {
        int n = in.ni(), k = in.ni(), q = in.ni();
        int[] arr = new int[n];
        for (int i = 0; i < n; ++i) {
            arr[(i + k) % n] = in.ni();
        }
        // Brute Eff it with arr[i] above
        /*for (int i = 0; i < k; ++i) {
            int last = arr[n - 1];
            for (int j = n - 1; j >= 1; --j) {
                arr[j] = arr[j - 1];
            }
            arr[0] = last;
        }*/
        for (int i = 0; i < q; ++i) {
            po(arr[in.ni()]);
        }
        out.println(sb.toString());
    }

    // Short for Process Output
    private void po(Object o) { sb.append("" + o).append("\n"); }
    private void po(Object... o) { sb.append("" + Arrays.toString(o)).append("\n"); }
    private void jpo(Object o) { sb.append("" + o); }
    private void jpo(Object... o) { sb.append("" + Arrays.toString(o)); }
}

public class Solution {
    public static void main(String[] args) {
	    InputStream is = System.in;
	    boolean needFileIO = true;
	    if (needFileIO) {
	        try {
	            is = new FileInputStream("in");
		        //os = new FileOutputStream("out");
		        } catch (FileNotFoundException e) { throw new RuntimeException(e); }
	    }
	    InputReader in = new InputReader(is);
	    OutputStream os = System.out; PrintWriter out = new PrintWriter(os);
	    new Solver().solve(in, out);
	    out.close();
    }
}

class InputReader {
    private final BufferedReader br;
    private StringTokenizer t;
    public InputReader(InputStream is) { br = new BufferedReader(new InputStreamReader(is)); t = null; }
    public int ni() { return Integer.parseInt(ns()); }
    public long nl() { return Long.parseLong(ns()); }
    public double nd() { return Double.parseDouble(ns()); }
    public BigInteger nbi() { return new BigInteger(ns()); }
    public BigDecimal nbd() { return new BigDecimal(ns()); }
    public String ns() {
	while (t == null || !t.hasMoreTokens()) {
	    try { t = new StringTokenizer(br.readLine());
	    } catch (IOException e) { throw new RuntimeException(e); }}
	return t.nextToken();
    }
    public String nli() {
    	String line = "";
    	try {
    		line = br.readLine();
    		
    	} catch (IOException e) { throw new RuntimeException(e); }
    	return line;
    }
}
