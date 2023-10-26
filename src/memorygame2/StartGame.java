/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package memorygame2;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author ausaaf mohammed
 */

public class StartGame {

    private JFrame frame;
    private JPanel panel;
    private JLabel questionLabel;
    private JTextField answerField;
    private JButton submitButton;
    private String playerName;

    private Random random;
    private int currentQuestionIndex;
    private ArrayList<String> digits;
    private javax.swing.Timer timer;
    private int score; // Added to keep track of the score
    private boolean scoreDisplayed; // Flag to check if the score has been displayed

    public StartGame(String playerName) {
        this.playerName = playerName;
        random = new Random();
        currentQuestionIndex = 0;
        digits = new ArrayList<>();
        score = 0; // Initialize score to 0
        scoreDisplayed = false; // Initialize the flag to false

        frame = new JFrame("Memory Quiz");
        panel = new JPanel();
        questionLabel = new JLabel();
        answerField = new JTextField();
        submitButton = new JButton("Submit");

        // Set the size of the text fields, answer dialog box, and submit button.
        answerField.setPreferredSize(new Dimension(200, 50));
        submitButton.setPreferredSize(new Dimension(100, 50));
        questionLabel.setPreferredSize(new Dimension(100, 20));

        // Set the font of the questionLabel and answerField components.
        questionLabel.setFont(new Font("Arial", Font.PLAIN, 24));
        answerField.setFont(new Font("Arial", Font.PLAIN, 24));

        // Set the layout manager of the panel to the FlowLayout object.
        panel.setLayout(new FlowLayout());

        // Add the components to the panel in the desired order.
        panel.add(questionLabel);
        panel.add(answerField);
        panel.add(submitButton);

        // Add the panel to the frame.
        frame.add(panel, BorderLayout.CENTER);
        
        answerField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                submitButton.doClick(); // Simulate a click on the submit button
            }
        });
        
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                // Handle the window-closing event
                showScore();
                frame.dispose(); // Close the game window
            }
        });
        
       // Create a timer.
       // Create a timer with a 3-second delay (3000 milliseconds)
        timer = new javax.swing.Timer(3000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                questionLabel.setVisible(false);
                answerField.setText("");
                currentQuestionIndex++;
                showNextQuestion();
            }
        });

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String answer = answerField.getText();
                boolean isCorrect = answer.equals(getCorrectAnswer());

                if (isCorrect) {
                    questionLabel.setText("Correct!");
                    score++; // Increment the score for correct answers
                } else {
                    questionLabel.setText("Wrong!");
                }

                // Start the timer.
                timer.start();

                if (currentQuestionIndex >= digits.size()) {
                    // Display the score when all questions have been answered
                    showScore();
                    frame.setVisible(false);
                }
            }
        });

        frame.setSize(1000, 800);
        frame.setVisible(true);
        generateDigits(); // Generate the sequence of digits
        showNextQuestion(); // Display the first question
    }

    private void generateDigits() {
        // Generate a random sequence of 5 digits.
        for (int i = 0; i < 10; i++) {
            digits.add(String.valueOf(random.nextInt(10)));
        }
    }

    private void showNextQuestion() {
        if (currentQuestionIndex < digits.size()) {
            questionLabel.setText(digits.get(currentQuestionIndex));
            questionLabel.setVisible(true);

            // Start the timer here
            timer.start();
        } else {
            // Display the score when all questions have been answered
            showScore();
            frame.setVisible(false);
        }
    }


    private String getCorrectAnswer() {
        if (currentQuestionIndex >= digits.size()) {
            return null;
        }

        return digits.get(currentQuestionIndex);
    }


    private void showScore() {
        PlayerScore playerScore = new PlayerScore(this.playerName, score);
        ScoreboardDataAccess dataAccess = new ScoreboardDataAccess();
        dataAccess.addScore(playerScore);

        if (!scoreDisplayed) {
            new ScoreDisplay(this.playerName, score).setVisible(true);
            scoreDisplayed = true;
            frame.dispose(); // Close the StartGame window
        }
    }



}
