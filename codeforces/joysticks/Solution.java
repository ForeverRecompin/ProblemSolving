import java.io.*;
import java.util.*;

public class Solution {
    static boolean needFileInput = false;

    public static void main(String[] args) {
	InputStream is = System.in;
	if (needFileInput) {
	    try {
		is = new FileInputStream("in");
	    } catch (FileNotFoundException e) {
		throw new RuntimeException(e);
	    }
	}
	InputReader in = new InputReader(is);
	OutputStream os = System.out;
	PrintWriter out = new PrintWriter(os);
	Solver solver = new Solver();
	solver.solve(in, out);
	out.close();
    }

    static class Solver {
	StringBuilder sb = new StringBuilder();

	void solve(InputReader in, PrintWriter out) {
	    // --- Input ---
	    int joyStick1 = in.ni(), joyStick2 = in.ni();
	    // --- Meats and potatoes
	    int minutes = 0;
	    while (joyStick1 > 0 && joyStick2 > 0) {
		//po(joyStick1, joyStick2);
		if (joyStick1 == 1 && joyStick2 == 1) break;
		if (joyStick1 < joyStick2) {
		    joyStick1 += 1;
		    joyStick2 -= 2;
		} else if (joyStick2 <= joyStick1) {
		    joyStick2 += 1;
		    joyStick1 -= 2;
		}
		++minutes;
	    }
	    po(minutes);
	    // --- Output --- 
	    out.println(sb);
	}

	void po(Object o) { sb.append("" + o + "\n"); }
	void po(Object... o) { sb.append("" + Arrays.deepToString(o) + "\n"); }
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

	int ni() { return Integer.parseInt(ns()); }
    }
}
