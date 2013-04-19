package de.htwg.towerdefence.model.impl;

import java.io.IOException;

import de.htwg.towerdefence.model.impl.FastMob;

import junit.framework.TestCase;

public class FastMobTest extends TestCase {
	
FastMob mob;
	
	public void setUp() throws IOException {
		for(int i = 1; i <= 6; i++) {
			mob = new FastMob(i);
		}
	}
	
	public void testDoc() {
		
		// Set and Get Level
		mob.setLevel(3);
		assertEquals(3, mob.getLevel());
		
		// Set and Get Name
		mob.setName("FastMob");
		assertEquals("FastMob", mob.getName());
		

	}
}
