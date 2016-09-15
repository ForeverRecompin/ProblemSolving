import java.io.*;
import java.util.*;

public class Solution {
    static boolean needFileInput = false;

    static class Solver {
	StringBuilder sb = new StringBuilder();
	static final int FACTOR = 200;
	static final int UPPER_BOUND = 1001;
	int[] countArr = null;
	int minCount = (int) FACTOR * UPPER_BOUND;
	
	void solve(InputReader in, PrintWriter out) {
	    int n = in.ni(), m = in.ni();
	    init();
	    minCount = getWays(n, m, 0);
	    po(minCount == (FACTOR * UPPER_BOUND) ? 0 : minCount);
	    // --- Output ---
	    out.println(sb.toString());
	}

	int getWays(int n, int m, int count) {
	    Queue<State> q = new ArrayDeque<>();
	    State u = new State(n, 0);
	    countArr[n] = 0;
	    q.offer(u);
	    while(!q.isEmpty()) {
		u = q.poll();
		//po(u.id);

		if (u.id == m) break;
		
		if (u.id - 1 < 0 || 2 * u.id >= FACTOR * UPPER_BOUND) continue;
		
		if (countArr[u.id - 1] == 0) {
		    countArr[u.id - 1] = countArr[u.id] + 1;
		    q.offer(new State(u.id - 1, countArr[u.id - 1]));
		}
		if (countArr[2 * u.id] == 0) {
		    countArr[2 * u.id] = countArr[u.id] + 1;
		    q.offer(new State(2 * u.id, countArr[2 * u.id]));
		}
	    }
	    return u.count;
	}

	void init() {
	    countArr = new int[FACTOR * UPPER_BOUND];
	    Arrays.fill(countArr, 0);
	}

	class State {
	    int id, count;
	    State(int id, int count) {
		this.id = id;
		this.count = count;
	    }
	}
	
	void po(Object o) { sb.append("" + o + "\n"); }
	void po(Object... o) { sb.append("" + Arrays.deepToString(o) + "\n"); }
    }

    public static void main(String[] args) {
	InputStream is = System.in;
	if (needFileInput) {
	    try {
		is = new FileInputStream("in");
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
    }
}
