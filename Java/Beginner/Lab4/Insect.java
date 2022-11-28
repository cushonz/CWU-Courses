
/**
 * @author      Filip Jagodzinski
 * @version     1.123
 * @since       2013-1-6
 */
public class Insect {

    // fields
    private int lifeSpanDays;
    private int numLegs;
    
    public int numLegs() {
     return 6;
     }

    // methods
    /**
     * The constructor.
     * 
     * Sets the numLegs field to 6.
     */
    public Insect() {
        numLegs = 6;
    }

    /**
     * This setter method sets the value of the lifeSpanDays
     * instance field.
     * 
     * @param days the lifespan of the insect
     */
    public void setLifeSpanDays(int days) {
        lifeSpanDays = days;
    }

    /**
     * This getter method retrieves the instance field
     * numLegs
     * 
     * @return The number of legs of the Insect object
     */
    public int getNumLegs() {
        return numLegs;
    }

    /**
     * This getter method retrieves the instance field
     * lifeSpanDays
     * 
     * @return The lifespan (int) of the Insect object
     */
    public int getLifeSpan() {
        return lifeSpanDays;
    }
}