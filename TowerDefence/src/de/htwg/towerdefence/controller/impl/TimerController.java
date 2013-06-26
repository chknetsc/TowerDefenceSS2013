package de.htwg.towerdefence.controller.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.TimerTask;

import de.htwg.towerdefence.model.IMob;
import de.htwg.towerdefence.model.IPlayer;
import de.htwg.towerdefence.model.IPlayingField;
import de.htwg.towerdefence.model.ITower;
import de.htwg.towerdefence.model.impl.Mob;
import de.htwg.towerdefence.model.way.ICheckWay;
import de.htwg.towerdefence.util.Coord;

public class TimerController extends TimerTask {
	
	IPlayingField field;
	IPlayer player;
	ICheckWay way;
	int nextWave;
	int lvlWave;
	

	public TimerController(IPlayingField field, IPlayer player, ICheckWay way) {
		this.field = field;
		this.player = player;
		this.way = way;
		this.nextWave = 0;
		this.lvlWave = 1;
	}
	
	@Override
	public void run() {
		List<Coord> waypoints = this.way.getShortesWay();
		List<IMob> mobs;
		
		for(int i = 0; i<waypoints.size()-3; i++) {
			mobs = this.field.getReadyMobs(waypoints.get(i).getX(), waypoints.get(i).getY());
			this.field.setListMob(waypoints.get(i+1).getX(), waypoints.get(i+1).getY(), mobs);
		}
		
		mobs = this.field.getReadyMobs(waypoints.get(waypoints.size()-1).getX(), waypoints.get(waypoints.size()-1).getY());
		this.player.setLife(this.player.getLife()-mobs.size());
		
		towersShootOnMobs();
		System.out.println(this.field.drawPlayingField());
		System.out.println("Anzahöl an Leben: " + this.player.getLife());
		
		this.nextWave++;
		System.out.println(this.nextWave);
		if(this.nextWave>5) {
				IMob mob = new Mob();
				mob.setLive(2*this.lvlWave);
				mob.setSpeed(3);
				System.out.println(this.field.setMob(0, 0, mob));
				this.nextWave = 0;
			}
		this.lvlWave++;	
	}
	
	public void towersShootOnMobs() {
		
		ITower tower;
		
		for (int x = 0; x <= this.field.getSizeX(); x++) {					// Gehe alle Felder durch
			for (int y = 0; y <= this.field.getSizeY(); y++) {		 
				if(this.field.isSetTower(x, y)) {					// Schaue ob Tower auf dem Feld liegt
					
					tower = this.field.getTower(x, y);
					int range = tower.getRange();
					int numberOfShoots = tower.getNumberOfShoot();
					int yT = y;
					int xT = x;
					
					// Oberes Feld 
					yT = yT-range;									// Erstes Feld checken
					MobsOnField(tower, xT, yT, numberOfShoots);
						
					int durchgang = 2;
					for(int i = 0; i < range; i++) {
						if(i==0) {
							yT++;
							xT++;
						} else {
							yT++;
							xT = xT + durchgang;
						}
						for(int j = 0; j <= durchgang; j++) {
							MobsOnField(tower, xT, yT, numberOfShoots); 
							xT--;
						}
						durchgang += 2;
					}
					
					
					// unteres Feld
					yT = y;
					xT = x;
					
					yT += range; 
					MobsOnField(tower, xT, yT, numberOfShoots);
					
					durchgang = 2;
					for(int i = 0; i < (range-1); i++) {
						if(i==0) {
							yT--;
							xT--;
						} else {
							yT--;
							xT = xT - durchgang;
						}
						for(int j = 0; j <= durchgang; j++) {
							MobsOnField(tower, xT, yT, numberOfShoots);
							xT++;
						}
						durchgang += 2;
					}
				}
			}
		}
	}
	
	// Returns the Number of Shoots leaft
	public int MobsOnField(ITower tower, int x, int y, int numberOfShoots) {
		
		if(this.field.getNumberOfMobs(x, y) != 0) {				// befindet sich Mobs auf dem Feld
			
			List<IMob> mobs = field.getMobs(x, y);
			
			for(int i = 0; i < mobs.size(); i++) {				// Über Mob Liste iterieren
				if(tower.shoot() && numberOfShoots != 0) {		// Prüfen ob Tower Schussbereit ist und noch schüsse übrig sind
					IMob mob = mobs.get(i);
					System.out.println("MobLife: "+ mob.getLive());
					int damage = tower.calcDamage();			// Schaden berechnen 
					System.out.println("Damage: "+ damage);
					mob.getDamage(damage);						// Leben von Mob abziehen und schauen ob er tot ist
					System.out.println("MobLife: "+ mob.getLive());
					// Get Money 
					}
					numberOfShoots--;
			}
		this.field.deleteDeadMobs(x, y);				// Mob aus Liste löschen
		}
		return numberOfShoots;
	}
}
