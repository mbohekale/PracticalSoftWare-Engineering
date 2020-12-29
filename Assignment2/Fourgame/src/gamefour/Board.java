package gamefour;

import java.awt.Color;
/**
 * 
 * @author Student Mboh ekale
 *
 */


public class Board
{
  private Field[][] board;
  private final int boardSize;
  private Player actualPlayer;
  private int scorePlayer1;
  private int scorePlayer2;
  private int count;
  public boolean hasWinner=false;
  static String currentPlayer;
    
  public Board(int boardSize) {
	   hasWinner=false;
	   currentPlayer="X";
	this.boardSize = boardSize;
    this.board = new Field[this.boardSize][this.boardSize];
    for (int i = 0; i < this.boardSize; i++) {
      for (int j = 0; j < this.boardSize; j++) {
        this.board[i][j] = new Field();
      }
    } 
  }
  public boolean hasWinner() {
	return hasWinner=true;	  
  }
  public String getCurrentPlayer() {
	return currentPlayer="X";
			  
	  }
  
  public Field getValue(int a, int b) { return this.board[a][b]; }


  
  public int getBoardSize() { return this.boardSize; }


  
  public int getScorePlayer1() { return this.scorePlayer1; }


  
  public int getScorePlayer2() { return this.scorePlayer2; }


  
  public void setScorePlayer1(int paramInt) { this.scorePlayer1 = paramInt; }


  
  public void setScorePlayer2(int paramInt) { this.scorePlayer2 = paramInt; }


  
  public void setActualPlayer(Player paramPlayer) { this.actualPlayer = paramPlayer; }


  
  public void applyColor(int a, int b) {
    if (this.actualPlayer == Player.Player1) {
      this.board[a][b].setColor(Color.red);
    } else {
      
      this.board[a][b].setColor(Color.blue);
    } 
  }
  
  public Player switchActualPlayer() {
    if (this.actualPlayer == Player.Player1) {
      this.actualPlayer = Player.Player2;
    } else {
      this.actualPlayer = Player.Player1;
    }
    return this.actualPlayer;
  }
    public Player togglePlayer() {
        if (this.actualPlayer == Player.Player1) {
          this.actualPlayer = Player.O;
        } else {
          this.actualPlayer = Player.X;
        }
  
    return this.actualPlayer;
  }
  
  public Player preMoveTurn()
  { 
	  return (this.actualPlayer == Player.Player1) ? Player.Player2 : Player.Player1; 
  }



  public void applyScore() {
    if (this.actualPlayer == Player.Player1) {
      this.scorePlayer1++;
    } else {
      this.scorePlayer2++;
    } 
  }
  
  public boolean isOver() 
  {
	  return (this.scorePlayer1 + this.scorePlayer2 == this.boardSize * this.boardSize); 
  }

  
  public String findWinner() 
  { 
	  return (this.scorePlayer1 > this.scorePlayer2) ? "Player1" : "Player2"; 
  }
}
