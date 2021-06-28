package mars.rover.exception;

public class UnknownInstructionException extends RuntimeException {

	public UnknownInstructionException(String newInstruction) {
		super("Unknown instruction '" + newInstruction + "'!");
	}
	
}
