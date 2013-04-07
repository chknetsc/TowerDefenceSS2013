package TowerDefence;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;


import controller.IGameController;
import controller.impl.GameController;

import textUI.Tui;
import util.Coord;

import model.IMob;
import model.impl.Field;
import model.impl.Mob;
import model.impl.PlayingField;
import model.impl.Tower;
import model.way.ICheckWay;
import model.way.impl.CheckWay;

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
