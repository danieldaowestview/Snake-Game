import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Board extends JPanel implements KeyListener, ActionListener {
    private int height = 800;
    private int width = 800;
    private Snake snake;
    private Food food;
    private LinkedList<Snake> parts;

    public void paint(Graphics g) {
        super.paintComponent(g);
        // food.paint(g) gotta paint the apple
        if (snake == null) {
            snake = new Snake(400, 400);
        }
        if (food == null) {
            food = new Food(500, 500);
        }
        if (parts == null || parts.isEmpty()) {
            parts = new LinkedList<>();
            parts.add(snake);
        }

        Font font = new Font("Monospaced", Font.BOLD, 50);
        g.setFont(font);
        g.drawString("Score:" + snake.getScore(), 200, 100);

        snake.paint(g);
        food.paint(g);

        if (collisionWithBoard()) {
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

        if (foodbox.intersects(snakebox)) {
            food.newCoord();
            snake.score();

            Snake lastPart = parts.getLast();
            Snake newPart = null;

            if (snake.getMove() == 1) { // moving up
                newPart = new Snake(lastPart.getX(), lastPart.getY() + snake.getWidth());
            } else if (snake.getMove() == 2) { // moving down
                newPart = new Snake(lastPart.getX(), lastPart.getY() - snake.getHeight());
            } else if (snake.getMove() == 3) { // moving left
                newPart = new Snake(lastPart.getX() + snake.getWidth(), lastPart.getY());
            } else if (snake.getMove() == 4) { // moving right
                newPart = new Snake(lastPart.getX() - snake.getWidth(), lastPart.getY());
            }

            parts.add(newPart);
        }

        for (int i = parts.size() - 1; i >= 1; i--) { // update snake positions from tail to head
            Snake currentPart = parts.get(i);
            Snake previousPart = parts.get(i - 1);
            currentPart.setX(previousPart.getX());
            currentPart.setY(previousPart.getY());
   //         currentPart.move();
        }

        for (Snake s : parts) { // paint each part of snake
            s.paint(g);
            g.fillRect(s.getX(), s.getY(), s.getWidth(), s.getHeight());
        }
    }

    public boolean collisionWithBoard() {
        if (snake.getMove() == 4) { // moving right
            if (snake.getX() + 50 > width) {
                return true;
            }
        } else if (snake.getX() > width || snake.getX() < 0) {
            return true;
        }
        if (snake.getMove() == 2) { // moving down
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
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // Not used in this implementation
    }

    @Override
    public void keyPressed(KeyEvent key) {
        switch (key.getKeyCode()) {
            case KeyEvent.VK_W: // up
                snake.setVx(0);
                snake.setVy(-7);
                snake.setMove(1);
                break;

            case KeyEvent.VK_S: // down
                snake.setVx(0);
                snake.setVy(7);
                snake.setMove(2);
                break;

            case KeyEvent.VK_A: // left
                snake.setVx(-7);
                snake.setVy(0);
                snake.setMove(3);
                break;

            case KeyEvent.VK_D: // right
                snake.setVx(7);
                snake.setVy(0);
                snake.setMove(4);
                break;

            case KeyEvent.VK_O: // reset the game
                snake.setAlive(true);
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // Not used in this implementation
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

