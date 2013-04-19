package de.htwg.towerdefence.model.impl;

import de.htwg.towerdefence.model.IPlayer;

public class Player implements IPlayer {
	
	private String name;
	private int money;
	private int life;
	
	public Player() {
		setName("Player1");
		setLife(10);
		setMoney(1000);
	}
	
	public Player(String name, int life, int money) {
		setName(name);
		setLife(life);
		setMoney(money);
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
