import java.io.*;
import java.util.*;

class Solver {
    private StringBuilder sb = new StringBuilder();
    private int[][] T = null;
    private int[] w = null;
    
    public void solve(InputReader in, PrintWriter out) {
        int tc = in.ni();
        while (tc-- > 0) {
            int n = in.ni(), k = in.ni();
            w = new int[n];
            for (int i = 0; i < n; ++i) {
                w[i] = in.ni();
            }
            T = new int[n + 1][k + 1];
            for (int i = 0; i < n; ++i) { Arrays.fill(T[i], -1); }
            T[0][0] = 0;
            int cost = getCost(n - 1, k);
            //for (int i = 0; i < n; ++i) { po(Arrays.toString(T[i])); }
            po(cost == -1 ? 0 : cost);
        }
        out.println(sb.toString());
    }
    
    private int getCost(int ind, int toAccountForCost) {
        if (ind < 0 || toAccountForCost == 0) {
            return 0;
        }
        if (w[ind] > toAccountForCost) {
            return getCost(ind - 1, toAccountForCost);
        }
        if (T[ind][toAccountForCost] == -1) {
            T[ind][toAccountForCost] =  findMax(getCost(ind - 1, toAccountForCost),
                                                 w[ind] + getCost(ind - 1, toAccountForCost - w[ind]),
                                                 w[ind] + getCost(ind, toAccountForCost - w[ind])); // unbounded
        }
        return T[ind][toAccountForCost];
    }
    
    private int findMax(int... arr) {
        int maxVal = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; ++i) {
            maxVal = Math.max(maxVal, arr[i]);
        }
        return maxVal;
    }
    private void jpo(Object o) { sb.append("" + o); }
    private void jpo(Object... o) { sb.append("" + Arrays.toString(o)); }
    private void po(Object o) { sb.append("" + o + "\n"); }
    private void po(Object... o) { sb.append("" + Arrays.toString(o) + "\n"); }
}

public class Solution {
    public static void main(String[] args) {
	boolean needFileInput = true;
	InputStream is;
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
        t = null;
        br = new BufferedReader(new InputStreamReader(is));
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
                                             
