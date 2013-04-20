package de.htwg.towerdefence.model.impl;

public class FastMob extends Mob {
	
	private String name;						// Name der Mob Art
	private int level;							// Level des Mobs

	// Konstruktor creat Mob
	public FastMob(int level) {
		this.name = "FastMob";
		this.level = level;
	}
	
	// Set the Attributs of the Mob to the given Level
	private void intiMob(int level) {
		setName("FastMob");						// Set MobName
		setLevel(level);						// Set Level
		
		switch(level) {								// Set Live and Speed to the spezific Level
		
			case 1:				// Level 1
				setLive(10);
				setSpeed(6);
				break;
			case 2:				// Level 2
				setLive(30);
				setSpeed(5);
				break;
			case 3:				// Level 3
				setLive(50);
				setSpeed(4);
				break;
			case 4:				// Level 4
				setLive(60);
				setSpeed(3);
				break;
			case 5:				// Level 5
				setLive(60);
				setSpeed(2);
				break;
			default:			// Over Level 5
				setLive(80);
				setSpeed(1);
		}
	}

	// Get/Set Name
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	// Get/Set Level
	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}
	
	
	

}
