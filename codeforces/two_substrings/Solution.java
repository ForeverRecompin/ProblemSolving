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
	String s = in.ns();
	boolean flag1 = false, flag2 = false;
	List<Integer> AB = new ArrayList<>(), BA = new ArrayList<>();
	for (int i = 0; i < s.length() - 1; ++i) {
	    if (s.substring(i, i + 2).equals("AB")) {
		AB.add(i);
	    }
	    if (s.substring(i, i + 2).equals("BA")) {
		BA.add(i);
	    }
	}
	//Collections.sort(AB);
	//Collections.sort(BA);
	for (int i = 0; i < AB.size(); ++i) {
	    for (int j = 0; j < BA.size(); ++j) {
		if (Math.abs(AB.get(i) - BA.get(j)) >= 2) {
		    flag1 = flag2 = true;
		    break;
		} 
	    }
	}
	
	po((flag1 && flag2) ? "YES" : "NO");
        out.println(sb.toString());
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
 
