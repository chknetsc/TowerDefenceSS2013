package de.htwg.towerdefence.controller.impl;

import java.util.Timer;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import de.htwg.towerdefence.controller.IGameController;
import de.htwg.towerdefence.model.IMob;
import de.htwg.towerdefence.model.IPlayer;
import de.htwg.towerdefence.model.IPlayingField;
import de.htwg.towerdefence.model.ITower;
import de.htwg.towerdefence.model.impl.Mob;
import de.htwg.towerdefence.model.impl.Player;
import de.htwg.towerdefence.model.impl.PlayingField;
import de.htwg.towerdefence.model.impl.Tower;
import de.htwg.towerdefence.model.way.ICheckWay;
import de.htwg.towerdefence.model.way.impl.CheckWay;
import de.htwg.towerdefence.util.Coord;
import de.htwg.towerdefence.util.observer.Observable;

@Singleton
public class GameController extends Observable implements IGameController {
		
	private IPlayingField field;
	private IPlayer player;
	private ICheckWay way;
	private Coord start;
	private Coord end;
	Timer timer;
	
	@Inject
	public GameController() {
		this.field = new PlayingField();
		this.player = new Player();
		this.way = new CheckWay();
	}
	
	@Override
	public void initGameController(int sizeX, int sizeY, Coord start, Coord end) {
		this.way.initWayPoints(sizeX, sizeY);
		this.field.initPlayingField(sizeX, sizeY);
		this.start = start;
		this.end = end;
		this.way.existWay(this.start.getX(), this.start.getY(),this.end.getX(), this.end.getY());
	}

	@Override
	public boolean setTower(int x, int y, int type) {
		this.way.deleteWayPoint(x, y);
		if(this.way.existWay(this.start.getX(), this.start.getY(),this.end.getX(), this.end.getY()) && player.getMoney() >= 150) {
			ITower tower = new Tower(20,1,2,5,0.6);
			player.setMoney(player.getMoney() - 150);
			return this.field.setTower(x, y, tower);
		} 
	    this.way.addWayPoint(x, y);
	    this.way.existWay(this.start.getX(), this.start.getY(),this.end.getX(), this.end.getY());
 	   
	    notifyObservers();
	    return false;
 	    
 	    
	}

	public String getPlayingField() {
		return this.field.drawPlayingField();
	}
	
	@Override
	public int getTowerDamage(int x, int y) {
		return this.field.getTower(x, y).getDamage();
	}

	@Override
	public int getTowerRange(int x, int y) {
		return this.field.getTower(x, y).getRange();
	}

	@Override
	public int getTowerSpeed(int x, int y) {
		return this.field.getTower(x, y).getSpeed();
	}

	@Override
	public int getTowerNumberShoot(int x, int y) {
		return this.field.getTower(x, y).getNumberOfShoot();
	}

	@Override
	public double getTowerHitrate(int x, int y) {
		return this.field.getTower(x, y).getHitRate();
	}

	@Override
	public boolean updateTowerDamage(int x, int y) {
		return this.field.getTower(x, y).setDamage(this.field.getTower(x, y).getDamage()+10);
	}

	@Override
	public boolean updateTowerRange(int x, int y) {
		return this.field.getTower(x, y).setRange(this.field.getTower(x, y).getRange()+1);
	}

	@Override
	public boolean updateTowerSpeed(int x, int y) {
		return this.field.getTower(x, y).setSpeed(this.field.getTower(x, y).getSpeed()+1);
	}

	@Override
	public boolean updateTowerNumberShoot(int x, int y) {
		return this.field.getTower(x, y).setNumberOfShoot(this.field.getTower(x, y).getNumberOfShoot()+1);
	}

	@Override
	public boolean updateTowerHitrate(int x, int y) {
		return this.field.getTower(x, y).setHitRate(this.field.getTower(x, y).getHitRate()+0.1);
	}
	
	@Override
	public int getUpdateTowerDamageCost(int x, int y) {
		return 10;
	}

	@Override
	public int getUpdateTowerRangeCost(int x, int y) {
		return 10;
	}

	@Override
	public int getUpdateTowerSpeedCost(int x, int y) {
		return 10;
	}

	@Override
	public int getUpdateTowerNumberShootCost(int x, int y) {
		return 10;
	}

	@Override
	public int getUpdateTowerHitrateCost(int x, int y) {
		return 10;
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
	public boolean setMob(int x, int y, int type) {
		IMob mob = new Mob();
		mob.setLive(200);
		mob.setSpeed(2);
		return this.field.setMob(x, y, mob);
	}

	@Override
	public void startGame() {
		this.timer = new Timer();
		timer.schedule( new TimerController(this.field,this.player,this.way), 0, 500 );
	}

	@Override
	public void pauseGame() {
		timer.cancel();
	}

	@Override
	public void stopGame() {
		timer.cancel();
	}

	@Override
	public int getMoney() {
		return this.player.getMoney();
	}

	@Override
	public int getLive() {
		return this.player.getLife();
	}

	@Override
	public int getSizeX() {
		return this.field.getSizeX();
	}

	@Override
	public int getSizeY() {
		return this.field.getSizeY();
	}

	@Override
	public int getTypeOf(int x, int y) {
		return this.field.getTypeOf(x, y);
	}
	
	
}
