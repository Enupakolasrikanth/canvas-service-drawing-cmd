package canvas.service.drawing.cmd.service;

import canvas.service.drawing.cmd.command.*;
import canvas.service.drawing.cmd.core.CanvasPaint;
import canvas.service.drawing.cmd.util.CanvasCostants;
import canvas.service.drawing.cmd.exception.CanvasPaintDrawException;
import canvas.service.drawing.cmd.exception.CommandNotFoundException;
import canvas.service.drawing.cmd.exception.CommandWrongParamsException;

/**
 * CommandFactory implementation for creating Command objects.
 */
public class PaintFactoryImpl implements PaintFactory {
	 
	@Override 
	public Paint buildCommand(String line, CanvasPaint canvas) throws CanvasPaintDrawException {
		Paint cmd = null;
		line = line.trim();
		String sp[] = line.split("\\s+");//to determine space
		if (sp.length == 0) {
			throw new CommandWrongParamsException("Wrong command! Try one of the following: C w h; L x1 y1 x2 y2; R x1 y1 x2 y2; B x y c and Q for quit.");
		}
		
		if (sp[0].equalsIgnoreCase(CanvasCostants.COMMAND_CREATE_CANVAS)) {
			// Canvas weight height (c w h)
			if (sp.length != 3) {
				throw new CommandWrongParamsException("Wrong Parameters! For creating new canvas try 'C w h',  example: 'C 40 20'");
			} else {
				try {
					int w = Integer.parseInt(sp[1]);
					int h = Integer.parseInt(sp[2]);
					cmd = new PaintCreateNewCanvas(w, h);
				} catch (Exception e) {
					throw new CommandWrongParamsException("Weight and Height must be numbers! Example: 'C 40 20'");
				}
			}
		} else if (sp[0].equalsIgnoreCase(CanvasCostants.COMMAND_LINE)) {
			// L x1 y1 x2 y2
			if (sp.length != 5) {
				throw new CommandNotFoundException("Wrong Parameters! For drawing a line try 'L x1 y1 x2 y2',  example: 'L 1 2 6 2'");
			} else {
				try {
					int x1 = Integer.parseInt(sp[1]);
					int y1 = Integer.parseInt(sp[2]);
					int x2 = Integer.parseInt(sp[3]);
					int y2 = Integer.parseInt(sp[4]);
					cmd = new PaintLine(x1, y1, x2, y2, canvas);
				} catch (Exception e) {
					throw new CommandWrongParamsException("Coordinates must be numbers! Example: 'L 2 2 8 2'");
				}
			}
		} else if (sp[0].equalsIgnoreCase(CanvasCostants.COMMAND_RECTANGLE)) {
			// R x1 y1 x2 y2
			if (sp.length != 5) {
				throw new CommandNotFoundException("Wrong Parameters! For drawing a Rectangle try 'R x1 y1 x2 y2',  example: 'R 1 1 6 3'");
			} else {
				try {
					int x1 = Integer.parseInt(sp[1]);
					int y1 = Integer.parseInt(sp[2]);
					int x2 = Integer.parseInt(sp[3]);
					int y2 = Integer.parseInt(sp[4]);
					cmd = new PaintRectangle(x1, y1, x2, y2, canvas);
				} catch (Exception e) {
					throw new CommandWrongParamsException("Coordinates must be numbers! Example: 'R 1 1 9 4'");
				}
			}
		} else if (sp[0].equalsIgnoreCase(CanvasCostants.COMMAND_FILL)) {
			// B x y c
			if (sp.length != 4) {
				throw new CommandNotFoundException("Wrong Parameters! For filling an area try 'B x1 y1 color',  example: 'B 2 3 c'");
			} else {
				int x = -1;
				int y = -1;
				try{
					x = Integer.parseInt(sp[1]);
					y = Integer.parseInt(sp[2]);
				} catch (Exception e) { 
					throw new CommandWrongParamsException("Coordinates must be numbers! Example: 'B 2 3 c'");
				}
				
				String color = sp[3];
				if(color.length() > 1){
					throw new CommandWrongParamsException("Wrong Parameters! Color must be a single character. Example: 'B 2 3 c'");
				}
				cmd = new PaintBucketFill(x, y, color, canvas);
			}
		} else if (sp[0].equalsIgnoreCase(CanvasCostants.COMMAND_QUITE)) {
			cmd = new PaintQuite(canvas);
		} else if (sp[0].equalsIgnoreCase(CanvasCostants.COMMAND_HELP)) {
			cmd = new PaintHelp(canvas);
		} else if (sp[0].equalsIgnoreCase(CanvasCostants.COMMAND_CLEAR)) {
			cmd = new PaintClearCanvas(canvas);
		} else {
			throw new CommandNotFoundException("Command not found! The line must start with letter: 'C', 'L', 'R, 'B' or 'Q' for exit.");
		}

		return cmd;
	}

}
