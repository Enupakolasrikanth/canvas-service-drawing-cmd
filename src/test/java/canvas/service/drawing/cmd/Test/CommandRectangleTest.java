package canvas.service.drawing.cmd.Test;

import canvas.service.drawing.cmd.command.PaintRectangle;
import canvas.service.drawing.cmd.exception.CanvasPaintDrawException;
import canvas.service.drawing.cmd.exception.CommandWrongParamsException;
import org.junit.Test;

public class CommandRectangleTest extends PaintTest {

	/**
	 * Inserts a rectangles which covers the borders of the canvas.
	 * Tests the presence of the starts all around the borders and counts the total number of stars.
	 */
	@Test
	public void test_CoverBorderWithStars() throws CanvasPaintDrawException {
		int x1 = 1, y1 = 1, x2 = width, y2 = height;
		PaintRectangle cmd = new PaintRectangle(x1, x1, width, height, canvasPaint);
		canvasPaint.insertRectangle(cmd);
		int expected = (x2 - x1) * 2 + (y2 - y1) * 2;
		assertExpected(canvasPaint, expected);
	}

	@Test
	public void test_X1EqualsX2() throws CanvasPaintDrawException {
		int x1 = 3, y1 = 1, x2 = 3, y2 = 4;
		PaintRectangle cmd = new PaintRectangle(x1, y1, x2, y2, canvasPaint);
		canvasPaint.insertRectangle(cmd);
		
		int expected = (y2 - y1) + 1;
		assertExpected(canvasPaint, expected);
	}

	@Test
	public void test_Y1EqualY2() throws CanvasPaintDrawException {
		int x1 = 1, y1 = 1, x2 = 14, y2 = 1;
		PaintRectangle cmd = new PaintRectangle(x1, y1, x2, y2, canvasPaint);
		canvasPaint.insertRectangle(cmd);

		int expected = (x2 - x1) + 1;
		assertExpected(canvasPaint, expected);
	}

	@Test(expected = CommandWrongParamsException.class)
	public void test_X1GreaterThanX2() throws CanvasPaintDrawException {
		PaintRectangle cmd = new PaintRectangle(16, 1, 14, 3, canvasPaint);
		canvasPaint.insertRectangle(cmd);
	}

	@Test(expected = CommandWrongParamsException.class)
	public void test_X1EqualsZero() throws CanvasPaintDrawException {
		PaintRectangle cmd = new PaintRectangle(0, 1, 20, 3, canvasPaint);
		canvasPaint.insertRectangle(cmd);
	}
	@Test(expected = CommandWrongParamsException.class)
	public void testEX_YLessThanZero() throws CanvasPaintDrawException {
		PaintRectangle cmd = new PaintRectangle(16, -1, 20, 3, canvasPaint);
		canvasPaint.insertRectangle(cmd);
	}
	// vertical lines
	@Test(expected = CommandWrongParamsException.class)
	public void test_EqualsZero() throws CanvasPaintDrawException {
		PaintRectangle cmd = new PaintRectangle(16, 0, 20, 3, canvasPaint);
		canvasPaint.insertRectangle(cmd);
	}

}
