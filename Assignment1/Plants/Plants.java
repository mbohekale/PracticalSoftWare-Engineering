package aAssignment1Project;

public abstract class Plants {
	String name;
	int nutrients;
	String type;
	
	public Plants(String name,int nutrients) {
		this.name=name;
		this.nutrients=nutrients;		
	}
	public Plants(String name,String type) {
		this.name=name;
		this.type=type;
	}
	
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public abstract boolean isAlive();
	public abstract void alpha();
	public abstract void beta();
	public abstract void noRadiation();
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNutrients() {
		return nutrients;
	}
	public void setNutrients(int nutrients) {
		this.nutrients = nutrients;
	}
	
	public String toString() {
		return name
				+nutrients
				+ type;
	}

}
