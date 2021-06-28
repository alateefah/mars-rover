package mars.rover.util.exception;

import mars.rover.pojo.Plateau;
import mars.rover.pojo.Position;

public class NotOnPlateauException extends RuntimeException {
    
    public NotOnPlateauException(Plateau plateau, Position position) {
		super("Position not in Plateau.");
	}

}
