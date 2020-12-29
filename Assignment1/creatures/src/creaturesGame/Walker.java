package creaturesGame;
/**
 * 
 * @author Mboh ekale
 * subClass of the Creature
 *
 */
public class Walker extends Creature{
	int maxWaterLevels=12;
	public Walker(String name, int initialWater) {
		super(name, initialWater);
		distance=0;
		initialWater=0;
		type="w";
	}

	@Override
	public void sunnyDay() {
		initialWater =initialWater - 2;
		distance =distance+1;
	}

	@Override
	public void cloudyDay() {
		initialWater =initialWater-1;
		distance =distance+2;
		
	}

	@Override
	public void rainyDay() {
		initialWater =initialWater+3;
		distance =distance+1;
	}
	@Override
	public int getDistance() {
		
		return distance ;
	}
	@Override
	public void getWinner() {
		int totalDistance=maxWaterLevels-distance;
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
		Walker w = new Walker(name,initialWater);
		return distance;
		
		
	}
	

}
