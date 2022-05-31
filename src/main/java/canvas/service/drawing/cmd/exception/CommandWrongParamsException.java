package canvas.service.drawing.cmd.exception;

/**
 * Thrown when parameters inserted from command line are not correct.
 * coordinates outside the canvas.
 */
public class CommandWrongParamsException extends CanvasPaintDrawException {

	private static final long serialVersionUID = -862900567890450854L;

	public CommandWrongParamsException(String message){

		super(message);
	}
}
