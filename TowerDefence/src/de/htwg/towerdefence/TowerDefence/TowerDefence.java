package de.htwg.towerdefence.TowerDefence;



import java.util.Scanner;

import org.apache.log4j.PropertyConfigurator;

import com.google.inject.Guice;
import com.google.inject.Injector;
import de.htwg.towerdefence.controller.IGameController;
import de.htwg.towerdefence.gui.impl.GUITD;
import de.htwg.towerdefence.textUI.Tui;
import de.htwg.towerdefence.util.Coord;

public class TowerDefence {
	
	private static Scanner scanner;
	
	public static void main( String[] args ) throws InterruptedException
	{
		// Set up logging through log4j
		PropertyConfigurator.configure("log4j.properties");
		
		// Set up Google Guice Dependency Injector
		Injector injector = Guice.createInjector(new TowerDefenceModule());
		
		// Controller Init
		IGameController controller;
		controller = injector.getInstance(IGameController.class);
		controller.initGameController(29, 20,new Coord(0,0),new Coord(28,19));
		
		// Tui Init
		//Tui tui = injector.getInstance(Tui.class);
		
		// Gui Init
		Thread t1 = new Thread(injector.getInstance(GUITD.class));
		t1.start();

		// Game Starten
		//tui.printTui("Spiel gestartet");
		controller.startGame();
		
		// Tui eingaben
		/*
		boolean continu = true;
		scanner = new Scanner(System.in);
		while (continu) {
		    // continu = tui.handleInput(scanner.next());		
		}
		*/
		
	  }
}
