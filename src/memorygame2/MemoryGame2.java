/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package memorygame2;

import javax.swing.SwingUtilities;

/**
 *
 * @author ausaaf mohammed
 */

public class MemoryGame2 {

    public static void main(String[] args) {
        
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                // Create the game menu
                GameMenu menu = new GameMenu();
                menu.setVisible(true);
                
                // Initialize instructions
                GameInstructions instructions = new GameInstructions();
                instructions.setVisible(false);
            }
        });
    }
}
