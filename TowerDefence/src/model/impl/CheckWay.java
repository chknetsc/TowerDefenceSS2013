package model.impl;

import java.util.LinkedList;
import java.util.List;

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
			  System.out.println("Erzeuge Vertex " + i);
		}
		for(int i = 1; i<=(sizeX*sizeY); i++) {
		   if((i%sizeX) != 0) {
			 g.addEdge(i,i+1);
			 System.out.println("Erzeuge Edge zwischen " + i + " und " + (i+1));
		   }
		   if(i<=(sizeX*sizeY)-sizeX) {
			 g.addEdge(i,i+this.sizeX);
			 System.out.println("Erzeuge Edge zwischen " + i + " und " + (i+this.sizeX));
		   }
		}
	}
	
	// Deletes one Point on the List
	public boolean deleteWayPoint(int x, int y) {
		return this.g.deleteAllEdgeOn(this.getNumberofVertex(x, y));
	}
	
	// Adds a wayPoint to the list
	public boolean addWayPoint(int x, int y) {
		int vertex = this.getNumberofVertex(x, y);
		boolean check = false;
		if((vertex%sizeX) != 0) {
		   g.addEdge(vertex,vertex+1);
		   System.out.println("Erzeuge Edge zwischen " + vertex + " und " + (vertex+1));
		   check = true;
		}
		if(vertex<=(sizeX*sizeY)-sizeX) {
		   g.addEdge(vertex,vertex+this.sizeX);
		   System.out.println("Erzeuge Edge zwischen " + vertex + " und " + (vertex+this.sizeX));
		   check = true;
		}
		if(vertex-this.sizeX > 0) {
			g.addEdge(vertex,vertex-this.sizeX);
			System.out.println("Erzeuge Edge zwischen " + vertex + " und " + (vertex-this.sizeX));
			check = true;
		}
		if((vertex-1)%this.sizeX != 0) {
			g.addEdge(vertex,vertex-1);
			System.out.println("Erzeuge Edge zwischen " + vertex + " und " + (vertex-1));
			check = true;
		}
		return check;
	}
	
	// Returns the Number of the Vertex
	public int getNumberofVertex(int x, int y) {
		if(this.sizeX > x && this.sizeY > y) {
		return ((this.sizeX)*(y+1)) - ((this.sizeX-1)-x);
		}
		return 0;
	}	
	
	// Returns the Coord of the Vertex
	public Coord getCoordOfVertex(int vertex) {
		Coord c = new Coord();
		if((this.sizeX*this.sizeY >= vertex) && (vertex > 0)) {
		  c.setY((vertex-1)/this.sizeX);
		  c.setX(((vertex-1)-this.sizeX*c.getY()));
		  return c;
		}
		return null;
	}
	
	// Proof if there is a way
	public boolean existWay(int startX, int startY, int endX, int endY) {
		int vertex1 = this.getNumberofVertex(startX, startY);
		int vertex2 = this.getNumberofVertex(endX, endY);
		System.out.println("Berechne von: " + vertex1 + " zu " + vertex2 + " die Strecke!");
		return this.path.searchShortestPath(vertex1,vertex2);
	}
	
	// Gets a List of Coords with the shortest way
	public List<Coord> getShortesWay() {
		List<Integer> l = this.path.getShortestPath();
		List<Coord> c = new LinkedList<Coord>();
		if(l != null) {
			for(int i = 0; i<l.size(); i++) {
				c.add(this.getCoordOfVertex(l.get(i)));
				System.out.println(l.get(i));
			}
			return c;
		}
		return null;
	}
	
}
