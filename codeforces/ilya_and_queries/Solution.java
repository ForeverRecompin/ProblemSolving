import java.io.*;
import java.util.*;

public class Solution {
    static boolean needFileInput = true;
    public static void main(String[] args) {
	InputStream is;
	if (needFileInput) {
	    try {
		is = new FileInputStream("in");
	    } catch (FileNotFoundException e) {
		throw new RuntimeException(e);
	    }
	} else {
	    is = System.in;
	}
	InputReader in = new InputReader(is);
	OutputStream os = System.out;
	PrintWriter out = new PrintWriter(os);
	Solver solver = new Solver();
	solver.solve(in, out);
	out.close();
    }
}

class Solver {
    StringBuilder sb = new StringBuilder();
    String s = null;
    char[] N = null;
    int[] T = null;
    int[] sumArray = null;
    
    public void solve(InputReader in, PrintWriter out) {
	// --- Input ---
	s = in.ns();
	int m = in.ni();
	// --- Meats and Potatoes ---
	init(s.length());
	precalc(s.length());
	for (int i = 0; i < m; ++i) {
	    int a = in.ni() - 1, b = in.ni() - 1;
	    po(sumArray[b] - sumArray[a]);
	}
	
	// --- Output --- 
	out.println(sb);
    }

    void precalc(int n) {
	for (int i = n - 1; i >= 1; --i) {
	    if (N[i] == N[i - 1]) T[i] = 1;
	    else T[i] = 0;
	}
	int sum = 0;
	for (int i = 0; i < n; ++i) {
	    sum += T[i];
	    sumArray[i] = sum; 
	}
    }

    void init(int n) {
	T = new int[n];
	sumArray = new int[n];
	N = s.toCharArray();
	Arrays.fill(T, 0);
	Arrays.fill(sumArray, 0);
    }

    void po(Object o) { sb.append("" + o + "\n"); }
    void po(Object... o) { sb.append("" + Arrays.deepToString(o) + "\n"); }
}

class InputReader {
    StringTokenizer t;
    BufferedReader br;
    
    InputReader(InputStream is) {
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
    
    public int ni() { return Integer.parseInt(ns()); }
}
