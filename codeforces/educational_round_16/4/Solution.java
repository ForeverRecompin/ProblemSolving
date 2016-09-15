import java.io.*;
import java.util.*;
import java.math.*;

public class Solution {
    private static final boolean needFileIO = false;
    private static final String INPUT_FILE = "in";

    static class Solver {
	private StringBuilder sb = new StringBuilder();

	public void solve(InputReader in, PrintWriter out) {
	    long a1 = in.nl(), b1 = in.ni(), a2 = in.ni(), b2 = in.ni();
	    long l = in.nl(), r = in.nl();
	    //List<Long> series_1 = new ArrayList<>();
	    //List<Long> series_2 = new ArrayList<>();
	    Map<Long, Integer> occur_m = new LinkedHashMap<>();
	    long el_series_1 = 0, el_series_2 = 0;
	    for (int i = 0; ; ++i) {
		el_series_1 = (a1 * (long) i) + b1;
		//series_1.add(el_series_1);
		if (occur_m.get(el_series_1) == null) {
		    occur_m.put(el_series_1, 1);
		} else {
		    occur_m.put(el_series_1, occur_m.get(el_series_1) + 1);
		}
		el_series_2 = (a2 * (long) i) + b2;
		if (occur_m.get(el_series_2) == null) {
		    occur_m.put(el_series_2, 1);
		} else {
		    occur_m.put(el_series_2, occur_m.get(el_series_2) + 1);
		}
		//series_2.add(el_series_2);
		if (el_series_1 >= r && el_series_2 >= r) break; 
	    }
	    int ans = 0;
	    for (Map.Entry<Long, Integer> e : occur_m.entrySet()) {
		if (e.getKey() >= l && e.getKey() <= r && e.getValue() == 2) {
		    ++ans;
		}
	    }
	    po(ans);
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
