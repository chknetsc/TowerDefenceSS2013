package model;

import junit.framework.TestCase;
import java.io.IOException;

public class FieldTest extends TestCase {
	
	Field field;
	Tower tower;
	Mob mob;
	
	public void setUp() throws IOException {
		Field field = new Field();
		Tower tower = new Tower(1,1,1,1,1.0);
		Mob mob = new Mob(10,2);
	}
	
	public void testDoc() {
		// Set and get Tower
		assertEquals(false,field.isSetTower());
	}
}