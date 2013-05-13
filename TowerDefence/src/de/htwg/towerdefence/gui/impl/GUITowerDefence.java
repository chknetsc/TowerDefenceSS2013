package de.htwg.towerdefence.gui.impl;

import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.gui.AbstractComponent;
import org.newdawn.slick.gui.ComponentListener;

import de.htwg.towerdefence.controller.IGameController;

public class GUITowerDefence extends BasicGame implements ComponentListener {
	
	private IGameController cont;

	public GUITowerDefence(IGameController cont)
    {
        super("TowerDefence");
        this.cont = cont;
    }
  
    @Override
    public void init(GameContainer gc) throws SlickException {
    	gc.setTargetFrameRate(60);
    	gc.setShowFPS(false);
    }
    
    @Override
    public void update(GameContainer gc, int delta) throws SlickException    
    {
    	
    }
    
    public void render(GameContainer gc, Graphics g) throws SlickException
    {
    	g.setColor(Color.white);
    	g.fillRect(0, 0, gc.getWidth(),gc.getHeight());
    	g.setColor(Color.lightGray);
    	g.fillRect(0, 0, gc.getWidth(),20);
    	g.setColor(Color.black);
    	g.drawString("Live: " + this.cont.getLive(), 0, 0);
    	g.drawString("Money: " + this.cont.getMoney(), 200, 0);
    	
    	for(int i = 0; i<gc.getWidth(); i=i+20) {
    		g.fillRect(i,20,1,gc.getHeight());
    	}
    	
    	for(int i = 0; i<gc.getHeight(); i=i+20) {
    		g.fillRect(0,i,gc.getWidth(),1);
    	}
    	
    	g.setColor(Color.blue);
    	for(int i = 0; i<this.cont.getSizeX(); i++) {
    		for(int j = 0; j<this.cont.getSizeY(); j++) {
        		if(this.cont.getTypeOf(i,j) == 2) {
        			g.setColor(Color.blue);
        			g.fillRect(i*20,j*20+20,20,20);
        		}
        		if(this.cont.getTypeOf(i,j) == 1) {
        			g.setColor(Color.black);
        			g.fillRect(i*20,j*20+20,20,20);
        		}
        	}
    	}
    }
    
    public void componentActivated(AbstractComponent source) {
		
	}
}
