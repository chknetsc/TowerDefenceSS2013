package de.htwg.towerdefence.util;

public class Edge<V> {
 // Startnode
 final private V source; 
 
 // Finishnode
 final private V target;
 
 // Weight
 final private double weight;
 


 public Edge(V source, V target) {
     this.source = source;
     this.target = target;
     this.weight = 1.0;
 }

 public Edge(V source, V target, double weight) {
     this.source = source;
     this.target = target;
     this.weight = weight;
 }

 public V getSource() {
     return this.source;
 }

 public V getTarget() {
     return this.target;
 }

 public double getWeight() {
     return this.weight;
 }

 @Override public String toString() {
     if (weight == 1) {
         return source + " -- " + target;
     } else {
         return source + " -- " + target + " (" + weight + ")";
     }
 }
}

