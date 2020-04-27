package com.iamvkohli.graphs.algorithms;

public class ConnectedComponentsEfficient {
	public int countComponents(int n, int[][] edges) {
		Graph g = new Graph(n);
		for (int[] edge : edges) {
			g.connect(edge[0], edge[1]);
		}
		return g.count;
	}
}


/*
 *  Create a graph class
 *  
 */
class Graph {
	
	//Array to store parent of each vertex
	private int[] parent;
	private int[] size;
	
	//Count of connected components
	public int count;

	/*
	 * Contructor 
	 * Initially - all vertices are disconnected
	 */
	public Graph(int n) {
		parent = new int[n];
		size = new int[n];
		count = n;
		
		for (int i = 0; i < n; i++) {
			parent[i] = i;
			size[i] = 1;
		}
	}

	/*
	 * Method to connect the components
	 * Parameters : Edge a->b
	 */
	public void connect(int a, int b) {
		int pa = findParent(a);
		int pb = findParent(b);

		if (pa == pb) {
			return;
		}

		if (size[pa] > size[pb]) {
			parent[pb] = pa;
			size[pa] += size[pb];
		} else {
			parent[pa] = pb;
			size[pb] += size[pa];
		}
		count--;
	}

	
	private int findParent(int a) {
		while (parent[a] != a) {
			a = parent[parent[a]];
		}
		return a;
	}
}