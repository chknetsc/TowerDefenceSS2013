package de.htwg.towerdefence.util;

public class Coord {
     private int x;
     private int y;
     
     
     public Coord(){
    	 this.x = 0;
    	 this.y = 0;
     }
     
     public Coord(int x, int y){
    	 this.x = x;
    	 this.y = y;
     }
     
     // Returns the X Value
     public int getX() {
    	 return this.x;
     }
     
     // Set the X value
     public boolean setX(int x) {
    	 if(x >= 0) {
    		 this.x = x;
    		 return true;
    	 }
    	 return false;
     }
     
     // Returns the y value
     public int getY() {
    	 return this.y;
     }
     
  // Set the y value
     public boolean setY(int y) {
    	 if(y >= 0) {
    		 this.y = y;
    		 return true;
    	 }
    	 return false;
     }
}
