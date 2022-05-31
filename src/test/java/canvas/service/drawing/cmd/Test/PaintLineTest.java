package canvas.service.drawing.cmd.Test;

import canvas.service.drawing.cmd.command.PaintLine;
import canvas.service.drawing.cmd.exception.CanvasPaintDrawException;
import canvas.service.drawing.cmd.exception.CommandNotImplementedException;
import canvas.service.drawing.cmd.exception.CommandWrongParamsException;
import canvas.service.drawing.cmd.util.CanvasCostants;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PaintLineTest extends PaintTest {

	protected static final transient Log logger = LogFactory.getLog(PaintLineTest.class);

	@Test
	public void testHP_leftBorder() throws CanvasPaintDrawException {
		// left column
		PaintLine cmd = new PaintLine(1, 1, 1, height, canvasPaint);
		canvasPaint.insertLine(cmd);

		String mat[][] = canvasPaint.getMatrix();
		int countPoints = 0;
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[i].length; j++) {
				// check if first column contains only 'x' elements
				if (j == 0) {
					assert (mat[i][j].equals(CanvasCostants.PIXEL));
				}
				// count all the 'x' present in the matrix.
				if (mat[i][j].equals(CanvasCostants.PIXEL)) {
					countPoints++;
				}
			}
		}
		assertEquals(height, countPoints);
	}

	@Test
	public void testHP_upperBorder() throws CanvasPaintDrawException {
		PaintLine cmd = new PaintLine(1, 1, width, 1, canvasPaint);
		canvasPaint.insertLine(cmd);

		String mat[][] = canvasPaint.getMatrix();
		int countPoints = 0;
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[i].length; j++) {
				// check if first row contains only 'x' elements
				if (i == 0) {
					assert (mat[i][j].equals(CanvasCostants.PIXEL));
				}
				// count all the 'x' present in the matrix.
				if (mat[i][j].equals(CanvasCostants.PIXEL)) {
					countPoints++;
				}
			}
		}
		assertEquals(width, countPoints);
	}

	@Test
	public void testHP_rightBorder() throws CanvasPaintDrawException {
		// right column
		PaintLine cmd = new PaintLine(width, 1, width, height, canvasPaint);
		canvasPaint.insertLine(cmd);

		String mat[][] = canvasPaint.getMatrix();
		int countPoints = 0;
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[i].length; j++) {
				// check if last column contains only 'x' elements
				if (j == mat[i].length - 1) {
					assert (mat[i][j].equals(CanvasCostants.PIXEL));
				}
				// count all the 'x' present in the matrix.
				if (mat[i][j].equals(CanvasCostants.PIXEL)) {
					countPoints++;
				}
			}
		}
		assertEquals(height, countPoints);
	}

	@Test
	public void testHP_bottomBorder() throws CanvasPaintDrawException {
		// bottom row
		PaintLine cmd = new PaintLine(1, height, width, height, canvasPaint);
		canvasPaint.insertLine(cmd);

		String mat[][] = canvasPaint.getMatrix();
		int countPoints = 0;
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[i].length; j++) {
				// check if last row contains only 'x' elements
				if (i == mat.length - 1) {
					assert (mat[i][j].equals(CanvasCostants.PIXEL));
				}
				// count all the 'x' present in the matrix.
				if (mat[i][j].equals(CanvasCostants.PIXEL)) {
					countPoints++;
				}
			}
		}
		assertEquals(width, countPoints);
	}

	/**
	 * Inserts 4 lines which covers the borders of the canvas. First row, last row, first column and the last column. 
	 * Tests the presence of the 'x' all around the borders and counts the total number of 'x'.
	 */
	@Test
	public void testHP_CoverBordersWithLines() throws CanvasPaintDrawException {
		// left side column
		PaintLine cmd = new PaintLine(1, 1, 1, height, canvasPaint);
		canvasPaint.insertLine(cmd);

		// upper side row
		cmd = new PaintLine(1, 1, width, 1, canvasPaint);
		canvasPaint.insertLine(cmd);

		// right side column
		cmd = new PaintLine(width, 1, width, height, canvasPaint);
		canvasPaint.insertLine(cmd);

		// bottom  row
		cmd = new PaintLine(1, height, width, height, canvasPaint);
		canvasPaint.insertLine(cmd);

		// Testing the created canvas
		String mat[][] = canvasPaint.getMatrix();
		int countPoints = 0;
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[i].length; j++) {
				// check if first and last row contains only 'x' elements
				if (i == 0 || i == mat.length - 1) {
					assert (mat[i][j].equals(CanvasCostants.PIXEL));
				}

				// check if first and last column contains only 'x' elements
				if (j == 0 || j == mat[i].length - 1) {
					assert (mat[i][j].equals(CanvasCostants.PIXEL));
				}

				// count all the 'x' present in the matrix.
				if (mat[i][j].equals(CanvasCostants.PIXEL)) {
					countPoints++;
				}
			}
		}

		int mustBe = (width * 2) + (height * 2) - 4; // 2 rows + 2 columns - 4 corners
		assertEquals(mustBe, countPoints);
	}

	@Test(expected = CommandNotImplementedException.class)
	public void testEX_NotVerticalLine() throws CanvasPaintDrawException {
		PaintLine cmd = new PaintLine(6, 2, 7, 4, canvasPaint);
		canvasPaint.insertLine(cmd);
	}

	@Test(expected = CommandWrongParamsException.class)
	public void testEX_X1GreaterThanX2() throws CanvasPaintDrawException {
		PaintLine cmd = new PaintLine(4, 2, 1, 2, canvasPaint);
		canvasPaint.insertLine(cmd);
	}

	@Test(expected = CommandWrongParamsException.class)
	public void testEX_X1LessThanZero() throws CanvasPaintDrawException {
		PaintLine cmd = new PaintLine(-2, 2, 6, 2, canvasPaint);
		canvasPaint.insertLine(cmd);
	}

	@Test(expected = CommandWrongParamsException.class)
	public void testEX_X1EqualZero() throws CanvasPaintDrawException {
		PaintLine cmd = new PaintLine(0, 2, 6, 2, canvasPaint);
		canvasPaint.insertLine(cmd);
	}

	@Test(expected = CommandWrongParamsException.class)
	public void testEX_X2GreaterThanWidth() throws CanvasPaintDrawException {
		PaintLine cmd = new PaintLine(1, 2, width + 1, 2, canvasPaint);
		canvasPaint.insertLine(cmd);
	}

	@Test
	public void testCL_X2EqualWidth() throws CanvasPaintDrawException {
		PaintLine cmd = new PaintLine(6, 2, width, 2, canvasPaint);
		canvasPaint.insertLine(cmd);
		assertExpected(canvasPaint, (width - 6) + 1);
	}

	@Test(expected = CommandWrongParamsException.class)
	public void testEX_YLessThanZero() throws CanvasPaintDrawException {
		PaintLine cmd = new PaintLine(1, -2, 6, -2, canvasPaint);
		canvasPaint.insertLine(cmd);
	}

	@Test(expected = CommandWrongParamsException.class)
	public void testEX_YEqualZero() throws CanvasPaintDrawException {
		PaintLine cmd = new PaintLine(1, 0, 6, 0, canvasPaint);
		canvasPaint.insertLine(cmd);
	}

	@Test(expected = CommandWrongParamsException.class)
	public void testEX_YGreaterThanHeight() throws CanvasPaintDrawException {
		PaintLine cmd = new PaintLine(1, height + 1, 6, height + 1, canvasPaint);
		canvasPaint.insertLine(cmd);
	}

	@Test
	public void test_X1X2EqualWidth() throws CanvasPaintDrawException {
		PaintLine cmd = new PaintLine(width, 3, width, 4, canvasPaint);
		canvasPaint.insertLine(cmd);
		assertExpected(canvasPaint, (4 - 3) + 1);
	}

}
