package controller.impl;

import contoller.IGameController;
import model.IMob;
import model.IPlayingField;
import model.ITower;
import model.impl.Mob;
import model.impl.PlayingField;
import model.impl.Tower;

// Handle the total GameLogic
public class GameController implements IGameController {
	
	// Alle Interfaces auführen mit dennen der Controller arbeiten muss
	ITower tower;
	IMob mob;
	IPlayingField playingField;
	
	public GameController() {
		// TODO Später eigene Funktion anlegen um Größe zu bestimmen
		playingField = new PlayingField(10,10);
	}
	
	//----------------------- Mehoden zum Testen der Klassen (Protoypten) ---------------------------
	

	public void createAndSetTower(int xPosition, int yPosition) {
		tower = new Tower(1,1,1,1,1.0);
		playingField.setTower(xPosition, yPosition, (Tower) tower);
	}
	

	public void createAndSetMob(int xPosition, int yPosition) {
		mob = new Mob();
		playingField.setMob(xPosition, yPosition, (Mob) mob);
	}
	

	public int fetchSizeX() {
		return playingField.getSizeX();	
	}
	

	public int fetchSizeY() {
		return playingField.getSizeX();	
	}
	

	public String fetchPlayingField() {
		return playingField.drawPlayingField();	
	}
	
	
	
	
	// Set the Size of the PlayingField to Small, Middle, Big
	public void setSizeofPlayingField(int groese) {
		if(1 == groese) {
			playingField.initPlayingField(20, 20);
		}
		else if(2 == groese) {
			playingField.initPlayingField(50, 50);
		}
		else {
			playingField.initPlayingField(100, 100);
		}
	}
}
