package TowerDefence;

import model.Field;
import model.Tower;

public class TowerDefence {
	public static void main( String[] args )
	  {
		System.out.println("Towerdefence");
		System.out.println("ist ein");
		System.out.println("super");
		System.out.println("Spiel");
		System.out.println("!!!!");
		System.out.println("!!!!");
		
		Field field = new Field();
		Tower tower = new Tower(1,1,1,1,1.0);
		
		System.out.println(field.isSetTower());
		field.setTower(tower);
		System.out.println(field.isSetTower());
	  }
}
