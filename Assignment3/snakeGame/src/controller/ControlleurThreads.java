package controller;

import java.util.ArrayList;
import java.util.HashMap;

import controller.GameLevel;
import util.ThreadSquare;
import util.Tuple;
import view.WindowGUI;
/**
 * 
 * @author Ekale
 * in this class create the attributes of the game
 *
 */
public class ControlleurThreads 
	  extends Thread
	{

	  ArrayList<ArrayList<ThreadSquare>> Squares = new ArrayList<>();
	  Tuple headSnakePos;
	  int sizeSnake = 3;
	  long speed = 100L;
	  
	  private final HashMap<String, HashMap<Integer, GameLevel>> gameLevels;
	  private GameLevel gameLevel = null;
	  
	  public static int directionSnake;
	  ArrayList<Tuple> positions = new ArrayList<>();
	  
	  Tuple foodPosition;

	  
	  public ControlleurThreads(Tuple positionDepart) {
		this.gameLevels = new HashMap<>();
	    this.Squares = WindowGUI.Threads;
	    
	    this.headSnakePos = new Tuple(positionDepart.x, positionDepart.y);
	    directionSnake = 1;

	    
	    Tuple headPos = new Tuple(this.headSnakePos.getX(), this.headSnakePos.getY());
	    this.positions.add(headPos);
	    
	    this.foodPosition = new Tuple(WindowGUI.height - 1, WindowGUI.width - 1);
	    spawnFood(this.foodPosition);
	  }
	  
	  public void printGameLevel(){ gameLevel.printLevel(); }


	  
	  public void run() {
	    while (true) {
	      moveInterne(directionSnake);
	      checkCollision();
	      moveExterne();
	      deleteTail();
	      pauser();
	    } 
	  }

	  
	  private void pauser() {
	    try {
	      sleep(this.speed);
	    } catch (InterruptedException e) {
	      e.printStackTrace();
	    } 
	  }

	  
	  private void checkCollision() {
	    Tuple posCritique = this.positions.get(this.positions.size() - 1);
	    for (int i = 0; i <= this.positions.size() - 2; i++) {
	      boolean biteItself = (posCritique.getX() == ((Tuple)this.positions.get(i)).getX() && posCritique.getY() == ((Tuple)this.positions.get(i)).getY());
	      if (biteItself) {
	        stopTheGame();
	      }
	    } 
	    
	    boolean eatingFood = (posCritique.getX() == this.foodPosition.y && posCritique.getY() == this.foodPosition.x);
	    if (eatingFood) {
	    	/**
	    	 * if the food is consume
	    	 * the size of the snake increases by one
	    	 */
	     // System.out.println("Yummy!");
	      this.sizeSnake++;
	      this.foodPosition = getValAleaNotInSnake();
	      
	      spawnFood(this.foodPosition);
	    } 
	  }

	  
	  private void stopTheGame() {
	    System.out.println("COLISION! \n");
	    while (true) {
	      pauser();
	    }
	  }


	  
	  private void spawnFood(Tuple foodPositionIn) { ((ThreadSquare)((ArrayList)this.Squares.get(foodPositionIn.x)).get(foodPositionIn.y)).square.lightMeUp(1); }



	  
	  private Tuple getValAleaNotInSnake() {
	    int ranX = 0 + (int)(Math.random() * 19.0D);
	    int ranY = 0 + (int)(Math.random() * 19.0D);
	    Tuple p = new Tuple(ranX, ranY);
	    for (int i = 0; i <= this.positions.size() - 1; i++) {
	      if (p.getY() == ((Tuple)this.positions.get(i)).getX() && p.getX() == ((Tuple)this.positions.get(i)).getY()) {
	        ranX = 0 + (int)(Math.random() * 19.0D);
	        ranY = 0 + (int)(Math.random() * 19.0D);
	        p = new Tuple(ranX, ranY);
	        i = 0;
	      } 
	    } 
	    return p;
	  }


	  
	  private void moveInterne(int dir) {
	    switch (dir) {
	      case 4:
	        this.headSnakePos.ChangeData(this.headSnakePos.x, (this.headSnakePos.y + 1) % 20);
	        this.positions.add(new Tuple(this.headSnakePos.x, this.headSnakePos.y));
	        break;
	      case 3:
	        if (this.headSnakePos.y - 1 < 0) {
	          this.headSnakePos.ChangeData(this.headSnakePos.x, 19);
	        } else {
	          
	          this.headSnakePos.ChangeData(this.headSnakePos.x, Math.abs(this.headSnakePos.y - 1) % 20);
	        } 
	        this.positions.add(new Tuple(this.headSnakePos.x, this.headSnakePos.y));
	        break;
	      case 2:
	        if (this.headSnakePos.x - 1 < 0) {
	          this.headSnakePos.ChangeData(19, this.headSnakePos.y);
	        } else {
	          
	          this.headSnakePos.ChangeData(Math.abs(this.headSnakePos.x - 1) % 20, this.headSnakePos.y);
	        } 
	        this.positions.add(new Tuple(this.headSnakePos.x, this.headSnakePos.y));
	        break;
	      
	      case 1:
	        this.headSnakePos.ChangeData(Math.abs(this.headSnakePos.x + 1) % 20, this.headSnakePos.y);
	        this.positions.add(new Tuple(this.headSnakePos.x, this.headSnakePos.y));
	        break;
	    } 
	  }

	  
	  private void moveExterne() {
	    for (Tuple t : this.positions) {
	      int y = t.getX();
	      int x = t.getY();
	      ((ThreadSquare)((ArrayList<ThreadSquare>)this.Squares.get(x)).get(y)).pauseThread();
	      ((ThreadSquare)((ArrayList)this.Squares.get(x)).get(y)).square.lightMeUp(0);
	    } 
	  }



	  
	  private void deleteTail() {
	    int cmpt = this.sizeSnake;
	    for (int i = this.positions.size() - 1; i >= 0; i--) {
	      if (cmpt == 0) {
	        Tuple t = this.positions.get(i);
	        ((ThreadSquare)((ArrayList)this.Squares.get(t.y)).get(t.x)).square.lightMeUp(2);
	        ((ThreadSquare)((ArrayList<ThreadSquare>)this.Squares.get(t.y)).get(t.x)).pauseThread();
	      } else {
	        
	        cmpt--;
	      } 
	    } 
	    cmpt = this.sizeSnake;
	    for (int i = this.positions.size() - 1; i >= 0; i--) {
	      if (cmpt == 0) {
	        this.positions.remove(i);
	      } else {
	        
	        cmpt--;
	      } 
	    } 
	  }
}
