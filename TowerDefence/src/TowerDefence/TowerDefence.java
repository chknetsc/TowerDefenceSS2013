package TowerDefence;

import java.util.Scanner;

import contoller.IGameController;
import controller.impl.GameController;

import textUI.Tui;

import model.impl.Mob;
import model.impl.PlayingField;
import model.impl.Tower;

public class TowerDefence {
	public static void main( String[] args )
	  {
		/*
		Tower tower = new Tower(1,1,1,1,1.0);
		Mob mob = new Mob(10,10);
		Mob mob2 = new Mob(10,10);
		
		PlayingField field = new PlayingField(10,20);
		System.out.println(field.drawPlayingField());
	
		field.setTower(0,1, tower);
		field.setMob(2, 2, mob);
		field.setMob(3, 2, mob2);
		System.out.println(field.drawPlayingField());
		
		*/
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
		
		
		
	  }
	
}
