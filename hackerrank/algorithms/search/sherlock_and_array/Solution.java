import java.io.*;
import java.util.*;
import java.math.*;

public class Solution {
    private static final boolean needFileIO = false;
    private static final String INPUT_FILE = "in";

    static class Solver {
	private StringBuilder sb = new StringBuilder();

	public void solve(InputReader in, PrintWriter out) {
	    int tc = in.ni();
	    while (tc-- > 0) {
		int n = in.ni();
		int[] arr = new int[n];
		for (int i = 0; i < n; ++i) {
		    int p = in.ni();
		    arr[i] = p;
		}
		int[] prefixSum = new int[n];
		prefixSum[0] = 0;
		int[] suffixSum = new int[n];
		suffixSum[0] = 0;
		int psum = 0, ssum = 0;
		for (int i = 1; i < n; ++i) {
		    psum += arr[i - 1];
		    prefixSum[i] = psum;
		    ssum += arr[n - i];
		    suffixSum[n - i - 1] = ssum;
		}
		boolean possible = false;
		//po("pre", prefixSum);
		//po("post", suffixSum);
		for (int i = 0; i < n; ++i) {
		    if (prefixSum[i] == suffixSum[i]) {
			    possible = true;
			    break;
		    }
		}
		po(possible ? "YES" : "NO");
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
	public String ns() {
	    while (t == null || !t.hasMoreTokens()) {
		try { t = new StringTokenizer(br.readLine());
		} catch (IOException e) { throw new RuntimeException(e); }
	    }
	    return t.nextToken();
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
