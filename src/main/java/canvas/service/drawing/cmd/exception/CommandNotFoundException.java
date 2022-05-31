package canvas.service.drawing.cmd.exception;

/**
 * Thrown when cannot build a command  from the user input.
 */
public class CommandNotFoundException extends CanvasPaintDrawException {

	private static final long serialVersionUID = -862900384850854L;

	public CommandNotFoundException(String message){
		super(message);
	}
}
