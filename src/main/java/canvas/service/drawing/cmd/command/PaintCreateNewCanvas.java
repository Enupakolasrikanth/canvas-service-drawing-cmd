package canvas.service.drawing.cmd.command;

import canvas.service.drawing.cmd.core.CanvasPaint;
import canvas.service.drawing.cmd.util.CanvasCostants;
import canvas.service.drawing.cmd.exception.CanvasPaintDrawException;

/**
 * Command used by the canvas for creating a new Canvas
 */
public class PaintCreateNewCanvas extends Paint {
	
	private int weight;
	private int height;
	private CanvasPaint canvas;
	
	private PaintCreateNewCanvas() {
		name = CanvasCostants.COMMAND_CREATE_CANVAS;
	}
	
	public PaintCreateNewCanvas(int w, int h) {
		this();
		weight = w;
		height = h;
	}
	
	@Override
	public void execute() throws CanvasPaintDrawException {
		canvas = new CanvasPaint(weight, height);
	}
	
	@Override
	public CanvasPaint getCanvas() {
		return canvas;
	}
	
}
