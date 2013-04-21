package de.htwg.towerdefence.textUI;

import de.htwg.towerdefence.controller.IGameController;


// Text based UI 
public class Tui {
	
	private IGameController controller;	
	
	// Connect Controller with Tui
	public Tui(IGameController controller) {								
		// Später Oberserver einfügen
		this.controller = controller;
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
				// Monster spawnen bzw später anderen Tower erstellen
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
		
		printTui("Werte sind zu klein oder groß für Spielfeld");
		return false;
		
	}

	// Show up Menue Text depend on count of User Inputs 
	public void printMenue() {
		String menue = "WILLKOMMEN BEIM SPIEL SPACETOWERDEFENCE !!!!!!!!!\n" +	
						"Edit by Martin and Chris :)\n\n" +
						"Wählen sie die Spielfeldgröße \n" +
						"Klein  = 1\n" +
						"Mittel = 2\n" +
						"Groß   = 3\n" +
						"==> ";
		printTui(menue);
	}
	
	// Set the Size of the PlayingField
	public void setPlayingFieldSize(int groese) {
		
		
	}
	
	// Show the Instuktions for the User
	public void printInstruktions() {
		String instruktion = 
				"Wählen sie eine Option aus !\n" +
				"'T' um Tower zu setzen auf die Position 'X,Y' Beispiel: 'T,1,2'  \n" +
				"oder 'Q' um das Spiel zu verlassen ...\n";
		printTui(instruktion);
	}
	
	public void bringPlayingField() {
		String spielfeld = "";
		printTui(spielfeld);
	}
	
	public void printTui(String inhalt) {
		System.out.println(inhalt);
	}

}
