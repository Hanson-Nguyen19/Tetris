/**
 * @authorHansonNguyen, @authorNavtejGhataure, @authorSimonCadieux
 */
package baseCode;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public abstract class MovingObject implements Runnable {
	
	/**
	 * The x location of the object.
	 */
	double x;
	
	/**
	 * The y location of the object.
	 */
	double y;
	
	/**
	 * The left edge.
	 */
	int left;
	
	/**
	 * The right edge.
	 */
	int right;
	
	/**
	 * The top edge.
	 */
	int top;
	
	/**
	 * The bottom edge.
	 */
	int bottom;
	
	/**
	 * Object color (defaults to black)
	 */
	Color color;
	
	/**
	 * Sets default color and pauseDuration values. Sets speed to 0. Starts
	 * thread. Every subclass of MovingObject must use this constructor.
	 * @param x
	 * Initial x position.
	 * @param y
	 * Initial y position.
	 * @param left
	 * Left edge for bouncing.
	 * @param right
	 * Right edge for bouncing.
	 * @param top
	 * Top edge for bouncing.
	 * @param bottom
	 * Bottom edge for bouncing.
	 */
	public MovingObject(double x, double y, int left, int right, int top,
			int bottom) {
		this.color = Color.BLACK;
		this.x = x;
		this.y = y;
		this.left = left;
		this.right = right;
		this.top = top;
		this.bottom = bottom;
	}
	
	/**
	 * Draws the object.
	 * @param gc
	 * The graphics context
	 */
	abstract public void draw(GraphicsContext gc);
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Sets the x location.
	 * @param x
	 * New x location.
	 */
	public void setX(int x) {
		this.x = x;
	}
	
	/**
	 * Sets the y location.
	 * @param y
	 * New y location.
	 */
	public void setY(int y) {
		this.y = y;
	}
	
	/**
	 * Sets color of object.
	 * @param color
	 * New color.
	 */
	public void setColor(Color color) {
		this.color = color;
	}
}