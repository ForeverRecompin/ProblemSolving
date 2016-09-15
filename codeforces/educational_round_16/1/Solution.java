import java.io.*;
import java.util.*;
import java.math.*;

public class Solution {
    private static final boolean needFileIO = false;
    private static final String INPUT_FILE = "in";

    static class Solver {
	private StringBuilder sb = new StringBuilder();
	int[] dx = {1, -1,  0, 0, 1,-1, 1, -1};
	int[] dy = {0,  0, -1, 1, 1, 1,-1, -1};
	public void solve(InputReader in, PrintWriter out) {
	    char[] pos = in.ns().toCharArray();
	    //po("pos", pos);
	    int c = pos[0] - 'a';
	    int r = pos[1] - '1';
	    int moves = 0;
	    for (int i = 0; i < 8; ++i) {
		int nr = r + dx[i];
		int nc = c + dy[i];
		if (nr >= 0 && nr < 8 && nc >= 0 && nc < 8) ++moves;
	    }
	    po(moves);
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
