import java.awt.Color;
import java.awt.Graphics;

public class Food {
	private int x, y;
	boolean eaten;
	int width;
	private Color color1;
	private Color set;

	public Color getSet() {
		return set;
	}

	public void setSet(Color set) {
		this.set = set;
	}

	public Food(int pX, int pY) {
		this.x = pX;
		this.y = pY;
		eaten = false;
		this.width = 50;
		color1 = new Color((int)(Math.random()*256), (int)(Math.random()*256), (int)(Math.random()*256));
	}

	public void paint(Graphics g) {
		g.fillOval(x, y, width, width);
		g.setColor(color1);
	}

	public void newCoord() {
		this.x = (int) (Math.random() * (700)); // [0, 800] randomize it
		this.y = (int) (Math.random() * (700)); // randomize it between [0, 600]
		System.out.println("Food X:" + this.x);
		System.out.println("Food Y:" + this.y);
	}

	public boolean isEaten() {
		if (this.eaten) {
			return true;
		}
		return false;
	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}

	public int getWidth() {
		// TODO Auto-generated method stub
		return this.width;
	}

}
