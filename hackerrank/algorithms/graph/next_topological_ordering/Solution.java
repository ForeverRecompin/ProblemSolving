import java.io.*;
import java.util.*;

public class Solution {
    static void po(PrintWriter w, Object o) {
	w.println("" + o);
    }
    
    static void po(PrintWriter w, Object... o) {
	w.println(Arrays.deepToString(o));
    }
    
    public static void main(String[] args) throws FileNotFoundException {
        InputReader in = new InputReader(new FileInputStream("in"));
        PrintWriter w = new PrintWriter(System.out);

        int n = in.nextInt();
        int m = in.nextInt();

        ArrayList<Integer> g[] = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++)
            g[i] = new ArrayList<Integer>();
      
        int IN[] = new int[n + 1];
        for (int i = 0; i < m; i++) {
            int u = in.nextInt();
            int v = in.nextInt();
            g[u].add(v);
            IN[v]++;
        }
	po(w, "graph", g);
	po(w, "deg", IN);
        int p[] = in.nextIntArray(n);
        int l = -1;
        
        int c[] = new int[n + 1];
        
        TreeSet<Integer> set = new TreeSet<Integer>();
        for (int i = 1; i <= n; i++) {
            if (c[i] == IN[i]) {
                set.add(i);
            }
        }
	po(w, "set", set);
        
        //System.out.println(set);
        int pos = 0;
        
        while(!set.isEmpty()) {
	    System.out.println("\tSet: " + set);
            if (set.last() != p[pos]) {
                l = pos;
            }
            set.remove(p[pos]);
            for (int next : g[p[pos]]) {
                c[next]++;
                if (c[next] == IN[next])
                    set.add(next);
            }
            pos++;
        }
        
	System.out.println("here: " + pos);
        
        if (l == -1) 
            w.println(-1);
        else {
            pos = 0;
            Arrays.fill(c, 0);
            for (int i = 1; i <= n; i++) {
                if (c[i] == IN[i]) {
                    set.add(i);
                }
            }
	    po(w, "set later", set);
            while(!set.isEmpty()) {
                int now = -1;
                if (pos == l) {
                       now = set.higher(p[pos]);
                }
                else if (pos < l){
                     now = p[pos];
                }
                else {
                    now = set.first();
                }
                w.print(now + " ");
                set.remove(now);
                for (int next : g[now]) {
                    c[next]++;
                    if (c[next] == IN[next])
                        set.add(next);
                }
                pos++;
            }
            w.println();
        }
        
        w.close();
    }

    static class InputReader {

        private final InputStream stream;
        private final byte[] buf = new byte[8192];
        private int curChar, snumChars;
        private SpaceCharFilter filter;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        public int snext() {
            if (snumChars == -1)
                throw new InputMismatchException();
            if (curChar >= snumChars) {
                curChar = 0;
                try {
                    snumChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (snumChars <= 0)
                    return -1;
            }
            return buf[curChar++];
        }

        public int nextInt() {
            int c = snext();
            while (isSpaceChar(c)) {
                c = snext();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = snext();
            }
            int res = 0;
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = snext();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public long nextLong() {
            int c = snext();
            while (isSpaceChar(c)) {
                c = snext();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = snext();
            }
            long res = 0;
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = snext();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public int[] nextIntArray(int n) {
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = nextInt();
            }
            return a;
        }

        public String readString() {
            int c = snext();
            while (isSpaceChar(c)) {
                c = snext();
            }
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = snext();
            } while (!isSpaceChar(c));
            return res.toString();
        }

        public String nextLine() {
            int c = snext();
            while (isSpaceChar(c))
                c = snext();
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = snext();
            } while (!isEndOfLine(c));
            return res.toString();
        }

        public boolean isSpaceChar(int c) {
            if (filter != null)
                return filter.isSpaceChar(c);
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        private boolean isEndOfLine(int c) {
            return c == '\n' || c == '\r' || c == -1;
        }

        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);
        }
    }
}
