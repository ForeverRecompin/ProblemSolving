import java.io.*;
import java.util.*;
import java.math.*;

public class Solution {
    private static final boolean needFileIO = true;
    private static final String INPUT_FILE = "in";

    static class Solver {
	private StringBuilder sb = new StringBuilder();
	List<Integer> N;
	List<Integer> T;
	
	public void solve(InputReader in, PrintWriter out) {
	    int n = in.ni(), m = in.ni();
	    N = new ArrayList<>();
	    for (int i = 0; i < n; ++i) {
		int number = in.ni();
		N.add(number);
	    }
	    Set<Integer> S = new HashSet<>();
	    T = new ArrayList<>(Collections.nCopies(n + 1, 0));
	    for (int i = n - 1; i >= 0; --i) {
		S.add(N.get(i));
		T.set(i, S.size());
	    }
	    for (int i = 0; i < m; ++i) {
		po(T.get(in.ni() - 1));
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
