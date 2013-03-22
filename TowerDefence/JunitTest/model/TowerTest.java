package model;

import java.io.IOException;

import junit.framework.TestCase;

public class TowerTest extends TestCase {
	
	Tower tower;
	
	public void setUp() throws IOException {
		tower = new Tower(1, 1, 1, 1.0);
	}
	
	public void testDoc() {
		// Set and Get Damage
		assertEquals(true,tower.setDamage(1));
		assertEquals(false,tower.setDamage(0));
		assertEquals(1,tower.getDamage());
	}

}
