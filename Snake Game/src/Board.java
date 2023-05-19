import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.Timer;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Board extends JPanel implements KeyListener, ActionListener {
	private int height;
	private int width;

	Snake snake = new Snake(400, 400);

	public void paint(Graphics g) {
		super.paintComponent(g);
		// food.paint(g) gotta paint the apple

		snake.paint(g);

		//

	}

	public static void main(String[] arg) {
		new Board();
		new Snake(400, 400);
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
			break; // prevents bleeding into other cases

		case 83: // down
			System.out.println(83);
			snake.setVx(0);
			snake.setVy(7);
			break;

		case 65: // left
			// logic if this case is met
			System.out.println(65);
			snake.setVx(-7);
			snake.setVy(0);
			break; // prevents bleeding into other cases

		case 68: // right
			System.out.println(68);
			snake.setVx(7);
			snake.setVy(0);
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
		f.setSize(800, 600);
		f.add(this);
		f.addKeyListener(this);
		t = new Timer(16, this);
		t.start();
		f.setVisible(true);
	}

}
