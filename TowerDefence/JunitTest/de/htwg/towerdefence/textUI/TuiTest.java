package de.htwg.towerdefence.textUI;

import java.io.IOException;

import de.htwg.towerdefence.controller.impl.GameController;
import de.htwg.towerdefence.textUI.Tui;
import junit.framework.TestCase;

public class TuiTest extends TestCase {
	
	Tui tui;
	GameController controller;
	
	public void setUp() throws IOException {
		controller = new GameController();
		tui = new Tui(controller);
	}
	
	public void testDoc() {
		
		// Menue ausgabe 
		tui.printMenue();
		
		// Spielfeld ausgeben
		tui.bringPlayingField();
		
		// Positions Check
		assertEquals(false, tui.checkSizeValue(-1, 2));
		assertEquals(false, tui.checkSizeValue(1, -2));
		assertEquals(false, tui.checkSizeValue(11, 2));
		assertEquals(false, tui.checkSizeValue(2, 20));
		
	// Eingabe verarbeiten
		//Tower Setzen
		assertEquals(true,tui.handleInput("t,1,2"));
		assertEquals(true,tui.handleInput("T,1,2"));
		assertEquals(true,tui.handleInput("m,1,2"));
		assertEquals(true,tui.handleInput("M,1,2"));
		// Spiel beenden 
		assertEquals(false,tui.handleInput("q,1,2"));
		assertEquals(false,tui.handleInput("Q,1,2"));
		// Falsche Eingabe 
		assertEquals(true, tui.handleInput("z,1,2"));
		assertEquals(true,tui.handleInput("T,11,2"));

	}

}
