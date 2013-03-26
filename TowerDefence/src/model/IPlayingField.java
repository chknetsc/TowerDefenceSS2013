package model;

import java.util.List;

import model.impl.Mob;
import model.impl.Tower;

public interface IPlayingField {
	
	public boolean setTower(int x, int y, Tower tower);  // Place a Tower on the Playingfield at x,y
	public Tower getTower(int x, int y);                 // Returns the Tower from x,y at the Playingfield
	public Tower deleteTower(int x, int y);              // Deletes a tower on x,y and returns the tower
	public boolean setMob(int x, int y, Mob mob);        // Place a Mob on the Playingfield at x,y
	public List<Mob> getMob(int x, int y);               // Returns the Mobs from x,y at the Playingfield
	public boolean moveMobs();                           // Moves the Mobs to the next Field
	public boolean calculateWay();                       // Calculates the Way of the Mobs
	public int getSizeX();								 // Returns the X Size of the PlayingField
	public int getSizeY();								 // Returns the Y Size of the PlayingField
	public String drawPlayingField();					 // Returns a String of the PlayingField
}
