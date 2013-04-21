package de.htwg.towerdefence.model;

public interface IPlayer {

	// --------------- Get and Set Methoden -------------------
	abstract String getName();

	abstract void setName(String name);

	abstract int getMoney();

	abstract void setMoney(int money);

	abstract int getLife();

	abstract void setLife(int life);

}