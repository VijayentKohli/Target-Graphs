package com.iamvkohli.graphs.algorithms;

import java.util.ArrayList;


/*
 * logic - DFS TRAVERSAL
 * 
 */
public class ConnectedComponents {
	public int countComponents(int n, int[][] edges) {

		// Create and Populate a graph
		ArrayList<Integer>[] graph = new ArrayList[n];
		for (int i = 0; i < n; i++) {
			graph[i] = new ArrayList<>();
		}

		// Populating a graph
		for (int i = 0; i < edges.length; i++) {
			int src = edges[i][0];
			int dest = edges[i][1];
			graph[src].add(edges[i][1]);
			graph[dest].add(edges[i][0]);
		}

		boolean[] visited = new boolean[n];
		int countComponent = 0;
		for (int i = 0; i < n; i++) {
			// If node is not visited
			if (!visited[i]) {
				dfs(graph, visited, i);
				countComponent++;
			}
		}
		return countComponent;
	}

	public void dfs(ArrayList<Integer>[] graph, boolean[] visited, int cur) {

		if (visited[cur]) {
			return;
		}

		visited[cur] = true;
		for (int i = 0; i < graph[cur].size(); i++) {
			// dfs into each of the adjacent vertices
			int vertex = graph[cur].get(i);
			if (!visited[vertex]) {
				dfs(graph, visited, vertex);
			}
		}

	}
}
