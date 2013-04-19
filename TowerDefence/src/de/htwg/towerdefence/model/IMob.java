package de.htwg.towerdefence.model;

public interface IMob {

	// Get and Set Health
	public int getLive();

	public void setLive(int health);

	// Get and Set Speed
	public int getSpeed();

	public void setSpeed(int speed);

	// Dem Mob schaden abziehen
	public int getDamage(int damage);

	// Prüft ob Mob tot ist
	public boolean mobDead();
	
	// Macht das gleiche wie Mehoden oben nur zusammen
	public boolean mobDamageAndLive(int damage);
	
	// Decrease Speed and return true if Mob can walk 
	public boolean decreaseSpeedAndWalk();

}