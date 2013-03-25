package TowerDefence;

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
		
		Tower tower = new Tower(100,1,1,1,0.0);
		for(int i=0;i<100;i++){
			System.out.println(tower.calcDamage());
		}
	  }
}
