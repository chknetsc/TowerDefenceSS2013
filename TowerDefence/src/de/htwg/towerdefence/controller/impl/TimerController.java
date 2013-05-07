package de.htwg.towerdefence.controller.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.TimerTask;

import de.htwg.towerdefence.model.IMob;
import de.htwg.towerdefence.model.IPlayer;
import de.htwg.towerdefence.model.IPlayingField;
import de.htwg.towerdefence.model.way.ICheckWay;
import de.htwg.towerdefence.util.Coord;

public class TimerController extends TimerTask{
	
	IPlayingField field;
	IPlayer player;
	ICheckWay way;
	

	public TimerController(IPlayingField field, IPlayer player, ICheckWay way) {
		this.field = field;
		this.player = player;
		this.way = way;
	}
	
	@Override
	public void run() {
		System.out.println(this.field.drawPlayingField());
		System.out.println("Anzahöl an Leben: " + this.player.getLife());
		List<Coord> waypoints = this.way.getShortesWay();
		List<IMob> mobs;
		
		for(int i = 0; i<waypoints.size()-1; i++) {
			mobs = this.field.getReadyMobs(waypoints.get(i).getX(), waypoints.get(i).getY());
			this.field.setListMob(waypoints.get(i+1).getX(), waypoints.get(i+1).getY(), mobs);
		}
		
		mobs = this.field.getReadyMobs(waypoints.get(waypoints.size()-1).getX(), waypoints.get(waypoints.size()-1).getY());
		this.player.setLife(this.player.getLife()-mobs.size());
	}
}
