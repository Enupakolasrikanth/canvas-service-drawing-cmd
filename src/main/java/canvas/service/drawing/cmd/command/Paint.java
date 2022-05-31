package canvas.service.drawing.cmd.command;

import canvas.service.drawing.cmd.core.CanvasPaint;
import canvas.service.drawing.cmd.exception.CanvasPaintDrawException;

/**
 * Each command must extends this class so must provide at least the name, canvas status, and execute method.
 */
public abstract class Paint {
	
	protected String name;
	public abstract void execute() throws CanvasPaintDrawException;
	public abstract CanvasPaint getCanvas();
	
}
