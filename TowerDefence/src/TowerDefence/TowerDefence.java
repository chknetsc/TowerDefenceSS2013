package TowerDefence;

import model.Mob;
import model.PlayingField;
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
		
		Tower tower = new Tower(1,1,1,1,1.0);
		Mob mob = new Mob(10,10);
		Mob mob2 = new Mob(10,10);
		
		PlayingField field = new PlayingField(10,20);
		System.out.println(field.drawPlayingField());
	
		field.setTower(0,1, tower);
		field.setMob(2, 2, mob);
		field.setMob(3, 2, mob2);
		System.out.println(field.drawPlayingField());
	  }
}
