package canvas.service.drawing.cmd.command;

import canvas.service.drawing.cmd.core.CanvasPaint;
import canvas.service.drawing.cmd.util.CanvasCostants;
import canvas.service.drawing.cmd.exception.CanvasPaintDrawException;
import canvas.service.drawing.cmd.exception.CanvasPaintNotCreatedException;

public class PaintClearCanvas extends Paint {
	
	private CanvasPaint canvas;
	
	private PaintClearCanvas() {
		name = CanvasCostants.COMMAND_CLEAR;
	}
	public PaintClearCanvas(CanvasPaint canvas) {
		this();
		this.canvas = canvas;
	}


	@Override
	public void execute() throws CanvasPaintDrawException {
		if(canvas == null){
			throw new CanvasPaintNotCreatedException("First create a new Canvas using 'C' command. Insert '"+ CanvasCostants.COMMAND_HELP+"' for Help.\n");
		}
		canvas.clearCanvas();
	}
	
	@Override
	public CanvasPaint getCanvas() {

		return canvas;
	}
}
