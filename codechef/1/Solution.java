import java.io.*;
import java.util.*;
import java.math.*;

public class Solution {
    private static final boolean needFileIO = false;
    private static final String INPUT_FILE = "in";

    static class Main {
	private StringBuilder sb = new StringBuilder();

	public void solve(InputReader in, PrintWriter out) {
	    int tc = in.ni();
	    while (tc-- > 0) {
		String x = in.ns();
		double k = in.nd();
		double[] num = new double[(int) k];
		double[] den = new double[(int) k];
		for (int i = 0; i < k; ++i) {
		    num[i] = in.nd();
		}
		for (int i = 0; i < k; ++i) {
		    den[i] = in.nd();
		}
		double xc = 1;
		for (int i = 0; i < k; ++i) {
		    xc = xc + (xc * num[i]/den[i]);
		}
		//po(xc)
		double res = Math.abs(xc - 1) * 100 / xc;
		double ires = res % 1.0;
		po((int) (res - ires));
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
