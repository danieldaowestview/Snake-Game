import java.awt.Color;
import java.awt.Graphics;

public class Snake {
	private boolean alive;
	private int x;
	private int y;
	private int move;

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}

	public void setY(int pY) {
		this.y = pY;
	}

	public void setX(int pX) {
		this.x = pX;
	}

	public Color getColor() {
		return color;
	}

	private int width; // size variable
	private Color color; // color

	// # - parts of a class - constructor
	// helps with creation of class
	// assigns values to the instance variable
	public Snake() { // the default constructor is the one w/o parameters

		x = (int) (Math.random() * (600 - 100 + 1)) + 100; // [100 600] randomize it
		y = (int) (Math.random() * (400 - 100 + 1)) + 100;// randomize it between [100 400]
		this.alive = true;
		this.move = 1;
		width = 3;
		color = new Color(0, 0, 0);

	}
}
