package mars.rover.util;

public class RawRover {
    
    private String coordinate;
    private String instructions;

    public void setCoordinates(String coordinate) {
        this.coordinate = coordinate;
    }

    public String getCoordinates() {
        return this.coordinate;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public String getInstructions() {
        return this.instructions;
    }
}
