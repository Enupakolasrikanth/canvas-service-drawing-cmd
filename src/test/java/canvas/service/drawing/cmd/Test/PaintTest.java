package canvas.service.drawing.cmd.Test;

import canvas.service.drawing.cmd.core.CanvasPaint;
import canvas.service.drawing.cmd.util.CanvasCostants;
import canvas.service.drawing.cmd.exception.CanvasPaintDrawException;
import canvas.service.drawing.cmd.service.PaintFactory;
import canvas.service.drawing.cmd.service.PaintFactoryImpl;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.After;
import org.junit.Before;

import static org.junit.Assert.assertEquals;

public abstract class PaintTest {
	
	protected static final transient Log logger = LogFactory.getLog(CommandRectangleTest.class);
	protected CanvasPaint canvasPaint;
	protected int width = 20;
	protected int height = 4;
	protected PaintFactory commandFactory;

	@Before
	public void InitialSetUp() {
		commandFactory = new PaintFactoryImpl();
		try {
			canvasPaint = new CanvasPaint(width, height);
		} catch (CanvasPaintDrawException e) {
			logger.error("Exception while initializing Canvas log: " + e.getMessage(), e);
		}
	}

	@After
	public void postComplete() {
		canvasPaint.printCanvas();
		canvasPaint.clearCanvas();
	}

	/**
	 * Counts the 'pixels' present in the canvas and compare it with the expected value.
	 */
	protected void assertExpected(CanvasPaint canvas, String pixels, int expected) throws CanvasPaintDrawException {
		String mat[][] = canvas.getMatrix();
		int found = 0;
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[i].length; j++) {
				// count  the 'x' (or 'o')  in the matrix.
				if (mat[i][j].equals(pixels)) {
					found++;
				}
			}
		}

		assertEquals(expected, found);
	}
	
	protected void assertExpected(CanvasPaint canvas, int expected) throws CanvasPaintDrawException {
		assertExpected(canvas, CanvasCostants.PIXEL, expected);
	}
	
}
