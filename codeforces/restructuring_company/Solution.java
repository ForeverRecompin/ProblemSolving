import java.io.*;
import java.util.*;
import java.math.*;

public class Solution {
    private static final boolean fio = true;

    static class Solver {

        /*
         * Union-Find DS akin to the one in the textbook CP3
         */
        class UF {
            int[] p, r, ss; // parent, rank, set-size
            int num; // total number of sets

            UF(int n) {
                p = new int[n];
                r = new int[n];
                ss = new int [n];
                num = n;
                for (int i = 0; i < n; ++i) {
                    p[i] = i;
                    r[i] = 0;
                    ss[i] = 1;
                }
            }

            int find(int i) {
                if (p[i] == i) return i;
                else {
                    int ret = find(p[i]);
                    p[i] = ret;
                    return ret;
                }
            }

            void merge(int i, int j) {
                int pi = find(i);
                int pj = find(j);
                if (pi == pj) return;
                --num;
                if (r[pi] > r[pj]) {
                    p[pj] = pi;
                    ss[pi] += ss[pj];
                } else {
                    p[pi] = pj;
                    ss[pj] += ss[pi];
                    if (r[pi] == r[pj]) {
                        r[pj] += 1;
                    }
                }
            }

            void rangeMerge(int i, int j) {
                if (j < i) {
                    int temp = j; j = i; i = temp;
                }
                int pi = find(i);
                for (int k = j; k > i; --k) {
                    merge(pi, k);
                }
            }

            boolean isSame(int i, int j) {
                return find(i) == find(j);
            }
        }

        public void solve(InputReader in, PrintWriter out) {
            int n = in.ni(), q = in.ni();
            UF uf = new UF(n);
            for (int i = 0; i < q; ++i) {
                int what = in.ni(), a = in.ni() - 1, b = in.ni() - 1;
                if (what == 1) {
                    uf.merge(a, b);
                } else if (what == 2) {
                    uf.rangeMerge(a, b);
                } else if (what == 3) {
                    out.println(uf.isSame(a, b) ? "YES" : "NO");
                }
            }
        }

        private void po(Object o) { System.out.println("> " + o); }
        private void po(Object... o) { System.out.println("> " + Arrays.deepToString(o)); }
    }

    public static void main(String[] args) throws FileNotFoundException {
        InputReader in = new InputReader(System.in);
        if (fio) in = new InputReader(new FileInputStream("in"));
        PrintWriter out = new PrintWriter(System.out);
        new Solver().solve(in, out);
        out.close();
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
}
