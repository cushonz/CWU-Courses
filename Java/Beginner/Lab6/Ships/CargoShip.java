
/**
Author: 
Date Last Modified: 

Description: The CargoShip class stores data about 
a ship that is used for carrying cargo.
 */
public class CargoShip extends Ship {

    // fields
    private int tonnage;        // Cargo tonnage
    private boolean isDoubleHull; // whether hull is extra thick

    /**
    Constructor
     */
    CargoShip(String name, int year, int tonnage, boolean doubleHull) {

        // Call the superclass constructor (Ship),
        // passing the name and year as arguments.
        super(name, year);

        // Set tonnage.
        this.tonnage = tonnage;

        // Set whether double hull
        isDoubleHull = doubleHull;
    }

    /**
    setTonnage method
     */
    public void setTonnage(int tonnage) {
        this.tonnage = tonnage;
    }

    /**
    getTonnage method
     */
    public int getTonnage() {
        return tonnage;
    }

    /**
    toString method
     */
    public String toString() {
        return "Name: " + getName()
                + "\n   Type: Cargo"
                + "\n   Cargo capacity: " + tonnage + " tons"
                + "\n   Year built: " + getYearBuilt()
                + "\n   Double Hull: " + isDoubleHull;
    }
}