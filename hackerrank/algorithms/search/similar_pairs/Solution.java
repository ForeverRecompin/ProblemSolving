import java.io.*;
import java.util.*;

public class Solution {
    static boolean needFileInput = true;
    static String inputFile = "in";
    
    static class Solver {
	StringBuilder sb = new StringBuilder();
	List<List<Integer>> adj = null;
	List<Boolean> vis = null;
	int n, k;
	long pairs;
	
	void init(int n) {
	    adj = new ArrayList<>();
	    for (int i = 0; i < n; ++i) {
		List<Integer> nbor = new ArrayList<>();
		adj.add(nbor);
	    }
	}

	void addEdge(int u, int v) {
	    adj.get(u).add(v);
	}

	/*
	 * Dfs from node 'i'
	 */
	void dfs(int i) {
	    Deque<Integer> q = new ArrayDeque<>();
	    vis = new ArrayList<>(Collections.nCopies(n, false));
	    q.offerFirst(i);
	    while (!q.isEmpty()) {
		int u = q.pollFirst();
		//po("visiting", u);
		vis.set(u, true);
		for (int v : adj.get(u)) {
		    if (!vis.get(v)) {
			if (Math.abs(v - i) <= k) ++pairs;
			q.offerFirst(v);
		    }
		}
	    }
	}
	
	void solve(InputReader in, PrintWriter out) {
	    n = in.ni();
	    k = in.ni();
	    init(n);
	    for (int i = 0; i < n - 1; ++i) {
		int u = in.ni() - 1, v = in.ni() - 1;
		addEdge(u, v);
	    }
	    long res = 0;
	    for (int i = 0; i < n; ++i) {
		dfs(i);
		res = Math.max(res, pairs);
	    }
	    po(res);
	    out.println(sb);
	}

	void po(Object... o) { sb.append("" + Arrays.deepToString(o) + "\n"); }
	void po(Object o) { sb.append("" + o + "\n"); }
    }

    static class InputReader {
	StringTokenizer t;
	BufferedReader br;

	InputReader(InputStream is) {
	    t = null;
	    br = new BufferedReader(new InputStreamReader(is));
	}

	String ns() {
	    while (t == null || !t.hasMoreTokens()) {
		try {
		    t = new StringTokenizer(br.readLine());
		} catch (IOException e) {
		    throw new RuntimeException(e);
		}
	    }
	    return t.nextToken();
	}

	int ni() {
	    return Integer.parseInt(ns());
	}

	long nl() {
	    return Long.parseLong(ns());
	}
    }
    
    public static void main(String[] args) {
	InputStream is = System.in;
	if (needFileInput) {
	    try {
		is = new FileInputStream(inputFile);
	    } catch (FileNotFoundException e) {
		throw new RuntimeException(e);
	    }
	}
	InputReader in = new InputReader(is);
	OutputStream os = System.out;
	PrintWriter out = new PrintWriter(os);
	new Solver().solve(in, out);
	out.close();
    }

}
