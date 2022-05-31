package canvas.service.drawing.cmd.exception;


/**
 * Thrown when calling a command not supported.
 * when trying to draw the line that is not horizontal and not even vertical.
 */
public class CommandNotImplementedException extends CanvasPaintDrawException {

	private static final long serialVersionUID = -8629000422659650854L;

	public CommandNotImplementedException(String message){
		super(message);
	}
}
