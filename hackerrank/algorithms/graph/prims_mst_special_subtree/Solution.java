import java.io.*;
import java.util.*;

class Solver {
    private static final int INF = Integer.MAX_VALUE;
    private StringBuilder sb = new StringBuilder();
    List<List<V>> adj = null;
    
    public void solve(InputReader in, PrintWriter out) {
        int n = in.ni(), m = in.ni();
        initAdj(n);
	int factor = 0;
        for (int i = 0; i < m; ++i) {
            int u = in.ni() - factor, v = in.ni() - factor, w = in.ni();
            addEdge(u, v, w);
            addEdge(v, u, w);
        }
        int src = in.ni() - factor;
        List<Integer> dist = solvePrimsMST(n, src);
        int totDist = 0;
        for (int d : dist) {
            totDist += d;
        }
        po(totDist);
        out.println(sb.toString());
    }
    
    private List<Integer> solvePrimsMST(int nOfV, int src) {
        List<Integer> dist = new ArrayList<>();
	boolean[] vis = new boolean[nOfV];
        for (int i = 0; i < nOfV; ++i) {
            dist.add(INF);
        }
        dist.set(src, 0);
        Queue<V> q = new PriorityQueue<>();
        q.offer(new V(src, dist.get(src)));
        while (!q.isEmpty()) {
            V vtx = q.poll();
	    int u = vtx.id;
            int wu = vtx.weight;
	    vis[u] = true;
	    if (wu > dist.get(u)) {
                continue;
            }
            for (V nbor : adj.get(u)) {
                int v = nbor.id;
                int wuv = nbor.weight;
                if (wuv < dist.get(v) && !vis[v]) {
		    dist.set(v, wuv);
                    q.offer(new V(v, dist.get(v)));
                }
            }
        }
        return dist;
    }
    
    private void addEdge(int u, int v, int w) {
        adj.get(u).add(new V(v, w));
    }
    
    private void initAdj(int nOfV) {
        adj = new ArrayList<>();
        for (int i = 0; i < nOfV; ++i) {
            List<V> nbor = new ArrayList<>();
            adj.add(nbor);
        }
    }
    
    class V implements Comparable<V> {
        public int id, weight;
        
        public V(int id_, int weight_) {
            id = id_;
            weight = weight_;
        }
        
        @Override
        public int compareTo(V other) {
            return ((Integer) weight).compareTo(((Integer) other.weight));
        }
    }
    
    private void po(Object o) { sb.append("" + o + "\n"); }
    private void po(Object... o) { sb.append("" + Arrays.toString(o) + "\n"); }
    private void jpo(Object o) { sb.append("" + o); }
    private void jpo(Object... o) { sb.append("" + Arrays.toString(o)); }
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
        Solver solver = new Solver();
        solver.solve(in, out);
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
