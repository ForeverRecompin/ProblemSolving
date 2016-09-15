import java.io.*;
import java.util.*;
import java.math.*;

public class Solution {
    private static boolean needFileIO = false;

    static class Solver {
	private StringBuilder sb = new StringBuilder();

	public void solve(InputReader in, PrintWriter out) {
	    long n = in.nl(), k = in.nl();
	    /*
	    // Recipe for TLE
	    List<Long> odds = new ArrayList<>();
	    List<Long> evens = new ArrayList<>();
	    for (long i = 1; i <= n; ++i) {
		if (i % 2 == 0) evens.add(i);
		else odds.add(i);
	    }
	    po((int)k - odds.size() <= 0 ? odds.get((int) k - 1) : evens.get(-odds.size() + (int) k - 1));
	    */

	    // n = 4
	    // 1 3 2 4
	    // k (1, 1), (2, 3), (3, 2), (4, 4)
	    //for (int i = 0; i < 4; ++i) {
	    //if (i < 4 / 2) po(i, 2*(i) + 1);
	    //else po(i, 2 * (i - 1));
	    //}
	    if (n % 2 == 0) {
		po(k <= n / 2 ? 2 * (k - 1) + 1 : 2 * (k - n / 2));
	    } else {
		po(k <= n / 2 + 1 ? 2 * (k - 1) + 1 : 2 * (k - 1 - n / 2));
	    }
	    out.println(sb.toString());
	}
	
	// Short for Process Output
	private void po(Object o) { sb.append("" + o).append("\n"); }
	private void po(Object... o) { sb.append("" + Arrays.deepToString(o)).append("\n"); }
	private void jpo(Object o) { sb.append("" + o); }
    }

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

    static class InputReader {
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
}
