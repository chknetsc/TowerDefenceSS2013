package model.impl;

import java.util.LinkedList;
import java.util.List;

import model.IField;

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
	// Returns the deleted Tower
	public Tower deleteTower() {
		Tower tmp = this.getTower();
		this.tower = null;
		return tmp;
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
		List<Mob> mobs = new LinkedList<Mob>(this.mobs);
		return mobs;
	}
	
	@Override
	// Returns the Number of Mobs
	public int getNumberOfMobs() {
		return this.NumberMobs;
	}
	
	@Override
	// Deletes all Mobs from the list where Damage < 0
	public boolean deleteDeadMobs() {
		boolean del = false;
		for(int i = 0; i<this.mobs.size(); i++) {
			Mob m = this.mobs.get(i);
			if(m.getLive() < 0) {
				this.mobs.remove(i);
				del = true;
			}
		}
		return del;
	}

	@Override
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
