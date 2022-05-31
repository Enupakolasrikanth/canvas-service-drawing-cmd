package canvas.service.drawing.cmd.command;

import canvas.service.drawing.cmd.core.CanvasPaint;
import canvas.service.drawing.cmd.util.CanvasCostants;
import canvas.service.drawing.cmd.exception.CanvasPaintDrawException;

/**
 * Help command
 */
public class PaintHelp extends Paint {
	
	private CanvasPaint canvas;

	private PaintHelp() {
		name = CanvasCostants.COMMAND_HELP;
	}
	public PaintHelp(CanvasPaint canvas) {
		this();
		this.canvas = canvas;
	}
	@Override
	public void execute() throws CanvasPaintDrawException {
		printHelp();
	}
	@Override
	public CanvasPaint getCanvas() {
		return canvas;
	}
	
	private void printHelp() {
		System.out.println("");
		System.out.println("------start-------");
		System.out.println("C w h - Create a new canvas of width w and height h.");
		System.out.println("L x1 y1 x2 y2 - Create a new line from (x1,y1) to (x2,y2).");
		System.out.println("R x1 y1 x2 y2 - Create a new rectangle, whose upper left corner is (x1,y1) and lower right corner is (x2,y2).");
		System.out.println("B x y c - Fill the area connected to (x,y) with 'color' c.");
		System.out.println("X - Clear the canvas.");
		System.out.println("H - Help.");
		System.out.println("Q - Quit the program.");
		System.out.println("--------end------");
	}

}
