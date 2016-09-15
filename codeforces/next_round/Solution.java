import java.io.*;
import java.util.*;

public class Solution {
    static boolean needFileInput = false;
    
    static class Solver {
	StringBuilder sb = new StringBuilder();
	
	void solve(InputReader in, PrintWriter out) {
	    int n = in.ni(), k = in.ni();
	    int[] scores = new int[n];
	    for (int i = 0; i < n; ++i) {
		scores[i] = in.ni();
	    }
	    int qualifyingScore = scores[k - 1];
	    int advancers = 0;
	    for (int i = 0; i < n; ++i) {
		if (scores[i] > 0) {
		    if (scores[i] >= qualifyingScore) {
			++advancers;
		    } 
		}
	    }
	    po(advancers);
	    // --- Output ---
	    out.println(sb);
	}

	void po(Object o) {
	    sb.append("" + o + "\n");
	}

	void po(Object... o) {
	    sb.append("" + Arrays.deepToString(o) + "\n");
	}
    }

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
	new Solver().solve(in, out);
	out.close();
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
