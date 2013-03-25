package model;

public class SmallMob extends Mob {
	
	String name;
	int level;

	public SmallMob(int live, int speed, String name, int level) {
		super(live, speed);
		setName(name);
		setLevel(level);
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
