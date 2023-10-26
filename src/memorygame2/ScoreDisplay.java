/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package memorygame2;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author ausaaf mohammed
 */

public class ScoreDisplay extends JFrame {
    
    public ScoreDisplay(String playerName, int score) {
        super("Score Display");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Create labels to display the player's name and score
        JLabel nameLabel = new JLabel("Player: " + playerName);
        nameLabel.setFont(new Font("Arial", Font.PLAIN, 24));
        
        JLabel scoreLabel = new JLabel("Your score: " + score);
        scoreLabel.setFont(new Font("Arial", Font.PLAIN, 24));

        // Set labels to be centered
        nameLabel.setHorizontalAlignment(JLabel.CENTER);
        scoreLabel.setHorizontalAlignment(JLabel.CENTER);

        // Create a panel to hold the labels
        JPanel panel = new JPanel(new GridLayout(2, 1));
        panel.add(nameLabel);
        panel.add(scoreLabel);

        // Add the panel to the frame
        add(panel);

        // Set the frame size and make it visible
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }
    
}
