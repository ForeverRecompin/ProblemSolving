import java.io.*;
import java.util.*;

public class Solution {
    //private static final boolean needFileIO = true;
    //private static final String INPUT_FILE = "in";

    static class Solver {
	//private StringBuilder sb = new StringBuilder();
		
	void solve(InputReader in, PrintWriter out) {
	    int n = in.ni();
	    Integer[] N = new Integer[n];
	    for (int i = 0; i < n; ++i) {
		int x = in.ni();
		N[i] = x;
	    }
	    /*
	    //WA #1
	    // Correct algorithm: Finding the geometric mean.
	    //long ans = (long) 1e18 + 1; // minimize sum
	    //po(ans);
	    long[] N_copy = Arrays.copyOf(N, n);
	    Arrays.sort(N_copy);
	    long min_dist = N[1];
	    int atIndex = 0;
	    for (int i = 0; i < n; ++i) {
		if (N[i] == min_dist) {
		    atIndex = i;
		    break;
		} 
	    }
	    po(atIndex + 1);
	    */
	    Arrays.sort(N);
	    out.println(N[(n-1)/2]);
	    // out.println(sb.toString());
	}
    }

    static class InputReader {
	private final BufferedReader br;
	private StringTokenizer t;
	public InputReader(InputStream is) {
	    br = new BufferedReader(new InputStreamReader(is), 32768);
	    t = null;
	}
	public int ni() { return Integer.parseInt(ns()); }
	public String ns() {
	    while (t == null || !t.hasMoreTokens()) {
		try { t = new StringTokenizer(br.readLine());
		} catch (IOException e) { throw new RuntimeException(e); }
	    }
	    return t.nextToken();
	}
    }
      
    public static void main(String[] args) {
	InputStream is = System.in;
	/*
	if (needFileIO) {
	    try {
		is = new FileInputStream(INPUT_FILE);
		//os = new FileOutputStream("out");
	    } catch (FileNotFoundException e) { throw new RuntimeException(e); }
	}
	*/
	InputReader in = new InputReader(is);
	OutputStream os = System.out; PrintWriter out = new PrintWriter(os);
	new Solver().solve(in, out);
	out.close();
    }
}
