import java.io.*;
import java.util.*;

public class Solution {
    static boolean needFileInput = true;
    static String inputFile = "in";

    static class Solver {
	int UPPER_BOUND = (int) 10 + 1;
	int[] N = new int[UPPER_BOUND];
	
	void solve(InputReader in, PrintWriter out) {
	    int n = in.ni();
	    for (int i = 0; i < n; ++i) N[i] = in.ni();
	    int currentSum = N[0], maxSum = N[0], bestFrom = 0, from = 0, to = 0;
	    for (int i = 1; i < n; ++i) {
		if (currentSum + N[i] > N[i]) {
		    currentSum = currentSum + N[i];
		} else {
		    from = i;
		    currentSum = N[i];
		}
		if (currentSum > maxSum) {
		    to = i;
		    bestFrom = from;
		    maxSum = currentSum;
		}
	    }
	    print(bestFrom, to, maxSum);
	    out.println(sb);
	}

	StringBuilder sb = new StringBuilder();
	void print(Object... o) { sb.append("" + Arrays.deepToString(o) + "\n"); }
	void print(Object o) { sb.append("" + o + "\n"); }
	void jprint(Object o) { sb.append("" + o); }
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
