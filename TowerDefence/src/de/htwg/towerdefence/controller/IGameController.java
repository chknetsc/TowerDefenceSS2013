package de.htwg.towerdefence.controller;

import de.htwg.towerdefence.util.Coord;


public interface IGameController {
		
	// Towerfunktionen
	boolean setTower(int x, int y, int type);
	int getTowerDamage(int x, int y);
	int getTowerRange(int x, int y);
	int getTowerSpeed(int x, int y);
	int getTowerNumberShoot(int x, int y);
	double getTowerHitrate(int x, int y);
	int getUpdateTowerDamageCost(int x, int y);
	boolean updateTowerDamage(int x, int y, int damage);
	int getUpdateTowerRangeCost(int x, int y);
	boolean updateTowerRange(int x, int y, int range);
	int getUpdateTowerSpeedCost(int x, int y);
	boolean updateTowerSpeed(int x, int y, int speed);
	int getUpdateTowerNumberShootCost(int x, int y);
	boolean updateTowerNumberShoot(int x, int y, int numberShoot);
	int getUpdateTowerHitrateCost(int x, int y);
	boolean updateTowerHitrate(int x, int y, double hitrate);
	boolean deleteTower(int x, int y);
	boolean isSetTower(int x, int y);
	
	// Mobfunktionen
	boolean setMob(int x, int y, int type);
	
	// Steuerung
	void initGameController(int sizeX, int sizeY, Coord start, Coord end);
	void startGame();
	void pauseGame();
	void stopGame();
	int getMoney();
	int getLive();
}