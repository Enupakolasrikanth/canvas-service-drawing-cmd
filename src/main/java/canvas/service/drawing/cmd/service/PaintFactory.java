package canvas.service.drawing.cmd.service;

import canvas.service.drawing.cmd.core.CanvasPaint;
import canvas.service.drawing.cmd.command.Paint;
import canvas.service.drawing.cmd.exception.CanvasPaintDrawException;

/**
 * PaintFactory for creating Command objects.
 */
public interface PaintFactory {
	
	/**
	 * Factory which creates Command objects starting from the string inserted as input.
	 * The commands handled by the application are the following:
	 * 
	 * C w h         -  Create a new canvas of width (w) and height (h).
	 * L x1 y1 x2 y2 - Create a new line from (x1,y1) to (x2,y2).
	 * R x1 y1 x2 y2 - Create a new rectangle, whose upper left corner is (x1,y1) and lower right corner is (x2,y2).
	 * B x y c       - Fill the entire area connected to (x,y) with "color" c.
	 * Q             - Quit the program.
	 * H             - Help.
	 * 
	 * @param line Input string to parse as command
	 * @param canvas 
	 * @return the command object created from the string input
	 * @throws CanvasPaintDrawException If the string input cannot be converted to a command input
	 */
	public Paint buildCommand(String line, CanvasPaint canvas) throws CanvasPaintDrawException;
	
}
