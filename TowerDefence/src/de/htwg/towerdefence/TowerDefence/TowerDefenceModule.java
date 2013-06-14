package de.htwg.towerdefence.TowerDefence;

import com.google.inject.AbstractModule;
import de.htwg.towerdefence.controller.IGameController;
import de.htwg.towerdefence.model.IPlayer;
import de.htwg.towerdefence.model.IPlayingField;
import de.htwg.towerdefence.model.way.ICheckWay;

public class TowerDefenceModule extends AbstractModule{

	@Override
	protected void configure() {
		// TODO Auto-generated method stub
		
		bind(IGameController.class).to(de.htwg.towerdefence.controller.impl.GameController.class);
		bind(IPlayingField.class).to(de.htwg.towerdefence.model.impl.PlayingField.class);
		bind(IPlayer.class).to(de.htwg.towerdefence.model.impl.Player.class);
		bind(ICheckWay.class).to(de.htwg.towerdefence.model.way.impl.CheckWay.class);
	}
}
