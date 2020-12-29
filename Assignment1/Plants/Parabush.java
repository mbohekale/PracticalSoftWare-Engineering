package aAssignment1Project;

public class Parabush extends Plants{

	public Parabush(String name, int initnutrients) {
		super(name, initnutrients);
		initnutrients=0;
		//type = "b";
		
	}

	@Override
	public boolean isAlive() {
		return true;
	}

	@Override
	public void alpha() {}

	@Override
	public void beta() {}

	@Override
	public void noRadiation() {}
	

}
