package textUI;

public class Tui {
	
	public Tui() {
	// Später Controller und Oberserver einfügen
	}

	// Handle User Inputs and call the Funktions from Controller
	public boolean handleInput(String input) {
		
		// Cut String in single char
		char towerart = input.charAt(0);
		
		// Prüft Eingabe und erstellt daraus Tower
		if(towerart == 'T' || towerart == 't') {
			if (checkSizeValue(input.charAt(2),input.charAt(4))) {
				// controller.createTower();
				printTui("Tower erstellt");
				return true;
			}
			printTui("Tower kann nicht erstellt werden");
			return true;
		}
		else if(towerart == 'Q' || towerart == 'q') {
			printTui("Spiel Beendet");
			return false;
		}
		else {
			printTui("Flasche Eingabe");
			return true;
		}
		
	}
	
	
	// Check if the x an y are acceptable Values
	public boolean checkSizeValue(int xPosition,int yPosition) {
		/*
		if (xPosition < 0 || xPosition > contoller.fetchSizeX() ||
			yPosition < 0 || yPosition > contoller.fetchSizeX() ) {
				printTui("Werte sind zu klein oder groß für Spielfeld");
				return false;
			}
			*/
		return true;
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
		String spielfeld = "";
		// controller.fetchPlayingField();
		printTui(spielfeld);
	}
	
	public void printTui(String inhalt) {
		System.out.println(inhalt);
	}

}
