package de.htwg.towerdefence.model.way.impl;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import de.htwg.towerdefence.model.way.IUndirectedGraph;
import de.htwg.towerdefence.util.Edge;




public class AdjacencyListUndirectedGraph<V> implements IUndirectedGraph<V>{

	private HashMap<V,HashMap<V,Double>> adjacencyList = new HashMap<V,HashMap<V,Double>>();
	private List<Edge<V>> edgeList = new LinkedList<Edge<V>>();

	@Override
	public boolean addVertex(V v) {
		if(!adjacencyList.containsKey(v)) {
			adjacencyList.put(v,new HashMap<V, Double>());
			return true;
		}		
	return false;
	}

	@Override
	public boolean addEdge(V v, V w) {
		return addEdge(v, w, 1.0);
	}

	@Override
	public boolean addEdge(V v, V w, double weight) {
		if( adjacencyList.containsKey(v) && adjacencyList.containsKey(w) ) {
			//edge is already listed
			if(adjacencyList.get(v).containsKey(w)) {
				return false;
			}
			//put in hashmap of v
			adjacencyList.get(v).put(w, weight);
					
			//put in hashmap of w
			adjacencyList.get(w).put(v, weight);
					
			edgeList.add(new Edge<V>(v,w));
			edgeList.add(new Edge<V>(w,v));
			
			return true;
		}
		return false;				
	}
	
	public boolean deleteAllEdgeOn(V v){
		if(this.adjacencyList.containsKey(v)) {
			List<V> l = this.getAdjacentVertexList(v);
			for ( Iterator<V> i = l.iterator(); i.hasNext(); )
			   {
				 this.delteEdge(v, i.next());
			   }
			return true;
		}
		return false;
	}
	
	public boolean delteEdge(V v, V w){
		if(this.containsEdge(v, w)) {
			this.adjacencyList.get(v).remove(w);
			this.adjacencyList.get(w).remove(v);
			
			for(int i = 0; i < this.getNumberOfEdges(); i++) {
				Edge<V> e = this.edgeList.get(i);
				 if(e.getSource() == v && e.getTarget() == w) {
					 this.edgeList.remove(i);
				 }
			}
			for(int i = 0; i < this.getNumberOfEdges(); i++) {
				Edge<V> e = this.edgeList.get(i);
				 if(e.getSource() == w && e.getTarget() == v) {
					 this.edgeList.remove(i);
				 }
			}
			return true;
		}
		return false;
	}
	
	@Override
	public boolean containsVertex(V v) {
		if(this.adjacencyList.containsKey(v)) {
			return true;
		}
		return false;
	}

	@Override
	public boolean containsEdge(V v, V w) {
		if(this.adjacencyList.get(v).containsKey(w)) {
			return true;
		}
		return false;
	}

	@Override
	public double getWeight(V v, V w) {
		if(adjacencyList.containsKey(v) && adjacencyList.containsKey(w)) {
			if(!adjacencyList.get(v).containsKey(w) || v.equals(w)) {
				return 0.0;
			}
		return adjacencyList.get(v).get(w);
		}
		return 0.0;
	}

	@Override
	public int getNumberOfVertexes() {
		return adjacencyList.size();
	}

	@Override
	public int getNumberOfEdges() {
		return edgeList.size();
	}

	@Override
	public List<V> getVertexList() {
		List<V> vertices = new LinkedList<V>();
		for(Map.Entry<V, HashMap<V, Double>> e : adjacencyList.entrySet()) {
			vertices.add(e.getKey());
		}
		return vertices;
	}

	@Override
	public List<Edge<V>> getEdgeList() {
		return new LinkedList<Edge<V>>(edgeList);
	}

	@Override
	public List<V> getAdjacentVertexList(V v) {
		List<V> vertices = new LinkedList<V>();
		if(adjacencyList.containsKey(v)) {
			HashMap<V, Double> hm = adjacencyList.get(v);
			
			for( Map.Entry<V, Double> e : hm.entrySet() ) {
				vertices.add(e.getKey());
			}
		}
	return vertices;
	}

	@Override
	public List<Edge<V>> getIncidentEdgeList(V v) {
		List<Edge<V>> edges = new LinkedList<Edge<V>>();
		if(adjacencyList.containsKey(v)) {
			for(Edge<V> e : edgeList ) {
				if(e.getSource().equals(v)) {
					edges.add(e);
				}
			}
		}
	return edges;
	}

	@Override
	public int getDegree(V v) {
		if(adjacencyList.containsKey(v)) {
			return adjacencyList.get(v).size();
		}
	return -1;
	}

}

