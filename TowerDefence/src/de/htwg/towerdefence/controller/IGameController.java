package de.htwg.towerdefence.controller;


public interface IGameController {
		
	// Towerfunktionen
	boolean setTower(int x, int y);
	int getTowerDamage(int x, int y);
	int getTowerRange(int x, int y);
	int getTowerSpeed(int x, int y);
	int getTowerNumberShoot(int x, int y);
	double getTowerHitrate(int x, int y);
	boolean updateTowerDamage(int x, int y, int damage);
	boolean updateTowerRange(int x, int y, int range);
	boolean updateTowerSpeed(int x, int y, int speed);
	boolean updateTowerNumberShoot(int x, int y, int numberShoot);
	boolean updateTowerHitrate(int x, int y, double hitrate);
	boolean deleteTower(int x, int y);
	boolean isSetTower(int x, int y);
	
	// Mobfunktionen
	boolean setMob(int x, int y);
	
	// Steuerung
	void initGameController(int sizeX, int sizeY);
	boolean startGame();
	boolean pauseGame();
	boolean stopGame();
	int getMoney();
}