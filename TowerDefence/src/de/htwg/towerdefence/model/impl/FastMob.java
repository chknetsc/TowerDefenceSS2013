package de.htwg.towerdefence.model.impl;

public class FastMob extends Mob {
	
	// Name der Mob Art
	private String name;
	// Level des Mobs
	private int level;							

	// Konstruktor creat Mob
	public FastMob(int level) {
		this.name = "FastMob";
		this.level = level;
	}
	
	// Set the Attributs of the Mob to the given Level
	private void intiMob(int level) {
		// Set MobName
		setName("FastMob");	
		// Set Level
		setLevel(level);						
		
		// Set Live and Speed to the spezific Level
		switch(level) {								
		// Level 1
			case 1:				
				setLive(10);
				setSpeed(6);
				break;
		// Level 2
			case 2:				
				setLive(30);
				setSpeed(5);
				break;
	    // Level 3
			case 3:				
				setLive(50);
				setSpeed(4);
				break;
	    // Level 4
			case 4:				
				setLive(60);
				setSpeed(3);
				break;
		// Level 5
			case 5:				
				setLive(60);
				setSpeed(2);
				break;
		// Over Level 5
			default:			
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
