import java.io.*;
import java.util.*;

public class Solution {
    static boolean needFineInput = false; 

    
    public static void main(String[] args) {
	InputStream is = System.in;
	if (needFineInput) {
	    try {
		is = new FileInputStream("in");
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
    
    static class Solver {
	StringBuilder sb = new StringBuilder();
	
	void solve(InputReader in, PrintWriter out) {
	    int tc = in.ni();
	    while (tc-- > 0) {
		po(getAns(in.ns()));
	    }
	    // --- Output ---
	    out.println(sb);
	}

	String getAns(String s) {
	    int l = s.length();
	    if (l <= 10) return s;
	    StringBuilder o = new StringBuilder();
	    return o
		.append(s.charAt(0))
		.append(l- 2)
		.append(s.charAt(l - 1))
		.toString();
	}

	void po(Object o) {
	    sb.append("" + o + "\n");
	}
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
}
