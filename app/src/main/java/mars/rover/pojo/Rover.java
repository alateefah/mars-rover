package mars.rover.pojo;

import mars.rover.exception.UnknownInstructionException;
import mars.rover.util.OrientationCommand;

public class Rover {
    
    private String roverName;
    private Position position;
    private String instructions;

    public Rover(String name, Position position, String instructions) {
		this.roverName = name;
        this.position = position;
        this.instructions = instructions;
	}

    public void setRoverName(String roverName) {
        this.roverName = roverName;
    }

    public String getRoverName() {
        return roverName;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }

    public void setInstruction(String instructions) {
        this.instructions = instructions;
    }

    public String getInstructions() {
        return this.instructions;
    }

    public Rover runInstruction() {   
        String[] instructionArray = this.instructions.split("");
        for (int x = 0; x < instructionArray.length; x++) {
            String instruction = instructionArray[x];            
            switch (instruction) {
                case "L": 
                case "R": 
                    Position pos = new Position(this.position.getX(), this.position.getY(), rotate(this.position.getCoord(), instruction), this.position.getPlateau());
                    this.setPosition(pos);    
                    break;           
                case "M": 
                    this.setPosition(this.position.move());
                    break;
                default: throw new UnknownInstructionException(instruction);
            }
        }
        return this;  
    }

    private static String rotate(String dir, String command) {
        String val = dir+command;
        OrientationCommand cmd = OrientationCommand.valueOf(val);
        return cmd.getValue(); 
    }

}
