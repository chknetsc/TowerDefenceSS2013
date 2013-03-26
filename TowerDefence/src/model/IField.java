package model;

import java.util.List;

public interface IField {
	
	public boolean setTower(Tower tower);    // Place one Tower on the Field
	public Tower getTower();                 // Returns the Tower when set
	public Tower deleteTower();              // Returns the deleted Tower
	public boolean isSetTower();             // Checks if a tower is set
	public boolean setMob(Mob mob);          // Place one Mob on the Field
	public List<Mob> getMobs();              // Returns a List of the Mobs on the Field
	public int getNumberOfMobs();            // Returns the Number of Mobs
	public boolean deleteDeadMobs();         // Deletes all Mobs from the list where Damage < 0
	public int getTypeOf();                  // Returns what is on the Field 0-> nothing 1-> tower 2->mob
}
