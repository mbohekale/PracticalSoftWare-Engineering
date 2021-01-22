package aGUI.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import aGUI.controller.SampleAppController;
import aGUI.model.Board;
import aGUI.model.Field;
/*
 * we add the game to the panel as private
 */
@SuppressWarnings("serial")
public class BoardGUI{
	private SampleAppController controller;
	private JPanel boardPanel;
	private Board board;
	private JButton[][] buttons;
	private JLabel scoreLabel;
	private JLabel turnLabel;
	private boolean isFirstPlayer=false;
	private static String PLAYERX = "Player X";
	private static String PLAYERO = "Player O";
	private String playerName = PLAYERX;
	
	
	public BoardGUI(int paraInt) {
		
		this.controller = new SampleAppController();
		this.board = new Board(paraInt);
		this.boardPanel=new JPanel();
		this.boardPanel.setLayout(new GridLayout(this.board.getBoardSize(),this.board.getBoardSize()));
		this.buttons = new JButton[this.board.getBoardSize()][this.board.getBoardSize()];
		for(int i=0;i<this.board.getBoardSize();i++) {
			for(int j=0;j<this.board.getBoardSize();j++) {
				JButton button = new JButton();
				
				this.buttons[i][j] = button;
				button.setPreferredSize(new Dimension(100,70));
				button.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						JButton clickedButton = (JButton) e.getSource();
						String buttonLabel = clickedButton.getText();
						if("".equals(buttonLabel) && isFirstPlayer) {
							clickedButton.setText("X");
							clickedButton.setFont(new Font(Font.SANS_SERIF,Font.BOLD,36));
							isFirstPlayer=false;
						}else if("".equals(buttonLabel) && !isFirstPlayer) {
							clickedButton.setText("O");
							clickedButton.setFont(new Font(Font.SANS_SERIF,Font.BOLD,36));
							isFirstPlayer=true;
						}
						checkforwinner();
					}});
				boardPanel.add(button);
			}
		}
		this.scoreLabel = new JLabel("Score :");
		this.scoreLabel.setHorizontalAlignment(4);
		
		this.turnLabel = new JLabel("Turn :");
		this.turnLabel.setHorizontalAlignment(4);		
		
	}
		
	public JPanel getBoardPanel() {
		return boardPanel;}
	public boolean find3InRow() {
		//Row 1
		if (""!=buttons[0][0].getText() && buttons[0][0].getText() == buttons[0][1].getText()
		&& buttons[0][1].getText() == buttons[0][2].getText()){
		highlightWinningCombo(buttons[0][0],buttons[0][1],buttons[0][2]);
		return true;
		}
		//Column 1
		if (""!=buttons[0][0].getText() && buttons[0][0].getText() == buttons[1][0].getText()
			&& buttons[1][0].getText() == buttons[2][0].getText()){
		highlightWinningCombo(buttons[0][0],buttons[1][0],buttons[2][0]);
		return true;
		}
		//Diagonal 1
		if (""!=buttons[0][0].getText() && buttons[0][0].getText() == buttons[1][1].getText()
			&& buttons[1][1].getText() == buttons[2][2].getText()){
		highlightWinningCombo(buttons[0][0],buttons[1][1],buttons[2][2]);
		return true;
		}
		
		return false;
	}
	public void checkforwinner() {
		String [] str = {"OK"};
	
	if(find3InRow()){
		String winnerName=(playerName == PLAYERO)?PLAYERX:PLAYERO;
		JOptionPane.showMessageDialog(null, str, winnerName, 0, null);
		}
	}
	public void highlightWinningCombo(JButton b1,JButton b2,JButton b3) {
		b1.setBackground(Color.cyan);
		b2.setBackground(Color.cyan);
		b3.setBackground(Color.cyan);
	}
	
	
}