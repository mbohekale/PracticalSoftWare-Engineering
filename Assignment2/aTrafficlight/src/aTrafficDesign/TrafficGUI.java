package aTrafficDesign;


import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class TrafficGUI extends JPanel{
	Timer timer;
	private final int nRed = 10;
	private final int nYellow = 3;
	private final int nGreen = 10;
	
	private int r,y,g;
	
	JButton red; 
	JButton yellow; 
	JButton green; 
	
	JLabel lblRed  = new JLabel(String.valueOf(nRed));;	
	JLabel lblYellow=new JLabel(String.valueOf(nYellow));
	JLabel lblGreen =new JLabel(String.valueOf(nGreen));
	ImageIcon img = new ImageIcon("img/red1.png");
	ImageIcon img1 = new ImageIcon("img/traf2.png");
	ImageIcon img2= new ImageIcon("img/traf3.png");
	public TrafficGUI() {
		initComponent();				
		add(red);
		add(yellow);
		add(green);
		
		
	}
	private void initComponent() {		
		setLayout(new GridLayout(3,1));
		red = new JButton(img);
		red.add(lblRed);
		yellow = new JButton(img1);
		yellow.add(lblYellow);
		green = new JButton(img2);
		green.add(lblGreen);
		
		lblRed.setEnabled(true);
		lblYellow.setEnabled(false);
	    lblGreen.setEnabled(false);
	
		changeText();
	}
	private void changeText() {
		int speed =500;
		r=nRed;
		y=nYellow;
		g=nGreen;
		
		lblRed.setFont(new Font("Digital 7", Font.BOLD,70));
		lblYellow.setFont(new Font("Digital 7", Font.BOLD,70));
	    lblGreen.setFont(new Font("Digital 7", Font.BOLD,70));
	    
	    ActionListener al = new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent a) {
				if(r>=0) {
				lblRed.setText(String.valueOf(r));
				r--;
				}else if(y>=0) {
				lblYellow.setText(String.valueOf(y));
				lblRed.setText(null);
				lblYellow.setEnabled(true);
			    lblGreen.setEnabled(false);
				y--;					
				}else if(g>=0) {
				lblGreen.setText(String.valueOf(g));
				lblYellow.setText(null);
				lblYellow.setEnabled(false);
			    lblGreen.setEnabled(true);
				g--;					
				}else {
					lblRed.setEnabled(true);
					lblYellow.setEnabled(false);
				    lblGreen.setEnabled(false);
				    
				    lblGreen.setText(null);
				    
				    r=nRed;
					y=nYellow;
					g=nGreen;				    
				    
				}
			}};
	    
	    timer = new Timer(speed,al);
	    timer.start();
		
	}
	
	
	
	
	
	
}
