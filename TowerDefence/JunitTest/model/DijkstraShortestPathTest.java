package model;

import java.io.IOException;

import model.impl.AdjacencyListUndirectedGraph;
import model.impl.DijkstraShortestPath;

import junit.framework.TestCase;

public class DijkstraShortestPathTest extends TestCase {
	
	DijkstraShortestPath<Integer> path;
	IGraph<Integer> g;
	
	public void setUp() throws IOException {
		this.g = new AdjacencyListUndirectedGraph<Integer>();
		this.path = new DijkstraShortestPath<Integer>(this.g);
		int sizeX = 10;
		int sizeY = 10;
		
		for(int i = 1; i<=(sizeX*sizeY); i++) {
			  g.addVertex(i);
		}
		for(int i = 1; i<=(sizeX*sizeY); i++) {
		   if((i%sizeX) != 0) {
			 g.addEdge(i,i+1);
		   }
		   if(i<=(sizeX*sizeY)-sizeX) {
			 g.addEdge(i,i+sizeX);
		   }
		}
		
	}
	
	public void testDoc() {
		
		assertEquals(true,this.path.searchShortestPath(1, 10));
		assertEquals(false,this.path.searchShortestPath(1, 1));
		
	}
}