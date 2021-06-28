package mars.rover;

import org.junit.Test;

import mars.rover.pojo.Plateau;
import mars.rover.pojo.Position;
import mars.rover.pojo.Rover;
import mars.rover.util.OrientationCommand;
import mars.rover.util.exception.NotOnPlateauException;
import mars.rover.util.exception.UnknownInstructionException;

import static org.junit.Assert.*;

public class AppTest {

    private Plateau plateau = new Plateau(5, 5);

    @Test
    public void move_rover_dimension_change_successful() {
        
        Position position = new Position(1, 2, "N", plateau);

        Rover rover = new Rover("Rover 1", position, "LMLM");
        rover.runInstruction();

        String positionString = rover.getPosition().getX()+" "+rover.getPosition().getY()+" "+rover.getPosition().getCoord();
        
        assertEquals("0 1 S", positionString);

    }

    @Test(expected = NotOnPlateauException.class)
    public void move_rover_throws_not_in_plateau_error() {
        
        Position position = new Position(1, 2, "N", plateau);

        Rover rover = new Rover("Rover 1", position, "LMLMMMMMMMMM");
        rover.runInstruction();
    }

    @Test(expected = UnknownInstructionException.class)
    public void move_rover_throws_unknown_instruction_error() {
        
        Position position = new Position(1, 2, "N", plateau);

        Rover rover = new Rover("Rover 1", position, "LMLKMM");
        rover.runInstruction();
    }

    @Test
    public void test_left_orientation() {
        //rotate left from North
        Position northPosition = new Position(1, 2, "N", plateau);
        Rover northRover = new Rover("Rover 1", northPosition, "L");
        northRover.runInstruction();
        assertEquals(northRover.getPosition().getCoord(), OrientationCommand.valueOf("NL").getValue());

        //rotate left from West
        Position westPosition = new Position(1, 2, "W", plateau);
        Rover westRover = new Rover("Rover 1", westPosition, "L");
        westRover.runInstruction();
        assertEquals(westRover.getPosition().getCoord(), OrientationCommand.valueOf("WL").getValue());

        //rotate left from East
        Position eastPosition = new Position(1, 2, "E", plateau);
        Rover eastRover = new Rover("Rover 1", eastPosition, "L");
        eastRover.runInstruction();
        assertEquals(eastRover.getPosition().getCoord(), OrientationCommand.valueOf("EL").getValue());

        //rotate left from South
        Position southPosition = new Position(1, 2, "S", plateau);
        Rover southRover = new Rover("Rover 1", southPosition, "L");
        southRover.runInstruction();
        assertEquals(southRover.getPosition().getCoord(), OrientationCommand.valueOf("SL").getValue());
    }

    public void test_right_orientation() {
        //rotate right from North
        Position northPosition = new Position(1, 2, "N", plateau);
        Rover northRover = new Rover("Rover 1", northPosition, "R");
        northRover.runInstruction();
        assertEquals(northRover.getPosition().getCoord(), OrientationCommand.valueOf("NR").getValue());

        //rotate right from West
        Position westPosition = new Position(1, 2, "W", plateau);
        Rover westRover = new Rover("Rover 1", westPosition, "R");
        westRover.runInstruction();
        assertEquals(westRover.getPosition().getCoord(), OrientationCommand.valueOf("WR").getValue());

        //rotate right from East
        Position eastPosition = new Position(1, 2, "E", plateau);
        Rover eastRover = new Rover("Rover 1", eastPosition, "R");
        eastRover.runInstruction();
        assertEquals(eastRover.getPosition().getCoord(), OrientationCommand.valueOf("ER").getValue());

        //rotate right from South
        Position southPosition = new Position(1, 2, "S", plateau);
        Rover southRover = new Rover("Rover 1", southPosition, "R");
        southRover.runInstruction();
        assertEquals(southRover.getPosition().getCoord(), OrientationCommand.valueOf("SR").getValue());
    }
}
