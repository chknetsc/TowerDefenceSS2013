package de.htwg.towerdefence.model;

public interface IPlayer {

	// --------------- Get and Set Methoden -------------------
	public abstract String getName();

	public abstract void setName(String name);

	public abstract int getMoney();

	public abstract void setMoney(int money);

	public abstract int getLife();

	public abstract void setLife(int life);

}