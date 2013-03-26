package contoller;

public interface IGameController {

	public void createAndSetTower(int xPosition, int yPosition);

	public void createAndSetMob(int xPosition, int yPosition);

	public int fetchSizeX();

	public int fetchSizeY();

	public String fetchPlayingField();

}