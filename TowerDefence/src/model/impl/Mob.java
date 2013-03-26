package model.impl;

import model.IMob;

public class Mob implements IMob {
	
	private int live;			// Gesundheit des Mobs
	private int speed; 			// Bewegunstempo des Mobs
	
	// Konstruktor
	public Mob(int live, int speed) {
		setLive(live);
		setSpeed(speed);
	}
	
	// Get and Set Health

	public int getLive() {
		return live;
	}
	
	
    /* Deine Set Methoden können auch negative werte annehmen
     * des müsstest du noch verbessern.
     * könnte sonst noch zu problemen komnmen*/
	
	
	public void setLive(int health) {
		this.live = health;
	}
	
	// Get and Set Speed
	public int getSpeed() {
		return speed;
	}
	
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	// Dem Mob schaden abziehen
	public int addDamage(int damage) {
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
}
