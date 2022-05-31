package canvas.service.drawing.cmd.exception;

/**
 * General Canvas Exception. All application exceptions extends this class.
 */
public class CanvasPaintDrawException extends Exception{

	private static final long serialVersionUID = -8638000422653848838L;

	public CanvasPaintDrawException(String message){
		super(message);
	}
}
