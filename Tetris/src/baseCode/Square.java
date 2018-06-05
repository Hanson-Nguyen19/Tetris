package baseCode;
import javafx.scene.paint.Color;
import javafx.scene.canvas.GraphicsContext;
/**
 * This class implements a flashing ball. Feel free to change this, implement a
 * new object, change the animation, etc. <br><br>December 9, 2007.
 * @authorNavtejGhataure, @authorHansonNguyen, @authorSimonCadieux, @authorUmmu
 */
public class Square extends MovingObject {
	/**
	 * The radius of the ball.
	 */
	int size;
	/**
	 * Counts the frames between flash on/off.
	 */
	int counter;
	/**
	 * The number of frames to wait before toggling the flash.
	 */
	int flashSpeed;
	
	Color tcolor;
	/**
	 * Calls the superclass constructor, plus sets radius, and flash parameters.
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
		counter = 0;
		flashSpeed = (int) (Math.random() * 5 + 5);
		tcolor = ncolor;
	}
	/**
	 * Controls the animation parameters. (Called once every time the ball
	 * position is updated.)
	 */
	public void animateOneStep() {
		counter++;
		if (counter == flashSpeed) {
			counter = 0;
		}
	}
	/**
	 * Draws the Squares
	 * @param g
	 * The graphics context.
	 */
	public void draw(GraphicsContext gc) {
		int drawX = (int) x - size;
		int drawY = (int) y - size;
		gc.setFill(tcolor);
		gc.fillRect(drawX, drawY, size, size);
	}
	public double getX() {
	return x;
	}
	public double getY() {
	return y;
	}
	public double getRadius() {
	return size;
	}
	}
