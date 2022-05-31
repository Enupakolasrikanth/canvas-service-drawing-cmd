package canvas.service.drawing.cmd.command;

import canvas.service.drawing.cmd.core.CanvasPaint;
import canvas.service.drawing.cmd.util.CanvasCostants;
import canvas.service.drawing.cmd.exception.CanvasPaintDrawException;
import canvas.service.drawing.cmd.exception.CanvasPaintNotCreatedException;

/**
 * Command used by the Canvas for filling the area around a given coordinate.
 * Same as "bucket fill" tool in paint programs.
 */
public class PaintBucketFill extends Paint {

	private CanvasPaint canvas;
	private int x;
	private int y;
	private String color;
	
	private PaintBucketFill() {
		name = CanvasCostants.COMMAND_FILL;
	}
	
	public PaintBucketFill(int x, int y, String color, CanvasPaint canvas) {
		this();
		this.x = x;
		this.y = y;
		this.color = color;
		this.canvas = canvas;
	}
	
	@Override
	public void execute() throws CanvasPaintDrawException {
		if(canvas == null){
			throw new CanvasPaintNotCreatedException("First create a new Canvas using 'C' command. Insert '"+ CanvasCostants.COMMAND_HELP+"' for Help.\n");
		}
		canvas.fillBucket(this);
	}
	
	@Override
	public CanvasPaint getCanvas() {
		return canvas;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public String getColor() {
		return color;
	}
	
}