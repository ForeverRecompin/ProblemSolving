import java.io.*;
import java.util.*;
import java.math.*;

public class Solution {
    private static final boolean needFileIO = true;
    private static final String INPUT_FILE = "in";

    static class Solver {
	private StringBuilder sb = new StringBuilder();

	class UnionFind {
	    int[] parent, rank, setSize;
	    int numSets;

	    UnionFind(int n) {
		numSets = n;
		parent = new int[n];
		rank = new int[n];
		setSize = new int[n];
		for (int i = 0; i < n; ++i) {
		    p[i] = i;
		    rank[i] = 0;
		    setSize[i] = 1;
		}
	    }

	    int find(int i) {
		if (p[i] == i) return i;
		else {
		    int ret = find(p[i]);
		    p[i] = ret;
		    return ret;
		}
	    }

	    void merge(int i, int j) {
		int pi = find(i);
		int pj = find(j);
		if (pi == pj) return;
		if (rank[pi] > rank[pj]) {
		    parent[pj] = pi;
		    setSize[pi] += setSize[pj];
		} else {
		    parent[pi] = p[j];
		    setSize[pj] += setSize[pi];
		    if (rank[pi] == rank[pj]) {
			rank[pj] += 1;
		    }
		}
	    }
	}
	
	public void solve(InputReader in, PrintWriter out) {
	    
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
