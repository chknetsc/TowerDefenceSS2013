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
	private Image background = null;
	private Image playingfield = null;
	private Image upgrademenu = null;
	private Image tower1 = null;
	
	
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
    	this.background = new Image("res/background.png");
    	this.playingfield = new Image("res/playingfield.png");
    	this.upgrademenu = new Image("res/upgrademenu.png");
    	this.tower1 = new Image("res/tower1.png");
    }
    
    @Override
    public void update(GameContainer gc, int delta) throws SlickException    
    {
    	if(gc.getInput().isMousePressed(Input.MOUSE_LEFT_BUTTON)) {
        	this.MouseX = gc.getInput().getMouseX();
        	this.MouseY = gc.getInput().getMouseY();
        	this.XCord = ((this.MouseX) / 20);
        	this.YCord = ((this.MouseY) / 20);
        	this.cont.setTower(this.XCord-2, (this.YCord-3), 0);
        	if(this.XCord == 39 && this.YCord == 29)  {
        		this.cont.setMob(0, 0, 0);
        	}
    	}
    }
    
    public void render(GameContainer gc, Graphics g) throws SlickException
    {
    	g.setColor(Color.white);
    	g.fillRect(0, 0, gc.getWidth(),gc.getHeight());
    	    	
    	this.background.draw(0, 0, 800, 600);
    	this.background.setAlpha(1.0f);
    	
    	this.statusbar.draw(0, 0, 800, 25);
    	this.statusbar.setAlpha(1.0f);
    	
    	this.playingfield.draw(30, 50, 600, 461);
    	this.playingfield.setAlpha(1.0f);
    	
    	this.upgrademenu.draw(650, 50, 150, 400);
    	this.upgrademenu.setAlpha(0.8f);
    	
    	g.setColor(Color.white);
    	g.drawString("Live: " + this.cont.getLive(), 550, 2);
    	g.drawString("Money: " + this.cont.getMoney(), 650, 2);

    	
    	this.drawMash(gc, g);
    	this.drawInfo(g);
    	
    	
    	for(int i = 0; i<this.cont.getSizeX(); i++) {
    		for(int j = 0; j<this.cont.getSizeY(); j++) {
        		if(this.cont.getTypeOf(i,j) == 2) {
        			g.setColor(Color.blue);
        			g.fillRect(i*20+40,j*20+60,20,20);
        		}
        		if(this.cont.getTypeOf(i,j) == 1) {
        			this.tower1.draw(i*20+40, j*20+60, 20, 20);
        	    	this.tower1.setAlpha(1.0f);
        		}
        	}
    	}
    }
    
    private void drawInfo(Graphics g) {
    	g.setColor(Color.white);
    	g.drawString("X-Cord: " + this.MouseX, 0, 2);
    	g.drawString("Y-Cord: " + this.MouseY, 130, 2);
    	g.drawString("FieldCoords: " + this.XCord + "/" + (this.YCord-1), 260, 2);
    }
    
    private void drawMash(GameContainer gc, Graphics g) {
      g.setColor(Color.black);
      for(int i = 60; i<(gc.getWidth()-160); i=i+20) {
    	  g.fillRect(i,60,1,(gc.getHeight()-160));
      }
      for(int i = 80; i<(gc.getHeight()-100); i=i+20) {
    	  g.fillRect(40,i,(gc.getWidth()-220),1);
      }
    }
    
    public void componentActivated(AbstractComponent source) {
		
	}
}
