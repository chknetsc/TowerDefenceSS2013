package AsternTest;

import java.util.List;


public interface IGraph<V> {
 
 boolean addVertex(V v);                       // Adds node to the graph
 boolean addEdge(V v, V w);                    // Adds a new Edge to the graph with weight 1.0
 boolean addEdge(V v, V w, double weight);     // Adds a new Edge to the graph with weight
 boolean containsVertex(V v);                  // Checks if graph contains node
 boolean containsEdge(V v, V w);               // Checks if graph contains edge
 double getWeight(V v, V w);                   // Returns the weight of the edge
 int getNumberOfVertexes();                    // Returns the number of Nodes
 int getNumberOfEdges();                       // Returns the number of edge
 List<V> getVertexList();                      // Returns a list of all Nodes
 List<Edge<V>> getEdgeList();                  // Returns a list of all edge
 List<V> getAdjacentVertexList(V v);           // Get a list of all neighbor nodes
 List<Edge<V>> getIncidentEdgeList(V v);       // get a list of all neighbor edges
}

