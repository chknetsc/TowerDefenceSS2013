package de.htwg.towerdefence.model.impl;

import java.util.LinkedList;
import java.util.List;

import de.htwg.towerdefence.model.IMob;
import de.htwg.towerdefence.model.ITower;


public class Field {
	
	private ITower tower;
	private List<IMob> mobs;
	
	public Field() {
		this.tower = null;
		this.mobs = new LinkedList<IMob>();
	}

	// Place one Tower on the Field
	public boolean setTower(ITower tower) {
		if(!this.isSetTower() && this.getNumberOfMobs() == 0) {
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
			return true;
		}
		return false;
	}
	
	// Adds a List to the List of Mobs
	public boolean setListMob(List<IMob> mobs) {
		return this.mobs.addAll(mobs);
	}

	// Returns a List of all the Mobs on the Field
	public List<IMob> getMobs() {
		return new LinkedList<IMob>(this.mobs);
	}
	
	// Returns a list with Mobs where Speed = 0
	// All these Mobs on the Field where deleted
	public List<IMob> getReadyMobs() {
		List<IMob> m = new LinkedList<IMob>();
		for(int i = 0; i<this.mobs.size(); i++) {
			if(this.mobs.get(i).decreaseSpeedAndWalk()) {
				m.add(this.mobs.get(i));
			}
		}
		// Removes all the Mobs where walked
		this.mobs.removeAll(m);
		return m;
	}
	
	
	// Returns the Number of Mobs
	public int getNumberOfMobs() {
		return this.mobs.size();
	}
	
	// Deletes all Mobs on this Field
	public boolean deleteAllMobs() {
		if(!this.mobs.isEmpty()) {
			this.mobs.clear();
			return true;
		}
		return false;
	}
	
	// Deletes all Mobs from the list where Damage <= 0
	public boolean deleteDeadMobs() {
		boolean del = false;
		for(int i = 0; i<this.mobs.size(); i++) {
			IMob m = this.mobs.get(i);
			if(m.getLive() <= 0) {
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
