package de.htwg.towerdefence.controller.impl;

import de.htwg.towerdefence.controller.IGameController;
import de.htwg.towerdefence.model.IMob;
import de.htwg.towerdefence.model.IPlayingField;
import de.htwg.towerdefence.model.ITower;
import de.htwg.towerdefence.model.impl.Mob;
import de.htwg.towerdefence.model.impl.PlayingField;
import de.htwg.towerdefence.model.impl.Tower;

public class GameController implements IGameController {
		
	private IPlayingField field;
	
	public GameController() {
		
	}
	
	@Override
	public void initGameController(int sizeX, int sizeY) {
		this.field = new PlayingField();
		this.field.initPlayingField(sizeX, sizeY);
	}

	@Override
	public boolean setTower(int x, int y) {
		ITower tower = new Tower(1,1,1,1,1.0);
		return this.field.setTower(x, y, tower);
	}

	@Override
	public int getTowerDamage(int x, int y) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getTowerRange(int x, int y) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getTowerSpeed(int x, int y) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getTowerNumberShoot(int x, int y) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getTowerHitrate(int x, int y) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean updateTowerDamage(int x, int y, int damage) {
		return this.field.getTower(x, y).setDamage(damage);
	}

	@Override
	public boolean updateTowerRange(int x, int y, int range) {
		return this.field.getTower(x, y).setRange(range);
	}

	@Override
	public boolean updateTowerSpeed(int x, int y, int speed) {
		return this.field.getTower(x, y).setSpeed(speed);
	}

	@Override
	public boolean updateTowerNumberShoot(int x, int y, int numberShoot) {
		return this.field.getTower(x, y).setNumberOfShoot(numberShoot);
	}

	@Override
	public boolean updateTowerHitrate(int x, int y, double hitrate) {
		return this.field.getTower(x, y).setHitRate(hitrate);
	}

	@Override
	public boolean deleteTower(int x, int y) {
		if(this.field.deleteTower(x, y) != null) {
			return true;
		}
		return false;
	}

	@Override
	public boolean isSetTower(int x, int y) {
		return this.field.isSetTower(x, y);
	}

	@Override
	public boolean setMob(int x, int y) {
		IMob mob = new Mob();
		mob.setLive(100);
		mob.setSpeed(1);
		return this.field.setMob(x, y, mob);
	}

	@Override
	public boolean startGame() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean pauseGame() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean stopGame() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getMoney() {
		// TODO Auto-generated method stub
		return 0;
	}
}
