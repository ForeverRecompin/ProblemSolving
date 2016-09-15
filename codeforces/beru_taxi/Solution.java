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
    List<Loc> L = null;
    
    public void solve(InputReader in, PrintWriter out) {
	int x = in.ni(), y = in.ni();
	Loc init = new Loc(x, y, 0);
	L = new ArrayList();
	L.add(init);
	int numOfTaxis = in.ni();
	for (int i = 0; i < numOfTaxis; ++i) {
	    x = in.ni();
	    y = in.ni();
	    int v = in.ni();
	    L.add(new Loc(x, y, v));
	}
	int homeX = L.get(0).x, homeY = L.get(0).y;
	double minTime = 1e+6;
	for (int i = 1; i <= numOfTaxis; ++i) {
	    Loc cur = L.get(i);
	    double dist = Math.sqrt((Math.pow((cur.x - homeX),2))
				    + (Math.pow((cur.y - homeY), 2)));
	    minTime = Math.min(minTime, dist/cur.v);
	    //po(i, dist, dist/cur.v);
	}
	String res = String.format("%.19f", minTime);
	po(res);
        out.println(sb.toString());
    }

    // Location
    class Loc {
	int x, y, v;
	Loc(int x, int y, int v) {
	    this.x = x;
	    this.y = y;
	    this.v = v;
	}

	public String toString() {
	    return x + " " + y;
	}
    }

    // Short for Process Output
    private void po(Object o) { sb.append("" + o).append("\n"); }
    private void po(Object... o) { sb.append("" + Arrays.toString(o)).append("\n"); }
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
