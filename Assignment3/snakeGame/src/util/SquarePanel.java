package util;

import java.awt.Color;

import javax.swing.JPanel;
/**
 * 
 * @author Ekale
 * Drawing the panel
 *
 */
public class SquarePanel 
	  extends JPanel
	  {
	    private static final long serialVersionUID = 1785548725355874876L;
	   
	    
	    public SquarePanel(Color d) { setBackground(d); }


	    
	    public void ChangeColor(Color d) {
	      setBackground(d);
	      repaint();	      
	    }
	   

}
