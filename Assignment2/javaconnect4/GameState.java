package javaconnect4;

import java.awt.Point;
import java.util.Stack;

public class GameState {
    private Boolean[][] pieces; //true = red, false = yellow, null = no piece
    final Stack<Point> moves;
    private String error;
    private boolean gameOver;
    private boolean redWins;
    private boolean yellowWins;
    private boolean redsTurn;
    public GameState(){
            pieces = new Boolean[7][6];
            moves = new Stack<>();
            gameOver = false;
            redWins = false;
            yellowWins = false;
            redsTurn = true;
           
    }
    public void move(int row){
        error = null;
        if(gameOver) setErrorMessage();
        else if(pieces[row - 1][5] != null) setErrorMessage();
        else {
        int y = 0;
        while(pieces[row - 1][y] != null) {
                y++;
        }
        pieces[row-1][y] = redsTurn;
        moves.push(new Point(row - 1, y));
        redsTurn = !redsTurn;
        checkForWin();            
    }         
}
    private void setErrorMessage(){}
    public void undo(){}
    public void restart(){
        pieces = new Boolean[7][6];
        gameOver = false;
        redWins = false;
        yellowWins = false;
        redsTurn = true;
        moves.clear();
        error = null;
    }
    private void checkForWin(){
        gameOver = false;
        redWins = false;
        yellowWins = false;
        //checks for red win
        if(fourInARow(true)) {
                gameOver = true;
                redWins = true;
        }
        //checks for yellow win
        else if(fourInARow(false)) {
                gameOver = true;
                yellowWins = true;
        }
        //checks if it's a tie
        else {
                //if there are no empty spaces in the top row (and no one has won) it's a tie
                for(int i = 0; i < pieces.length; i++) {
                        if(pieces[i][pieces[0].length - 1] == null) break;
                        else if(i == pieces.length - 1) gameOver = true;
                }
        }
    }
    private boolean fourInARow(boolean color){

    //vertical
    //runs through each column, from bottom to top
    for(int i = 0; i < pieces.length; i++) {
            //initializes a 4-in-a-row counter
            int count = 0;
            for(int j = 0; j < pieces[0].length; j++) {
                    //if there is no piece, there can be no pieces above it either
                    //so there is no reason to continue checking this column
                    if(pieces[i][j] == null) break;
                    //if there is a piece in this position, and it is of the color we are 
                    //checking for, increase the count
                    else if(pieces[i][j] == color) count ++;
                    //otherwise, reset the count
                    else count = 0;
                    //if the count is 4, then we have found 4 in a row and can return true
                    if(count == 4) {
                            return true;
                    }
            }
    }
    //horizontal
    //runs through each row, from left to right
    for(int j = 0; j < pieces[0].length; j++) {
            //initializes a 4-in-a-row counter
            int count = 0;
            for(int i = 0; i < pieces.length; i++) {
                    //if there is a piece in this position, and it is of the color we are 
                    //checking for, increase the count
                    if(pieces[i][j] == null || pieces[i][j] == !color) count = 0;
                    //otherwise, reset the count
                    else count++;
                    //if the count is 4, then we have found 4 in a row and can return true
                    if(count == 4) {
                            return true;
                    }
                    //if there are less spots left in this row than are needed to complete
                    //a four in a row, there is no need to continue checking this row
                    if(4 - (pieces.length) - 1 - i > count) break;
            }
    }
    //diagonal ( \ )
    //runs through each diagonal, from bottom-right to top-left
    for(int i = 3; i < pieces.length + 2; i++) {
            //initializes a 4-in-a-row counter
            int count = 0;
            for(int j = 0; (i - j) >= 0 && j < pieces[0].length; j++) {
                    if(i - j < pieces.length) {
                            //if there is a piece in this position, and it is of the color we are 
                            //checking for, increase the count
                            if(pieces[i - j][j] == null || pieces[i - j][j] == !color) count = 0;
                            //otherwise, reset the count
                            else count++;
                            //if the count is 4, then we have found 4 in a row and can return true
                            if(count == 4) {
                                    return true;
                            }
                            //if there are less spots left in this diagonal than are needed to complete
                            //a four in a row, there is no need to continue checking this diagonal
                            if(4 - (pieces[0].length) - 1 - i > count) break;
                    }
            }
    }
    //diagonal ( / )
    //runs through each diagonal, from bottom-left to top-right
    for(int i = 3; i >= -2; i--) {
            //initializes a 4-in-a-row counter
            int count = 0;
            for(int j = 0; (i + j) < pieces.length && j < pieces[0].length; j++) {
                    if(i + j >= 0) {
                            //if there is a piece in this position, and it is of the color we are 
                            //checking for, increase the count
                            if(pieces[i + j][j] == null || pieces[i + j][j] == !color) count = 0;
                            //otherwise, reset the count
                            else count++;
                            //if the count is 4, then we have found 4 in a row and can return true
                            if(count == 4) {
                                    return true;
                            }
                            //if there are less spots left in this diagonal than are needed to complete
                            //a four in a row, there is no need to continue checking this diagonal
                            if(4 - (pieces[0].length) - 1 - i > count) break;
                    }
            }
    }
    //if no 4-in-a-row combination was found, return false
        
        return false;
    }
    public Boolean[][] getPieces(){
		return pieces;
	}
    public boolean getRedWins(){
            return redWins;
    }	
    public boolean getYellowWins(){
            return yellowWins;
    }
   
    public Stack<Point> getMoves(){
            return moves;
    }

    public String getError() {
            return error;
    }
    public boolean getRedsTurn(){
		return redsTurn;
	}

    public boolean getGameOver(){
            return gameOver;
    }
    
}