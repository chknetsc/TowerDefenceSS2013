package de.htwg.towerdefence.model.impl;

import java.io.IOException;

import de.htwg.towerdefence.model.ITower;
import de.htwg.towerdefence.model.impl.Tower;


import junit.framework.TestCase;

public class TowerTest extends TestCase {
	
	ITower tower;
	
	public void setUp() throws IOException {
		tower = new Tower(1, 1, 1, 1, 1.0);
	}
	
	public void testDoc() {
		
		// Set and Get Damage
		assertEquals(true,tower.setDamage(1));
		assertEquals(false,tower.setDamage(0));
		assertEquals(1,tower.getDamage());
		
		// Set and Get Speed
	    assertEquals(true,tower.setSpeed(1));
		assertEquals(false,tower.setSpeed(0));
		assertEquals(1,tower.getSpeed());
		
		// Set and Get Range
		assertEquals(true,tower.setRange(1));
		assertEquals(false,tower.setRange(0));
		assertEquals(1,tower.getRange());
		
		// Set and Get HitRate
		assertEquals(true,tower.setHitRate(1.0));
		assertEquals(true,tower.setHitRate(0.0));
		assertEquals(false,tower.setHitRate(2.0));
		assertEquals(false,tower.setHitRate(-2.0));
		assertEquals(true,tower.setHitRate(1.0));
		assertEquals(1.0,tower.getHitRate());
		
		// CalcDamage 
		assertEquals(1,tower.calcDamage());
		tower.setHitRate(0.0);
		assertEquals(0,tower.calcDamage());
		
		// Set and Get NumberShoot
		assertEquals(true,tower.setNumberOfShoot(1));
		assertEquals(false,tower.setNumberOfShoot(0));
		assertEquals(1,tower.getNumberOfShoot());
		
		// Randomwert erzeugen
		assertEquals(1.0,tower.random(1.0, 1.0));
		
		// Shoot
		tower.setSpeed(2);
		System.out.println(tower.getSpeed());
		assertEquals(false,tower.shoot());
		System.out.println(tower.getSpeed());
		assertEquals(true,tower.shoot());
	}
}
