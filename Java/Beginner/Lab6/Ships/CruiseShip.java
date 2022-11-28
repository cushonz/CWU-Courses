
/**
Author: 
Date Last Modified: 

Description: The CruiseShip class stores data about 
a ship that is used for carrying passengers.
 */
public class CruiseShip extends Ship {

    // fields
    private int passengers;    // Maximum number of passengers
    private int numPets;       // Number of pets allowed

    /**
    Constructor     
     */
    CruiseShip(String name, int year, int passengers, int numPets) {
        // Call the superclass constructor (Ship),
        // passing the name and year as arguments.
        super(name, year);

        // Set passengers.
        this.passengers = passengers;

        // Set numPets
        this.numPets = numPets;
    }

    /**
    setPassengers method      
     */
    public void setPassengers(int passengers) {
        this.passengers = passengers;
    }

    /**
    getPassengers method
     */
    public int getPassengers() {
        return passengers;
    }

    /**
    getPassengers method
     */
    public int getNumPets() {
        return numPets;
    }

    /**
    toString method
     */
    public String toString() {
        return "Name: " + getName()
                + "\n   Type: Cruise Ship"
                + "\n   Maximum passengers: " + passengers
                + "\n   Year build: " + getYearBuilt()
                + "\n   Num Pets Allowed: " + numPets;
    }
}