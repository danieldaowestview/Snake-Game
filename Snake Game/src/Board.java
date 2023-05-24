import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.Timer;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Board extends JPanel implements KeyListener, ActionListener {
	private int height = 800;
	private int width = 800;
	Snake snake = new Snake(400, 400);
	Food food = new Food(500, 500);
	Wall wall = new Wall((int)(Math.random()*300),(int)(Math.random()*300));
	Wall wall1 = new Wall((int)(Math.random()*300)+300,(int)(Math.random()*300));
	Wall wall2 = new Wall((int)(Math.random()*300)+300,(int)(Math.random()*300));
	Wall wall3 = new Wall((int)(Math.random()*300) ,(int)(Math.random()*300) +300);
	ArrayList<Snake> parts = new ArrayList<Snake>();

	public void paint(Graphics g) {
		super.paintComponent(g);
		// food.paint(g) gotta paint the apple
		if(parts.isEmpty()) {
			parts.add(snake);
		}
		Font font = new Font("Monospaced", Font.BOLD, 50);
		g.setFont(font);
		g.drawString("Score:" + snake.getScore(), 200, 100);
		snake.paint(g);
		food.paint(g);
		wall.paint(g);
		wall1.paint(g);
		wall2.paint(g);
		wall3.paint(g);

		if (collisionWithBoard() == true) {
			snake.setX(300);
			snake.setY(300);
			snake.setAlive(false);
			snake.setVx(0);
			snake.setVy(0);

		}
		if (!snake.isAlive()) {
			snake.setVx(0);
			snake.setVy(0);
			snake.setScore(0);
			g.drawString("YOU DIED", 0, 400);
			g.drawString("Press O to Play AGAIN", 0, 600);
		}
		Rectangle snakebox = new Rectangle(snake.getX(), snake.getY(), snake.getWidth(), snake.getWidth());
		Rectangle foodbox = new Rectangle(food.getX(), food.getY(), food.getWidth(), food.getWidth());
		Rectangle wallbox = new Rectangle(wall.getX(), wall.getY (), wall.getWidth(), wall.getWidth());
		Rectangle wallbox1 = new Rectangle(wall1.getX(), wall1.getY (), wall1.getWidth(), wall1.getWidth());
		Rectangle wallbox2 = new Rectangle(wall2.getX(), wall2.getY (), wall2.getWidth(), wall2.getWidth());
		Rectangle wallbox3 = new Rectangle(wall3.getX(), wall3.getY (), wall3.getWidth(), wall3.getWidth());
		if(snakebox.intersects(wallbox) || snakebox.intersects(wallbox1)|| snakebox.intersects(wallbox2)|| snakebox.intersects(wallbox3) ) {
			snake.setVx(0);
			snake.setVy(0);
			g.drawString("YOU DIED", 0, 400);
			g.drawString("Press O to Play AGAIN", 0, 600);
		}
		
		if (foodbox.intersects(snakebox)) {
			food.newCoord();
			snake.score();
			System.out.println("Food X:" + this.getX());
			System.out.println("Food Y:" + this.getY());
			if(snake.getMove() == 1) { // adds part based on direction of head of snake
				Snake k = new Snake(parts.get(parts.size() - 1).getX(), parts.get(parts.size() - 1).getY() + snake.getHeight());
				parts.add(k);
			}
			if(snake.getMove() == 2) {
				Snake k = new Snake(parts.get(parts.size() - 1).getX(), parts.get(parts.size() - 1).getY() - snake.getHeight());
				parts.add(k);
			}
			if(snake.getMove() == 3) {
				Snake k = new Snake(parts.get(parts.size() - 1).getX() + snake.getWidth(), parts.get(parts.size() - 1).getY());
				parts.add(k);
			}
			if(snake.getMove() == 4) {
				Snake k = new Snake(parts.get(parts.size() - 1).getX() - snake.getWidth(), parts.get(parts.size() - 1).getY());
				parts.add(k);
			}
			
			

		}
		for (int i = 1; i < parts.size(); i++) { // paints each part of snake
			Snake s = parts.get(i);
			s.paint(g);
			g.fillRect(s.getX(), s.getY(), s.getWidth(), s.getHeight());
			s.setVx(parts.get(i - 1).getVx());
			s.setVy(parts.get(i - 1).getVy());
		}

	}

	public boolean collisionWithBoard() {
		if (snake.getMove() == 4) { // if moving right
			if (snake.getX() + 50 > width) {
				return true;
			}
		} else if (snake.getX() > width || snake.getX() < 0) {
			return true;
		}
		if (snake.getMove() == 2) { // if moving down
			if (snake.getY() + 50 > height) {
				return true;
			}
		} else if (snake.getY() + 50 > height || snake.getY() < 0) {
			return true;
		}
		return false;
	}

	public static void main(String[] arg) {
		new Board();
		new Snake(400, 400);
		// if()
		// CheckerboardGUI check = new CheckerboardGUI();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		repaint();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		// bing bong bing bong

	}

	@Override
	public void keyPressed(KeyEvent key) {
		// Information about the key that is pressed
		// lives in the KeyEvent object called arg0
		System.out.println(key.getKeyCode());
		// 87 IS THE w key

		// Switch statements
		switch (key.getKeyCode()) {

		case 87: // up
			// logic if this case is met
			System.out.println(87);
			snake.setVx(0);
			snake.setVy(-7);
			snake.setMove(1);
			break; // prevents bleeding into other cases

		case 83: // down
			System.out.println(83);
			snake.setVx(0);
			snake.setVy(7);
			snake.setMove(2);
			break;

		case 65: // left
			// logic if this case is met
			System.out.println(65);
			snake.setVx(-7);
			snake.setVy(0);
			snake.setMove(3);
			break; // prevents bleeding into other cases

		case 68: // right
			System.out.println(68);
			snake.setVx(7);
			snake.setVy(0);
			snake.setMove(4);
			break;

		case 79: // reset the game
			System.out.println(79);
			snake.setAlive(true);
			break;
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	Timer t;

	public Board() {
		JFrame f = new JFrame("Snake");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(width, height);
		f.add(this);
		f.addKeyListener(this);
		t = new Timer(16, this);
		t.start();
		f.setVisible(true);
	}

}
