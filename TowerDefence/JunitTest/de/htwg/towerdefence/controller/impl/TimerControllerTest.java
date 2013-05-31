package de.htwg.towerdefence.controller.impl;

import java.io.IOException;

import de.htwg.towerdefence.controller.IGameController;
import de.htwg.towerdefence.model.IMob;
import de.htwg.towerdefence.model.IPlayer;
import de.htwg.towerdefence.model.IPlayingField;
import de.htwg.towerdefence.model.ITower;
import de.htwg.towerdefence.model.impl.Mob;
import de.htwg.towerdefence.model.impl.Tower;
import de.htwg.towerdefence.model.way.ICheckWay;
import de.htwg.towerdefence.util.Coord;
import junit.framework.TestCase;

public class TimerControllerTest extends TestCase {
	
TimerController timer;
IGameController controller;
IPlayingField field;
IPlayer player;
ICheckWay way;
ITower tower;
IMob mob;
	
	public void setUp() throws IOException {
		controller = new GameController();
		controller.initGameController(10, 10,new Coord(0,0),new Coord(9,9));
		timer = new TimerController(field, player, way);
		
		tower = new Tower(1,1,1,1,0.5);
		mob = new Mob();
		
	}
	
	public void testDoc() {
		
		// Run Test
		//timer.run();
		
		
		controller.setTower(2, 2, 1);
		assertEquals(2 ,timer.MobsOnField(tower, 2, 1, 3));
		
		
		
		
		
	}

}
