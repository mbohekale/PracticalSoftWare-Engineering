package gamefour;

import javax.swing.SwingUtilities;

/**
 * The main entries of the game
 *
 * @author ekale
 */
public class Colorclicker {    
    public static void main(String[] args) {
    	SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new ColorClickerGUI();
				
			}});
       
    }
    
}
