package aGUI.view;

import java.awt.MenuBar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import aGUI.controller.SampleAppController;
import aGUI.model.Board;
/*
 * we add panel to the frame as private
 * we also pass the game Object to the constructor
 * And then pass it to the panel(game)
 * set up the frame for the game
 */
@SuppressWarnings("serial")
public class SampleGUI {
	private JFrame fr;
	private BoardGUI boardGui;
	private final int InitialBoardSize = 5;
	
	JMenu menu, submenu;  
    JMenuItem i1, i2, i3, i4, i5; 
    JMenuBar mb;
	
	public SampleGUI(SampleAppController controller) {
		fr = new JFrame("TicTacToe");
		boardGui = new BoardGUI(InitialBoardSize);
			setJMenu();
			setFrame();			
	}
	public void setFrame() {		
		/*
		 * setContentPane is used as the container
		 * where the panel is passed or added to the frame
		 */	
			
			this.fr.getContentPane().add(this.boardGui.getBoardPanel());			
			this.fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.fr.setSize(300, 300);
			this.fr.setLocationRelativeTo(null);
			this.fr.setVisible(true);
	}
	public void setJMenu() {
		 	JMenuBar jMenuBar = new JMenuBar();
		 	this.fr.setJMenuBar(jMenuBar);
		    
		    JMenu jMenu1 = new JMenu("Game");
		    jMenuBar.add(jMenu1);
		    JMenu jMenu2 = new JMenu("New");
		    jMenu1.add(jMenu2);
		    JMenuItem jMenu3 = new JMenuItem("EXIT");
		    jMenu1.add(jMenu3);
		    jMenu3.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
				}});
		    
         
       
         
         
         int[] boardSizes = {3 ,5, 7};
         
         for(int i:boardSizes) {        	 
        	 JMenuItem jMenuItem1 = new JMenuItem("" + i + " x " + i);
             jMenu2.add(jMenuItem1); 
             jMenuItem1.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
				  SampleGUI.this.fr.getContentPane().remove(SampleGUI.this.boardGui.getBoardPanel());
	              //SampleGUI.this.getContentPane().remove(SampleGUI.this.boardGui.getTurnLabel());
	              //FourgameGUI.this.frame.getContentPane().remove(SampleGUI.this.boardGui.getScoreLabel());
				  SampleGUI.this.boardGui = new BoardGUI(i);
				  SampleGUI.this.fr.getContentPane().add(SampleGUI.this.boardGui.getBoardPanel(), "Center");
	              //FourgameGUI.this.frame.getContentPane().add(FourgameGUI.this.boardGUI.getTurnLabel(), "North");
	              //FourgameGUI.this.frame.getContentPane().add(FourgameGUI.this.boardGUI.getScoreLabel(), "South");
				  SampleGUI.this.fr.pack();
	            }});
         }
         
         
	}
	
}


