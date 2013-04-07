package model.impl;

import model.IMob;

public class Mob implements IMob {
	
	private int live;			// Gesundheit des Mobs
	private int speed; 			// Time that mob must wait on Field
	private int speed_tmp;		// Mainspeed
	
	// Konstruktor
	public Mob() {

	}
	
	// Get and Set Health

	public int getLive() {
		return live;
	}
	
	
	public void setLive(int health) {
		this.live = health;
	}
	
	// Get and Set Speed
	public int getSpeed() {
		return speed;
	}
	
	public void setSpeed(int speed) {
		this.speed = speed;
		this.speed_tmp = speed;
	}
	
	
	// Dem Mob schaden abziehen
	public int getDamage(int damage) {
		setLive(this.live-damage);		// Zieht übergebenene Damage von aktuellen Leben ab 
		return this.live;				// Giebt übrige Leben zurück
	}
	
	// Prüft ob Mob tot ist
	public boolean mobDead() {
		if(this.live <= 0) {
			return true;				// True falls Mob tot ist 
		} 
		else {
			return false;				// False wenn Mob noch lebt
		}
	}
	
	// Macht das gleiche wie Mehoden oben nur zusammen
	public boolean mobDamageAndLive(int damage) {
		this.live -= damage;			// Zieht übergebenene Damage von aktuellen Leben ab
		if(this.live <= 0) {
			return true;						// True falls Mob tot ist
		}
		else {
			return false;						// False wenn Mob noch lebt
		}
	}
	
	// Decrease Speed and return true if Mob can walk 
	public boolean decreaseSpeedAndWalk() {
		this.speed--;					
		if(this.speed <= 0) {				// Check if Speed is Zero
			this.speed = this.speed_tmp;
			return true;					// True if Mob can walk on new Field
		}
		else {
			return false;					// False if Mob needs more Time
		}
	}
}
