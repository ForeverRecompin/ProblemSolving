import java.io.*;
import java.util.*;
import java.math.*;

public class Solution {
    private static boolean needFileIO = false;
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
    List<List<Integer>> rail = null;
    List<List<Integer>> bus = null;
    List<Boolean> vis = null;
    List<Integer> dist = null;
    int n, m;
    
    public void solve(InputReader in, PrintWriter out) {
	n = in.ni();
	m = in.ni();
	init(n);
	for (int i = 0; i < n - 1; ++i) {
	    for (int j = i + 1; j < n; ++j) {
		addEdge(i, j, bus);
	    }
	}
	for (int i = 0; i < m; ++i) {
	    int u = in.ni() - 1, v = in.ni() - 1;
	    addEdge(u, v, rail);
	    removeEdge(u, v, bus);
	}
	int railDist = getDist(n, 0, n - 1, rail);
	int busDist = getDist(n, 0, n - 1, bus);
	if (railDist == -1 || busDist == -1) po(-1);
	else po(Math.max(railDist, busDist));
	out.println(sb.toString());
    }

    int getDist(int n, int src, int dest, List<List<Integer>> adj) {
	dist = new ArrayList<>();
	vis = new ArrayList<>();
	for (int i = 0; i < n; ++i) {
	    dist.add(-1);
	    vis.add(false);
	}
	Queue<Integer> q = new ArrayDeque<>();
	dist.set(src, 0);
	q.offer(src);
	while (!q.isEmpty()) {
	    int u = q.poll();
	    int udist = dist.get(u);
	    if (u == dest) break;
	    vis.set(u, true);
	    for (int nbor : adj.get(u)) {
		if (vis.get(nbor)) continue;
		vis.set(nbor, true);
		dist.set(nbor, 1 + udist);
		q.offer(nbor);
	    }
	}
	//po(adj);
	//po(dist);
	return dist.get(n - 1);
    }

    void addEdge(int u, int v, List<List<Integer>> adj) {
	if (u >= n || v >= n) return;
	adj.get(u).add(v);
	adj.get(v).add(u);
    }

    void removeEdge(int u, int v, List<List<Integer>> adj) {
	if (u >= n || v >= n) return;
	adj.get(u).remove((Integer) v);
	adj.get(v).remove((Integer) u);
    }
	
    void init(int n) {
	rail = new ArrayList<>();
	bus = new ArrayList<>();
	for (int i = 0; i < n; ++i) {
	    List<Integer> nbor = new ArrayList<>();
	    List<Integer> anotherNbor = new ArrayList<>();
	    rail.add(nbor);
	    bus.add(anotherNbor);
	}
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
