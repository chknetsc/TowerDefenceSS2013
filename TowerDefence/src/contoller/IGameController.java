package contoller;

public interface IGameController {

	public void createAndSetTower(int xPosition, int yPosition);

	public void createAndSetMob(int xPosition, int yPosition);

	public int fetchSizeX();


	public String fetchPlayingField();
	
	// Set the Size of the PlayingField to Small, Middle, Big
	public void setSizeofPlayingField(int groese);

}