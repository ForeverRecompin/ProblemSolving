import java.io.*;
import java.util.*;

public class Solution {
    static boolean fio = true;

    static class Solver {
	StringBuilder sb = new StringBuilder();

	void solve(InputReader in, PrintWriter out) {
	    int n = in.ni(), sum, prob = 0;
	    for (int i = 0; i < n; ++i) {
		sum = 0;
		for (int j = 0; j < 3; ++j) sum += in.ni();
		if (sum >= 2) {
		    ++prob;
		}
	    }
	    po(prob);
	    out.println(sb);
	}

	void po(Object... o) { sb.append("" + Arrays.deepToString(o) + "\n"); }
	void po(Object o) { sb.append("" + o + "\n"); }
	void jpo(Object o) { sb.append("" + o); }
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
    public static void main(String[] args) throws FileNotFoundException {
	InputReader in = new InputReader(System.in);
	if (fio) in = new InputReader(new FileInputStream("in"));
	PrintWriter out = new PrintWriter(System.out);
	new Solver().solve(in, out);
	out.close();
    }
}

import java.io.*;
import java.util.*;
import java.math.*;

public class Solution {
    private static final boolean fio = true;

    static class Solver {

        public void solve(InputReader in, PrintWriter out) {

        }

        private void po(Object o) { System.out.println("> " + o); }
        private void po(Object... o) { System.out.println("> " + Arrays.deepToString(o)); }
    }

    static class InputReader {
        private final BufferedReader br;
        private StringTokenizer t;
        public InputReader(InputStream is) {
            br = new BufferedReader(new InputStreamReader(is));
            t = null;
        }
        public int ni() { return Integer.parseInt(ns()); }
        public long nl() { return Long.parseLong(ns()); }
        public double nd() { return Double.parseDouble(ns()); }
        public BigInteger nbi() { return new BigInteger(ns()); }
        public BigDecimal nbd() { return new BigDecimal(ns()); }
        public String ns() {
            while (t == null || !t.hasMoreTokens()) {
                try { t = new StringTokenizer(br.readLine());
                } catch (IOException e) { throw new RuntimeException(e); }
            }
            return t.nextToken();
        }
        public String nli() {
            String line = "";
            try {
                line = br.readLine();
            } catch (IOException e) { throw new RuntimeException(e); }
            return line;
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
