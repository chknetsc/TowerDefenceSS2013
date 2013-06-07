package de.htwg.towerdefence.textUI;

import org.apache.log4j.Logger;

import de.htwg.towerdefence.controller.IGameController;
import de.htwg.towerdefence.util.Coord;
import de.htwg.towerdefence.util.observer.Event;
import de.htwg.towerdefence.util.observer.IObserver;


// Text based UI 
public class Tui implements IObserver {
	
	private IGameController controller;	
	
	private String newLine = System.getProperty("line.separator");
	private Logger logger = Logger.getLogger("de.htwg.towerdefence.textUI");
	
	// Connect Controller with Tui
	public Tui(IGameController controller) {								
		this.controller = controller;
		controller.initGameController(10, 10, new Coord(0,0), new Coord(10,10));
		
		//controller.addObserver(this);
	}
	

	// Handle User Inputs and call the Funktions from Controller
	public boolean handleInput(String input) {
		// Cut input Sting in a singel characters
		String[] splitInput = input.split(",");			
									
		if(splitInput[0].equalsIgnoreCase("Q")) {
			printTui("Spiel Beendet");
			return false;
		}
		else {
			int xPosition = Integer.parseInt(splitInput[1]);		
			int yPosition = Integer.parseInt(splitInput[2]);
			// Check X and Y User Input and 
			if (checkSizeValue(xPosition,yPosition)) {								
				
				// Tower setzen
				if(splitInput[0].equalsIgnoreCase("T")) {
					// TODO If Fall einbauen falls Platz bereits belegt
					
						// create a Tower on the Field
					
						printTui("Tower erstellt");
						return true;
				}
				// Monster spawnen bzw sp�ter anderen Tower erstellen
				else if(splitInput[0].equalsIgnoreCase("M")) {
					// TODO If Fall einbauen falls Platz bereits belegt
					
					// create a Mob on the Field
					
					printTui("Mob gespawnt");
					return true;
				} else {
					// Ausgabe wenn Eingabe fehlerhaft
					printTui("Tower nicht vorhanden");								
					return true;
				}
			} else {
				// Ausgabe wenn Eingabe fehlerhaft
				printTui("Flasche Eingabe");										
				return true;
			}
		}
	}
		
	
	// Check if the x an y are acceptable Values
	public boolean checkSizeValue(int xPosition,int yPosition) {
		if( xPosition < 0 || xPosition > controller.getSizeX() || yPosition < 0 || yPosition > controller.getSizeY() ) {
			printTui("Werte sind zu klein oder gro� f�r Spielfeld");
			return false;
		}
		return true;
		
	}

	// Show up Menue Text depend on count of User Inputs 
	public void printMenue() {
		String menue = "WILLKOMMEN BEIM SPIEL SPACETOWERDEFENCE !!!!!!!!!\n" +	
						"Edit by Martin and Chris :)\n\n" +
						"W�hlen sie die Spielfeldgr��e \n" +
						"Klein  = 1\n" +
						"Mittel = 2\n" +
						"Gro�   = 3\n" +
						"==> ";
		printTui(menue);
	}
	
	// Set the Size of the PlayingField
	public void setPlayingFieldSize(int groese) {
		
		
	}
	
	// Show the Instuktions for the User
	public void printInstruktions() {
		String instruktion = 
				"W�hlen sie eine Option aus !\n" +
				"'T' um Tower zu setzen auf die Position 'X,Y' Beispiel: 'T,1,2'  \n" +
				"oder 'Q' um das Spiel zu verlassen ...\n";
		printTui(instruktion);
	}
	
	public void printPlayingField() {
		String spielfeld = controller.getPlayingField();
		printTui(spielfeld);
	}
	
	public void printTui(String inhalt) {
		logger.info(newLine + inhalt);
	}

	@Override
	public void update(Event e) {
		printPlayingField();
	}

}
