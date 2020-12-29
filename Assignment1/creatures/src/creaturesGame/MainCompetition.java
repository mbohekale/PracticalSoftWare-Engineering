package creaturesGame;


import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
/**
 * 
 * @author Mboh Ekale
 * Main entres of the project
 *
 */

public class MainCompetition {	

	public static void main(String[] args) throws FileNotFoundException, InvalidInputException{
		CreatureDataBase cdb = new CreatureDataBase();
	
		
		try {
			//cdb.read("cars.txt");
			//cdb.read("employee.txt");
			cdb.read("data.txt");
			//cdb.read("data.txt");
			cdb.report();
			cdb.getMaxValue();
			}catch(FileNotFoundException ex ) {
				System.out.println("FileNotFound!");
				 System.exit(-1);
			} catch (InvalidInputException ex) {
	            System.out.println("Invalid input!");
	            System.exit(-1);
	        }	
		
		
		
			
	}

	
	
	

}
