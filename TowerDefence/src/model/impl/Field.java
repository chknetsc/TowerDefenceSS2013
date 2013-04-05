package model.impl;

import java.util.LinkedList;
import java.util.List;

import model.IMob;
import model.ITower;

public class Field {
	
	private ITower tower;
	private List<IMob> mobs;
	private int NumberMobs;
	
	public Field() {
		this.tower = null;
		this.mobs = new LinkedList<IMob>();
		this.NumberMobs = 0;
	}

	// Place one Tower on the Field
	public boolean setTower(ITower tower) {
		if(!this.isSetTower() && this.NumberMobs == 0) {
			this.tower = tower;
			return true;
		} 
		return false;
	}

	// Returns the Tower when set
	public ITower getTower() {
		return this.tower;
	}
	
	// Returns the deleted Tower
	public ITower deleteTower() {
		ITower tmp = this.getTower();
		this.tower = null;
		return tmp;
	}
	
	// Checks if a tower is set
	public boolean isSetTower() {
		if(this.tower == null) {
			return false;
		}
		return true;
	}

	// Place one Mob on the Field
	public boolean setMob(IMob mob) {
		if(!this.isSetTower()) {
			this.mobs.add(mob);
			this.NumberMobs++;
			return true;
		}
		return false;
	}
	
	// Deletes all Mobs on this Field
	public boolean deleteAllMobs() {
		if(!this.mobs.isEmpty()) {
			this.mobs.clear();
			return true;
		}
		return false;
	}

	// Returns a List of the Mobs on the Field
	public List<IMob> getMobs() {
		List<IMob> mobs = new LinkedList<IMob>(this.mobs);
		return mobs;
	}
	
	// Returns the Number of Mobs
	public int getNumberOfMobs() {
		return this.NumberMobs;
	}
	
	// Deletes all Mobs from the list where Damage < 0
	public boolean deleteDeadMobs() {
		boolean del = false;
		for(int i = 0; i<this.mobs.size(); i++) {
			IMob m = this.mobs.get(i);
			if(m.getLive() < 0) {
				this.mobs.remove(i);
				del = true;
			}
		}
		return del;
	}

	// Returns what is on the Field 0-> nothing 1-> tower 2->mob
	public int getTypeOf() {
		if(this.isSetTower()) {
			return 1;
		} else if (this.getNumberOfMobs() != 0) {
			return 2;
		} else {
			return 0;
		}
	}
}
