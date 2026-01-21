package client;

import javax.swing.*;
import java.awt.*;

/**
 * GameClientUI - GUI Client for Rock Paper Scissors Game
 * Day 5: Basic Swing GUI implementation
 */
public class GameClientUI extends JFrame {
    // UI Components
    private JTextField nameField;
    private JButton joinBtn;
    private JLabel statusLabel;
    private JButton rockBtn, paperBtn, scissorsBtn;
    private JLabel resultLabel;
    private JLabel scoreLabel;

    // Game state
    private int wins = 0;
    private int losses = 0;
    private int draws = 0;

    public GameClientUI() {
        initializeUI();
    }

    /**
     * Initialize all UI components
     */
    private void initializeUI() {
        // Window settings
        setTitle("Rock Paper Scissors Game");
        setSize(450, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null); // Center window

        // Main panel with BorderLayout
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Title
        JLabel titleLabel = new JLabel("🎮 ROCK PAPER SCISSORS 🎮");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(titleLabel);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));

        // Connection panel
        JPanel connectionPanel = createConnectionPanel();
        mainPanel.add(connectionPanel);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 15)));

        // Status label
        statusLabel = new JLabel("Enter your name and click Join");
        statusLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        statusLabel.setForeground(new Color(70, 130, 180));
        statusLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(statusLabel);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));

        // Game buttons panel
        JPanel gamePanel = createGameButtonsPanel();
        mainPanel.add(gamePanel);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 15)));

        // Result label
        resultLabel = new JLabel("Result: - ");
        resultLabel.setFont(new Font("Arial", Font.BOLD, 16));
        resultLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(resultLabel);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 10)));

        // Score label
        scoreLabel = new JLabel(getScoreText());
        scoreLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        scoreLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(scoreLabel);

        // Add main panel to frame
        add(mainPanel);
    }

    /**
     * Create the connection panel (name field + join button)
     */
    private JPanel createConnectionPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER));

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setFont(new Font("Arial", Font.PLAIN, 14));

        nameField = new JTextField(15);
        nameField.setFont(new Font("Arial", Font.PLAIN, 14));

        joinBtn = new JButton("Join Game");
        joinBtn.setFont(new Font("Arial", Font.BOLD, 14));
        joinBtn.setBackground(new Color(76, 175, 80));
        joinBtn.setForeground(Color.WHITE);
        joinBtn.setFocusPainted(false);

        // Add action listener (will be implemented in Day 6)
        joinBtn.addActionListener(e -> handleJoinButton());

        // Allow pressing Enter in name field to join
        nameField.addActionListener(e -> handleJoinButton());

        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(joinBtn);

        return panel;
    }

    /**
     * Create the game buttons panel (Rock, Paper, Scissors)
     */
    private JPanel createGameButtonsPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 0));

        // Rock button
        rockBtn = new JButton("🪨 ROCK");
        rockBtn.setFont(new Font("Arial", Font.BOLD, 14));
        rockBtn.setPreferredSize(new Dimension(120, 50));
        rockBtn.setEnabled(false); // Disabled until joined
        rockBtn.addActionListener(e -> handleChoice("ROCK"));

        // Paper button
        paperBtn = new JButton("📄 PAPER");
        paperBtn.setFont(new Font("Arial", Font.BOLD, 14));
        paperBtn.setPreferredSize(new Dimension(120, 50));
        paperBtn.setEnabled(false);
        paperBtn.addActionListener(e -> handleChoice("PAPER"));

        // Scissors button
        scissorsBtn = new JButton("✂️ SCISSORS");
        scissorsBtn.setFont(new Font("Arial", Font.BOLD, 14));
        scissorsBtn.setPreferredSize(new Dimension(140, 50));
        scissorsBtn.setEnabled(false);
        scissorsBtn.addActionListener(e -> handleChoice("SCISSORS"));

        panel.add(rockBtn);
        panel.add(paperBtn);
        panel.add(scissorsBtn);

        return panel;
    }

    /**
     * Handle Join button click (placeholder for Day 6)
     */
    private void handleJoinButton() {
        String name = nameField.getText().trim();

        if (name.isEmpty()) {
            JOptionPane.showMessageDialog(
                this,
                "Please enter your name!",
                "Error",
                JOptionPane.ERROR_MESSAGE
            );
            return;
        }

        // For Day 5 testing: just show that button works
        statusLabel.setText("Connecting to server...");
        joinBtn.setEnabled(false);
        nameField.setEnabled(false);

        // Simulate connection (will implement real connection in Day 6)
        System.out.println("Join button clicked! Name: " + name);

        // For testing, enable game buttons after a short delay
        Timer timer = new Timer(1000, e -> {
            statusLabel.setText("Connected! (Demo mode - Day 5)");
            enableGameButtons();
        });
        timer.setRepeats(false);
        timer.start();
    }

    /**
     * Handle game choice button click (placeholder for Day 6)
     */
    private void handleChoice(String choice) {
        System.out.println("Choice made: " + choice);

        // For Day 5 testing: just show feedback
        statusLabel.setText("You chose " + choice + " (Demo mode)");
        disableGameButtons();

        // Simulate result after delay
        Timer timer = new Timer(1500, e -> {
            resultLabel.setText("Result: Demo Mode - Day 5");
            statusLabel.setText("Ready for next round");
            enableGameButtons();
        });
        timer.setRepeats(false);
        timer.start();
    }

    /**
     * Enable game buttons
     */
    private void enableGameButtons() {
        rockBtn.setEnabled(true);
        paperBtn.setEnabled(true);
        scissorsBtn.setEnabled(true);
    }

    /**
     * Disable game buttons
     */
    private void disableGameButtons() {
        rockBtn.setEnabled(false);
        paperBtn.setEnabled(false);
        scissorsBtn.setEnabled(false);
    }

    /**
     * Update the status label
     */
    public void updateStatus(String status) {
        SwingUtilities.invokeLater(() -> statusLabel.setText(status));
    }

    /**
     * Update the result label
     */
    public void updateResult(String result) {
        SwingUtilities.invokeLater(() -> resultLabel.setText("Result: " + result));
    }

    /**
     * Update score after a game
     */
    public void updateScore(String result) {
        if (result.contains("WIN") || result.contains("You win")) {
            wins++;
        } else if (result.contains("LOSE") || result.contains("You lose")) {
            losses++;
        } else if (result.contains("DRAW") || result.contains("Draw")) {
            draws++;
        }

        SwingUtilities.invokeLater(() -> scoreLabel.setText(getScoreText()));
    }

    /**
     * Get formatted score text
     */
    private String getScoreText() {
        return String.format("Score - Wins: %d | Losses: %d | Draws: %d", wins, losses, draws);
    }

    /**
     * Main method to launch the GUI
     */
    public static void main(String[] args) {
        // Launch GUI on Event Dispatch Thread
        SwingUtilities.invokeLater(() -> {
            GameClientUI gui = new GameClientUI();
            gui.setVisible(true);
            System.out.println("=== Rock Paper Scissors GUI Client ===");
            System.out.println("Day 5: GUI components initialized");
            System.out.println("Window displayed successfully!");
        });
    }
}
