package creaturesGame;
/**
 * 
 * @author Mboh ekale
 *sub class of the Creature
 */
public class Sponge extends Creature{
	int maxWaterLevels=20;
	public Sponge(String name, int initialWater) {
		super(name, initialWater);
		distance =0;
		initialWater=0;
		type="s";
	}
	/**
	 * inherited from the abstract class Creatures
	 */
	@Override
	public void sunnyDay() {
		initialWater =initialWater-4;
		int d1 =distance+0;
	}
	/**
	 * inherited from the abstract class Creatures
	 */
	@Override
	public void cloudyDay() {
		initialWater =initialWater-1;
		int d2 = distance+1;
		
	}
	/**
	 * inherited from the abstract class Creatures
	 */
	@Override
	public void rainyDay() {
		initialWater=initialWater+6;
		int d3 =distance+3;
	}
	@Override
	public void getWinner() {
		int totalDistance=maxWaterLevels-distance;
	}
	@Override
	public int getDistance() {
		return distance ;
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
		 Sponge s = new Sponge(name,initialWater);
		return distance;
		 
		
	}

}
