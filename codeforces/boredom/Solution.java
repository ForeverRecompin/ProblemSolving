import java.io.*;
import java.util.*;
import java.math.*;

public class Solution {
    private static boolean needFileIO = true;
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
    long[] T = null;
    long[] freq = null;
    
    public void solve(InputReader in, PrintWriter out) {
	long n = in.nl();
	freq = new long[100001];
	for (int i = 0; i < n; ++i) {
	    long el = in.nl();
	    ++freq[(int) el];
	}
	T = new long[100001];
	Arrays.fill(T, -1);
	T[0] = 0;
	T[1] = freq[1];
	for (int i = 2; i < 100001; ++i) {
	    T[i] = Math.max(T[i - 1],
			    T[i - 2] + (i * freq[i]));
	}
	po(T[100000]);
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
