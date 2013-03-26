package model;

import java.io.IOException;

import model.impl.Mob;

import junit.framework.TestCase;

public class MobTest extends TestCase {
	
IMob mob;
	
	public void setUp() throws IOException {
		mob = new Mob(100, 1);
	}
	
	public void testDoc() {
		
		// Set and Get live
		mob.setLive(10);
		assertEquals(10, mob.getLive());
		
		// Set and Get Speed
		mob.setSpeed(2);
		assertEquals(2, mob.getSpeed());
		
		// addDamage
		assertEquals(5, mob.addDamage(5));
		
		// mobDead
		assertEquals(false, mob.mobDead());
		mob.setLive(0);
		assertEquals(true, mob.mobDead());
		
		
	}

}
