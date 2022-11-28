
public abstract class Ship {
	private String name;
	private int yearBuilt;
	private int numPropellars;
	
	public Ship(String name,int year){
		this.name = name;
		this.yearBuilt = year;
		this.setNumPropellars(4);
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setYearBuilt(int year) {
		this.yearBuilt = year;
	}
	
	public void setNumPropellars(int props) {
		this.numPropellars = props;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getYear() {
		return this.yearBuilt;
	}
	
	public int getNumProps() {
		return this.numPropellars;
	}
	
	public abstract String toString();
	
}
