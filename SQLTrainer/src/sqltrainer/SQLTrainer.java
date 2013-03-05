/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sqltrainer;

import sqltrainer.welcome.WelcomeScreen;

/**
 *
 * @author karlinsv
 */
public class SQLTrainer {
    
    WelcomeScreen welcomeScreen = null;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new SQLTrainer();
    }
    
    public SQLTrainer() {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                welcomeScreen = new WelcomeScreen();
                welcomeScreen.setVisible(true);
            }
        });
    }
}
