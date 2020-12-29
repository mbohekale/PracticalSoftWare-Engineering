package creaturesGame;

import java.util.ArrayList;
import java.util.Vector;

public abstract class Creature {
	  String name;
	  int  initialWater;
	  String type;
	  Boolean living;
	  int distance;
	 public Creature(String name,String type) {
			this.name=name;	
			this.type=type;
			this.distance = distance;
			}
	 public Creature(String name, int initialWater) {
			this.name=name;	
			this.initialWater=initialWater;
			this.distance=distance;
			
			}
	 /**
	  * 
	  * @return
	  * name of the creatures
	  */
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name=name;
	}
	/**
	 * gets the type of the creatures
	 * @return
	 */
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type=type;
	}
	public void setInitialWater(int initialWater) {
		this.initialWater=initialWater;
	}
	/**
	 * get the amount of water contained by the creatures
	 * @return
	 */
	public int getInitialWater() {
		return initialWater;
	}	 
	
	public void addWater(int water) {
			
	}
	public abstract int addDistances(int distance);
	public abstract int getDistance();
	public abstract boolean isAlive();
	public abstract void sunnyDay();
	public abstract void cloudyDay();
	public abstract void rainyDay();
	public abstract void getWinner();
	
	/**
	 * Help to print the names attributes of the creatures
	 */
	
	public String toString() {
	return name+" "+type+"  "+ initialWater; 
	}

}
