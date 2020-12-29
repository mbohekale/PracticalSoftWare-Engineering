package gamefour;

/**
 * creating the board of the game
 */

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author ekale
 */

	public class BoardGUI
	{
	  private JButton[][] buttons;
	  private Board board;
	  private JPanel boardPanel;
	  private JLabel scoreLabel;
	  private JLabel turnLabel;
	  static String currentPlayer;
	  static boolean hasWinner=false;
	 
	  
	  public BoardGUI(int boardSize) {
		  currentPlayer="X";
	    this.board = new Board(boardSize);
	    this.boardPanel = new JPanel();
	    this.boardPanel.setLayout(new GridLayout(this.board.getBoardSize(), this.board.getBoardSize()));
	    this.buttons = new JButton[this.board.getBoardSize()][this.board.getBoardSize()];
	    for (int i = 0; i < this.board.getBoardSize(); i++) {
	      for (int j = 0; j < this.board.getBoardSize(); j++) {
	        JButton jButton = new JButton();
	        jButton.addActionListener(new ButtonListener(i, j));
	        jButton.setPreferredSize(new Dimension(100, 60));
	        this.buttons[i][j] = jButton;
	        jButton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					
					if(((JButton)e.getSource()).getText().equals("")&& hasWinner==false) {
						jButton.setText(currentPlayer);
						togglePlayer();
						
					}
					
				}});
	        this.boardPanel.add(jButton);
	        
	      } 
	    } 
	    /**
	     * creating the labels
	     */
	    this.turnLabel = new JLabel("Move turn : " + this.board.preMoveTurn());
	    this.turnLabel.setHorizontalAlignment(4);
	    
	    this.scoreLabel = new JLabel("Score : Player1  " + this.board.getScorePlayer1() +
	    		" - " + this.board.getScorePlayer2() + "Player2");
	    this.scoreLabel.setHorizontalAlignment(4);
	    
	  }


	  
	  public JPanel getBoardPanel() { return this.boardPanel; }
	  
	  /**
	   * 
	   * @return get score
	   */

	  
	  public JLabel getScoreLabel() { return this.scoreLabel; }

	  /**
	   * 
	   * @return whose turn is it
	   */
	  
	  public JLabel getTurnLabel() { return this.turnLabel; }


	  
	  class ButtonListener
	    implements ActionListener
	  {
		  JButton jButton = new JButton();
	    private int x;

	    
	    private int y;

	    
	    public ButtonListener(int var1, int var2) {
	      this.x = var1;
	      this.y = var2;
	    }
	    /**
	     * action performed by clicking the buttons
	     */

	    
	    public void actionPerformed(ActionEvent e) {
	      if (BoardGUI.this.board.getValue(this.x, this.y).getColor() == null) {
	        BoardGUI.this.board.switchActualPlayer();
	        BoardGUI.this.board.togglePlayer();
	        BoardGUI.this.turnLabel.setText("Move turn : " + BoardGUI.this.board.preMoveTurn());
	        BoardGUI.this.refresh(this.x, this.y);
	        
	      } 
	      
	    	      //sBoard();
	      
	      
	    }
		
	 
	    
	  }


	  /**
	   * refreshing the board
	   * @param val1
	   * @param val2
	   */
	  
	  public void refresh(int val1, int val2) {
	    for (int i = 0; i < this.board.getBoardSize(); i++) {
	      for (int  j= 0; j < this.board.getBoardSize(); j++) {
	        Field field = this.board.getValue(i, j);
	        JButton jButton = this.buttons[i][j];
           /**
            * where the logic of the game is
            */
	        
		      	  		      	         
	        
	        if (Math.abs(val1 - i) >= 1 && Math.abs(val2 - j) >=1 && this.board.getValue(i,j).getColor() == null) {
	         // this.board.getValue(i, j).setNumber(this.board.getValue(i, j).getNumber() + 1);
	         //jButton.setText("x"); 
	               
	        	  
	          
	          
	          //jButton.setText(String.valueOf(field.getNumber()));
	          /**
	           * getting the max value on the button
	           * which is 4
	           * it can be change to any amount
	           * if(this.board.getValue(i, j).getNumber() == 2 )
	           * (this.board.getValue(i, j).getNumber() == 3)
	           * 
	           */
	          if (this.board.getValue(i, j).getNumber() == 0 ) {
	            //this.board.applyColor(i, j);
	            this.board.applyScore();
	            jButton.setBackground(field.getColor());
	            this.scoreLabel.setText("Score : Player1  " + this.board.getScorePlayer1() + " - "
	            + this.board.getScorePlayer2() + " Player2");
	          }
	         
	          
	         }	         
	        
	      } 
	    } 
	    /**
	     * if the game is over there will be a message to say who 
	     * won
	     * The board will restart automatically
	     * once the winner is found
	     */
	    
	    if (this.board.isOver()) {
	      System.out.println();
	      JOptionPane.showMessageDialog(this.boardPanel, this.board.findWinner() + " Won!", "Announcement", -1);
	      restart();
	    } 
	  }
	  
	
		  
	public void togglePlayer() {
		if(currentPlayer.equals("X")) {
			currentPlayer="O";
		}else {
			currentPlayer="X";
			
			
		}
		
		try {
			winningGame();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void winningGame() throws Exception 
	{	
		try {
		int num=0;
		//first combination 3x3
		if(num<1) {
			sBoard();
			mBoard();
			 lBoard();
			num++;
		}else
		//second combination 5x5
		if (num < 2) {			
		mBoard();
		num++;
		}
			if(num<=3) {
		  lBoard();
		  num++;
			}
		}catch(ArrayIndexOutOfBoundsException  e) {
			System.out.println(e);
			}
		
	}
		 	

		 
		
			
	  private void lBoard() {
		  try {
		  // forth combination 7x7 
		  String str13= this.buttons[1][1].getText();
		  String str14 = this.buttons[1][board.getBoardSize()-2].getText();
		  String str15 =this.buttons[5][1].getText();
		  String str16 =this.buttons[5][board.getBoardSize()-2].getText(); 
		  // fithy combination
		  String str17= this.buttons[2][2].getText(); String str18 =
		  this.buttons[2][board.getBoardSize()-3].getText(); String str19 =
		  this.buttons[4][2].getText(); String str20 =
		  this.buttons[4][board.getBoardSize()-3].getText();
		  
		  // sith combination
		  String str21= this.buttons[2][2].getText();
		  String str22= this.buttons[2][board.getBoardSize()-3].getText();
		  String str23= this.buttons[4][2].getText();
		  String str24= this.buttons[4][board.getBoardSize()-4].getText(); 
		  // seventh combination
		  String str25= this.buttons[0][0].getText();
		  String str26=this.buttons[0][board.getBoardSize()-1].getText();
		  String str27=this.buttons[6][0].getText();
		  String str28=this.buttons[6][board.getBoardSize()-1].getText();
		  
		  //4th 
		  if(str13.equals("O") && str14.equals("O")&& str15.equals("O")&&
		  str16.equals("O")) { JOptionPane.showMessageDialog(null, currentPlayer +
		  "won"+ "Game"); restart();
		  
		  } //5th 
		  if(str17.equals("O") && str18.equals("O")&& str19.equals("O")&&
		  str20.equals("O")) { JOptionPane.showMessageDialog(null, currentPlayer +
		  "won"+ "Game");
		  
		  restart(); }
		  //6th 
		  if(str21.equals("O") && str22.equals("O")&&
		  str23.equals("O")&& str24.equals("O")) { JOptionPane.showMessageDialog(null,
		  currentPlayer + "won"+ "Game");
		  
		  restart(); }
		  
		  if(str25.equals("O") && str26.equals("O")&& str27.equals("O")&&
		  str28.equals("O")) { JOptionPane.showMessageDialog(null, currentPlayer +
		  "won"+ "Game");
		  
		  restart();
		  } 
	  }catch(ArrayIndexOutOfBoundsException e) {
		  System.out.println(e);
	  }
	}		 
		




	private void mBoard() {
		try {

		  String str5 = this.buttons[0][0].getText();
		  String str6 =this.buttons[0][board.getBoardSize()-1].getText();
		  String str7 =this.buttons[4][0].getText();
		  String str8 =this.buttons[4][board.getBoardSize()-1].getText(); 
		  // Third combination
		  String str9 = this.buttons[1][1].getText();
		  String str10 =this.buttons[1][board.getBoardSize()-2].getText();
		  String str11 =this.buttons[3][1].getText();
		  String str12 =this.buttons[3][board.getBoardSize()-2].getText(); 
		  
		  //1st			  
		   if(str5.equals("O") && str6.equals("O")&& str7.equals("O")&& str8.equals("O"))
		   { 
			   JOptionPane.showMessageDialog(null, currentPlayer + "won"+ "Game");
			   restart(); 
		  } 
		   if(str9.equals("O") && str10.equals("O")&&
		  str11.equals("O")&& str12.equals("O"))
		   {
			   JOptionPane.showMessageDialog(null,
		  currentPlayer + "won"+ "Game"); 
			   restart();
		  
		  }
	}catch(ArrayIndexOutOfBoundsException e) {
		System.out.println(e);
	}
	}



	private void sBoard() {
try {
String str1 = this.buttons[0][0].getText();
String str2 = this.buttons[0][board.getBoardSize()-1].getText();
String str3 = this.buttons[2][0].getText();
String str4 = this.buttons[2][board.getBoardSize()-1].getText();

if(str1.equals("O") && str2.equals("O")&& str3.equals("O")&& str4.equals("O"))
{
JOptionPane.showMessageDialog(null, currentPlayer + "won"+ "Game");
restart();

  }	
}catch(ArrayIndexOutOfBoundsException e) {
	System.out.println(e);
}
}



	/**
	   * every thing in this method is zero
	   */
	  public void restart() {
		  try {
	    for (int i = 0; i < this.board.getBoardSize(); i++) {
	      for (int j = 0; j < this.board.getBoardSize(); j++) {
	        this.board.getValue(i, j).setColor(null);
	        this.board.getValue(i, j).setNumber(0);
	        this.board.getValue(i, j).setCount(0);
	        this.board.setScorePlayer1(0);
	        this.board.setScorePlayer2(0);
	        this.board.setActualPlayer(null);
	        this.buttons[i][j].setBackground(null);
	        this.buttons[i][j].setText("");
	        this.buttons[0][this.board.getBoardSize()-1].setText("0");
	        this.buttons[0][0].setText("0");
	        this.buttons[6][0].setText("0");
	        this.buttons[6][this.board.getBoardSize()-1].setText("0");
	        this.buttons[(this.board.getBoardSize()-1)/2][(this.board.getBoardSize()-1)/2].setText("X");
	        this.scoreLabel.setText("Score : Player1  " + this.board.getScorePlayer1() + " - " 
	        + this.board.getScorePlayer2() + " Player2");
	        this.turnLabel.setText("Move turn : " + this.board.preMoveTurn());
	        
	        
	      } 
	    } 
		  }catch(ArrayIndexOutOfBoundsException e) {
			  System.out.println(e);
		  }
	  }
	  
	}