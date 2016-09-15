import java.io.*;
import java.util.*;

public class Adj {
    static int n;
    
    public static void main(String[] args) {
	List<List<Integer>> bus = new ArrayList<>();
	List<List<Integer>> rail = new ArrayList<>();
	n = 4;
	init(n, bus);
	init(n, rail);
	for (int i = 0; i < n - 1; ++i) {
	    for (int j = i + 1; j < n; ++j) {
		addEdge(i, j, bus);
	    }
	}
	addEdge(0, 1, rail);
	removeEdge(0, 1, bus);
	addEdge(0, 2, rail);
	addEdge(0, 3, rail);
	addEdge(1, 2, rail);
	addEdge(1, 3, rail);
	addEdge(2, 3, rail);
	System.out.println(bus);
	System.out.println(rail);
    }

    static void init(int n, List<List<Integer>> adj) {
	for (int i = 0; i < n; ++i) {
	    List<Integer> nbor = new ArrayList<>();
	    adj.add(nbor);
	}
    }
    
    static void addEdge(int u, int v, List<List<Integer>> adj) {
	if (u >= n || v >= n) return;
	adj.get(u).add(v);
	adj.get(v).add(u);
    }

    static void removeEdge(int u, int v, List<List<Integer>> adj) {
	if (u >= n || v >= n) return; 
	if (adj.get(u).contains(v)) adj.get(u).remove(v);
	if (adj.get(v).contains(u)) adj.get(v).remove(u);
    }
}
