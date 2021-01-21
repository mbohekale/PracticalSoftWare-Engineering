package aTrafficDesign;



import javax.swing.JFrame;
import javax.swing.JPanel;

public class TrafficMain {

	public static void main(String[] args) {
		JFrame fr = new JFrame();
		JPanel tg = new TrafficGUI();
		
		
		fr.add(tg);
		fr.setTitle("TrafficLight");
		fr.setSize(400,400);
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fr.setLocationRelativeTo(null);
		fr.setVisible(true);
		

	}

}
