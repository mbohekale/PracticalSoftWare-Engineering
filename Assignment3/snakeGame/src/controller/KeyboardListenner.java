package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardListenner implements KeyListener{
	public void keyPressed(KeyEvent event) {
	    switch (event.getKeyCode()) {
	      case 39:
	        if (ControlleurThreads.directionSnake != 2)
	          ControlleurThreads.directionSnake = 1; 
	        break;
	      case 38:
	        if (ControlleurThreads.directionSnake != 4) {
	          ControlleurThreads.directionSnake = 3;
	        }
	        break;
	      case 37:
	        if (ControlleurThreads.directionSnake != 1) {
	          ControlleurThreads.directionSnake = 2;
	        }
	        break;
	      case 40:
	        if (ControlleurThreads.directionSnake != 3)
	          ControlleurThreads.directionSnake = 4; 
	        break;
	    } 
	  }
	  
	  public void keyReleased(KeyEvent event) {}
	  
	  public void keyTyped(KeyEvent event) {}

}
