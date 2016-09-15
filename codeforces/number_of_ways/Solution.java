import java.io.*;
import java.util.*;
import java.math.*;

public class Solution {
    private static final boolean needFileIO = false;
    private static final String INPUT_FILE = "in";

    static class Solver {
	private StringBuilder sb = new StringBuilder();
	List<Integer> N;
	
	public void solve(InputReader in, PrintWriter out) {
	    int n = in.ni();
	    N = new ArrayList<>();
	    long sum = 0;
	    boolean allZero = true;
	    for (int i = 0; i < n; ++i) {
		int number = in.ni();
		sum += number;
		N.add(number);
		if (allZero) {
		    allZero = number == 0 ? true : false;
		}
	    }
	    if (allZero) {
		po(3 * n  + 1);
	    }
	    else if (sum % 3 != 0) {
		po(0);
	    } else {
		long oneThirds = sum/3;
		long runningSum = 0;
		long countOfZeroes = 0;
		long ways = 1;
		for (int i = 0; i < n - 1; ++i) {
		    int num = N.get(i);
		    runningSum += num;
		    if (runningSum == oneThirds) {
			po(N, i, runningSum);
			while (N.get(i + 1) == 0 && (i + 1) < n - 1) {
			    ++countOfZeroes;
			    ++i;
			}
			ways = ways * (countOfZeroes + 1);
			runningSum = 0;
		    }
		}
		po(ways == 1 ? 0 : ways);
	    }
	    out.println(sb.toString());
	}

	// Short for Process Output
	private void po(Object o) { sb.append("" + o).append("\n"); }
	private void po(Object... o) { sb.append("" + Arrays.deepToString(o)).append("\n"); }
	private void jpo(Object o) { sb.append("" + o); }
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
      
    public static void main(String[] args) {
	InputStream is = System.in;
	if (needFileIO) {
	    try {
		is = new FileInputStream(INPUT_FILE);
		//os = new FileOutputStream("out");
	    } catch (FileNotFoundException e) { throw new RuntimeException(e); }
	}
	InputReader in = new InputReader(is);
	OutputStream os = System.out; PrintWriter out = new PrintWriter(os);
	new Solver().solve(in, out);
	out.close();
    }
}
