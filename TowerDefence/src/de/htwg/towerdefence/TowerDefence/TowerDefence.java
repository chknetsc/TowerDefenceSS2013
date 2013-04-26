package de.htwg.towerdefence.TowerDefence;

import de.htwg.towerdefence.controller.impl.GameController;

public class TowerDefence {
	
	
	public static void main( String[] args ) throws InterruptedException
	  {
		// TowerDefence
		GameController cont;
		cont = new GameController();
		cont.initGameController(10, 10);
		System.out.println("Spiel gestartet");
		cont.startGame();
		Thread.sleep(5000);
		System.out.println("Spiel gestoppt");
		cont.stopGame();
		Thread.sleep(5000);
		System.out.println("Spiel gestartet");
		cont.startGame();
	  }
}
