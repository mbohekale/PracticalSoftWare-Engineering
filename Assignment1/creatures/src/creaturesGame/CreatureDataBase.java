package creaturesGame;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;


public class CreatureDataBase {
	ArrayList<Creature> creatures= new ArrayList<>();
	
		
	public CreatureDataBase() {
		
		creatures=new ArrayList<>();
	}
	
public void read(String filename) throws FileNotFoundException, InvalidInputException {
			
			Scanner sc = 
					//new Scanner(new BufferedReader(new FileReader("cars.txt")));
					//new Scanner(new BufferedReader(new FileReader("employee.txt")));
					//new Scanner(new BufferedReader(new FileReader("student.txt")));
					new Scanner(new BufferedReader(new FileReader("data.txt")));
			int numCreatures=sc.nextInt();
			System.out.printf("%d\n",numCreatures);
				for(int i=0;i<numCreatures;i++){
				Creature creature;
				String name=sc.next();
				String type =sc.next();
				int initialWater =sc.nextInt();
				
				switch(type) {
				case "r":
					creature= new Sandrunner(name,initialWater);
					
					break;
				case "s":
					creature = new Sponge(name,initialWater);
					
					break;
				case "w":
					creature = new Walker(name,initialWater);
					
					break;
				default:
					System.out.println(type);
					throw new InvalidInputException();
				}
				creatures.add(creature);
}
				
				String days;
				days=sc.next();				
	
		 for(int i=0;i<days.length();i++){ 
			 
			 for(Creature creature: creatures){				
					switch(days.charAt(i)) {
					case 's':
						creature.sunnyDay();
						System.out.print('s');						 
						break;
					case 'c':
						creature.rainyDay();
						System.out.print('c');						
						break;
					case 'r':
						creature.cloudyDay();
						System.out.print("r");
						break;
					default:
						System.out.println(days);
						throw new InvalidInputException();
					}
					
			}
	}
}
					
				
	
				/**
				 * this method goes through all the items in the arraylist
				 */
						
				public void report() {
					System.out.println("\n");
					System.out.println("Creatures in the database:");
		        
		        for (Creature v : creatures) {
		            System.out.println(v);
		            System.out.println(v.isAlive());
		        }
		        /**
		         * prints out the result of the race
		         */
		        }
				
				public Creature getMaxValue() {
				System.out.println("Winner of competition is:");
					Creature max = creatures.get(0);					
					 for(Creature c: creatures) {						
						 if(c.getDistance()>max.getDistance()) {
							max=c;							 
						 
						 }
						 
					 }
					 System.out.println(max);
					return max;
					
				}	
	
}
