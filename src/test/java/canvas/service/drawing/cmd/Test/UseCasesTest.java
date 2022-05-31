package canvas.service.drawing.cmd.Test;

import canvas.service.drawing.cmd.command.PaintLine;
import canvas.service.drawing.cmd.command.PaintRectangle;
import canvas.service.drawing.cmd.core.CanvasPaint;
import canvas.service.drawing.cmd.exception.CanvasPaintDrawException;
import canvas.service.drawing.cmd.exception.CommandWrongParamsException;
import org.junit.After;
import org.junit.Test;


/**
 * In this class are traced use cases which introduced errors in the test phase.
 */
public class UseCasesTest extends PaintTest {
	@After
	public void drillDown() {

		canvasPaint.clearCanvas();
	}

//	@Test
//	public void testHP_ParseBucketFillCommand() throws  CanvasPaintDrawException {
//		String cmdLine = "B 2 3 a";
//		Paint cmd = commandFactory.buildCommand(cmdLine, canvasPaint);
//		assertNotNull(cmd);
//		assertTrue(cmd instanceof PaintBucketFill);
//	}

	@Test(expected = CommandWrongParamsException.class)
	public void test_BucketFillWrongColor() throws CanvasPaintDrawException {
		String cmdLine = "B 1 3 sub";
		commandFactory.buildCommand(cmdLine, canvasPaint);
	}

	@Test
	public void testStars_1() throws CanvasPaintDrawException {
		PaintLine l = new PaintLine(1, 1, 18, 1, canvasPaint);
		int stars = (18 - 1) + 1;
		canvasPaint.insertLine(l);
		canvasPaint.printCanvas();
		assertExpected(canvasPaint, stars);

		l = new PaintLine(3, 2, 3, 3, canvasPaint);
		stars = stars + 2;
		canvasPaint.insertLine(l);
		canvasPaint.printCanvas();
		assertExpected(canvasPaint,stars);

		PaintRectangle r = new PaintRectangle(3, 2, 8, 3, canvasPaint);
		stars = stars + 10;
		canvasPaint.insertRectangle(r);
		canvasPaint.printCanvas();
		assertExpected(canvasPaint,stars);
	}
	
	@Test(expected = CommandWrongParamsException.class)
	public void testEX_newCanvasExceedWidthDimmension() throws CanvasPaintDrawException {
		canvasPaint = new CanvasPaint(251, 10);
	}
	@Test(expected = CommandWrongParamsException.class)
	public void testEX_newCanvasExceedHeightDimmension() throws CanvasPaintDrawException {
		canvasPaint = new CanvasPaint(10, 61);
	}
	@Test(expected = CommandWrongParamsException.class)
	public void testEX_newCanvasExceedWidthDimmension_secondCostructor() throws CanvasPaintDrawException {
		canvasPaint = new CanvasPaint(251, 10, new String[251][10]);
	}
	@Test(expected = CommandWrongParamsException.class)
	public void testEX_newCanvasExceedHeightDimmension_secondCostructor() throws CanvasPaintDrawException {
		canvasPaint = new CanvasPaint(10, 61);
		canvasPaint = new CanvasPaint(10, 61, new String[10][51]);
	}
	
}