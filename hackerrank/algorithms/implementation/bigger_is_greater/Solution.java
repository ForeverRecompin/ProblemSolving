import java.io.*;
import java.util.*;

class Solver {
    private StringBuilder sb = new StringBuilder();
    
    public void solve(InputReader in, PrintWriter out) {
        int tc = in.ni();
        while (tc-- > 0) {
            String s = in.ns();
            char[] scarr = s.toCharArray();
            boolean flag = nextPerm(scarr);
            po(flag == false ? "no answer" : new String(scarr));       
        }
        out.println(sb.toString());
    }
    
    private boolean nextPerm(char[] arr) {
        for (int i = arr.length - 2; i >= 0; --i) {
            if (arr[i] < arr[i + 1]) {
                for (int j = arr.length - 1; j >= 0; --j) {
                    if (arr[i] < arr[j]) {
                        swap(arr, i, j);
                        for (int f = i + 1, l = arr.length - 1 ; f < l; ++f, --l) {
                            swap(arr, f, l);
                        }
                        return true;
                    }
                }
             }
        }
        return false;
    }
    
    private void swap(char[] arr, int i, int j) {
        if  (i != j) {
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
    
    private void po(Object o) {
        sb.append("" + o).append("\n");
    }
    
    private void append(Object... o) {
        sb.append("" + Arrays.toString(o)).append("\n");
    }
}

public class Solution {
    public static void main(String[] args) {
        InputStream is;
	boolean needFileInput = true;
	try {
	    if (needFileInput) is = new FileInputStream("in");
	    else is = System.in;
	} catch (FileNotFoundException e) {
	    throw new RuntimeException(e);
	}
        InputReader in = new InputReader(is);
        OutputStream os = System.out;
        PrintWriter out = new PrintWriter(os);
        new Solver().solve(in, out);
        out.close();
    }
}

class InputReader {
    private StringTokenizer t;
    private BufferedReader br;
    
    public InputReader(InputStream is) {
        br = new BufferedReader(new InputStreamReader(is));
        t = null;
    }
    
    public String ns() {
        while (t == null || !t.hasMoreTokens()) {
            try {
                t = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return t.nextToken();
    }
    
    public int ni() {
        return Integer.parseInt(ns());
    }
}
