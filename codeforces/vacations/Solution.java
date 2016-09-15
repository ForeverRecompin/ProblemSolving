import java.io.*;
import java.util.*;
import java.math.*;

public class Solution {
    private static final boolean fio = true;

    static class Solver {
        int[] N;
        int[] T;

        public void solve(InputReader in, PrintWriter out) {
            int n = in.ni();
            N = new int[n + 1];
            T = new int[n + 1];
            for (int i = 1; i <= n; ++i ) {
                N[i] = in.ni();
            }
            T[0] = 0;
            T[1] = N[1] == 0 ? 1 : 0;
            for (int i = 2; i <= n; ++i) {
                if (N[i] == 0) {
                    T[i] = T[i - 1] + 1;
                } else if (N[i] == 3) {
                    T[i] = T[i - 1] + 0;
                } else if (N[i] == N[i - 1]) {
                    T[i] = T[i - 1] + 1;
                } else if (N[i] != N[i - 1] && N[i] == 2 || N[i] == 1 && N[i - 1] != 0) {
                    po("boo", i);
                    T[i] = T[i - 1] + 0;
                }
            }
            po("N", N);
            po("T", T);
            out.println(T[n]);
        }

        private void po(Object o) { System.out.println("> " + o); }
        private void po(Object... o) { System.out.println("> " + Arrays.deepToString(o)); }
    }

    static class InputReader {
        private final BufferedReader br;
        private StringTokenizer t;
        public InputReader(InputStream is) {
            br = new BufferedReader(new InputStreamReader(is));
            t = null;
        }
        public int ni() { return Integer.parseInt(ns()); }
        public long nl() { return Long.parseLong(ns()); }
        public double nd() { return Double.parseDouble(ns()); }
        public BigInteger nbi() { return new BigInteger(ns()); }
        public BigDecimal nbd() { return new BigDecimal(ns()); }
        public String ns() {
            while (t == null || !t.hasMoreTokens()) {
                try { t = new StringTokenizer(br.readLine());
                } catch (IOException e) { throw new RuntimeException(e); }
            }
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

    public static void main(String[] args) throws FileNotFoundException {
        InputReader in = new InputReader(System.in);
        if (fio) in = new InputReader(new FileInputStream("in"));
        PrintWriter out = new PrintWriter(System.out);
        new Solver().solve(in, out);
        out.close();
    }
}
