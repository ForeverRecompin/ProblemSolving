import java.io.*;
import java.util.*;

public class Solution {
    static String inputFile = "in";
    static boolean needFileInput = true;

    static class Solver {
	StringBuilder sb = new StringBuilder();

	void solve(InputReader in, PrintWriter out) {
	    int tc = in.ni();
	    StringBuilder sbnum = new StringBuilder();
	    while (tc-- > 0) {
		String s = in.ns();
	        char[] arr = s.toCharArray();
		Arrays.sort(arr);
	        boolean possible = false;
		sbnum.setLength(0);
		if (arr.length > 1) sbnum.append(arr[1]);
		sbnum.append(arr[0]);
	        long n = Long.parseLong(sbnum.toString());
		if (n % 8 == 0) {
		    possible = true;
		    out.println("YES");
	        }
		while (getNextPermutation(arr) && !possible) {
		    sbnum.setLength(0);
		    if (arr.length > 1) sbnum.append(arr[1]);
		    sbnum.append(arr[0]);
	            n = Long.parseLong(sbnum.toString());
		    if (n % 8 == 0) {
			possible = true;
			out.println("YES");
			break;
		    }
	        }
	        if (!possible) out.println("NO");
	    }
	}
	
	boolean getNextPermutation(char[] arr) {
	    for (int i = arr.length - 2; i >= 0; --i) {
		if (arr[i] < arr[i + 1]) {
		    for (int j = arr.length - 1; j >= 0; --j) {
			if (arr[i] < arr[j]) { 
			    swap(arr, i, j);
			    for (int f = i + 1, l = arr.length - 1; f < l; ++f, --l) {
				swap(arr, f, l);
			    }
			    return true;
			}
		    }
		}
	    }
	    return false;
	}

	void swap(char[] arr, int i, int j) {
	    if (i != j) {
		char temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	    }
	}

	void po(Object... o) { sb.append("" + Arrays.deepToString(o) + "\n"); }
	void po(Object o) { sb.append("" + o + "\n"); }
    }

    static class InputReader {
	StringTokenizer t;
	BufferedReader br;

	InputReader(InputStream is) {
	    br = new BufferedReader(new InputStreamReader(is));
	    t = null;
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

	long nl() {
	    return Long.parseLong(ns());
	}
    }
        
    public static void main(String[] args) {
	InputStream is = System.in;
	if (needFileInput) {
	    try {
		is = new FileInputStream(inputFile);
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
