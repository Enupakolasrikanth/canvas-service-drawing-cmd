package canvas.service.drawing.cmd.command;

import canvas.service.drawing.cmd.core.CanvasPaint;
import canvas.service.drawing.cmd.util.CanvasCostants;
import canvas.service.drawing.cmd.exception.CanvasPaintDrawException;
import canvas.service.drawing.cmd.exception.CanvasPaintNotCreatedException;

/**
 * Represents the command for drawing a line in the canvas. 
 * A line is represented by two points connected together. Line from (x1,y1) to (x2,y2).
 */
public class PaintLine extends Paint {

	private CanvasPaint canvas;
	private int x1;
	private int x2;
	private int y1;
	private int y2;

	private PaintLine() {
		name = CanvasCostants.COMMAND_LINE;
	}

	public PaintLine(int x1, int y1, int x2, int y2, CanvasPaint canvas) {
		this();
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		this.canvas = canvas;
	}

	@Override
	public void execute() throws CanvasPaintDrawException {
		if (canvas == null) {
			throw new CanvasPaintNotCreatedException("First create a new Canvas using 'C' command. Insert '" + CanvasCostants.COMMAND_HELP + "' for Help.\n");
		}
		canvas.insertLine(this);
	}

	@Override
	public CanvasPaint getCanvas() {
		return canvas;
	}

	public int getX1() {
		return x1;
	}

	public int getY1() {
		return y1;
	}

	public int getX2() {
		return x2;
	}

	public int getY2() {
		return y2;
	}

	public String toString() {
		String rv = "CommandLine[(" + x1 + ", " + y1 + "), (" + x2 + ", " + y2 + ")]";
		return rv;
	}

}