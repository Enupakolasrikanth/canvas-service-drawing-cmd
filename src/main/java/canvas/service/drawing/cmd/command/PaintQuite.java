package canvas.service.drawing.cmd.command;

import canvas.service.drawing.cmd.core.CanvasPaint;
import canvas.service.drawing.cmd.util.CanvasCostants;
import canvas.service.drawing.cmd.exception.CanvasPaintDrawException;
import canvas.service.drawing.cmd.exception.QuitException;

/**
 * Command used for quite the canvas.
 */
public class PaintQuite extends Paint {
	
	private CanvasPaint canvas;
	
	private PaintQuite() {
		name = CanvasCostants.COMMAND_QUITE;
	}
	
	public PaintQuite(CanvasPaint canvas) {
		this();
		this.canvas = canvas;
	}

	@Override
	public void execute() throws CanvasPaintDrawException {
		throw new QuitException("Quiting the game!");
	}
	
	@Override
	public CanvasPaint getCanvas() {
		return canvas;
	}

}