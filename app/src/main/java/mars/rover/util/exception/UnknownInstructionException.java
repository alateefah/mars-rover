package mars.rover.util.exception;

public class UnknownInstructionException extends RuntimeException {

	public UnknownInstructionException(String newInstruction) {
		super("Unknown instruction '" + newInstruction + "'!");
	}
	
}
