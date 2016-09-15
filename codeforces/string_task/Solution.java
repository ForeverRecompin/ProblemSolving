import java.io.*;
import java.util.*;

public class Solution {
    static boolean needFileInput = false;

    static class Solver {
	StringBuilder sb = new StringBuilder();

	void solve(InputReader in, PrintWriter out) {
	    char[] s = in.ns().toLowerCase().toCharArray();
	    Set<Character> vowels = initVowels();
	    StringBuilder transformedString = new StringBuilder();
	    for (char el : s) {
		if (vowels.contains(el)) continue;
		else {
		    transformedString.append(".").append(el);
		}
	    }
	    po(transformedString);
	    // --- Output ---
	    out.println(sb.toString());
	}

	Set<Character> initVowels() {
	    Set<Character> s = new HashSet<>();
	    s.add('a');
	    s.add('e');
	    s.add('i');
	    s.add('o');
	    s.add('u');
	    return s;
	}	    

	void po(Object o) { sb.append("" + o + "\n"); }
	void po(Object... o) { sb.append("" + Arrays.deepToString(o) + "\n"); }
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
    }
}
