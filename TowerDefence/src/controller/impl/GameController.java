package controller.impl;

import model.way.impl.CheckWay;
import util.Coord;
import controller.IGameController;

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
