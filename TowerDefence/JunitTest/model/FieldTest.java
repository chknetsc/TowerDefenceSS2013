package model;

import junit.framework.TestCase;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import model.impl.Field;
import model.impl.Mob;
import model.impl.Tower;

public class FieldTest extends TestCase {
	
	Field field;
	Tower tower;
	Mob mob;
	Mob mob2;
	Mob mob3;
	
	public void setUp() throws IOException {
		field = new Field();
		tower = new Tower(1,1,1,1,1.0);
		mob = new Mob();
		mob2 = new Mob();
		mob3 = new Mob();
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
		assertEquals(true,field.setMob(mob2));
		assertEquals(true,field.setMob(mob3));
		
		
		List<IMob> m = this.field.getMobs();
		for(int i = 0; i<m.size(); i++) {
			System.out.println(m.get(i).getLive());
		}
		
		assertEquals(3,field.getNumberOfMobs());
		assertEquals(false,field.deleteDeadMobs());
		this.mob2.getDamage(300);
		System.out.println(this.mob2.getLive());
		assertEquals(true,field.deleteDeadMobs());
		
		m = this.field.getMobs();
		for(int i = 0; i<m.size(); i++) {
			System.out.println(m.get(i).getLive());
		}
		
	}
}
