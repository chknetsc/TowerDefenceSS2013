package textUI;

import contoller.IGameController;


// Text based UI 
public class Tui {
	
	IGameController controller;
	
	public Tui(IGameController controller) {
		// Später Oberserver einfügen
		this.controller = controller;
	}

	// Handle User Inputs and call the Funktions from Controller
	public boolean handleInput(String input) {
		char towerart = input.charAt(0);								// Cut input Sting in singel characters
		
		if(towerart == 'T' || towerart == 't') {
			int xPosition = Integer.parseInt(input.substring(2, 3));
			int yPosition = Integer.parseInt(input.substring(4, 5));

			if (checkSizeValue(xPosition,yPosition)) {						// Check X and Y User Input and 
				controller.createAndSetTower(xPosition, yPosition);			// create a Tower on the Field
				printTui("Tower erstellt");
				return true;
			}
			printTui("Tower kann nicht erstellt werden");				// Fehlerausgabe fals Werte flasch sind
			return true;
		}
		else if(towerart == 'Q' || towerart == 'q') {					// Verlasse Spiel
			printTui("Spiel Beendet");
			return false;
		}
		else {
			printTui("Flasche Eingabe");								// Ausgabe wenn Eingabe fehlerhaft
			return true;
		}
		
	}
	
	
	// Check if the x an y are acceptable Values
	public boolean checkSizeValue(int xPosition,int yPosition) {
		if ((xPosition >= 0 && xPosition <= controller.fetchSizeX()) &&
			(yPosition >= 0 && yPosition <= controller.fetchSizeX())) {
			return true;
		}
		printTui("Werte sind zu klein oder groß für Spielfeld");
		return false;
		
	}

	// Show up Menue Text depend on count of User Inputs 
	public void printMenue() {
		String menue = "WILLKOMMEN BEIM SPIEL SPACETOWERDEFENCE !!!!!!!!!\n" +	
						"Edit by Martin and Chris :)\n\n" +
						"Wählen sie eine Option aus !\n" +
						"'T' um Tower zu setzen auf die Position 'X,Y' \n" +
						"Beispiel: 'T,1,2'  \n" +
						"oder 'Q' um das Spiel zu verlassen ...\n";
		printTui(menue);
	}
	
	public void bringPlayingField() {
		String spielfeld = controller.fetchPlayingField();
		printTui(spielfeld);
	}
	
	public void printTui(String inhalt) {
		System.out.println(inhalt);
	}

}
