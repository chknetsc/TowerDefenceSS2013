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
		this.field = new Field[sizeY][sizeX];
		this.sizeX = sizeX;
		this.sizeY = sizeY;
		this.init();
	}	
	
	// Initialize the PlayingField
	private void init() {
		for(int i=0; i<this.sizeY; i++) {
			for(int j=0; j<this.sizeX; j++) {
				this.field[i][j] = new Field();
			}
		}
	}

	@Override
	// Place a Tower on the Playingfield at x,y
	public boolean setTower(int x, int y, Tower tower) {
		// Search for the same Tower on the PlayField
		for(int i=0; i<this.sizeX; i++) {
			for(int j=0; j<this.sizeY; j++) {
				if(this.field[j][i].getTower() == tower) {
					return false;
				}
			}
		}
		// Set the tower on the Playfield
		if(x<this.getSizeX() && y<this.getSizeY()) {
			return this.field[y][x].setTower(tower);
		}
	    return false;
	}

	@Override
	// Returns the Tower from x,y at the Playingfield
	public Tower getTower(int x, int y) {
		if(x<this.getSizeX() && y<this.getSizeY()) {
		    return this.field[y][x].getTower();
		}
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
		// Search for the same Mob on the PlayField
		for(int i=0; i<this.sizeX; i++) {
			for(int j=0; j<this.sizeY; j++) {
				if(this.field[j][i].getNumberOfMobs() != 0) {
					List<Mob> m = this.field[j][i].getMobs();
					if(m.contains(mob)){
						return false;
					}
				}
			}
		}
        // Set the Mob on the Playfield	
		if(x<this.getSizeX() && y<this.getSizeY()) {
		    return this.field[y][x].setMob(mob);
		}
		return false;
	}

	@Override
	// Returns the Mobs from x,y at the Playingfield
	public List<Mob> getMob(int x, int y) {
		if(x<this.getSizeX() && y<this.getSizeY()) {
		    return this.field[y][x].getMobs();
		}
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
		for(int i=0; i<this.sizeY; i++) {
			str.append("#");
			for(int j=0; j<this.sizeX; j++) {
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
