import java.io.*;
import java.util.*;

@SuppressWarnings("unchecked")
class Solver {
    private static final int INF = Integer.MAX_VALUE;
    private StringBuilder sb = new StringBuilder();
    private List<List<V>> adj;
    
    public void solve(InputReader in, PrintWriter out) {
	int tc = in.ni();
	while (tc-- > 0) {
	    int n = in.ni(), m = in.ni();
	    adj = new ArrayList<>();
	    initAdj(n);
	    for (int i = 0; i < m; ++i) {
		int u = in.ni() - 1, v = in.ni() - 1, w = in.ni();
		addEdge(u, v, w);
		addEdge(v, u, w);
	    }
	    //po(adj);
	    int src = in.ni() - 1;
	    List<Integer> dist = getSSSPDist(n, src);
	    for (int d = 0; d < dist.size(); ++d) {
		if (d == src) continue;
		if (dist.get(d) == INF)    jpo(-1 + " "); 
		else    jpo(dist.get(d) + " ");
	    }
	    jpo("\n");
	}
	out.println(sb.toString());
    }

    private List<Integer> getSSSPDist(int nOfV, int src) {
	//po(adj);
	List<Integer> dist = new ArrayList<>();
	for (int i = 0; i < nOfV; ++i) {
	    dist.add(INF);
	}
	Comparator<V> c = (v1, v2) ->
	    ((Integer) v1.weight).compareTo(((Integer) v2.weight));
	Queue<V> q = new PriorityQueue<>(nOfV, c);
	dist.set(src, 0);
	q.offer(new V(src, src, 0));
	while (!q.isEmpty()) {
	    V vtx = q.poll();
	    int wu = vtx.weight; int u = vtx.toId; 
	    if (wu > dist.get(u)) continue;
	    for (V nbor : adj.get(u)) {
		int v = nbor.toId;
		int wuv = nbor.weight;
		int distV = dist.get(v);
		if (distV > wu + wuv) {
		    dist.set(v, wu + wuv);
		    q.offer(new V(u, v, dist.get(v)));
		}
	    }
	}
	return dist;
    }
    
    private List<Integer> getSlowSSSPDist(int nOfV, int src) {
	List<Integer> dist = new ArrayList();
	boolean[] vis = new boolean[nOfV];
	for (int i = 0; i < nOfV; ++i) {
	    dist.add(INF);
	    vis[i] = false;
	}
	dist.set(src, 0);
	while (true) {
	    int minW = INF;
	    int closestV = -1;
	    for (int i = 0; i < nOfV; ++i) {
		int w = dist.get(i);
		if (w < minW && !vis[i]) {
		    minW = w;
		    closestV = i;
		} 
	    }
	    if (closestV == -1) {
		break;
	    }
	    int u = closestV;
	    vis[u] = true;
	    List<V> nbors = adj.get(u);
	    for (V vtx : nbors) {
		int v = vtx.toId;
		int w = vtx.weight;
		int relW = w + dist.get(u);
		if (dist.get(v) > relW) {
		    dist.set(v, relW);
		}
	    }
	}
	return dist;
    }

    private void addEdge(int u, int v, int w) {
	//po(u, v, w);
	adj.get(u).add(new V(u, v, w));
    }

    private void initAdj(int nOfV) {
	for (int i = 0; i < nOfV; ++i) {
	    List<V> nbor = new ArrayList<>();
	    adj.add(nbor);
	}
    }
    
    private void po(Object... o) {
	sb.append(Arrays.toString(o)).append("\n");
    }
    
    private void po(Object o) {
	sb.append("" + o).append("\n");
    }

    private void jpo(Object... o) {
	sb.append(Arrays.toString(o));
    }
    
    private void jpo(Object o) {
	sb.append("" + o);
    }

    class V {
	public int fromId, toId, weight;
	
	public V(int fromId, int toId, int weight) {
	    this.fromId = fromId;
	    this.toId = toId;
	    this.weight = weight;
	}

	@Override 
	public String toString() {
	    return "(" + fromId + ", " + toId  + ", " + weight + ")";
	}
    }
}

public class Solution {
    public static void main(String[] args) {
	InputStream is;
	boolean needFileInput = true;
	try {
	    if (needFileInput)    is = new FileInputStream("in");
	    else is = System.in;
	} catch (Exception e) {
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
    private StringTokenizer t;
    private BufferedReader br;

    public InputReader(InputStream is) {
	t = null;
	br = new BufferedReader(new InputStreamReader(is));
    }

    public String ns() {
	while (t == null || !t.hasMoreTokens()) {
	    try {
		t = new StringTokenizer(br.readLine());
	    } catch (Exception e) {
		throw new RuntimeException(e);
	    }
	}
	return t.nextToken();
    }

    public int ni() {
	return Integer.parseInt(ns());
    }
}
