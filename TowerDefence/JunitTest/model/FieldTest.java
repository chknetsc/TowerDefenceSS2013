package model;

import junit.framework.TestCase;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class FieldTest extends TestCase {
	
	Field field;
	Tower tower;
	Mob mob;
	
	public void setUp() throws IOException {
		field = new Field();
		tower = new Tower(1,1,1,1,1.0);
		mob = new Mob(10,2);
	}
	
	public void testDoc() {
		
		// Type of pruefen
		assertEquals(0,field.getTypeOf());
		
		// issetTower pruefen
		assertEquals(false,field.isSetTower());
		assertEquals(true,field.setTower(tower));
		assertEquals(false,field.setTower(tower));
		assertEquals(true,field.isSetTower());
		assertEquals(1,field.getTypeOf());
		
		//get mob
		List<Mob> list = new LinkedList<Mob>();
		assertEquals(list,field.getMobs());
		
		//SetMob
		assertEquals(false,field.setMob(mob));
		
		// Delete Tower
		assertEquals(tower,field.deleteTower());
		assertEquals(false,field.isSetTower());
		
		//SetMob
		assertEquals(true,field.setMob(mob));
		assertEquals(2,field.getTypeOf());
		
		//Return mobs
		assertEquals(1,field.getNumberOfMobs());
		
		//Set tower
		assertEquals(false,field.setTower(tower));
		
	}
}
