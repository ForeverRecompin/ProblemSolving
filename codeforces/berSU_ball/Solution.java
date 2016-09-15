import java.io.*;
import java.util.*;
import java.math.*;

public class Solution {
    private static boolean needFileIO = false;
    public static void main(String[] args) {
	InputStream is = System.in;
	if (needFileIO) {
	    try {
		is = new FileInputStream("in");
		//os = new FileOutputStream("out");
	    } catch (FileNotFoundException e) { throw new RuntimeException(e); }
	}
	InputReader in = new InputReader(is);
	OutputStream os = System.out; PrintWriter out = new PrintWriter(os);
	new Solver().solve(in, out);
	out.close();
    }
}

class Solver {
    private StringBuilder sb = new StringBuilder();

    public void solve(InputReader in, PrintWriter out) {
	int n = in.ni();
	int[] boys = new int[n];
	getInput(in, n, boys);
	int m = in.ni();
	int[] girls = new int[m];
	getInput(in, m, girls);
	po(getMaxPairs(boys, girls));
        out.println(sb.toString());
    }

    int getMaxPairs(int[] A, int[] B) {
	Arrays.sort(A);
	Arrays.sort(B);
	int prev = 0;
	int j = prev;
	int pairs = 0;
	for (int i = 0; i < A.length; ++i) {
	    boolean paired = false;
	    while (!paired) {
		if (j >= B.length) break;
		if (Math.abs(A[i] - B[j]) <= 1) {
		    ++pairs;
		    prev = j + 1;
		    paired = true;
		    //po("Paired: ", i, j);
		    break;
		}
		++j;
	    }
	    j = prev;
	}
	return pairs;
    }

    void getInput(InputReader in, int n, int[] N) {
	for (int i = 0; i < n; ++i) {
	    N[i] = in.ni();
	}
    }

    // Short for Process Output
    private void po(Object o) { sb.append("" + o).append("\n"); }
    private void po(Object... o) { sb.append("" + Arrays.deepToString(o)).append("\n"); }
    private void jpo(Object o) { sb.append("" + o); }
}

class InputReader {
    private final BufferedReader br;
    private StringTokenizer t;
    public InputReader(InputStream is) { br = new BufferedReader(new InputStreamReader(is)); t = null; }
    public int ni() { return Integer.parseInt(ns()); }
    public long nl() { return Long.parseLong(ns()); }
    public double nd() { return Double.parseDouble(ns()); }
    public BigInteger nbi() { return new BigInteger(ns()); }
    public BigDecimal nbd() { return new BigDecimal(ns()); }
    public String ns() {
	while (t == null || !t.hasMoreTokens()) {
	    try { t = new StringTokenizer(br.readLine());
	    } catch (IOException e) { throw new RuntimeException(e); }}
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
