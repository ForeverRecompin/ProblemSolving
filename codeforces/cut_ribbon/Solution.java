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
    static final int UPPER_BOUND = 40001;
    int n, a, b, c;
    int minConfig;
    int[] T = null;
        
    public void solve(InputReader in, PrintWriter out) {
	n = in.ni();
	a = in.ni();
	b = in.ni();
	c = in.ni();
	minConfig = getMin(a, b, c);
	initT();
	po(getLenOfRibbon(n, a, b, c));
	//poa(T);
	out.println(sb.toString());
    }

    int getLenOfRibbon(int n, int a, int b, int c) {
	//po(n);
	if (n == 0) {
	    //po("Hit base condition");
	    return 0;
	}
	if (n < minConfig) {
	    //po("Too low");
	    return -1000000000;
	}
	
	if (T[n] == -1) {
	    T[n] = getMax(1 + getLenOfRibbon(n - a, a, b, c),
			  1 + getLenOfRibbon(n - b, a, b, c),
			  1 + getLenOfRibbon(n - c, a, b, c));
	}
	return T[n];
	/*
	return getMax(1 + getLenOfRibbon(n - a, a, b, c),
			  1 + getLenOfRibbon(n - b, a, b, c),
			  1 + getLenOfRibbon(n - c, a, b, c));

	*/    
    }

    int getMin(int... N) {
	int min = (int) 1e+9;
	for (int i = 0; i < N.length; ++i) {
	    min = Math.min(min, N[i]);
	}
	return min;
    }

    int getMax(int... N) {
	int max = (int) -1e+9;
	for (int i = 0; i < N.length; ++i) {
	    max = Math.max(max, N[i]);
	}
	return max;
    }

    void initT() {
	T = new int[UPPER_BOUND];
	for (int i = 0; i < UPPER_BOUND; ++i) {
	    T[i] = -1;
	}
    }
    
    // Short for Process Output
    private void po(Object o) { sb.append("" + o).append("\n"); }
    private void po(Object... o) { sb.append("" + Arrays.toString(o)).append("\n"); }
    private void poa(Object... o) { sb.append(Arrays.deepToString(o)).append("\n"); }
    private void jpo(Object o) { sb.append("" + o); }
    private void jpo(Object... o) { sb.append("" + Arrays.toString(o)); }
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
