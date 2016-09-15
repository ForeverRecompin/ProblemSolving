import java.io.*;
import java.util.*;
import java.math.*;

public class Solution {
    private static boolean needFileIO = false;
    public static void main(String[] args) {
	InputStream is = System.in;
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

class Solver {
    private StringBuilder sb = new StringBuilder();
    int[] N = null;
        
    public void solve(InputReader in, PrintWriter out) {
	int n = in.ni();
	N = new int[n];
	for (int i = 0; i < n; ++i) {
	    N[i] = in.ni();
	}
	int maxCountOf1 = N[0] == 1 ? 0 : 1;
	for (int i = 0; i < n; ++i) {
	    for (int j = 0; j < n; ++j) {
		if (i <= j) {
		    for (int k = i; k <= j; ++k) {
			N[k] = 1 - N[k];
		    }
		    int countOf1 = 0;
		    for (int k = 0; k < n; ++k) {
			if (N[k] == 1) ++countOf1;
		    }
		    //po(Arrays.toString(N), countOf1);
		    maxCountOf1 = Math.max(maxCountOf1, countOf1);
		    for (int k = i; k <= j; ++k) {
			N[k] = 1 - N[k];
		    }
		}
	    }
	}
	po(maxCountOf1);
        out.println(sb.toString());
    }

    // Short for Process Output
    private void po(Object o) { sb.append("" + o).append("\n"); }
    private void po(Object... o) { sb.append("" + Arrays.toString(o)).append("\n"); }
    private void jpo(Object o) { sb.append("" + o); }
    private void jpo(Object... o) { sb.append("" + Arrays.toString(o)); }
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
