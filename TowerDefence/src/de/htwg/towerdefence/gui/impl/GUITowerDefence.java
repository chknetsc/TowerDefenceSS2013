package de.htwg.towerdefence.gui.impl;

import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.gui.AbstractComponent;
import org.newdawn.slick.gui.ComponentListener;

import de.htwg.towerdefence.controller.IGameController;

public class GUITowerDefence extends BasicGame implements ComponentListener {
	
	private IGameController cont;
	private Image statusbar = null;
	
	private int MouseX = 0;
	private int MouseY = 0;
	private int XCord = 0;
	private int YCord = 0;
	

	public GUITowerDefence(IGameController cont)
    {
        super("TowerDefence");
        this.cont = cont;
    }
  
    @Override
    public void init(GameContainer gc) throws SlickException {
    	gc.setTargetFrameRate(60);
    	gc.setShowFPS(false);
    	
    	this.statusbar = new Image("res/statusbar.png");
    }
    
    @Override
    public void update(GameContainer gc, int delta) throws SlickException    
    {
    	if(gc.getInput().isMousePressed(Input.MOUSE_LEFT_BUTTON)) {
        	this.MouseX = gc.getInput().getMouseX();
        	this.MouseY = gc.getInput().getMouseY();
        	this.XCord = ((this.MouseX) / 20);
        	this.YCord = ((this.MouseY) / 20);
        	this.cont.setTower(this.XCord, (this.YCord-1), 0);
        	
        	if(this.XCord == 39 && this.YCord == 29)  {
        		this.cont.setMob(0, 0, 0);
        	}
    	}
    }
    
    public void render(GameContainer gc, Graphics g) throws SlickException
    {
    	g.setColor(Color.white);
    	g.fillRect(0, 0, gc.getWidth(),gc.getHeight());
    	    	
    	this.statusbar.draw(0, 0, 800, 25);
    	this.statusbar.setAlpha(1.0f);
    	
    	g.setColor(Color.white);
    	g.drawString("Live: " + this.cont.getLive(), 550, 2);
    	g.drawString("Money: " + this.cont.getMoney(), 650, 2);
    	
    	g.drawString("X-Cord: " + this.MouseX, 0, 2);
    	g.drawString("Y-Cord: " + this.MouseY, 130, 2);
    	
    	g.drawString("FieldCoords: " + this.XCord + "/" + (this.YCord-1), 260, 2);
    	
    	g.setColor(Color.black);
    	
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
