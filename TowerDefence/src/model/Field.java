package model;

import java.util.LinkedList;
import java.util.List;

public class Field implements IField {
	
	private Tower tower;
	private List<Mob> mobs;
	private int NumberMobs;
	
	public Field() {
		this.tower = null;
		this.mobs = new LinkedList<Mob>();
		this.NumberMobs = 0;
	}

	@Override
	// Place one Tower on the Field
	public boolean setTower(Tower tower) {
		if(!this.isSetTower() && this.NumberMobs == 0) {
			this.tower = tower;
			return true;
		} 
		return false;
	}

	@Override
	// Returns the Tower when set
	public Tower getTower() {
		return this.tower;
	}
	
	@Override
	// Checks if a tower is set
	public boolean isSetTower() {
		if(this.tower == null) {
			return false;
		}
		return true;
	}

	@Override
	// Place one Mob on the Field
	public boolean setMob(Mob mob) {
		if(!this.isSetTower()) {
			this.mobs.add(mob);
			this.NumberMobs++;
			return true;
		}
		return false;
	}

	@Override
	// Returns a List of the Mobs on the Field
	public List<Mob> getMobs() {
		return this.mobs;
	}
	
	@Override
	// Delete the List of the mobs
	// Funktion wird warsch nicht Funktionieren wegen Referenz
	public List<Mob> deleteList() {
		List<Mob> tmp = null;
		if(!this.isSetTower()) {
		tmp = this.getMobs();
		this.mobs.clear();
		}
	    return tmp;
	}

	@Override
	// Returns the Number of Mobs
	public int getNumberOfMobs() {
		return this.NumberMobs;
	}
}
