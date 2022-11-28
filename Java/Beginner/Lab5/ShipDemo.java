
public class ShipDemo {
	public static void main(String args[]) {
		final int NUM_SHIPS = 4;
		Ship[] shipyard = new Ship[NUM_SHIPS];
		
		shipyard[0] = new CruiseShip("Disney",2012,10000,30);
		shipyard[1] = new CargoShip("Cargo",2012,2,true);
		shipyard[2] = new CruiseShip("Fun",2014,1000,3);
		shipyard[3] = new CargoShip("Military",2012,2,false);
		
		for (int i=0;i<shipyard.length;i++) {
			System.out.println(shipyard[i].toString());
			System.out.println("--------------------------");
		}
	}
}
