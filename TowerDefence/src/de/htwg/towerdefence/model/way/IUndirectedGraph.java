package de.htwg.towerdefence.model.way;


public interface IUndirectedGraph<V> extends IGraph<V> {
	// Returns the value of node
    int getDegree(V v); 
}

