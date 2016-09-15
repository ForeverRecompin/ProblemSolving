import java.io.*;
import java.util.*;

public class Solution {

    static boolean fio = true;

    static class Solver {
	int n, m;
	char[][] board;
	boolean cycle = false;
	boolean[][] vis;
	int[] dx = {0, 0, 1, -1};
	int[] dy = {1, -1, 0, 0};
	
	/*
	 * DFS Cycle Detection
	 *
	 * cr: current row, cc: current col, 
	 * fromc: from col, fromr: from row,
	 * col: color under inspection.
	 */
	void findCycle(int cr, int cc, int col) {
	    if (board[cr][cc] != col) return;
	    if (vis[cr][cc]) {
		cycle = true;
		return;
	    }
	    vis[cr][cc] = true;
	    //po("Going to: ", cr, cc);
	    for (int i = 0; i < 4; ++i) {
		int nr = cr + dx[i];
		int nc = cc + dy[i];
		if (nr < 0 || nr >= n || nc < 0 || nc >= m) continue;
		findCycle(nr, nc, col);
	    }
	}
	
	void solve(InputReader in, PrintWriter out) {
	    n = in.ni();
	    m = in.ni();
	    board = new char[n][m];
	    vis = new boolean[n][m];
	    for (int i = 0; i < n; ++i) {
		board[i] = in.ns().toCharArray();
		Arrays.fill(vis[i], false);
	    }
	    for (int i = 0; i < n; ++i) {
		for (int j = 0; j < m; ++j) {
		    if (!vis[i][j]) {
			findCycle(i, j, board[i][j]);
			 po("from", i, j);
			 for (boolean[] sub_vis : vis) {
			     po("sub_vis", sub_vis);
			 }
		    }
     		    //if (cycle) break;
		}
	    }
	    po(cycle == true ? "Yes" : "No");
	    out.println(sb);
	}
	
	StringBuilder sb = new StringBuilder();
	void po(Object... o) { sb.append("" + Arrays.deepToString(o) + "\n"); }
	void po(Object o) { sb.append("" + o + "\n"); }
	void jpo(Object o) { sb.append("" + o); } 
    }

    static class InputReader {
	StringTokenizer t;
	BufferedReader br;
	
	InputReader(InputStream is) {
	    br = new BufferedReader(new InputStreamReader(is));
	    t = null;
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
    
    public static void main(String[] args) throws FileNotFoundException {
	InputReader in = new InputReader(System.in);
	if (fio) in = new InputReader(new FileInputStream("in"));
	PrintWriter out = new PrintWriter(System.out);
	new Solver().solve(in, out);
	out.close();
    }
}
