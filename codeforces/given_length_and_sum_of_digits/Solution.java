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
	int m = in.ni(); // Constraint 1: len of digits
	int s = in.ni(); // Constraint 2: sum of digits
	// Get min and max nums following these constraints
	String[] nums = getNums(m, s);
	po(nums[0] + " " + nums[1]);
        out.println(sb.toString());
    }

    String[] getNums(int m, int s) {
	String[] nums = {"-1", "-1"};

	if(m == 1 && s <= 9) {
	    nums[0] = nums[1] = "" + s;
	} else if (s == 0) {
	    ; // return default ans
	} else {
	    int origS = s;
	    StringBuilder max = new StringBuilder();
	    for (int i = 0; i < m; ++i) {
		if (s < 0) break;
		if (s > 9) {
		    max.append(9);
		    s -= 9;
		} else {
		    max.append(s);
		    s = 0;
		}
	    }
	    max = (s == 0) ? max : new StringBuilder("-1");
	    StringBuilder min = new StringBuilder();
	    s = origS;
	    for (int i = 1; i <= m; ++i) {
		innerLoop:
		for (int j = (i == 1 ? 1 : 0); j <= 9; ++j) {
		    //po(s);
		    if (s <  0) break;
		    if (s - j > 9 * (m - i)) continue;
		    else {
			min.append(j);
			s -= j;
			break innerLoop;
		    }
		} 
	    }
	    min = (s == 0) ? min : new StringBuilder("-1");
	    for (int i = 0; i < min.length(); ++i) {
		if (min.charAt(i) == '0') min.replace(i, i + 1, "");
		else break;
	    }
	    nums[0] = min.toString();
	    nums[1] = max.toString();
	}
	return nums;
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
