package de.htwg.towerdefence.model.impl;

import de.htwg.towerdefence.model.IMob;

public class Mob implements IMob {
	
	// Gesundheit des Mobs
	private int live;	
	
	// Time that mob must wait on Field
	private int speed;
	
	// Mainspeed
	private int speedtmp;		
	
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
		this.speedtmp = speed;
	}
	
	
	// Dem Mob schaden abziehen
	public int getDamage(int damage) {
		// Zieht übergebenene Damage von aktuellen Leben ab
		setLive(this.live-damage);
		// Giebt übrige Leben zurück
		return this.live;				
	}
	
	// Prüft ob Mob tot ist
	public boolean mobDead() {
		if(this.live <= 0) {
			// True falls Mob tot ist 
			return true;				
		} 
		// False wenn Mob noch lebt
		return false;				
	}
	
	// Macht das gleiche wie Mehoden oben nur zusammen
	public boolean mobDamageAndLive(int damage) {
		// Zieht übergebenene Damage von aktuellen Leben ab
		this.live -= damage;			
		if(this.live <= 0) {
			// True falls Mob tot ist
			return true;						
		}
		// False wenn Mob noch lebt
		return false;						
	}
	
	// Decrease Speed and return true if Mob can walk 
	public boolean decreaseSpeedAndWalk() {
		this.speed--;		
		// Check if Speed is Zero
		if(this.speed <= 0) {				
			this.speed = this.speedtmp;
			// True if Mob can walk on new Field
			return true;					
		}
		// False if Mob needs more Time
		return false;					
	}
}
