
public class Grasshopper extends Insect {

    private double jumpDistance;

    /**
     * The constructor
     */
    public Grasshopper() {
    }

    /**
     * sets jump distance
     * @param dist double representing jump distance
     */
    public void setJumpDist(double dist) {
        jumpDistance = dist;
    }

    /**
     * Returns jump distance
     * @return jumpDistance
     */
    public double getJumpDist() {
        return jumpDistance;
    }
}

