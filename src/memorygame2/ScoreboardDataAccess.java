/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package memorygame2;

/**
 *
 * @author ausup
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ScoreboardDataAccess {
    private final String dbURL = "jdbc:derby://localhost:1527/Scoreboard";

    public ScoreboardDataAccess() {
        try {
            Connection connection = DriverManager.getConnection(dbURL);
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<PlayerScore> getAllScores() {
        List<PlayerScore> scores = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection(dbURL);
            if (connection != null) {
                // Create the table if it doesn't exist
                createTableIfNotExists(connection);

                PreparedStatement statement = connection.prepareStatement("SELECT * FROM scores");
                ResultSet resultSet = statement.executeQuery();

                while (resultSet.next()) {
                    String playerName = resultSet.getString("playerName");
                    int score = resultSet.getInt("score");
                    scores.add(new PlayerScore(playerName, score));
                }

                resultSet.close();
                statement.close();
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return scores;
    }

    public void addScore(PlayerScore playerScore) {
        try {
            Connection connection = DriverManager.getConnection(dbURL);
            if (connection != null) {
                // Create the table if it doesn't exist
                createTableIfNotExists(connection);

                // Prepare an SQL statement to insert the player score
                String insertSQL = "INSERT INTO scores (playerName, score) VALUES (?, ?)";
                PreparedStatement statement = connection.prepareStatement(insertSQL);
                statement.setString(1, playerScore.getPlayerName());
                statement.setInt(2, playerScore.getScore());

                // Execute the SQL statement to insert the score
                statement.executeUpdate();

                statement.close();
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void createTableIfNotExists(Connection connection) throws SQLException {
        String createTableSQL = "CREATE TABLE IF NOT EXISTS scores (" +
            "playerName VARCHAR(255) PRIMARY KEY," +
            "score INT)";
        connection.createStatement().execute(createTableSQL);
    } 
    
    
    
    /** public static void main(String[] args) {
        // Define the database connection URL and credentials
        String dbURL = "jdbc:derby://localhost:1527/Scoreboard;user=THR2951;password=Assignment2";

        try {
            // Attempt to establish a connection
            Connection connection = DriverManager.getConnection(dbURL);
            System.out.println("Connected to the database successfully.");

            // Close the connection
            connection.close();
        } catch (SQLException e) {
            System.err.println("Failed to connect to the database: " + e.getMessage());
        }
    } **/
}
