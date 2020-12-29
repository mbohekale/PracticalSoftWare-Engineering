package creaturesGame;
/**
 *Sandrunner is a subclass of the Creature
 */

public class Sandrunner extends Creature{
		public static int maxWaterLevels=8;
	public Sandrunner(String name, int initialWater) {
		super(name, initialWater);
		distance =0;
		initialWater=0;
		type="r";
		
		
	}
	/**
	 * inherited from the abstract class Creatures
	 */
	
	@Override
	public void sunnyDay() {
		initialWater =initialWater+1;
		distance= distance+3;
	}
	/**
	 * inherited from the abstract class Creatures
	 */
	@Override
	public void cloudyDay() {
		initialWater =initialWater + 0;
		distance=distance+ 1;
		
	}
	/**
	 * inherited from the abstract class Creatures
	 */
	@Override
	public void rainyDay() {
		initialWater =initialWater+3;
		 distance = distance+ 0;
	}
	@Override
	public  void getWinner() {
		
	}
	@Override
	public int getDistance() {
		return distance;
	}
	@Override
	public boolean isAlive() {
		if(initialWater>0) {
			System.out.println("isAlive");
			return true;
		}else {
			System.out.println("isNotAlive");
		return false;
		}
	}
	@Override
	public int addDistances(int distance) {
		Sandrunner s = new Sandrunner(name,initialWater);
		return distance;
		   
	}

}
