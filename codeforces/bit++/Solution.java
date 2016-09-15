import java.io.*;
import java.util.*;

public class Solution {
    static boolean fio = true;

    static class Solver {
        void solve(InputReader in, PrintWriter out) {
            int numtc = in.ni();
            int x = 0;
            for (int tc = 1; tc <= numtc; ++tc) {
                String l = in.nli();
                if (l.equals("++X")) {
                    ++x;
                } else if (l.equals("X++")) {
                    x++;
                } else if (l.equals("--X")) {
                    --x;
                } else
                    x--;
            }
            out.println(x);
        }
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

        String nli() {
            String line = "";
            try {
                line = br.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return line;
        }

        int ni() {
            return Integer.parseInt(ns());
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
