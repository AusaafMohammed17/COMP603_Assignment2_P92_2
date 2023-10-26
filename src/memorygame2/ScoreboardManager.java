/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package memorygame2;

/**
 *
 * @author ausup
 */

import java.util.List;

public class ScoreboardManager {
    private ScoreboardDataAccess dataAccess;

    public ScoreboardManager() {
        // Initialize the data access component
        dataAccess = new ScoreboardDataAccess();
    }

    public List<PlayerScore> getScoreboard() {
        // Retrieve the scoreboard from dataAccess
        return dataAccess.getAllScores();
    }

    public void addScore(PlayerScore playerScore) {
        // Add a new score to the scoreboard using dataAccess
        dataAccess.addScore(playerScore);
    }
}

