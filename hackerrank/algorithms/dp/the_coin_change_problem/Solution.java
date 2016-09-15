import java.io.*;
import java.util.*;

public class Solution {
    private static boolean needFileInput = true;

    public static void main(String[] args) {
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

class Solver {
    private StringBuilder sb = new StringBuilder();
    private int[] w = null;
    private int[][] T = null;
    
    public void solve(InputReader in, PrintWriter out) {
	int n = in.ni(), m = in.ni();
	w = new int[m];
	for (int i = 0; i < m; ++i) {
	    w[i] = in.ni();
	}
	T = new int[m + 1][n + 1];
	for (int[] sarr : T) { Arrays.fill(sarr, -1); }
	T[0][0] = 0;
	int ways = getWays(n, m - 1);
	po(ways);	
	for (int[] sarr : T) { po(Arrays.toString(sarr));  }
	out.println(sb.toString());
    }

    private int getWays(int n, int ind) {
	if (ind < 0 || n < 0) {
	    return 0;
	}
	if (n == 0) {
	    return 1;
	}
	if (T[ind][n] == -1) {
	    T[ind][n] = getWays(n, ind - 1) + getWays(n - w[ind], ind);
	}
	return T[ind][n];
    }
    
    private void po(Object o) { sb.append("" + o + "\n"); }
}

class InputReader {
    private StringTokenizer t;
    private BufferedReader br;

    public InputReader(InputStream is) {
	br = new BufferedReader(new InputStreamReader(is));
	t = null;
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

    public int ni() { return Integer.parseInt(ns()); }
}
