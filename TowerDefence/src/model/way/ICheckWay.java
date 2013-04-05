package model.way;

import java.util.List;

import model.way.impl.Coord;





public interface ICheckWay {

	public void initWayPoints(int sizeX, int sizeY);                     // Initialize the Graph with the Way
	public boolean deleteWayPoint(int x, int y);                         // Deletes one Point on the List
	public int getNumberofVertex(int x, int y);                          // Returns the Number of the Vertex
	public boolean existWay(int startX, int startY, int endX, int endY); // Proof if there is a way
	public Coord getCoordOfVertex(int vertex);                           // Returns the Coord of the Vertex
	public List<Coord> getShortesWay();                                  // Gets a List of Coords with the shortest way
	public boolean addWayPoint(int x, int y); 	                         // Adds a wayPoint to the list
}
