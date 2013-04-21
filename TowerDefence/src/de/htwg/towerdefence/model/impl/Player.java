package de.htwg.towerdefence.model.impl;

import de.htwg.towerdefence.model.IPlayer;

public class Player implements IPlayer {
	
	private String name;
	private int money;
	private int life;
	private final int setLive = 10;
	private final int setMoney = 1000;
	
	public Player() {
		this.name = "Player1";
		this.life = this.setLive;
		this.money = this.setMoney;
	}
	
	public Player(String name, int life, int money) {
		this.name = name;
		this.life = life;
		this.money = money;
	}
	
	@Override
	public String getName() {
		return name;
	}


	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int getMoney() {
		return money;
	}


	@Override
	public void setMoney(int money) {
		this.money = money;
	}

	@Override
	public int getLife() {
		return life;
	}

	@Override
	public void setLife(int life) {
		this.life = life;
	}
	
}
