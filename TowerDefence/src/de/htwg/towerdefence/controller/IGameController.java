package de.htwg.towerdefence.controller;

import de.htwg.towerdefence.model.ITower;

public interface IGameController {
	boolean setTower(int x, int y);
	boolean deleteTower(int x, int y);
	boolean updateTower(int x, int y);
	ITower getTower(int x, int y);
}