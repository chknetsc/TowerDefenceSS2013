package de.htwg.towerdefence.TowerDefence;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;

import de.htwg.towerdefence.controller.impl.GameController;
import de.htwg.towerdefence.gui.impl.GUITowerDefence;
import de.htwg.towerdefence.util.Coord;

public class TowerDefence {
	
	
	public static void main( String[] args ) throws InterruptedException
	  {
		// TowerDefence
		GameController cont;
		
		/*
		AppGameContainer app;
		try {
			app = new AppGameContainer(new GUITowerDefence());
			app.setDisplayMode(800, 600, false);
		    app.start();
		} catch (SlickException e) {
			e.printStackTrace();
		}	    
	    */
		cont = new GameController();
		cont.initGameController(10, 10,new Coord(0,0),new Coord(9,9));
		System.out.println("Spiel gestartet");
		cont.startGame();
		cont.setTower(0, 1, 1);
		cont.setTower(1, 1, 1);
		cont.setTower(2, 1, 1);
		cont.setTower(3, 1, 1);
		cont.setTower(4, 1, 1);
		cont.setTower(5, 1, 1);
		cont.setTower(6, 1, 1);
		cont.setTower(7, 1, 1);
		cont.setTower(8, 1, 1);
		cont.setMob(0, 0, 1);
		Thread.sleep(500);
		cont.setMob(0, 0, 1);
		Thread.sleep(1000);
		cont.setMob(0, 0, 1);
		Thread.sleep(1000);
		cont.setMob(0, 0, 1);
		Thread.sleep(1000);
		cont.setTower(9, 8, 1);
		cont.setTower(8, 8, 1);
		cont.setTower(7, 8, 1);
		cont.setTower(6, 8, 1);
		cont.setTower(5, 8, 1);
		cont.setTower(4, 8, 1);
		cont.setTower(3, 8, 1);
		cont.setTower(2, 8, 1);
		cont.setTower(1, 8, 1);
		Thread.sleep(3000);
		cont.setTower(5, 2, 1);
	  }
}
