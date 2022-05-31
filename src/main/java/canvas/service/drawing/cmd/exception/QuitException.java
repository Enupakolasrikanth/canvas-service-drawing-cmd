package canvas.service.drawing.cmd.exception;

/**
 * General Canvas Exception. All application exceptions extends this class.
 */
public class QuitException extends CanvasPaintDrawException {

	private static final long serialVersionUID = 6056719373037617209L;

	public QuitException(String message){
		super(message);
	}
}
