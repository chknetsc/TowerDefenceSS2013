package de.htwg.towerdefence.controller;

import de.htwg.towerdefence.model.ITower;

public interface IGameController {
	// Towerfunktionen
	boolean setTower(int x, int y);
	boolean setTower(int x, int y, int damage, int range, int speed, int numberShoot, double hitrate);
	boolean updateTowerDamage(int x, int y, int damage);
	boolean updateTowerRange(int x, int y, int range);
	boolean updateTowerSpeed(int x, int y, int speed);
	boolean updateTowerNumberShoot(int x, int y, int numberShoot);
	boolean updateTowerHitrate(int x, int y, double hitrate);
	boolean deleteTower(int x, int y);
	boolean isSetTower(int x, int y);
	// Mobfunktionen
	boolean setMob(int x, int y);
	boolean setMob(int x, int y, int live, int speed);
}