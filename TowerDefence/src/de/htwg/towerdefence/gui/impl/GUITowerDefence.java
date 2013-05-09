package de.htwg.towerdefence.gui.impl;

import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.gui.AbstractComponent;
import org.newdawn.slick.gui.ComponentListener;

public class GUITowerDefence extends BasicGame implements ComponentListener {

	public GUITowerDefence()
    {
        super("TowerDefence");
    }
  
    @Override
    public void init(GameContainer gc) throws SlickException {
    	gc.setTargetFrameRate(60);
    }
    
    @Override
    public void update(GameContainer gc, int delta) throws SlickException    
    {
    	
    }
    
    public void render(GameContainer gc, Graphics g) throws SlickException
    {
    	
    }
    
    public void componentActivated(AbstractComponent source) {
		
	}
}
