package de.htwg.towerdefence.model.impl;

import de.htwg.towerdefence.model.ITower;

public class Tower implements ITower {
	
	// Hundert als Konstante
	private static final double hundred = 100.0;
	
	// 0.5 als Konstante
	private static final double half = 0.5;	
 
	// Damage of the Tower
	private int damage;  
	
	// Range of shooting
	private int range;  
	
	 // Speed of Shooting
	private int speed;
	
	// Time to the Next shoot
	private int speedtmp; 
	
	// Number of Shoots each round
	private int numberShoot;
	
	// Hitrate of the Tower
	private double hitrate;   
	
	// Set the Tower to the Values
	public Tower(int damage, int range, int speed, int numberShoot, double hitrate) {
		// Set Damage to Value
		this.damage = damage;
		// Set Range to Value
		this.range = range; 
		// Set Speed to Value
		this.speed = speed;  
		// Set Hitrate to Value
		this.hitrate = hitrate;
		// Set number of shoot to Value
		this.numberShoot = numberShoot;              
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
	// Set the Speed of the Tower
	public boolean setSpeed(int speed) {
		if ( speed > 0 ) {
			this.speed = speed;
			this.speedtmp = this.speed;
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
		if ( hitrate >= 0.0 && hitrate <= 1.0 ) {
			this.hitrate = hitrate;
			return true;
		}
	return false;
	}
	
	@Override
	// Set the Number of Shoot
	public boolean setNumberOfShoot(int shoot) {
		if ( shoot > 0 ) {
			this.numberShoot = shoot;
			return true;
		}
	return false;
	}

	@Override
	// Returns the Numer of Shoot
	public int getNumberOfShoot() {
		return this.numberShoot;
	}
	
	@Override
	// Returns true when the Tower can shoot
	public boolean shoot() {
		this.speedtmp--;					
		if(this.speedtmp <= 0) {
			this.speedtmp = this.speed;
			return true;
		}
		return false;
	}
	
	@Override
	// Calc the Damage of one shoot
	public int calcDamage() {
		int random = (int)(this.random(1.0,hundred)+half);
		// Tower has hit the target
		if( random <= this.hitrate*hundred ) {
			return this.damage;
		// Tower didn't hit the target
		// Make the Damage weaker 
		} else {
			return (int)(this.damage*(random/hundred));
		}
	}
	
	// Calc a random double
	public double random(double low, double high) {
		return Math.random() * (high - low) + low;
	}
}
