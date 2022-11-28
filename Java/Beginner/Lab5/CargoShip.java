
public class CargoShip extends Ship {
	private int tonnage;  
	private boolean isDoubleHull;
	
	public CargoShip(String name,int year,int tons,boolean doub) {
		super(name,year);
		this.tonnage = tons;
		this.isDoubleHull = doub;
	}


	public String toString(){
		return "Ship Type: Cargo Ship\n"
				+ "Propellars: "+this.getNumProps()+
				"\nYear: "+this.getYear()+
				"\nName: "+this.getName()+
				"\nTonnage: "+this.getTonnage()+
				"\nDouble Hull:"+ this.getHull();
	}
	
	public int getTonnage() {
		return tonnage;
	}

	public void setTonnage(int tonnage) {
		this.tonnage = tonnage;
	}

	public boolean getHull() {
		return isDoubleHull;
	}

	public void setDoubleHull(boolean isDoubleHull) {
		this.isDoubleHull = isDoubleHull;
	}
	
}
