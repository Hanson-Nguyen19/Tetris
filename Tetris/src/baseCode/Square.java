/**
 * This class implements a square into the game class.
 * @authorNavtejGhataure, @authorHansonNguyen, @authorSimonCadieux, @authorUmmu
 */
package baseCode;

import javafx.scene.paint.Color;
import javafx.scene.canvas.GraphicsContext;

public class Square extends MovingObject {
	
	/**
	 * The size of the square.
	 */
	int size;
	
	/**
	 * The color of the square.
	 */
	Color tcolor;
	
	/**
	 * Calls the superclass constructor, plus sets size and color.
	 * @param x
	 * The x location.
	 * @param y
	 * The y location.
	 * @param left
	 * The left edge.
	 * @param right
	 * The right edge.
	 * @param top
	 * The top edge.
	 * @param bottom
	 * The bottom edge.
	 */
	public Square(double x, double y, int left, int right, int top, int bottom ,Color ncolor) {
		super(x, y, left + 10, right - 10, top + 10, bottom - 10);
		// numbers above must match the radius
		size = 25;
		tcolor = ncolor;
	}

	/**
	 * Draws the Squares.
	 * @param g
	 * The graphics context.
	 */
	public void draw(GraphicsContext gc) {
		int drawX = (int) x - size;
		int drawY = (int) y - size;
		gc.setFill(tcolor);
		gc.fillRect(drawX, drawY, size, size);
	}
	
	/**
	 * gets the x value of the square.
	 * @return
	 */
	public double getX() {
		return x;
	}
	
	/**
	 * gets the y value of the square.
	 * @return
	 */
	public double getY() {
		return y;
	}
	
	/**
	 * gets the size of the square.
	 * @return
	 */
	public double getSize() {
		return size;
	}
}
