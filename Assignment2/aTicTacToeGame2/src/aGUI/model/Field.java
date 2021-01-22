package aGUI.model;

import java.awt.Color;

public class Field {
	Color color=null;
	int number;
	
	public Color getColor() {return color;}
	
	public void setColor(Color paramColor) { this.color = paramColor; }
	
	//public int getNumber() {return number;}
	
	//public void setNumber(int paramInt) { this.number = paramInt; }
	
	public int increase() {  if(number==5)return number;
	return number++;
			}
	//public void decrease() {number--;}
}
