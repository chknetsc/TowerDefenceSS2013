package de.htwg.towerdefence.TowerDefence;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;


import de.htwg.towerdefence.controller.IGameController;
import de.htwg.towerdefence.controller.impl.GameController;
import de.htwg.towerdefence.model.IMob;
import de.htwg.towerdefence.model.impl.Field;
import de.htwg.towerdefence.model.impl.Mob;
import de.htwg.towerdefence.model.impl.PlayingField;
import de.htwg.towerdefence.model.impl.Tower;
import de.htwg.towerdefence.model.way.ICheckWay;
import de.htwg.towerdefence.model.way.impl.CheckWay;
import de.htwg.towerdefence.textUI.Tui;
import de.htwg.towerdefence.util.Coord;



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
		
		Field f = new Field();
		List<IMob> m = new LinkedList<IMob>();
		IMob mob;
		List<IMob> im;
		
		mob = new Mob();
		mob.setLive(100);
		mob.setSpeed(3);
		m.add(mob);
		mob = new Mob();
		mob.setLive(99);
		mob.setSpeed(3);
		m.add(mob);
		mob = new Mob();
		mob.setLive(98);
		mob.setSpeed(1);
		m.add(mob);
		mob = new Mob();
		mob.setLive(97);
		mob.setSpeed(10);
		m.add(mob);
		
		for(int i = 0; i<m.size(); i++) {
			System.out.println("Mob " + i);
			System.out.println("Live: " + m.get(i).getLive());
			System.out.println("Speed: " + m.get(i).getSpeed() + "\n");
		}
		System.out.println("--------------------");
		f.setListMob(m);
		im = f.getReadyMobs();
		
		
		for(int i = 0; i<im.size(); i++) {
			System.out.println("Mob " + i);
			System.out.println("Live: " + im.get(i).getLive());
			System.out.println("Speed: " + im.get(i).getSpeed() + "\n");
		}
		System.out.println("--------------------");
		im = f.getMobs();
		for(int i = 0; i<im.size(); i++) {
			System.out.println("Mob " + i);
			System.out.println("Live: " + im.get(i).getLive());
			System.out.println("Speed: " + im.get(i).getSpeed() + "\n");
		}
		System.out.println("--------------------");
	  }
}
