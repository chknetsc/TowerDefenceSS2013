package de.htwg.towerdefence.model.way;

import java.util.List;

import de.htwg.towerdefence.util.Coord;







public interface ICheckWay {
	
	// Initialize the Graph with the Way
	public void initWayPoints(int sizeX, int sizeY);
	
	// Deletes one Point on the List
	public boolean deleteWayPoint(int x, int y);
	
	// Returns the Number of the Vertex
	public int getNumberofVertex(int x, int y);
	
	// Proof if there is a way
	public boolean existWay(int startX, int startY, int endX, int endY);
	
	// Returns the Coord of the Vertex
	public Coord getCoordOfVertex(int vertex);
	
	// Gets a List of Coords with the shortest way
	public List<Coord> getShortesWay();
	
	// Adds a wayPoint to the list
	public boolean addWayPoint(int x, int y);
	
	
}
