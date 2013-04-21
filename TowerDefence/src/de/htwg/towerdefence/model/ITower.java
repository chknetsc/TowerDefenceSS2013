package de.htwg.towerdefence.model;

public interface ITower {

	 // Returns the Damage
     public int getDamage();
     
     // Set the Damage of the Tower
     public boolean setDamage(int damage);
     
     // Returns the hitrate
     public double getHitRate();
     
     // Set the hitrate of the Tower
     public boolean setHitRate(double hitrate); 
     
     // Returns the Range
     public int getRange(); 
     
     // Set the Range of the Tower
     public boolean setRange(int range);  
     
     // Returns the Speed
     public int getSpeed(); 
     
     // Set the Speed of the Tower
     public boolean setSpeed(int speed); 
     
     // Calc the Damage of one shoot
     public int calcDamage();   
     
     // Set the Number of Shoot
     public boolean setNumberOfShoot(int shoot);
     
     // Returns the Number of Shoot
     public int getNumberOfShoot(); 
     
     // Returns true when the Tower can shoot
     public boolean shoot(); 
     
     // Calc a random double
     public double random(double low, double high); 
}
