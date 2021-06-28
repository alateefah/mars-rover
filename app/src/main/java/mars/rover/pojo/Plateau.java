package mars.rover.pojo;

/**
 * Plateau
 */
public class Plateau {

    private int dimX;
	private int dimY;

    public Plateau(int dimX, int dimY) {
        this.dimX = dimX;
        this.dimY = dimY;
    }

    public void setDimX(int dimX) {
        this.dimX = dimX;
    }

    public int getDimX() {
        return this.dimX;
    }

    public void setDimY(int dimY) {
        this.dimY = dimY;
    }

    public int getDimY() {
        return this.dimY;
    }

}