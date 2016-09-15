import java.io.*;
import java.util.*;
import java.math.*;

public class Solution {
    private static final boolean fio = true;

    static class Solver {

        public void solve(InputReader in, PrintWriter out) {

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
