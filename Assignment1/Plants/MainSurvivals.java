package aAssignment1Project;

import java.io.FileNotFoundException;
import java.io.IOException;

public class MainSurvivals {

	public static void main(String[] args) throws IOException{
		PlantsDataBase pdb = new PlantsDataBase();
		try {
			pdb.read("data.txt");
			pdb.report();
			}catch(FileNotFoundException ex ) {
				System.out.println("FileNotFound!");
				 System.exit(-1);
			} catch (InvalidInputException ex) {
	            //System.out.println("Invalid input!");
	            System.exit(-1);
	        }	
		

	}

}
