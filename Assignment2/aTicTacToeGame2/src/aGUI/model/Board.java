package aGUI.model;

import aGUI.view.SampleGUI;

public class Board {
	 private Field[][] board;
	 private final  int boardSize;
	 private Player actualPlayer;
	 private int scorePlayer1;
	 private int scorePlayer2;
	 SampleGUI sample;
	public Board(int paraInt) {
		this.boardSize=paraInt;
		this.board =new Field[this.boardSize][this.boardSize];
		for(byte b=0;b<this.boardSize;b++) {
			for(byte b1=0;b1<this.boardSize;b1++) {
				this.board[b][b1]=new Field();
				
			}
		}
	}
	public Field getValue(int val,int val1) {
		return this.board[val][val1];}
	public int getBoardSize() {	return this.boardSize;}
	  
	public void applyScore() {
		if(this.actualPlayer==Player.Player1) {
			this.scorePlayer1++;
		}else {
			this.scorePlayer2++;
		}
	}
	public Player switchActualPlayer() {
		if(this.actualPlayer==Player.Player1) {
			this.actualPlayer=Player.Player2;
		}else {
			this.actualPlayer=Player.Player1;
		}
		return this.actualPlayer;
	}
	

}
