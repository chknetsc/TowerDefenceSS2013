package de.htwg.towerdefence.model.impl;

import junit.framework.TestCase;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import de.htwg.towerdefence.model.IMob;
import de.htwg.towerdefence.model.IPlayingField;
import de.htwg.towerdefence.model.ITower;
import de.htwg.towerdefence.model.impl.Field;
import de.htwg.towerdefence.model.impl.Mob;
import de.htwg.towerdefence.model.impl.Tower;


public class PlayingFieldTest extends TestCase {
	
	IPlayingField f;
	IPlayingField field;
	ITower tower;
	
	public void setUp() throws IOException {
		this.f = new PlayingField();
		this.field = new PlayingField(10,10);
		this.f.initPlayingField(10, 10);
		this.tower = new Tower(1,1,1,1,1.0);
	}
	
	public void testDoc() {
		// Set Tower
		assertEquals(false,this.f.setTower(11, 11, this.tower));
		assertEquals(false,this.f.setTower(8, 11, this.tower));
		assertEquals(false,this.f.setTower(11, 8, this.tower));
		assertEquals(true,this.f.setTower(9, 9, this.tower));
		assertEquals(false,this.f.setTower(8, 8, this.tower));
		
		// Get Tower
		assertEquals(null,this.f.getTower(11, 11));
		assertEquals(null,this.f.getTower(8, 11));
		assertEquals(null,this.f.getTower(11, 8));
		assertEquals(this.tower,this.f.getTower(9, 9));
		
		// Is Set Tower
		assertEquals(false,this.f.isSetTower(11, 11));
		assertEquals(false,this.f.isSetTower(8, 11));
		assertEquals(false,this.f.isSetTower(11, 8));
		assertEquals(true,this.f.isSetTower(9, 9));
		
		// Delete Tower
		assertEquals(null,this.f.deleteTower(11, 11));
		assertEquals(null,this.f.deleteTower(8, 11));
		assertEquals(null,this.f.deleteTower(11, 8));
		assertEquals(this.tower,this.f.deleteTower(9, 9));
	}
}
