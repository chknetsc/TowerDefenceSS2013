package textUI;

public class Tui {
	
	public Tui() {
	// Sp�ter Controller und Oberserver einf�gen
	}

	public boolean handleInput(String input) {
		if(input.equalsIgnoreCase("T")) {
			System.out.println("Geben sie nun die Position an:");
			System.out.println("X = ");
			System.out.println("Y = ");
		}
		return false;
	}

	public void printMenue() {
		System.out.println("Edit by Martin and Chris :) ");
		System.out.println("W�hlen sie eine Option aus !");
		System.out.println("'T' um Tower zu setzen / 'Q' um das Spiel zu verlassen ");
	
	}

}
