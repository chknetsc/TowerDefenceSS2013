package de.htwg.towerdefence.controller.impl;

import java.io.IOException;

import de.htwg.towerdefence.controller.IGameController;
import de.htwg.towerdefence.textUI.Tui;
import de.htwg.towerdefence.util.Coord;
import junit.framework.TestCase;

public class GameControllerTest extends TestCase {
	
	IGameController controller;
	
	public void setUp() throws IOException {
		controller = new GameController();
		controller.initGameController(10, 10,new Coord(0,0),new Coord(9,9));
	}
	
	public void testDoc() {
		
		// Get Methodes
		assertEquals(10 , controller.getLive());
		assertEquals(1000 , controller.getMoney());
		
		String playField = controller.getPlayingField();
		assertEquals(playField , controller.getPlayingField());
		
		assertEquals(10 , controller.getSizeX());
		assertEquals(10 , controller.getSizeY());
		
		// Tower Setzen und Attribute hollen
		assertEquals(false , controller.setTower(0, 0, 1));
		assertEquals(true , controller.setTower(3, 3, 1));
		assertEquals(true , controller.isSetTower(3, 3));
		assertEquals(1 , controller.getTypeOf(3, 3));
		
		assertEquals(20 , controller.getTowerDamage(3, 3));
		assertEquals(0.6 , controller.getTowerHitrate(3, 3));
		assertEquals(5 , controller.getTowerNumberShoot(3, 3));
		assertEquals(1 , controller.getTowerRange(3, 3));
		assertEquals(2 , controller.getTowerSpeed(3, 3));
		
		// Tower updaten 
		assertEquals(true , controller.updateTowerDamage(3, 3));
		assertEquals(true , controller.updateTowerHitrate(3, 3));
		assertEquals(true , controller.updateTowerNumberShoot(3, 3));
		assertEquals(true , controller.updateTowerRange(3, 3));
		assertEquals(true , controller.updateTowerSpeed(3, 3));
		
		assertEquals(10 , controller.getUpdateTowerDamageCost(3, 3));
		assertEquals(10 , controller.getUpdateTowerHitrateCost(3, 3));
		assertEquals(10 , controller.getUpdateTowerNumberShootCost(3, 3));
		assertEquals(10 , controller.getUpdateTowerRangeCost(3, 3));
		assertEquals(10 , controller.getUpdateTowerSpeedCost(3, 3));
		
		// Tower löschen
		assertEquals(false , controller.deleteTower(1, 1));
		assertEquals(true , controller.deleteTower(3, 3));
		
		// Mob Setzen
		assertEquals(true , controller.setMob(0, 0, 1));
		
		// Spiel laufen lassen 
		controller.startGame();
		controller.pauseGame();
		controller.stopGame();
		
		
		
		
		
		//assertEquals(3 , controller.getTowerDamage(x, y));
		//assertEquals(3 , controller.getTowerHitrate(x, y));
		
	}
		

}
