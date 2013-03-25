package model;

import java.util.List;

public class PlayingField implements IPlayingField {
	
	private Field field[][];
	private int sizeX;
	private int sizeY;
	
	// Constructor with standard values
	public PlayingField() {
		this.field = new Field[100][100];
		this.sizeX = 100;
		this.sizeY = 100;
	}
	
	// Constructor with special values
	public PlayingField(int sizeX, int sizeY) {
		this.field = new Field[sizeX][sizeY];
		this.sizeX = sizeX;
		this.sizeY = sizeY;
	}	

	@Override
	// Place a Tower on the Playingfield at x,y
	public boolean setTower(int x, int y, Tower tower) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	// Returns the Tower from x,y at the Playingfield
	public Tower getTower(int x, int y) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	// Deletes a tower on x,y and returns the tower
	public Tower deleteTower(int x, int y) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	// Place a Mob on the Playingfield at x,y
	public boolean setMob(int x, int y, Mob mob) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	// Returns the Mobs from x,y at the Playingfield
	public List<Mob> getMob(int x, int y) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	// Moves the Mobs to the next Field
	public boolean moveMobs() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	// Calculates the Way of the Mobs
	public boolean calculateWay() {
		// TODO Auto-generated method stub
		return false;
	}
	
	public int getSizeX() {
        return this.sizeX;
	}
	
	public int getSizeY() {
		return this.sizeY;
	}
	
	public void drawPlayingField() {
		
	}
}
