import java.io.*;
import java.util.*;
import java.math.*;

class Solver {
    private StringBuilder sb = new StringBuilder();
    
    public void solve(InputReader in, PrintWriter out) {
	out.println(sb.toString());
    }

    // Short for Process Output
    private void po(Object o) {
	sb.append("" + o).append("\n");
    }
}

public class Main {
    public static void main(String[] args) {
	InputStream is = System.in;
	OutputStream os = System.out;
	boolean needFileIO = false;
	if (needFileIO) {
	    try {
		is = new FileInputStream("in");
		//os = new FileOutputStream("out");
	    } catch (FileNotFoundException fnfe) {
		throw new CustomException("I/O - File Not Found Failure" );
	    }
	}
	InputReader in = new InputReader(is);
	PrintWriter out = new PrintWriter(os);
	new Solver().solve(in, out);
	out.close();
    }
}

class InputReader {
    private final BufferedReader br;
    private StringTokenizer t;
    
    public InputReader(InputStream is) {
	br = new BufferedReader(new InputStreamReader(is));
	t = null;
    }
    
    public String gs() {
	while (t == null || !t.hasMoreTokens()) {
	    try {
		t = new StringTokenizer(br.readLine());
	    } catch (IOException ioe) {
		throw new CustomException("I/O - Read Failure"); 
	    }
	}
	return t.nextToken();
    }

    public String gli() {
	String line = "";
	try {
	    line = br.readLine();
	} catch (IOException ioe) {
	    throw new CustomException("I/O - Read Line Failure");
	}
	assert line.compareTo("") != 0;
	return line;
    }

    public int gi() {
	int i;
	try {
	    i = Integer.parseInt(gs()); 
	} catch (NumberFormatException nfe) {
	    throw new CustomException("I/O - Integer Parsing Failure");
	} catch (NullPointerException npe) {
	    throw new CustomException("I/O - No Input Present Failure");
	}
	return i;
    }
    
    public long gl() {
	long l;
	try {
	    l = Long.parseLong(gs()); 
	} catch (NumberFormatException nfe) {
	    throw new CustomException("I/O - Long Parsing Failure");
	} catch (NullPointerException npe) {
	    throw new CustomException("I/O - No Input Present Failure");
	}
	return l;
    }
    
    public double gd() {
	double d;
	try {
	    d = Double.parseDouble(gs()); 
	} catch (NumberFormatException nfe) {
	    throw new CustomException("I/O - Double Parsing Failure");
	} catch (NullPointerException npe) {
	    throw new CustomException("I/O - No Input Present Failure");
	}
	return d;
    }    
    
    public BigInteger gbi() {
	BigInteger bi;
	try {
	    bi = new BigInteger(gs());
	} catch (Exception e) {
	    throw new CustomException("I/O - Big Integer Read Faiure");
	}
	return bi;
    }
}

class CustomException extends RuntimeException {
    public CustomException(String msg) {
	    super(msg);
    }
}
