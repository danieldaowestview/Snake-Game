import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class Snake {
	private boolean alive;
	private int x;
	private int y;
	private int move; // direction of move, 1 - north, 2 - south, 3 - east, 4 - west
	private int vx;
	private int vy;
	private ArrayList growth;
	private int score;

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

	public void setVy(int pVY) {
		this.vy = pVY;
	}

	public void setVx(int pVX) {
		this.vx = pVX;
	}

	public Color getColor() {
		return color;
	}

	private int width; // size variable
	private Color color; // color
	private int height;

	// # - parts of a class - constructor
	// helps with creation of class
	// assigns values to the instance variable
	public Snake(int x, int y) { // the default constructor is the one w/o parameters

		this.x = x;
		this.y = y;
		this.setMove(1);
		width = 50;
		color = new Color(124, 252, 0);
		this.vx = 0;
		this.vy = 7;
		alive = true;
		ArrayList growth = new ArrayList();
		this.score = score;
	}

	public void paint(Graphics g) {
		g.fillRect(x, y, width, width);
		x += vx;
		y += vy;
	}

	public int getMove() {
		return move;
	}

	public void setMove(int move) {
		this.move = move;
	}

	public boolean isAlive() {
		return alive;
	}

	public void setAlive(boolean alive) {
		this.alive = alive;
	}

	public int getWidth() {
		// TODO Auto-generated method stub
		return this.width;
	}

	public int getHeight() {
		// TODO Auto-generated method stub
		return this.height;
	}
	
	public void grow() {
		//growth.add
	}

	public int getScore() {
		// TODO Auto-generated method stub
		return score;
	}
	
	public void score() {
		score++;
	}

}
