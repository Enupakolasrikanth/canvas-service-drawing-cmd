package canvas.service.drawing.cmd;


import canvas.service.drawing.cmd.command.Paint;
import canvas.service.drawing.cmd.core.CanvasPaint;
import canvas.service.drawing.cmd.exception.CanvasPaintDrawException;
import canvas.service.drawing.cmd.exception.QuitException;
import canvas.service.drawing.cmd.service.PaintFactory;
import canvas.service.drawing.cmd.service.PaintFactoryImpl;
import canvas.service.drawing.cmd.util.CanvasCostants;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.Closeable;
import java.util.Scanner;

/**
 * Main class for starting the application. Tests the application in an interactive mode via command.
 */
public class CanvasPaintApp {

	protected static final transient Log logger = LogFactory.getLog(CanvasPaintApp.class);
	private Scanner sc;
	private PaintFactory commandFactory;
	private Paint command;
	
	public CanvasPaintApp(){
		commandFactory = new PaintFactoryImpl();
		sc = new Scanner(System.in);
	}

	public static void main(String[] args) {
		CanvasPaintApp app = new CanvasPaintApp();
		app.run();
	}

	private void run() {
		boolean isExit = false;
		CanvasPaint canvas = null;
		try {
			canvas = new CanvasPaint(0, 0);
		} catch (CanvasPaintDrawException e) {
			logger.error("Exception initializing Canvas: " + e.getMessage(), e);
			System.out.println("Exception initializing Canvas: " + e.getMessage());
		}
		
		do {
			try {
				System.out.print("enter command: ");
				String line = sc.nextLine();
				command = commandFactory.buildCommand(line, canvas);
				command.execute();
				canvas = command.getCanvas(); 
				canvas.printCanvas();
			} catch (QuitException e) {
				isExit = true;
				System.out.println("Thank you for trying out Canvas Application");
			} catch (CanvasPaintDrawException e) {
				System.out.println("CanvasDrawException : " + e.getMessage());
			    System.out.println("Insert '" + CanvasCostants.COMMAND_HELP + "' for Help.\n");
			} catch (Exception e) {
				System.out.println("Exception: " + e.getMessage());
			    System.out.println("Insert '" + CanvasCostants.COMMAND_HELP + "' for Help.\n");
			}
		} while (!isExit);

		closeResource(sc);
	}

	private static void closeResource(Closeable sc) {
		try {
			sc.close();
		} catch (Exception e) {
			System.out.println("Cannot close the console! e: " + e.getMessage());
		}
	}

}
