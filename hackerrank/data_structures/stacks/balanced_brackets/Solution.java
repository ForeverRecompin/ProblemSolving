import java.io.*;
import java.util.*;

public class Solution {
    
    static boolean fio = true;
    
    static class Solver {
        void solve(InputReader in, PrintWriter out) {
            int numTc = in.ni();
            for (int tc = 1; tc <= numTc; ++tc) {
                String expression = in.ns();
                Deque<Character> s = new ArrayDeque<>();
                boolean isBalanced = true;
                for (int i = 0; i < expression.length(); ++i) {
                    char curr = expression.charAt(i);
                    if (curr == '[' || curr == '{' || curr == '(') s.offerFirst(curr);
                    else if (curr == ']') {
                        if (s.size() == 0) {
                            isBalanced = false;
                            break;
                        }
                        if (s.peekFirst() == '[') {
                            s.pollFirst();
                            continue;
                        } else {
                            isBalanced = false;
                            break;
                        }
                    } else if (curr == '}') {
                        if (s.size() == 0) {
                            isBalanced = false;
                            break;
                        }
                        if (s.peekFirst() == '{') {
                            s.pollFirst();
                            continue;
                        } else {
                            isBalanced = false;
                            break;
                        }
                    }
                    else if (curr == ')') {
                        if (s.size() == 0) {
                            isBalanced = false;
                            break;
                        }
                        if (s.peekFirst() == '(') {
                            s.pollFirst();
                            continue;
                        } else {
                            isBalanced = false;
                            break;
                        }
                    }
                }
                if (s.size() > 0) isBalanced = false;
                if (isBalanced) out.println("YES");
                else out.println("NO");
            }
        }
        
        void po(Object... o) {
            System.out.println(Arrays.deepToString(o));
        }
    }
    
    static class InputReader {
        BufferedReader br;
        StringTokenizer t;
        
        InputReader(InputStream is) {
            br = new BufferedReader(new InputStreamReader(is));
            t = null;
        }
        
        String ns() {
            while (t == null || !t.hasMoreTokens()) {
                try {
                    t  = new StringTokenizer(br.readLine());
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
    
    public static void main(String[] args) throws FileNotFoundException {
        InputReader in = new InputReader(System.in);
        if (fio)
            in = new InputReader(new FileInputStream("in"));
        PrintWriter out = new PrintWriter(System.out);
        new Solver().solve(in, out);
        out.close();
    }
}