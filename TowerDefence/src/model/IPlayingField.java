package model;

import java.util.List;

import model.impl.Mob;
import model.impl.Tower;

public interface IPlayingField {
	
    public void initPlayingField(int sizeX, int sizeY);  // Function to Initialize the PlayingField later
	public boolean setTower(int x, int y, ITower tower);  // Place a Tower on the Playingfield at x,y
	public ITower getTower(int x, int y);                 // Returns the Tower from x,y at the Playingfield
	public ITower deleteTower(int x, int y);              // Deletes a tower on x,y and returns the tower
	public boolean setMob(int x, int y, IMob mob);        // Place a Mob on the Playingfield at x,y
	public List<IMob> getMob(int x, int y);               // Returns the Mobs from x,y at the Playingfield
	public boolean moveMobs();                           // Moves the Mobs to the next Field
	public boolean calculateWay();                       // Calculates the Way of the Mobs
	public int getSizeX();								 // Returns the X Size of the PlayingField
	public int getSizeY();								 // Returns the Y Size of the PlayingField
	public String drawPlayingField();					 // Returns a String of the PlayingField
}
