package de.htwg.towerdefence.model.way;

import java.util.List;

import de.htwg.towerdefence.util.Edge;


public interface IGraph<V> {
	
 // Adds node to the graph
 boolean addVertex(V v);
 
 // Adds a new Edge to the graph with weight 1.0
 boolean addEdge(V v, V w);
 
 // Adds a new Edge to the graph with weight
 boolean addEdge(V v, V w, double weight);
 
 // delete a Edge between v and w
 boolean delteEdge(V v, V w); 
 
 // delete all Edge to this Point
 boolean deleteAllEdgeOn(V v); 
 
 // Checks if graph contains node
 boolean containsVertex(V v);  
 
 // Checks if graph contains edge
 boolean containsEdge(V v, V w);
 
 // Returns the weight of the edge
 double getWeight(V v, V w);  
 
 // Returns the number of Nodes
 int getNumberOfVertexes(); 
 
 // Returns the number of edge
 int getNumberOfEdges();  
 
 // Returns a list of all Nodes
 List<V> getVertexList();  
 
 // Returns a list of all edge
 List<Edge<V>> getEdgeList();  
 
 // Get a list of all neighbor nodes
 List<V> getAdjacentVertexList(V v);  
 
 // get a list of all neighbor edges
 List<Edge<V>> getIncidentEdgeList(V v);
 
}

