package model;

public class Tower implements ITower {

	int damage;       // Damage of the Tower
	int range;        // Range of shooting
	int speed;        // Speed of Shooting
	int speed_tmp;    // Time to the Next shoot 
	double hitrate;   // Hitrate of the Tower
	
	// Set the Tower to the Values
	public Tower(int damage, int range, int speed, double hitrate) {
		this.setDamage(damage);      // Set Damage to Value
		this.setRange(range);        // Set Range to Value
		this.setSpeed(speed);        // Set Speed to Value
		this.setHitRate(hitrate);    // Set Hitrate to Value
		this.speed_tmp = this.speed; // Init with the Speed
	}
	
	@Override
	// Returns the Damage of the Tower
	public int getDamage() {
		return this.damage;
	}

	@Override
	// Set the Damage of the Tower
	public boolean setDamage(int damage) {
		if ( damage > 0 ) {
			this.damage = damage;
			return true;
		}
	return false;
	}

	@Override
	// Returns the Range
	public int getRange() {
		return this.range;
	}

	@Override
	// Set the Range of the Tower
	public boolean setRange(int range) {
		if ( range > 0 ) {
			this.range = range;
			return true;
		}
	return false;
	}

	@Override
	// Returns the Speed
	public int getSpeed() {
		return this.speed;
	}

	@Override
	// Set the Speet of the Tower
	public boolean setSpeed(int speed) {
		if ( speed > 0 ) {
			this.speed = speed;
			return true;
		}
	return false;
	}

	@Override
	// Returns the Hitrate
	public double getHitRate() {
		return this.hitrate;
	}

	@Override
	// Set the hitrate of the Tower
	public boolean setHitRate(double hitrate) {
		if ( hitrate > 0.0 && hitrate <= 1.0 ) {
			this.hitrate = hitrate;
			return true;
		}
	return false;
	}

	@Override
	// Calc the Damage of one shoot
	public int calcDamage() {
		int random = (int)(this.random(1.0, 100.0)+0.5);
		// Tower has hit the target
		if(random <= this.hitrate*100) {
			return this.damage;
		// Tower didn't hit the target
		// Make the Damage weaker 
		} else {
			return (int)(this.damage*(random/100.0));
		}
	}
	
	// Calc a random double
	public double random(double low, double high) {
		return Math.random() * (high - low) + low;
	}

}
