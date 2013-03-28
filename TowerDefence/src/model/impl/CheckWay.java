package model.impl;

import model.ICheckWay;
import model.IGraph;

public class CheckWay implements ICheckWay {
	
	private IGraph<Integer> g;                  // Saves the List for the Calculation
	private DijkstraShortestPath<Integer> path; // Calculate the shortest way
	private int sizeX;
	private int sizeY;

	public CheckWay() {
		this.g = new AdjacencyListUndirectedGraph<Integer>();
		this.path = new DijkstraShortestPath<Integer>(this.g);
	}
	
	// Initialize the Graph with the Way
	public void initWayPoints(int sizeX, int sizeY) {
		this.sizeX = sizeX;       // X Field Size
		this.sizeY = sizeY;       // Y Field Size
		
		// Add Fields to the List
		for(int i = 1; i<=(sizeX*sizeY); i++) {
			  g.addVertex(i);
		}
		for(int i = 1; i<=(sizeX*sizeY); i++) {
		   if((i%sizeX) != 0) {
			 g.addEdge(i,i+1);
		   }
		   if(i<=(sizeX*sizeY)-sizeX) {
			 g.addEdge(i,i+4);
		   }
		}
	}
	
	// Deletes one Point on the List
	public boolean deleteWayPoint(int x, int y) {
		return this.g.deleteAllEdgeOn(this.getNumberofVertex(x, y));
	}
	
	// Returns the Number of the Vertex
	public int getNumberofVertex(int x, int y) {
		if(this.sizeX > x && this.sizeY > y) {
		return ((this.sizeX)*(y+1)) - ((this.sizeX-1)-x);
		}
		return 0;
	}	
	
	// Proof if there is a way
	public boolean existWay(int startX, int startY, int endX, int endY) {
		int vertex1 = this.getNumberofVertex(startX, startY);
		int vertex2 = this.getNumberofVertex(endX, endY);
		return this.path.searchShortestPath(vertex1,vertex2);
	}
	
}
