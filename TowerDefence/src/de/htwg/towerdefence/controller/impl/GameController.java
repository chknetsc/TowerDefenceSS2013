package de.htwg.towerdefence.controller.impl;

import de.htwg.towerdefence.controller.IGameController;
import de.htwg.towerdefence.model.way.impl.CheckWay;
import de.htwg.towerdefence.util.Coord;

public class GameController implements IGameController {
	
	private Coord start;        // Start Coords of the Playingfield
	private Coord end;          // End Coords of the Playingfield
	private CheckWay way;       // CheckWay to proof the Way
	
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
