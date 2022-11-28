
public class CruiseShip extends Ship {
	private int passangers;
	private int numPets;
	
	public CruiseShip(String name,int year,int pass,int pet) {
		super(name,year);
		this.numPets = pet;
		this.passangers = pass;
	}

	public String toString() {
		return "Ship Type: Cruise Ship\n"
				+"Propellars: "+this.getNumProps()+
				"\nYear: "+this.getYear()+
				"\nName: "+this.getName()+
				"\nPassangers: "+this.getPassangers()+
				"\nPets:"+ this.getNumPets();
	}
	
	public int getPassangers() {
		return passangers;
	}

	public void setPassangers(int passangers) {
		this.passangers = passangers;
	}

	public int getNumPets() {
		return numPets;
	}

	public void setNumPets(int numPets) {
		this.numPets = numPets;
	}
	
}
