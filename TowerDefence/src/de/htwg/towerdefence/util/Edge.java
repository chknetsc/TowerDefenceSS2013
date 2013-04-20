package de.htwg.towerdefence.util;

public class Edge<V> {

 final private V source;        // Startnode
 final private V target;        // Finishnode
 final private double weight;   // Weight


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

