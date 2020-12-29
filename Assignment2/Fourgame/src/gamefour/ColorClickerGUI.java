package gamefour;


import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 *
 * @author ekale
 */
public class ColorClickerGUI 
{
  private int boardSize;
  private JFrame frame;
  private BoardGUI boardGUI;
  private final int INITAIAL_BOARD_SIZE= 5;



  
  public ColorClickerGUI() {
    frame = new JFrame("GameOfFOUR");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    
    boardGUI = new BoardGUI(INITAIAL_BOARD_SIZE);
    frame.getContentPane().add(this.boardGUI.getBoardPanel(), BorderLayout.CENTER);
    frame.getContentPane().add(this.boardGUI.getScoreLabel(), BorderLayout.SOUTH);
    frame.getContentPane().add(this.boardGUI.getTurnLabel(), "South");
    
    JMenuBar menuBar = new JMenuBar();
    frame.setJMenuBar(menuBar);
    JMenu gameMenu = new JMenu("Game");
    menuBar.add(gameMenu);
    JMenu newMenu = new JMenu("New");
    gameMenu.add(newMenu);


    
    //int[] boardSizes =new int[] {2, 4, 6};
   // int[] boardSizes =new int[] {4, 6, 8};
    int[] boardSizes =new int[] {3, 5, 7};
    for(int boardSize: boardSizes) {
    	 JMenuItem sizeMenuItem = new JMenuItem(boardSize + "x" + boardSize);
         newMenu.add(sizeMenuItem);
         sizeMenuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.getContentPane().remove(boardGUI.getBoardPanel());
                frame.getContentPane().remove(boardGUI.getScoreLabel());
                boardGUI = new BoardGUI(boardSize);
                frame.getContentPane().add(boardGUI.getBoardPanel(),
                        BorderLayout.CENTER);
                frame.getContentPane().add(boardGUI.getScoreLabel(), BorderLayout.SOUTH);
                frame.pack();
				
			}});
    }
    
     

    
    JMenuItem exitMenuItem = new JMenuItem("Exit");
    gameMenu.add(exitMenuItem);
    exitMenuItem.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
			
		}});
    
    this.frame.pack();
    this.frame.setVisible(true);
  }

  
  public JFrame getFrame() 
  {
	  return frame; 
  }
}

