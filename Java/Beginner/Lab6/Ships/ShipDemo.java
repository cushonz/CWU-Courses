
/**
Author: 
Date Last Modified: 

Description: The ShipDemo program crates objects
of type cruiseShip and CargoShip.
 */
public class ShipDemo {

    public static void main(String[] args) {

        // Constant for the number of ships.
        final int NUM_SHIPS = 3;

        // Create an array of Ship references.
        Ship[] ships = new Ship[NUM_SHIPS];

        // Assign Ship objects to the array elements.
        ships[0] = new CruiseShip("Disney Goofy", 1998, 2400, 23);
        ships[1] = new CargoShip("Too Small", 1800, 500, false);
        ships[2] = new CruiseShip("I Wish I Had a Bigger Boat", 2001, 4, 3);

        // Call each object's toString method.
        for (int i = 0; i < NUM_SHIPS; i++) {
            System.out.println(ships[i].toString());
            System.out.println("----------------------------");
        }
    }
}