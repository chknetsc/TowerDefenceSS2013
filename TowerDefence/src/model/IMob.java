package model;

public interface IMob {

	// Get and Set Health
	public int getLive();

	public void setLive(int health);

	// Get and Set Speed
	public int getSpeed();

	public void setSpeed(int speed);

	// Dem Mob schaden abziehen
	public int addDamage(int damage);

	// Prüft ob Mob tot ist
	public boolean mobDead();

}