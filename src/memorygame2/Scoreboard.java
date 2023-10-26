/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package memorygame2;

/**
 *
 * @author ausup
 */

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.*;
import java.util.List;

public class Scoreboard extends JFrame {

    public Scoreboard(List<PlayerScore> scores) {
        super("Scoreboard");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        setLayout(new BorderLayout());

        // Create a panel to display scores
        JPanel scoreboardPanel = new JPanel(new GridLayout(scores.size() + 1, 2));

        // Add column headers
        scoreboardPanel.add(new JLabel("Player Name"));
        scoreboardPanel.add(new JLabel("Score"));

        // Add player scores
        for (PlayerScore score : scores) {
            scoreboardPanel.add(new JLabel(score.getPlayerName()));
            scoreboardPanel.add(new JLabel(Integer.toString(score.getScore())));
        }

        add(new JScrollPane(scoreboardPanel), BorderLayout.CENTER);

        // Set the window size and make it visible
        setSize(400, 300);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
