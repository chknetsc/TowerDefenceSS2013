package de.htwg.towerdefence.controller.impl;

import de.htwg.towerdefence.controller.IGameController;
import de.htwg.towerdefence.model.way.impl.CheckWay;
import de.htwg.towerdefence.util.Coord;

public class GameController implements IGameController {
	
	// Start Coords of the Playingfield
	private Coord start;  
	
	 // End Coords of the Playingfield
	private Coord end;  
	
	// CheckWay to proof the Way
	private CheckWay way;       
	
	public GameController() {
		
	}
	
	/*
	    this.start = new Coord(0,0);
		this.end = new Coord(this.sizeX-1, this.sizeY-1);
		this.way = new CheckWay();
		this.way.initWayPoints(this.sizeX, this.sizeY);
	 * 
	 * 
	 * 
	 */
}
