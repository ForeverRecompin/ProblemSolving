import java.io.*;
import java.util.*;

public class Solution {
    static boolean needFileInput = false;
    static String inputFile = "in";

    static class Solver {
	StringBuilder sb = new StringBuilder();

	void solve(InputReader in, PrintWriter out) {
	    int m = in.ni(), n = in.ni();
	    po(n * m < 2 ? 0 : n * m / 2);
	    out.println(sb);
	}

	void po(Object... o) { sb.append("" + Arrays.deepToString(o) + "\n"); }
	void po(Object o) { sb.append("" + o + "\n"); }
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
	PrintWriter out = new PrintWriter(System.out);
	new Solver().solve(in, out);
	out.close();
    }
}
