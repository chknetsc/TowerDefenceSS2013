package de.htwg.towerdefence.gui.impl;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;

import com.google.inject.Inject;

import de.htwg.towerdefence.controller.IGameController;

public class GUITD implements Runnable {
	
	private IGameController cont;
	
	@Inject
	public GUITD(IGameController cont)
    {
        this.cont = cont;
    }

	@Override
	public void run() {
		AppGameContainer app;
		try {
			app = new AppGameContainer(new GUITowerDefence(cont));
			app.setDisplayMode(800, 600, false);
		    app.start();
		} catch (SlickException e) {
			e.printStackTrace();
		}	    
	}
}
