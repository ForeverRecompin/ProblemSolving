import java.io.*;
import java.util.*;
import java.math.*;

public class Solution {
    private static final boolean needFileIO = true;
    private static final String INPUT_FILE = "in";

    static class Solver {
	private StringBuilder sb = new StringBuilder();

	public void solve(InputReader in, PrintWriter out) {
	    int tc = in.ni();
	    while (tc-- > 0) {
		String s = in.ns();
		int res = 0;
		for (int i = 0; i < s.length() - 1; ++i) {
		    int pairs = 2;
		    String seq1 = s.substring(i, i + 2);
		    for (int j = i + 2; j < s.length(); ++j) {
			String seq2 = "";
			if (j + 2 <= s.length() - 1) {
			    seq2 = s.substring(j, j + 2);
			    if (seq1.charAt(0) == seq2.charAt(0)
				&& seq1.charAt(1) == seq2.charAt(1)
				&& seq1.charAt(1) != seq2.charAt(0)) {
				pairs += 2;
			    }
			} else {
			    seq2 = s.substring(j);
			    if (seq1.charAt(0) == seq2.charAt(0)
				&& seq1.charAt(1) != seq2.charAt(0)) {
				pairs += 1;
			    }
			}
			//po(seq1, seq2);
		    }
		    pairs = pairs == 2 ? 0 : pairs;
		    res = Math.max(res, pairs);
		}
		po(res);
	    }
	    out.println(sb.toString());
	}

	// Short for Process Output
	private void po(Object o) { sb.append("" + o).append("\n"); }
	private void po(Object... o) { sb.append("" + Arrays.deepToString(o)).append("\n"); }
	private void jpo(Object o) { sb.append("" + o); }
    }

    static class InputReader {
	private final BufferedReader br;
	private StringTokenizer t;
	public InputReader(InputStream is) {
	    br = new BufferedReader(new InputStreamReader(is));
	    t = null;
	}
	public int ni() { return Integer.parseInt(ns()); }
	public long nl() { return Long.parseLong(ns()); }
	public double nd() { return Double.parseDouble(ns()); }
	public BigInteger nbi() { return new BigInteger(ns()); }
	public BigDecimal nbd() { return new BigDecimal(ns()); }
	public String ns() {
	    while (t == null || !t.hasMoreTokens()) {
		try { t = new StringTokenizer(br.readLine());
		} catch (IOException e) { throw new RuntimeException(e); }
	    }
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
      
    public static void main(String[] args) {
	InputStream is = System.in;
	if (needFileIO) {
	    try {
		is = new FileInputStream(INPUT_FILE);
		//os = new FileOutputStream("out");
	    } catch (FileNotFoundException e) { throw new RuntimeException(e); }
	}
	InputReader in = new InputReader(is);
	OutputStream os = System.out; PrintWriter out = new PrintWriter(os);
	new Solver().solve(in, out);
	out.close();
    }
}
