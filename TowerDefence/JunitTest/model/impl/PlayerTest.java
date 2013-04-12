package model.impl;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import model.IMob;
import model.IPlayer;
import junit.framework.TestCase;

public class PlayerTest extends TestCase {
	
	IPlayer player;
	
	
	public void setUp() throws IOException {
		player = new Player();
		player = new Player("Herbert", 3, 100);
	}
	
	public void testDoc() {
		
		// Set and Get Name 
		player.setName("Rudolf");
		assertEquals("Rudolf", player.getName());
		
		// Set and Get Life
		player.setLife(13);
		assertEquals(13, player.getLife());
		
		// Set and Get Money
		player.setMoney(50);
		assertEquals(50, player.getMoney());
		
	}

}
