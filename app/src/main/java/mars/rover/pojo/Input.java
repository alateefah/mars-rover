package mars.rover.pojo;

public class Input {

    private Plateau plateau;
    private Rover[] rovers;
    
    public void setPlateau(Plateau plateau) {
        this.plateau = plateau;
    }

    public Plateau getPlateau() {
        return plateau;
    }

    public void setRover(Rover[] rovers) {
        this.rovers = rovers;
    }

    public Rover[] getRovers() {
        return this.rovers;
    }

}
