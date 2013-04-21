package de.htwg.towerdefence.model;

import java.util.List;

public interface IPlayingField {
	
	// Function to Initialize the PlayingField later
    public void initPlayingField(int sizeX, int sizeY);
    
    // Place a Tower on the Playingfield at x,y
	public boolean setTower(int x, int y, ITower tower); 
	
	// Returns the Tower from x,y at the Playingfield
	public ITower getTower(int x, int y); 
	
	// Deletes a tower on x,y and returns the tower
	public ITower deleteTower(int x, int y); 
	
	// Checks if a tower is set
	public boolean isSetTower(int x, int y);
	
	// Place a Mob on the Playingfield at x,y
	public boolean setMob(int x, int y, IMob mob); 
	
	// Adds a List to the Field of Mobs
	public boolean setListMob(int x, int y, List<IMob> mobs); 
	
	// Returns the Mobs from x,y at the Playingfield
	public List<IMob> getMobs(int x, int y);   
	
	// Returns a list with Mobs where Speed = 0
	public List<IMob> getReadyMobs(int x, int y);
	
	// Returns the Number of Mobs
	public int getNumberOfMobs(int x, int y);  
	
	// Deletes all Mobs on this Field
	public boolean deleteAllMobs(int x, int y);	
	
	// Deletes all Mobs from the list where Damage <= 0
	public boolean deleteDeadMobs(int x, int y); 
	
	// Returns what is on the Field 0-> nothing 1-> tower 2->mob
	public int getTypeOf(int x, int y); 
	
	// Returns the X Size of the PlayingField
	public int getSizeX();
	
	// Returns the Y Size of the PlayingField
	public int getSizeY();	
	
	// Returns a String of the PlayingField
	public String drawPlayingField();					       
}
