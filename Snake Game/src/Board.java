import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Board extends JPanel implements KeyListener, ActionListener {
	private int height;
	private int width;
	
	
	public void paint(Graphics g) {
		super.paintComponent(g);
		//food.paint(g) gotta paint the apple
		
		
		
		
		
		
		
	}
	public static void man(String[] arg) {
		Frame d = new Frame();
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public Board() {
		JFrame f = new JFrame("Snake");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(800, 600);
	}
	
	
}
