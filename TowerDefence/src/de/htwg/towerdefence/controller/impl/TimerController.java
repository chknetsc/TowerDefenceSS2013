package de.htwg.towerdefence.controller.impl;

import java.util.TimerTask;

import de.htwg.towerdefence.model.IPlayer;
import de.htwg.towerdefence.model.IPlayingField;

public class TimerController extends TimerTask{
	
	IPlayingField field;
	IPlayer player;
	

	public TimerController(IPlayingField field, IPlayer player) {
		this.field = field;
		this.player = player;
	}
	
	@Override
	public void run() {
		System.out.println("Timer aktiv\n");
	}
}
