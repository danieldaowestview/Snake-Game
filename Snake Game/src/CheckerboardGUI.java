import javax.swing.*;
import java.awt.*;

public class CheckerboardGUI extends JFrame {
    private static final int BOARD_SIZE = 8;  // Number of squares per row and column
    private static final int SQUARE_SIZE = 60;  // Size of each square in pixels

    public CheckerboardGUI() {
        setTitle("Checkerboard");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create the main panel with a GridLayout
        JPanel mainPanel = new JPanel(new GridLayout(BOARD_SIZE, BOARD_SIZE));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        add(mainPanel);

        // Create the individual squares and add them to the main panel
        for (int row = 0; row < BOARD_SIZE; row++) {
            for (int col = 0; col < BOARD_SIZE; col++) {
                JPanel square = new JPanel();
                square.setPreferredSize(new Dimension(SQUARE_SIZE, SQUARE_SIZE));

                // Set the background color of the square based on the row and column
                if ((row + col) % 2 == 0) {
                    square.setBackground(Color.WHITE);
                } else {
                    square.setBackground(Color.BLACK);
                }

                mainPanel.add(square);
            }
        }

        // Pack and display the frame
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new CheckerboardGUI();
        });
    }
}