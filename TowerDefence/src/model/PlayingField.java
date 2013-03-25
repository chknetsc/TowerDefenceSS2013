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
		this.init();
	}
	
	// Constructor with special values
	public PlayingField(int sizeX, int sizeY) {
		this.field = new Field[sizeX][sizeY];
		this.sizeX = sizeX;
		this.sizeY = sizeY;
		this.init();
	}	
	
	// Initialize the PlayingField
	private void init() {
		for(int i=0; i<this.sizeX; i++) {
			for(int j=0; j<this.sizeY; j++) {
				this.field[i][j] = new Field();
			}
		}
	}

	@Override
	// Place a Tower on the Playingfield at x,y
	public boolean setTower(int x, int y, Tower tower) {
		return this.field[x][y].setTower(tower);
	}

	@Override
	// Returns the Tower from x,y at the Playingfield
	public Tower getTower(int x, int y) {
		return this.field[x][y].getTower();
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
		return this.field[x][y].setMob(mob);
	}

	@Override
	// Returns the Mobs from x,y at the Playingfield
	public List<Mob> getMob(int x, int y) {
		return this.field[x][y].getMobs();
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
	
	// Returns the X Size of the PlayingField
	public int getSizeX() {
        return this.sizeX;
	}
	
	// Returns the y Size of the PlayingField
	public int getSizeY() {
		return this.sizeY;
	}
	
	// Returns a String of the PlayingField 
	public String drawPlayingField() {
		StringBuilder str = new StringBuilder();
		for(int i=0; i<this.sizeX; i++) {
		   str.append("###");	
		}	
		str.append("##\n");
		for(int i=0; i<this.sizeX; i++) {
			str.append("#");
			for(int j=0; j<this.sizeY; j++) {
				if(this.field[i][j].isSetTower()) {
					str.append("-+-");
				} else if(this.field[i][j].getNumberOfMobs() != 0) {
					str.append("~%~");
				} else {
					str.append("   ");
				}
			}
			str.append("#\n");
		}
		for(int i=0; i<this.sizeX; i++) {
		   str.append("###");	
		}
		str.append("##");
	return str.toString();
	}
}
