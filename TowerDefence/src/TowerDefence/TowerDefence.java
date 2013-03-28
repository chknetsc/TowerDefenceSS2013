package TowerDefence;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;


import contoller.IGameController;
import controller.impl.GameController;

import textUI.Tui;

import model.IGraph;
import model.impl.AdjacencyListUndirectedGraph;
import model.impl.DijkstraShortestPath;
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
		
		IGraph<Integer> g = new AdjacencyListUndirectedGraph<Integer>();
		DijkstraShortestPath<Integer> path = new DijkstraShortestPath<Integer>(g);
		
		for(int i = 1; i<17; i++) {
		  g.addVertex(i);
		  System.out.println("Add Vertex " + i);
		}
		
		for(int i = 1; i<17; i++) {
		    if((i%4) != 0) {
			    g.addEdge(i,i+1);
			    System.out.println("Add Node between " + i + " and " + (i+1));
		    }
		    
		    if(i<13) {
			    g.addEdge(i,i+4);
			    System.out.println("Add Node between " + i + " and " + (i+4));
		    }
		}
	   System.out.println(path.searchShortestPath(1, 16));
	   List<Integer> l = path.getShortestPath();
	   
	   for ( Iterator<Integer> i = l.iterator(); i.hasNext(); )
	   {
	     System.out.println(i.next());
	   }
	   System.out.println("Number of Edges: "+g.getNumberOfEdges());
	   System.out.println(g.deleteAllEdgeOn(10));
	   System.out.println(g.deleteAllEdgeOn(8));
	   System.out.println(g.deleteAllEdgeOn(12));
	   System.out.println(g.deleteAllEdgeOn(9));
	   System.out.println(g.deleteAllEdgeOn(2));
	   System.out.println("Number of Edges: "+g.getNumberOfEdges());
	   System.out.println(path.searchShortestPath(1, 16));
	   l = path.getShortestPath();
	   
	   for ( Iterator<Integer> i = l.iterator(); i.hasNext(); )
	   {
	     System.out.println(i.next());
	   }
	   l = g.getAdjacentVertexList(1);
	   for ( Iterator<Integer> i = l.iterator(); i.hasNext(); )
	   {
	     System.out.println(i.next());
	   }	
	  }
}
