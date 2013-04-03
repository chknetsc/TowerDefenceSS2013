package model;

import way.IGraph;

public interface IUndirectedGraph<V> extends IGraph<V> {
    int getDegree(V v); // Returns the value of node
}

