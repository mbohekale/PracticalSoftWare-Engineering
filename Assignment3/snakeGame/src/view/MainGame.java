package view;


import java.io.IOException;
import javax.swing.WindowConstants;
/**
 * 
 * @author Ekale
 * Main entries of the game
 *
 */



public class MainGame {

	public static void main(String[] args) throws IOException{
		/**
		 * instantiate the main Class 
		 * and also creating the window
		 */
		     WindowGUI gui = new WindowGUI();
		     gui.setTitle("Snake");
		     gui.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		     gui.setSize(300,300);
		     gui.setResizable(false);
		     gui.setLocationRelativeTo(null);
		     gui.setVisible(true);
	}

}
