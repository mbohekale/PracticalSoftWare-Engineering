package aAssignment1Project;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class PlantsDataBase {
	ArrayList<Plants> plants = new ArrayList<>();
	
	public PlantsDataBase() {
		plants = new ArrayList<>();
	}
	
	public void read(String filename)
			throws FileNotFoundException, InvalidInputException {
		Scanner sc =
				new Scanner(new BufferedReader(new FileReader("data.txt")));
		int numOfPlants=sc.nextInt();
		System.out.printf("%d\n",numOfPlants);
			for(int i=0;i<numOfPlants;i++){
			Plants plant;
			String name=sc.next();
			String type =sc.next();
			int initnutrients =sc.nextInt();
			
			switch(type) {
			case "p":
				plant= new Puffs(name, initnutrients);	
				System.out.println(name+" "+"p"+" "+initnutrients);
				break;
			case "d":
				plant = new Deltatree(name, initnutrients);	
				System.out.println(name+" "+"d"+" "+initnutrients);
				break;
			case "b":
				plant = new Parabush(name,initnutrients);
				System.out.println(name+" "+initnutrients);
				break;
			default:
				System.out.println(type);
				throw new InvalidInputException();
			}
			plants.add(plant);
}
			
			String days;
			days=sc.next();				

	 for(int i=0;i<days.length();i++){ 
		 
		 for(Plants p: plants){				
				switch(days.charAt(i)) {
				case 'p':
					p.alpha();
					System.out.print('p');						 
					break;
				case 'd':
					p.beta();
					System.out.print('d');						
					break;
				case 'b':
					p.noRadiation();
					System.out.print('b');
					break;
				default:
					System.out.println(days);
					throw new InvalidInputException();
				}
			}
		 }
	 }
	public void report() {
		System.out.println("Hi plants");
		for(Plants v:plants) {
			System.out.println(v.name);
		}
	}
	
		
		
}
	
