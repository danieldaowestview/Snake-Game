import java.awt.Color;
import java.awt.Graphics;

public class Wall {
	private int x, y;
	private int width, height;
	private Color c; 
	
	
	
	public Wall(int d, int e) {
		this.x = d;
		this.y = e;
		
		this.width = 50; 
		this.height = 50;
		c = Color.BLUE;
		
	}
	public void setColor(Color c) {
		this.c = c;
	}
	
	public void paint(Graphics g) {
		g.setColor(c);
		g.fillRect(x, y, width, height);
	}
	public int getX() {
		// TODO Auto-generated method stub
		return this.x;
	}
	public int getWidth() {
		// TODO Auto-generated method stub
		return this.width;
	}
	public int getY() {
		// TODO Auto-generated method stub
		return this.y;
	}
}
