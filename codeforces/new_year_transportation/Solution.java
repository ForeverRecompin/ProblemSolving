import java.io.*;
import java.util.*;
import java.math.*;

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

class Solver {
    private StringBuilder sb = new StringBuilder();
    private int[] p = null;
    
    public void solve(InputReader in, PrintWriter out) {
    	int n = in.ni(), t = in.ni() - 1; // # cells, dest cell
	p = new int[n - 1]; // portals b/w cells
	for (int i = 0; i < n - 1; ++i) {
	    p[i] = in.ni();
	}
	int cc = 0; // default starting cell = 0
	//po("To reach: " + t);
        boolean res = findPath(cc, t, 0); // explore with the first available portal
	po(res == true ? "YES" : "NO");
        out.println(sb.toString());
    }

    private boolean findPath(int cc, int t, int ind) {
	//po("At Ind: " + ind); 
	if (cc > t) {
	    return false;
	} else if (cc == t) {
	    return true;
	}
	for (int i = ind; i < p.length; ++i) {
	    int nc = cc + p[i];
	    //po("Taking: " + nc);
	    if (findPath(nc, t, nc)) {
		return true;
	    } else {
		return false;
	    }
	}
	return false;
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
