package aAssignment1Project;

public class Puffs extends Plants{
	
	public static int nutrients=10;
	public Puffs(String name, int initnutrients) {
		super(name, nutrients);
		initnutrients=0;
		type = "p";		
		
	}

	@Override
	public boolean isAlive() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void alpha() {
		nutrients = nutrients + 2;
		
	}

	@Override
	public void beta() {
		nutrients = nutrients - 2;
		
	}

	@Override
	public void noRadiation() {
		nutrients = nutrients - 1;
		
	}
	

}
