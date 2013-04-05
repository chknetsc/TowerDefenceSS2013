package TowerDefence;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;


import contoller.IGameController;
import controller.impl.GameController;

import textUI.Tui;

import model.impl.Mob;
import model.impl.PlayingField;
import model.impl.Tower;
import model.way.ICheckWay;
import model.way.impl.CheckWay;
import model.way.impl.Coord;

public class TowerDefence {
	public static void main( String[] args )
	  {
		 /*
		IGameController controller = new GameController();
		Tui tui = new Tui(controller);
		
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		tui.printMenue();
		
		tui.setPlayingFieldSize(scanner.nextInt());
		tui.bringPlayingField();
		
		boolean continu = true;				// Solange true bis Spiel abgebrochen wird
		while(continu) {
			tui.printInstruktions();
			continu = tui.handleInput(scanner.next());
			tui.bringPlayingField();
		}
		//*/
		
		// Spielfeld anlegen und testen.
		//-------------------------------
		
		PlayingField field = new PlayingField(40,50);
		System.out.println(field.drawPlayingField());
		System.out.println(field.setTower(0, 1, new Tower(1,1,1,1,1.0)));
		System.out.println(field.setTower(1, 1, new Tower(1,1,1,1,1.0)));
		System.out.println(field.setTower(2, 1, new Tower(1,1,1,1,1.0)));
		System.out.println(field.setTower(3, 1, new Tower(1,1,1,1,1.0)));
		System.out.println(field.setTower(4, 1, new Tower(1,1,1,1,1.0)));
		System.out.println(field.setTower(5, 1, new Tower(1,1,1,1,1.0)));
		System.out.println(field.setTower(6, 1, new Tower(1,1,1,1,1.0)));
		System.out.println(field.setTower(7, 1, new Tower(1,1,1,1,1.0)));
		System.out.println(field.setTower(8, 1, new Tower(1,1,1,1,1.0)));
		System.out.println(field.setTower(9, 3, new Tower(1,1,1,1,1.0)));
		System.out.println(field.setTower(1, 3, new Tower(1,1,1,1,1.0)));
		System.out.println(field.setTower(2, 3, new Tower(1,1,1,1,1.0)));
		System.out.println(field.setTower(3, 3, new Tower(1,1,1,1,1.0)));
		System.out.println(field.setTower(4, 3, new Tower(1,1,1,1,1.0)));
		System.out.println(field.setTower(5, 3, new Tower(1,1,1,1,1.0)));
		System.out.println(field.setTower(6, 3, new Tower(1,1,1,1,1.0)));
		System.out.println(field.setTower(7, 3, new Tower(1,1,1,1,1.0)));
		System.out.println(field.setTower(8, 3, new Tower(1,1,1,1,1.0)));
		System.out.println(field.setTower(8, 2, new Tower(1,1,1,1,1.0)));
		System.out.println(field.drawPlayingField()); 
	  }
}
