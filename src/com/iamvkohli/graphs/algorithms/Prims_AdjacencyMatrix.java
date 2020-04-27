package com.iamvkohli.graphs.algorithms;

import java.util.Arrays;

public class Prims_AdjacencyMatrix {
	
	private int parent[]; //the source vertex of the edge
	private boolean included[]; //for unprocessed vertices that are not part of MST
	private int numV;
	private int [] key;
	
	public void initialize(int numVertices) {
		this.numV = numVertices;
		this.parent = new int [numV];
		this.included = new boolean [numV];
		this.key = new int [numV];
	}
	
	public int minKey(int[] key, boolean[] included) {
        int min = Integer.MAX_VALUE, min_index = -1; 
  
        for (int v = 0; v < numV; v++) 
            if ( !included[v] && key[v] < min) { //Process vertices which are not part of MST
                min = key[v]; 
                min_index = v; 
            }
        return min_index; 
	}
	
	public void prims(int[][] graph, int numVertices) {
		//Initialize all the values
		initialize(numVertices);
		
		//Set all the keys to infinity
		Arrays.fill(key, Integer.MAX_VALUE);
		
		//
		key[0] = 0;
		parent[0] = -1;
		
		for(int count=0; count< (numVertices-1); count++) {
			
			//Get min weighted edge
			int source = minKey(key, included); 
			
			//add the destination to MST
			included[source] = true;
			
			//Process all the adjacent vertices of this. 
			for(int destination=0; destination<numV; destination++) {
				if(graph[source][destination]!=0) {//If there is an edge
					
					//If the vertex is not included in MST && the weight is minimum, then add it to MST
					if( !included[destination] && graph[source][destination]< key[destination]) {
						parent[destination]  = source;
						key[destination] = graph[source][destination];
					}
				}
			}
			
		}
		
		//Print the MST using parent and key arrays
		
	}

	public static void main(String[] args) {
		Prims_AdjacencyMatrix inst1 = new Prims_AdjacencyMatrix();
		
		//Matrix of 5 vertices, say A B C D E
		int[][] matrix = {  { 0, 4, 0, 0, 5 }, 
							{ 4, 0, 3, 6, 1  }, 
							{ 0, 3, 0, 6, 2 }, 
							{ 0, 6, 6, 0, 7 },
							{ 5, 1, 2, 7, 0 } 
						};

		int numVertices = 5;
		
		inst1.prims(matrix, numVertices);		
	
	}

}
