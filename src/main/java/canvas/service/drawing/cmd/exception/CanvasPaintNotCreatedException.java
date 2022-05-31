package canvas.service.drawing.cmd.exception;

/**
 * Thrown when cannot build a command starting from the input string inserted by the user.
 */
public class CanvasPaintNotCreatedException extends CanvasPaintDrawException {

	private static final long serialVersionUID = -862900385678954L;
	public CanvasPaintNotCreatedException(String message){
		super(message);
	}
}
