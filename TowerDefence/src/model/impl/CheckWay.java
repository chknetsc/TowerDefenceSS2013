package model.impl;

import model.ICheckWay;
import model.IGraph;

public class CheckWay implements ICheckWay {
	
	private IGraph<Integer> g;                  // Saves the List for the Calculation
	private DijkstraShortestPath<Integer> path; // Calculate the shortest way

	public CheckWay() {
		this.g = new AdjacencyListUndirectedGraph<Integer>();
		this.path = new DijkstraShortestPath<Integer>(this.g);
	}
	
	// Initialize the Graph with the Way
	public void initCheckWay(int sizeX, int sizeY) {
		// Add Fields to the List
		for(int i = 1; i<(sizeX+sizeY); i++) {
			  g.addVertex(i);
		}
			
			for(int i = 1; i<17; i++) {
			    if((i%4) != 0) {
				    g.addEdge(i,i+1);
				    System.out.println("Add Node between " + i + " and " + (i+1));
			    }
			    
			    if(i<13) {
				    g.addEdge(i,i+4);
				    System.out.println("Add Node between " + i + " and " + (i+4));
			    }
			}
	}
}
