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
import org.newdawn.slick.gui.MouseOverArea;

import de.htwg.towerdefence.controller.IGameController;

public class GUITowerDefence extends BasicGame implements ComponentListener {
	
	private IGameController cont;
	
	private Image statusbar = null;
	private Image background = null;
	private Image playingfield = null;
	private Image upgrademenu = null;
	private Image buildmenu = null;
	private Image tower1 = null;
	private Image button = null;
	
	private MouseOverArea bsetTower;
	private MouseOverArea bdelTower;
	private MouseOverArea bDamageTower;
	private MouseOverArea bRangeTower;
	private MouseOverArea bSpeedTower;
	private MouseOverArea bHitrateTower;
	
	private int MouseX = 0;
	private int MouseY = 0;
	private int XCord = 0;
	private int YCord = 0;
	private int towerX = 0;
	private int towerY = 0;
	
	private boolean setTower= false;
	
	private String damage = "";
	private String range = "";
	private String speed = "";
	private String hitrate = "";
	

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
    	this.buildmenu = new Image("res/buildmenu.png");
    	this.tower1 = new Image("res/tower1.png");
    	this.button = new Image("res/button.png");
    	
    	this.bsetTower = new MouseOverArea(gc, button,55,535,180,30, this);
    	this.bsetTower.setNormalColor(new Color(1, 1, 1, 1.0f));
    	this.bsetTower.setMouseOverColor(new Color(1, 1, 1, 0.8f));
    	
    	this.bdelTower = new MouseOverArea(gc, button,660,400,180,30, this);
    	this.bdelTower.setNormalColor(new Color(1, 1, 1, 1.0f));
    	this.bdelTower.setMouseOverColor(new Color(1, 1, 1, 0.8f));
    	
    	this.bDamageTower = new MouseOverArea(gc, button,660,365,180,30, this);
    	this.bDamageTower.setNormalColor(new Color(1, 1, 1, 1.0f));
    	this.bDamageTower.setMouseOverColor(new Color(1, 1, 1, 0.8f));
    	
    	this.bSpeedTower = new MouseOverArea(gc, button,660,330,180,30, this);
    	this.bSpeedTower.setNormalColor(new Color(1, 1, 1, 1.0f));
    	this.bSpeedTower.setMouseOverColor(new Color(1, 1, 1, 0.8f));
    	
    	this.bHitrateTower = new MouseOverArea(gc, button,660,295,180,30, this);
    	this.bHitrateTower.setNormalColor(new Color(1, 1, 1, 1.0f));
    	this.bHitrateTower.setMouseOverColor(new Color(1, 1, 1, 0.8f));
    	
    	this.bRangeTower = new MouseOverArea(gc, button,660,260,180,30, this);
    	this.bRangeTower.setNormalColor(new Color(1, 1, 1, 1.0f));
    	this.bRangeTower.setMouseOverColor(new Color(1, 1, 1, 0.8f));
    }
    
    @Override
    public void update(GameContainer gc, int delta) throws SlickException    
    {
    	if(gc.getInput().isMousePressed(Input.MOUSE_LEFT_BUTTON)) {
        	this.MouseX = gc.getInput().getMouseX();
        	this.MouseY = gc.getInput().getMouseY();
        	this.XCord = ((this.MouseX) / 20);
        	this.YCord = ((this.MouseY) / 20);
        	if(this.setTower) {
        	   this.cont.setTower(this.XCord-2, (this.YCord-3), 0);
        	}
        	if(this.cont.isSetTower(this.XCord-2, (this.YCord-3))) {
        		updateTowerInfo();
        	} 
    	}
    	if(gc.getInput().isMousePressed(Input.MOUSE_RIGHT_BUTTON)) {
    		this.setTower = false;
    		this.damage = "";
    		this.hitrate = "";
    		this.range = "";
    		this.speed = "";
    	}
    }
    
    public void render(GameContainer gc, Graphics g) throws SlickException
    {
    	g.setColor(Color.white);
    	g.fillRect(0, 0, gc.getWidth(),gc.getHeight());
    	    	
    	this.background.draw(0, 0, 800, 600);
    	
    	this.statusbar.draw(0, 0, 800, 25);
    	this.statusbar.setAlpha(1.0f);
    	
    	this.playingfield.draw(30, 50, 600, 461);
    	this.playingfield.setAlpha(1.0f);
    	
    	this.upgrademenu.draw(650, 50, 150, 400);
    	this.upgrademenu.setAlpha(0.8f);
    	
    	this.buildmenu.draw(45, 520, 560, 100);
    	this.buildmenu.setAlpha(0.8f);
    	
    	this.bsetTower.render(gc, g);
    	this.bdelTower.render(gc, g);
    	this.bDamageTower.render(gc, g);
    	this.bSpeedTower.render(gc, g);
    	this.bHitrateTower.render(gc, g);
    	this.bRangeTower.render(gc, g);
    	
    	g.setColor(Color.white);
    	g.drawString("Live: " + this.cont.getLive(), 550, 2);
    	g.drawString("Money: " + this.cont.getMoney(), 650, 2);
    	g.drawString("Set Tower", 105, 538);
    	g.drawString("Delete Tower", 669, 403);
    	g.drawString("Upgrade Damage", 669, 367);
    	g.drawString("Upgrade Speed", 669, 335);
    	g.drawString("Upgrade Hitrate", 669, 300);
    	g.drawString("Upgrade Range", 669, 265);
    	
    	g.setColor(Color.black);
    	g.drawString("Tower:", 665, 60);
    	g.drawString("Damage:" + this.damage, 665, 100);
    	g.drawString("Range:" + this.range,665, 120);
    	g.drawString("Speed:" + this.speed, 665, 140);
    	g.drawString("Hitrate:" + this.hitrate, 665, 160);
    	   
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
    
    private void updateTowerInfo() {
    	Integer value;
		Double value2;
		value = new Integer(this.cont.getTowerDamage(this.XCord-2, (this.YCord-3))); 
		this.damage = value.toString();
		value = new Integer(this.cont.getTowerRange(this.XCord-2, (this.YCord-3))); 
		this.range = value.toString();
		value = new Integer(this.cont.getTowerSpeed(this.XCord-2, (this.YCord-3))); 
		this.speed = value.toString();
		value2 = new Double(this.cont.getTowerHitrate(this.XCord-2, (this.YCord-3))); 
		this.hitrate = value2.toString();
		this.towerX = this.XCord-2;
		this.towerY = this.YCord-3;
    }
    
    private void drawInfo(Graphics g) {
    	g.setColor(Color.white);
    	g.drawString("X-Cord: " + this.MouseX, 0, 2);
    	g.drawString("Y-Cord: " + this.MouseY, 130, 2);
    	g.drawString("FieldCoords: " + (this.XCord-2) + "/" + (this.YCord-3), 260, 2);
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
    	Integer value;
		Double value2;
    	if (source.equals(this.bsetTower)) {
			this.setTower = true;
		} else if (source.equals(this.bdelTower)) {
			this.cont.deleteTower(this.towerX, this.towerY);
		} else if (source.equals(this.bDamageTower)) {
			this.cont.updateTowerDamage(this.towerX, this.towerY);
			value = new Integer(this.cont.getTowerDamage(this.towerX, this.towerY)); 
			this.damage = value.toString();
		} else if (source.equals(this.bSpeedTower)) {
			this.cont.updateTowerSpeed(this.towerX, this.towerY);
			value = new Integer(this.cont.getTowerSpeed(this.towerX, this.towerY)); 
			this.speed = value.toString();
		} else if (source.equals(this.bHitrateTower)) {
			this.cont.updateTowerHitrate(this.towerX, this.towerY);
			value2 = new Double(this.cont.getTowerHitrate(this.towerX, this.towerY)); 
			this.hitrate = value2.toString();
		} else if (source.equals(this.bRangeTower)) {
			this.cont.updateTowerRange(this.towerX, this.towerY);
			value = new Integer(this.cont.getTowerRange(this.towerX, this.towerY)); 
			this.range = value.toString();
		}
	}
}
