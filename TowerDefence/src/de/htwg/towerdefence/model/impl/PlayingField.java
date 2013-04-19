package de.htwg.towerdefence.model.impl;

import java.util.List;

import de.htwg.towerdefence.model.IMob;
import de.htwg.towerdefence.model.IPlayingField;
import de.htwg.towerdefence.model.ITower;

public class PlayingField implements IPlayingField {
	
	private Field field[][];    // Field Array with the Towers and Mobs
	private int sizeX;          // X Size of the Field Array
	private int sizeY;          // Y Size of the Field Array
	
	// Constructor with standard values
	public PlayingField() {
		this.sizeX = 0;
		this.sizeY = 0;
	}
	
	// Constructor with special values
	public PlayingField(int sizeX, int sizeY) {
		this.sizeX = sizeX;
		this.sizeY = sizeY;
		this.init();
	}
	
	// Function to Initialize the PlayingField later
	public void initPlayingField(int sizeX, int sizeY) {
		this.sizeX = sizeX;
		this.sizeY = sizeY;
		this.init();
	}
	
	// Initialize the PlayingField
	private void init() {
		this.field = new Field[sizeY][sizeX];
		for(int i=0; i<this.sizeY; i++) {
			for(int j=0; j<this.sizeX; j++) {
				this.field[i][j] = new Field();
			}
		}
	}

	@Override
	// Place a Tower on the Playingfield at x,y
	public boolean setTower(int x, int y, ITower tower) {
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
	public ITower getTower(int x, int y) {
		if(x<this.getSizeX() && y<this.getSizeY()) {
		    return this.field[y][x].getTower();
		}
		return null;
	}

	@Override
	// Deletes a tower on x,y and returns the tower
	public ITower deleteTower(int x, int y) {
		if(x<this.getSizeX() && y<this.getSizeY()) {
		    return this.field[y][x].deleteTower();
		}
		return null;
	}
	
	@Override
	// Checks if a tower is set
	public boolean isSetTower(int x, int y) {
		return this.field[y][x].isSetTower();
	}

	@Override
	// Place a Mob on the Playingfield at x,y
	public boolean setMob(int x, int y, IMob mob) {
		// Search for the same Mob on the PlayField
		for(int i=0; i<this.sizeX; i++) {
			for(int j=0; j<this.sizeY; j++) {
				if(this.field[j][i].getNumberOfMobs() != 0) {
					List<IMob> m = this.field[j][i].getMobs();
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
	public List<IMob> getMobs(int x, int y) {
		if(x<this.getSizeX() && y<this.getSizeY()) {
		    return this.field[y][x].getMobs();
		}
		return null;
	}
	
	@Override
	// Adds a List to the Field of Mobs
	public boolean setListMob(int x, int y, List<IMob> mobs) {
		return this.field[y][x].setListMob(mobs);
	}

	@Override
	// Returns a list with Mobs where Speed = 0
	public List<IMob> getReadyMobs(int x, int y) {
		return this.field[y][x].getReadyMobs();
	}

	@Override
	// Returns the Number of Mobs
	public int getNumberOfMobs(int x, int y) {
		return this.field[y][x].getNumberOfMobs();
	}

	@Override
	// Deletes all Mobs on this Field
	public boolean deleteAllMobs(int x, int y) {
		return this.field[y][x].deleteAllMobs();
	}

	@Override
	// Deletes all Mobs from the list where Damage <= 0
	public boolean deleteDeadMobs(int x, int y) {
		return this.field[y][x].deleteDeadMobs();
	}

	// Returns the X Size of the PlayingField
	public int getSizeX() {
        return this.sizeX;
	}
	
	// Returns the y Size of the PlayingField
	public int getSizeY() {
		return this.sizeY;
	}
	
	@Override
	// Returns what is on the Field 0-> nothing 1-> tower 2->mob
	public int getTypeOf(int x, int y) {
		return this.field[y][x].getTypeOf();
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
