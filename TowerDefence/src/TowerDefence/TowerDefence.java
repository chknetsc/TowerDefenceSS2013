package TowerDefence;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;


import contoller.IGameController;
import controller.impl.GameController;

import textUI.Tui;

import model.ICheckWay;
import model.impl.CheckWay;
import model.impl.Coord;
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
		
		*/ /*
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
		
		ICheckWay way = new CheckWay();
		way.initWayPoints(7, 6);
		//System.out.println(way.getNumberofVertex(2, 1));
		System.out.println(way.deleteWayPoint(0, 1)); 
		System.out.println(way.deleteWayPoint(1, 1));
		System.out.println(way.deleteWayPoint(2, 1));
		System.out.println(way.deleteWayPoint(3, 1));
		System.out.println(way.deleteWayPoint(5, 0));
		System.out.println(way.deleteWayPoint(5, 1));
		System.out.println(way.deleteWayPoint(5, 2));
		System.out.println(way.deleteWayPoint(5, 3));
		System.out.println(way.deleteWayPoint(4, 3));
		System.out.println(way.deleteWayPoint(3, 3));
		System.out.println(way.deleteWayPoint(2, 3));
		System.out.println(way.deleteWayPoint(1, 3));
		if (way.existWay(0, 0, 6, 5)){
			System.out.println("Weg gefunden");
		}
		System.out.println(way.getNumberofVertex(1, 1));
		List<Coord> l = way.getShortesWay();
		for(int i = 0; i<l.size(); i++) {
			System.out.println("Coord: ("+l.get(i).getX()+"/"+l.get(i).getY()+")");
		}
		
		System.out.println(way.deleteWayPoint(0, 0));
		System.out.println(way.deleteWayPoint(0, 0));
		way.addWayPoint(0, 0);
		way.addWayPoint(3, 2);
	  }
}
