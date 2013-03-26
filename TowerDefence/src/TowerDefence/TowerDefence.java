package TowerDefence;

import java.util.Scanner;

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
		Tui tui = new Tui();
		
		Scanner scanner = new Scanner(System.in);
		tui.printMenue();
		
		boolean continu = true;				// Solange true bis Spiel abgebrochen wird
		while(continu) {
			continu = tui.handleInput(scanner.next());
		}
		//*/
		
		
		
	  }
	
}
