package de.htwg.towerdefence.model.impl;

import junit.framework.TestCase;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import de.htwg.towerdefence.model.IMob;
import de.htwg.towerdefence.model.ITower;
import de.htwg.towerdefence.model.impl.Field;
import de.htwg.towerdefence.model.impl.Mob;
import de.htwg.towerdefence.model.impl.Tower;


public class FieldTest extends TestCase {
	
	Field field;
	ITower tower;
	IMob mob;
	IMob mob2;
	IMob mob3;
	
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
		List<IMob> list = new LinkedList<IMob>();
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
		
		//Set List Mobs
		List<IMob> m = new LinkedList<IMob>();
		this.mob.setLive(100);
		this.mob.setSpeed(3);
		this.mob2.setLive(100);
		this.mob2.setSpeed(6);
		this.mob3.setLive(100);
		this.mob3.setSpeed(6);
		m.add(this.mob);
		m.add(this.mob2);
		m.add(this.mob3);
		assertEquals(true,field.setListMob(m));
		List<IMob> ready = new LinkedList<IMob>();
		assertEquals(ready,field.getReadyMobs());
		ready.add(mob);
		assertEquals(ready,field.getReadyMobs());
		
		// Delete dead mobs
		this.mob2.getDamage(50);
		assertEquals(false,field.deleteDeadMobs());
		this.mob2.getDamage(100);
		assertEquals(true,field.deleteDeadMobs());
		
		// Delete all mobs
		assertEquals(true,field.deleteAllMobs());
		assertEquals(false,field.deleteAllMobs());
	}
}
