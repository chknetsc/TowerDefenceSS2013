package de.htwg.towerdefence.model.way;

import java.util.List;

import de.htwg.towerdefence.util.Coord;


public interface ICheckWay {
	
	// Initialize the Graph with the Way
	void initWayPoints(int sizeX, int sizeY);
	
	// Deletes one Point on the List
	boolean deleteWayPoint(int x, int y);
	
	// Returns the Number of the Vertex
	int getNumberofVertex(int x, int y);
	
	// Proof if there is a way
	boolean existWay(int startX, int startY, int endX, int endY);
	
	// Returns the Coord of the Vertex
	Coord getCoordOfVertex(int vertex);
	
	// Gets a List of Coords with the shortest way
	List<Coord> getShortesWay();
	
	// Adds a wayPoint to the list
	boolean addWayPoint(int x, int y);
	
	
}
