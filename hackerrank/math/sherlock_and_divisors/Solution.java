import java.io.*;
import java.util.*;

public class Solution {
    static boolean needFileInput = false;
    static String inputFile = "in";

    static class Solver {
	StringBuilder sb = new StringBuilder();

	void solve(InputReader in, PrintWriter out) {
	    int tc = in.ni();
	    while (tc-- > 0) {
		long n = in.nl();
		int numOfFactors = 0;
		for (int i = 1; i <= Math.sqrt(n); ++i) {
		    if (n % i == 0 && i % 2 == 0) ++numOfFactors;
		    if (n % (n/i) == 0 && n/i != i && (n/i) % 2 == 0) ++numOfFactors;
		}
		po(numOfFactors);
	    }
	    out.println(sb.toString());
	}

	void po(Object o) { sb.append("" + o + "\n"); }
	void po(Object... o) { sb.append("" + Arrays.deepToString(o) + "\n"); }
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
