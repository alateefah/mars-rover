package mars.rover.util;

import mars.rover.pojo.Input;
import mars.rover.pojo.Plateau;
import mars.rover.pojo.Rover;
import mars.rover.pojo.Position;

import java.util.ArrayList;
import java.util.List;

public class InputFileProcessor {
    
    private String plateau;
    private ArrayList<RawRover> rawRovers = new ArrayList<>();

    public InputFileProcessor(List<String> data) {
        this.plateau = data.get(0);

        for(int i = 1; i < data.size(); i += 2) {

            RawRover rawRover = new RawRover();
            
            rawRover.setCoordinates(data.get(i));
            rawRover.setInstructions(data.get(i+1));

            rawRovers.add(rawRover);
        }
    }

    public Input getCleanInput() {
        Input cleanInput = new Input();
        
        // create Plateau
        String plateauDimensionString = this.plateau.split(":")[1];
        String[] dimensionString = plateauDimensionString.split(" ");

        Plateau plateau = new Plateau(Integer.parseInt(dimensionString[0]), Integer.parseInt(dimensionString[1]));

        cleanInput.setPlateau(plateau);

        //create Rover[]
        Rover[] cleanRovers = new Rover[this.rawRovers.size()];
        int x = 0;
        for(int i = 0; i < this.rawRovers.size(); i++) {

            String roverNameString = this.rawRovers.get(i).getCoordinates().split(":")[0];
            String roverName = roverNameString.split(" ")[0];

            String roverPositionString = this.rawRovers.get(i).getCoordinates().split(":")[1];
            String[] roverPositionArray = roverPositionString.split(" ");
            //create position
            Position roverPosition = new Position(Integer.parseInt(roverPositionArray[0]), Integer.parseInt(roverPositionArray[1]), roverPositionArray[2], plateau);
            
            String roverInstructionString = this.rawRovers.get(i).getInstructions().split(":")[1];

            Rover rover = new Rover(roverName, roverPosition, roverInstructionString);

            cleanRovers[x] = rover;
            x++;
        }
        cleanInput.setRover(cleanRovers);

        return cleanInput;
    }
}

