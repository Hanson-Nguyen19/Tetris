package baseCode;
import javafx.scene.paint.Color;

import javafx.scene.canvas.GraphicsContext;

/**
 * This class implements a flashing ball. Feel free to change this, implement a
 * new object, change the animation, etc. <br><br>December 9, 2007.
 * 
 * @author Navtej Ghataure
 * 
 */
public class Square extends MovingObject {
	/**
	 * The radius of the ball.
	 */
	int radius;
	/**
	 * Counts the frames between flash on/off.
	 */
	int counter;
	/**
	 * The number of frames to wait before toggling the flash.
	 */
	int flashSpeed;
	/**
	 * Controls the flash - true if the ball is filled in, false if it is an
	 * outline.
	 */
	boolean filledIn;

	/**
	 * Calls the superclass constructor, plus sets radius, and flash parameters.
	 * 
	 * @param x
	 *            The x location.
	 * @param y
	 *            The y location.
	 * @param left
	 *            The left edge.
	 * @param right
	 *            The right edge.
	 * @param top
	 *            The top edge.
	 * @param bottom
	 *            The bottom edge.
	 */
	public Square(double x, double y, int left, int right, int top, int bottom) {
		super(x, y, left + 10, right - 10, top + 10, bottom - 10);
		// numbers above must match the radius
		radius = 10;
		counter = 0;
		flashSpeed = (int) (Math.random() * 5 + 5);
		filledIn = true;
	}
	/**
	 * Draws the Squares
	 * 
	 * @param g
	 *            The graphics context.
	 */
	public void draw(GraphicsContext gc) {
		int drawX = (int) x;
		int drawY = (int) y;

		gc.setFill(color);
		gc.fillRect(drawX, drawY, radius, radius);
		
		if (!filledIn) {
			gc.setFill(Color.PURPLE);
			gc.fillRect(drawX + radius, drawY + radius, radius, radius);
			
		}
	}
	public double getX() {
	return x;
	}
	public double getY() {
	return y;
	}
	public double getRadius() {
	return radius;
	}
	}
