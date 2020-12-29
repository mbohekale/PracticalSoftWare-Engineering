package util;

import java.awt.Color;

import java.util.ArrayList;
/**
 * 
 * @author Ekale
 * Here we give the colors of the players
 *
 */

public class DataOfSquare {

	  ArrayList<Color> C = new ArrayList<>();
	  
	  int color;
	  public SquarePanel square;
	  
	  public DataOfSquare(int col) {
	    this.C.add(Color.darkGray);
	    this.C.add(Color.BLUE);
	    this.C.add(Color.white);
	    
	    this.color = col;
	    this.square = new SquarePanel(this.C.get(this.color));
	  }
	  
	  public void lightMeUp(int c) { this.square.ChangeColor(this.C.get(c)); }

}
