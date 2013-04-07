package model;

import java.util.List;

public interface IPlayingField {
	
    public void initPlayingField(int sizeX, int sizeY);        // Function to Initialize the PlayingField later
	public boolean setTower(int x, int y, ITower tower);       // Place a Tower on the Playingfield at x,y
	public ITower getTower(int x, int y);                      // Returns the Tower from x,y at the Playingfield
	public ITower deleteTower(int x, int y);                   // Deletes a tower on x,y and returns the tower
	public boolean isSetTower(int x, int y);                   // Checks if a tower is set
	public boolean setMob(int x, int y, IMob mob);             // Place a Mob on the Playingfield at x,y
	public boolean setListMob(int x, int y, List<IMob> mobs);  // Adds a List to the Field of Mobs
	public List<IMob> getMobs(int x, int y);                   // Returns the Mobs from x,y at the Playingfield
	public List<IMob> getReadyMobs(int x, int y);              // Returns a list with Mobs where Speed = 0
	public int getNumberOfMobs(int x, int y);                  // Returns the Number of Mobs
	public boolean deleteAllMobs(int x, int y);				   // Deletes all Mobs on this Field
	public boolean deleteDeadMobs(int x, int y);               // Deletes all Mobs from the list where Damage <= 0
	public int getTypeOf(int x, int y);                        // Returns what is on the Field 0-> nothing 1-> tower 2->mob
	public int getSizeX();								       // Returns the X Size of the PlayingField
	public int getSizeY();								       // Returns the Y Size of the PlayingField
	public String drawPlayingField();					       // Returns a String of the PlayingField
}
