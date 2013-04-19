package de.htwg.towerdefence.model;

public interface ITower {

     public int getDamage();                        // Returns the Damage
     public boolean setDamage(int damage);          // Set the Damage of the Tower
     public double getHitRate();                    // Returns the hitrate
     public boolean setHitRate(double hitrate);     // Set the hitrate of the Tower
     public int getRange();                         // Returns the Range
     public boolean setRange(int range);            // Set the Range of the Tower
     public int getSpeed();                         // Returns the Speed
     public boolean setSpeed(int speed);            // Set the Speed of the Tower
     public int calcDamage();                       // Calc the Damage of one shoot
     public boolean setNumberOfShoot(int shoot);    // Set the Number of Shoot 
     public int getNumberOfShoot();                 // Returns the Number of Shoot
     public boolean shoot();                        // Returns true when the Tower can shoot
     public double random(double low, double high); // Calc a random double
}
