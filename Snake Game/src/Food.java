
public class Food {
	private int x, y;
	boolean eaten;

	public Food() {
		this.x = x;
		this.y = y;
		eaten = false;
	}

	public void newCoord() {
		this.x = (int) (Math.random() * (800)); // [0, 800] randomize it
		this.y = (int) (Math.random() * (600)); // randomize it between [0, 600]
	}

}
