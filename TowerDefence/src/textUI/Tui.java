package textUI;

import contoller.IGameController;


// Text based UI 
public class Tui {
	
	IGameController controller;												
	
	public Tui(IGameController controller) {								// Connect Controller with Tui
		// Sp�ter Oberserver einf�gen
		this.controller = controller;
	}

	// Handle User Inputs and call the Funktions from Controller
	public boolean handleInput(String input) {
		
		String[] splitInput = input.split(",");			// Cut input Sting in a singel characters
									
		if(splitInput[0].equalsIgnoreCase("Q")) {
			printTui("Spiel Beendet");
			return false;
		}
		else {
			int xPosition = Integer.parseInt(splitInput[1]);		
			int yPosition = Integer.parseInt(splitInput[2]);
			
			if (checkSizeValue(xPosition,yPosition)) {								// Check X and Y User Input and 
				
				// Tower setzen
				if(splitInput[0].equalsIgnoreCase("T")) {
					// TODO If Fall einbauen falls Platz bereits belegt
						controller.createAndSetTower(xPosition, yPosition);			// create a Tower on the Field
						printTui("Tower erstellt");
						return true;
				}
				// Monster spawnen bzw sp�ter anderen Tower erstellen
				else if(splitInput[0].equalsIgnoreCase("M")) {
					// TODO If Fall einbauen falls Platz bereits belegt
					controller.createAndSetMob(xPosition, yPosition);				// create a Mob on the Field
					printTui("Mob gespawnt");
					return true;
				} else {
					printTui("Tower nicht vorhanden");								// Ausgabe wenn Eingabe fehlerhaft
					return true;
				}
			} else {
				printTui("Flasche Eingabe");										// Ausgabe wenn Eingabe fehlerhaft
				return true;
			}
		}
	}
		
	
	// Check if the x an y are acceptable Values
	public boolean checkSizeValue(int xPosition,int yPosition) {
		if ((xPosition >= 0 && xPosition <= controller.fetchSizeX()) &&
			(yPosition >= 0 && yPosition <= controller.fetchSizeX())) {
			return true;
		}
		printTui("Werte sind zu klein oder gro� f�r Spielfeld");
		return false;
		
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
		controller.setSizeofPlayingField(groese);
		
	}
	
	// Show the Instuktions for the User
	public void printInstruktions() {
		String instruktion = 
				"W�hlen sie eine Option aus !\n" +
				"'T' um Tower zu setzen auf die Position 'X,Y' Beispiel: 'T,1,2'  \n" +
				"oder 'Q' um das Spiel zu verlassen ...\n";
		printTui(instruktion);
	}
	
	public void bringPlayingField() {
		String spielfeld = "";
		spielfeld = controller.fetchPlayingField();
		printTui(spielfeld);
	}
	
	public void printTui(String inhalt) {
		System.out.println(inhalt);
	}

}
