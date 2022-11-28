
/**
 * @author      Filip Jagodzinski
 * @version     1.123
 * @since       2013-1-6
 */
public class Beetle extends Insect {

    // fields
    private boolean hasSingleClaw;
    private boolean isABigStink;

    // methods
    /**
     * The constructor.
     * 
     * Takes as input a single argument, of type boolean
     * @param singleClaw if the Beetle has a single claw
     */
    public Beetle(boolean singleClaw) {
        hasSingleClaw = singleClaw;


    }

    /**
     * This setter method sets the value of the isABigSting
     * instance field.
     * 
     * @param howStinky whether the Beetle is or is not a stink bug
     */
    public void setStink(int howStinky) {
        switch (howStinky) {
            case 1:
            case 2:
            case 3:
                isABigStink = false;
                break;
            default:
                isABigStink = true;
        }
    }

    /**
     * This getter method retrieves the value of the isABigStink
     * instance field.
     * 
     * @return Whether the Beetle is a stink bug
     */
    public boolean getIsABigStink() {
        return isABigStink;
    }
}