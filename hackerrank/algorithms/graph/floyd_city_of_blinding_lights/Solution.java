import java.io.*;
import java.util.*;

class Solver {
    private static final int INF = (int) Math.pow(10, 9);
    private StringBuilder sb = new StringBuilder();
    private int[][] adj = null;
    
    public void solve(InputReader in, PrintWriter out) {
	//po("Ok, this works");
	int factor = 1;
	int n = in.ni(), m = in.ni();
	initAdj(n);
	for (int i = 0; i < m; ++i) {
	    int u = in.ni() - factor, v = in.ni() - factor, w = in.ni();
	    addEdge(u, v, w);
	}
	getFloydDist(n);
	int q = in.ni();
	for (int i = 0; i < q; ++i) {
	    int a = in.ni() - factor, b = in.ni() - factor;
	    int w = adj[a][b];
	    po(w != INF ? w : -1);
	}
	out.println(sb.toString());
    }

    private void getFloydDist(int n) {
	int i, j, k;
	for (k = 0; k < n; k++) {
	    for (i = 0; i < n; i++) {
		for (j = 0; j < n; j++) {
		    //po(k, i, j, adj[i][j], adj[i][k] + adj[k][j]);
		    adj[i][j] = Math.min(adj[i][j], adj[i][k] + adj[k][j]);
		}
	    }
	}
    }

    private void addEdge(int u, int v, int w) {
	adj[u][v] = w;
    }
    
    private void initAdj(int nOfV) {
	adj = new int[nOfV][nOfV];
	for (int i = 0; i < nOfV; ++i) {
	    for (int j = 0; j < nOfV; ++j) {
		if (i != j) adj[i][j] = INF;
		else adj[i][j] = 0;
	    }
	}
    }
    
    class V {
	int id, weight;

	public V(int id, int weight) {
	    this.id = id;
	    this.weight = weight;
	}
    }

    private void po(Object o) {
	sb.append("" + o).append("\n");
    }

    private void po(Object... o) {
	sb.append("" + Arrays.toString(o)).append("\n");
    }
}


public class Solution {
    public static void main(String[] args) {
	boolean needFileInput = true;
	InputStream is;
	try {
	    if (needFileInput) is = new FileInputStream("in");
	    else is = System.in;
	} catch (FileNotFoundException e) {
	    throw new RuntimeException(e);
	}
	InputReader in = new InputReader(is);
	OutputStream os = System.out;
	PrintWriter out = new PrintWriter(os);
	new Solver().solve(in, out);
	out.close();
    }
}

class InputReader {
    private BufferedReader br;
    private StringTokenizer t;

    public InputReader(InputStream is) {
	t = null;
	br = new BufferedReader(new InputStreamReader(is));
    }

    public String ns() {
	while (t == null || !t.hasMoreTokens()) {
	    try {
		t = new StringTokenizer(br.readLine());
	    } catch (IOException e) {
		throw new RuntimeException(e);
	    }
	}
	return t.nextToken();
    }

    public int ni() {
	return Integer.parseInt(ns());
    }
}
