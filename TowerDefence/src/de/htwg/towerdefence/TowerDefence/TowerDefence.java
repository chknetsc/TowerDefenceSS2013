package de.htwg.towerdefence.TowerDefence;



import de.htwg.towerdefence.controller.IGameController;
import de.htwg.towerdefence.controller.impl.GameController;
import de.htwg.towerdefence.gui.impl.GUITD;
import de.htwg.towerdefence.util.Coord;

public class TowerDefence {
	
	
	public static void main( String[] args ) throws InterruptedException
	{
		// TowerDefence
		IGameController cont;
		cont = new GameController();
		cont.initGameController(29, 20,new Coord(0,0),new Coord(28,19));
		
		Thread t1 = new Thread( new GUITD(cont));
		t1.start();

		System.out.println("Spiel gestartet");
		cont.startGame();		
	  }
}
