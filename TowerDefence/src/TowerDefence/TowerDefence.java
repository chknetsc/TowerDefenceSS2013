package TowerDefence;

import model.Field;
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
		
		PlayingField field = new PlayingField(10,10);
		System.out.println(field.drawPlayingField());
		field.setMob(0, 0, mob);
		field.setMob(1, 0, mob);
		field.setMob(2, 0, mob);
		field.setTower(0,1, tower);
		field.setTower(1,1, tower);
		field.setTower(2,1, tower);
		field.setTower(3,1, tower);
		System.out.println(field.drawPlayingField());
	  }
}
