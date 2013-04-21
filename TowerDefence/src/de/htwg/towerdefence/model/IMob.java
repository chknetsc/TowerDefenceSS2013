package de.htwg.towerdefence.model;

public interface IMob {

	// Get and Set Health
	int getLive();

	void setLive(int health);

	// Get and Set Speed
	int getSpeed();

	void setSpeed(int speed);

	// Dem Mob schaden abziehen
	int getDamage(int damage);

	// Prüft ob Mob tot ist
	boolean mobDead();
	
	// Macht das gleiche wie Mehoden oben nur zusammen
	boolean mobDamageAndLive(int damage);
	
	// Decrease Speed and return true if Mob can walk 
	boolean decreaseSpeedAndWalk();

}