package view;


import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import controller.ControlleurThreads;
import controller.KeyboardListenner;
import util.DataOfSquare;
import util.SquarePanel;
import util.ThreadSquare;
import util.Tuple;

public class WindowGUI extends JFrame{
	  private static final long serialVersionUID = -2542001418764869760L;
	  public static ArrayList<ArrayList<ThreadSquare>> Threads;
	  public static int width = 20;
	  public static int height = 20;
	  private SquarePanel board;
	  JFrame frame;
	public WindowGUI() throws IOException{
		frame = new JFrame();
		/**
		 * creating the bar menu
		 */
		JMenuBar menuBar = new JMenuBar();
        JMenu menuGame = new JMenu("Game");
        JMenu menuGameLevel = new JMenu("Level");
        JMenu menuGameScale = new JMenu("Zoom");
		
		  createGameLevelMenuItems(menuGameLevel);
		  createScaleMenuItems(menuGameScale,1.0, 2.0, 0.5);
		 
        

        JMenuItem menuGameExit = new JMenuItem(new AbstractAction("Exit") {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        /**
         * adding the items to the menu
         */
        menuGame.add(menuGameLevel);
        menuGame.add(menuGameScale);
        menuGame.addSeparator();
        menuGame.add(menuGameExit);
        menuBar.add(menuGame);
        setJMenuBar(menuBar);
        
		
		Threads= new ArrayList<>();
		
		for (int i = 0; i < width; i++) {
		      ArrayList<ThreadSquare> data = new ArrayList<>();
		      for (int j = 0; j < height; j++) {
		        
	        DataOfSquare c = new DataOfSquare(2);
		        data.add(new ThreadSquare(c));
		      } 
		      Threads.add(data);
		  }

    
    getContentPane().setLayout(new GridLayout(20, 20, 0, 0));

    /**
     * starting the thread
     */
    for (int i = 0; i < width; i++) {
      for (int j = 0; j < height; j++) {
        ((ThreadSquare)((ArrayList<ThreadSquare>)Threads.get(i)).get(j)).start();
        ((ThreadSquare)((ArrayList<ThreadSquare>)Threads.get(i)).get(j)).pauseThread();
        getContentPane().add(((ThreadSquare)((ArrayList)Threads.get(i)).get(j)).square.square);
      } 
    } 

    
    Tuple position = new Tuple(10, 10);
    
    ControlleurThreads c = new ControlleurThreads(position);
    
    c.start();

    
    addKeyListener(new KeyboardListenner());
  }
	private void createScaleMenuItems(JMenu menuGameScale, double from, double to, double by) {}
	private void createGameLevelMenuItems(JMenu menuGameLevel) {}
	

}
