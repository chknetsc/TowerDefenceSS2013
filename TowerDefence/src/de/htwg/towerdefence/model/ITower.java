package de.htwg.towerdefence.model;

public interface ITower {

	 // Returns the Damage
     int getDamage();
     
     // Set the Damage of the Tower
     boolean setDamage(int damage);
     
     // Returns the hitrate
     double getHitRate();
     
     // Set the hitrate of the Tower
     boolean setHitRate(double hitrate); 
     
     // Returns the Range
     int getRange(); 
     
     // Set the Range of the Tower
     boolean setRange(int range);  
     
     // Returns the Speed
     int getSpeed(); 
     
     // Set the Speed of the Tower
     boolean setSpeed(int speed); 
     
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
