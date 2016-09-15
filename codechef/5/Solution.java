import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    private static final boolean needFileIO = false;
    private static final String INPUT_FILE = "in";

    static class Solver {
	private StringBuilder sb = new StringBuilder();
	List<Integer> color = null;
	List<List<Integer>> adj = null;
	List<Integer> monoNodes = null;
	int n;
	int res;
	
	void init() {
	    adj = new ArrayList<>();
	    for (int i = 0; i < n; ++i) {
		List<Integer> nbor = new ArrayList<>();
		adj.add(nbor);
	    }
	}

	void addEdge(int u, int v) {
	    adj.get(u).add(v);
	}

	void bfs(int i) {
	    List<Boolean> vis = new ArrayList<>(Collections.nCopies(n, false));
	    Deque<Integer> q = new ArrayDeque<>();
	    monoNodes = new ArrayList<>(Collections.nCopies(n, -1));
	    q.offerFirst(i);
	    while (!q.isEmpty()) {
		int u = q.pollLast();
		//po("visiting", u);
		int uc = color.get(u);
		vis.set(u, true);
		int mono = 1;
		boolean isMono = true;
		for (int v : adj.get(u)) {
		    if (!vis.get(v)) {
			q.offerFirst(v);
			if (color.get(v) == uc) {
			    mono++;
			} else {
			    isMono = false;
			}
		    }
		}
		if (isMono && adj.get(u).size() > 1) {
		    monoNodes.set(u, mono);
		    res = Math.max(res, mono);
		} else {
		    monoNodes.set(u, 0);
		}
	    }
	}
		
	public void solve(InputReader in, PrintWriter out) {
	    int tc = in.ni();
	    while (tc-- > 0) {
		n = in.ni();
		color = new ArrayList<>();
		for (int i = 0; i < n; ++i) {
		    int c = in.ni();
		    color.add(c);
		}
		init();
		for (int i = 0; i < n - 1; ++i) {
		    int u = in.ni() - 1, v = in.ni() - 1;
		    addEdge(u, v);
		}
		//po(color);
		//po(adj);
		int ans = -9999;
		for (int i = 0; i < n; ++i) {
		    res = -9999;
		    bfs(i);
		    //po(monoNodes);
		    ans = Math.max(ans, res);
		}
		po(ans == -9999 ? 1 : ans);
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
