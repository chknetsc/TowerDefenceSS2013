package de.htwg.towerdefence.TowerDefence;



import java.util.Scanner;

import org.apache.log4j.PropertyConfigurator;
import de.htwg.towerdefence.controller.IGameController;
import de.htwg.towerdefence.controller.impl.GameController;
import de.htwg.towerdefence.gui.impl.GUITD;
import de.htwg.towerdefence.textUI.Tui;
import de.htwg.towerdefence.util.Coord;

public class TowerDefence {
	
	private static Scanner scanner;
	
	public static void main( String[] args ) throws InterruptedException
	{
		// Set up logging through log4j
		PropertyConfigurator.configure("log4j.properties");
		
		// Controller Init
		IGameController cont;
		cont = new GameController();
		cont.initGameController(29, 20,new Coord(0,0),new Coord(28,19));
		
		// Tui Init
		Tui tui = new Tui(cont);
		
		// Gui Init
		Thread t1 = new Thread( new GUITD(cont));
		t1.start();

		// Game Starten
		tui.printTui("Spiel gestartet");
		cont.startGame();
		
		// Tui eingaben
		boolean continu = true;
		scanner = new Scanner(System.in);
		while (continu) {
		    continu = tui.handleInput(scanner.next());		
		}
		
	  }
}
