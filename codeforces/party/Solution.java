import java.io.*;
import java.util.*;

public class Solution {
    static boolean needFileInput = false;
    static final String INPUT_FILE = "in";

    static class Solver {
	StringBuilder sb = new StringBuilder();
	List<Integer> employees = null;
	int depth;

	/*
	  The logic to this problem did not occur to me. 
	  This solution has been written after reading the
	  editorial and several other solutions.
	  
	  The answer - minimum number of groups is bounded
	  by the maximal depth of the (logical) tree of managers
	  and employees.
	      
	  Why did I not see it?
	*/
	void solve(InputReader in, PrintWriter out) {
	    int n = in.ni();
	    
	    employees = new ArrayList<>();
	    for (int i = 0; i < n; ++i) {
		employees.add(in.ni() - 1); // 0-indexed
		// Store immediate manager of ith employee
	    }
	    
	    int ans = 0; 
	    for (int i = 0; i < n; ++i) {
		depth = 0;
		findDepth(i);
		ans = Math.max(ans, depth);
	    }
	    po(ans);
	    // --- Output ---
	    out.println(sb.toString());
	}

	void findDepth(int ind) {
	    ++depth;
	    // -2 check is because we already decremented
	    // once while taking the inputs (0-indexing) 
	    if (ind < 0 || employees.get(ind) == -2) return;
	    findDepth(employees.get(ind));
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

	int ni() {
	    return Integer.parseInt(ns());
	}
    }

    public static void main(String[] args) {
	InputStream is = System.in;
	if (needFileInput) {
	    try {
		is = new FileInputStream(INPUT_FILE);
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
    
}
