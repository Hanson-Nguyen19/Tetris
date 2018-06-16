/**
 * @authorHansonNguyen, @authorNavtejGhataure, @authorSimonCadieux
 */
package baseCode;

import java.util.ArrayList;

public class Movement {

	/**
	 * Moves the currently falling block based on the input detected in Game.java.
	 * @param direction
	 * @param square
	 * @param squareSize
	 */
	public static void moveBlocks(String direction, ArrayList<Square> square, int squareSize) {
		if (direction =="Left"){
			for(int i = square.size()-4; i <square.size();i ++) {
				square.get(i).setX((int)(square.get(i).getX()- squareSize));
			}
			if(Hit.isHit(square, squareSize)) {
				for(int i = square.size()-4; i <square.size();i ++) {
					square.get(i).setX((int)(square.get(i).getX()+ squareSize));
				}
			}
		}else if (direction == "Right") {
			for(int i = square.size()-4; i <square.size();i ++) {
				square.get(i).setX((int)(square.get(i).getX()+ squareSize));
			}
			if(Hit.isHit(square, squareSize)) {
				for(int i = square.size()-4; i <square.size();i ++) {
					square.get(i).setX((int)(square.get(i).getX()- squareSize));
				}	
			}
		}else if (direction == "Down") {
			dropBlocks(square, squareSize);
		}
	}
	
	/**
	 * Rotates the currently falling block based on the shape and current rotation.
	 * @param shape
	 * @param square
	 * @param squareSize
	 */
	public static void rotateBlock(int shape, ArrayList<Square> square, int squareSize) {

		if (shape == 1) {
			//Line
			if((square.get(square.size()-1).getX() + squareSize) == square.get(square.size()-2).getX()) {
				square.get(square.size()-1).setX((int)square.get(square.size()-2).getX());
				square.get(square.size()-1).setY((int)square.get(square.size()-2).getY() + squareSize);
				square.get(square.size()-4).setX((int)square.get(square.size()-2).getX());
				square.get(square.size()-4).setY((int)square.get(square.size()-2).getY() - 2*squareSize);
				square.get(square.size()-3).setX((int)square.get(square.size()-2).getX());
				square.get(square.size()-3).setY((int)square.get(square.size()-2).getY() - squareSize);
			}else if ((square.get(square.size()-1).getX() - squareSize) == square.get(square.size()-2).getX()) {
				square.get(square.size()-1).setX((int)square.get(square.size()-2).getX()+ squareSize);
				square.get(square.size()-1).setY((int)square.get(square.size()-2).getY());
				square.get(square.size()-4).setX((int)square.get(square.size()-2).getX() + 2*squareSize);
				square.get(square.size()-4).setY((int)square.get(square.size()-2).getY());
				square.get(square.size()-3).setX((int)square.get(square.size()-2).getX()+ squareSize);
				square.get(square.size()-3).setY((int)square.get(square.size()-2).getY());
			}else if ((square.get(square.size()-1).getY() + squareSize) == square.get(square.size()-2).getY()) {
				square.get(square.size()-1).setX((int)square.get(square.size()-2).getX());
				square.get(square.size()-1).setY((int)square.get(square.size()-2).getY() - squareSize);
				square.get(square.size()-4).setX((int)square.get(square.size()-2).getX());
				square.get(square.size()-4).setY((int)square.get(square.size()-2).getY() + 2*squareSize);
				square.get(square.size()-3).setX((int)square.get(square.size()-2).getX());
				square.get(square.size()-3).setY((int)square.get(square.size()-2).getY() + squareSize);
			}else if ((square.get(square.size()-1).getY() - squareSize) == square.get(square.size()-2).getY()) {
				square.get(square.size()-1).setX((int)square.get(square.size()-2).getX() - squareSize);
				square.get(square.size()-1).setY((int)square.get(square.size()-2).getY());
				square.get(square.size()-4).setX((int)square.get(square.size()-2).getX()+ 2*squareSize);
				square.get(square.size()-4).setY((int)square.get(square.size()-2).getY());
				square.get(square.size()-3).setX((int)square.get(square.size()-2).getX() + squareSize);
				square.get(square.size()-3).setY((int)square.get(square.size()-2).getY());
			}
		}else if (shape == 2) {
			//s
			// 20
			//31
			if((square.get(square.size()-3).getY()-squareSize) == square.get(square.size()-2).getY()) {
				square.get(square.size()-3).setX((int)square.get(square.size()-2).getX()-squareSize);
				square.get(square.size()-3).setY((int)square.get(square.size()-2).getY());
				square.get(square.size()-1).setX((int)square.get(square.size()-2).getX()-squareSize);
				square.get(square.size()-1).setY((int)square.get(square.size()-2).getY()-squareSize);
				square.get(square.size()-4).setX((int)square.get(square.size()-2).getX());
				square.get(square.size()-4).setY((int)square.get(square.size()-2).getY()+squareSize);
			}else if ((square.get(square.size()-3).getX()+squareSize) == square.get(square.size()-2).getX()) {
				square.get(square.size()-3).setX((int)square.get(square.size()-2).getX());
				square.get(square.size()-3).setY((int)square.get(square.size()-2).getY()-squareSize);
				square.get(square.size()-1).setX((int)square.get(square.size()-2).getX()+squareSize);
				square.get(square.size()-1).setY((int)square.get(square.size()-2).getY()-squareSize);
				square.get(square.size()-4).setX((int)square.get(square.size()-2).getX()-squareSize);
				square.get(square.size()-4).setY((int)square.get(square.size()-2).getY());
			}else if ((square.get(square.size()-3).getY()+squareSize) == square.get(square.size()-2).getY()) {

				square.get(square.size()-3).setX((int)square.get(square.size()-2).getX()+squareSize);
				square.get(square.size()-3).setY((int)square.get(square.size()-2).getY());
				square.get(square.size()-1).setX((int)square.get(square.size()-2).getX()+squareSize);
				square.get(square.size()-1).setY((int)square.get(square.size()-2).getY()+squareSize);
				square.get(square.size()-4).setX((int)square.get(square.size()-2).getX());
				square.get(square.size()-4).setY((int)square.get(square.size()-2).getY()-squareSize);
			}else if ((square.get(square.size()-3).getX()-squareSize) == square.get(square.size()-2).getX()) {

				square.get(square.size()-3).setX((int)square.get(square.size()-2).getX());
				square.get(square.size()-3).setY((int)square.get(square.size()-2).getY()+squareSize);
				square.get(square.size()-1).setX((int)square.get(square.size()-2).getX()-squareSize);
				square.get(square.size()-1).setY((int)square.get(square.size()-2).getY()+squareSize);
				square.get(square.size()-4).setX((int)square.get(square.size()-2).getX()+squareSize);
				square.get(square.size()-4).setY((int)square.get(square.size()-2).getY());
			}
		}else if (shape == 3) {
			//z
			if((square.get(square.size()-4).getY()-squareSize) == square.get(square.size()-2).getY()) {
				square.get(square.size()-3).setX((int)square.get(square.size()-2).getX());
				square.get(square.size()-3).setY((int)square.get(square.size()-2).getY()-squareSize);
				square.get(square.size()-4).setX((int)square.get(square.size()-2).getX()-squareSize);
				square.get(square.size()-4).setY((int)square.get(square.size()-2).getY());
				square.get(square.size()-1).setX((int)square.get(square.size()-2).getX()-squareSize);
				square.get(square.size()-1).setY((int)square.get(square.size()-2).getY()+squareSize);
			}else if ((square.get(square.size()-4).getX()+squareSize) == square.get(square.size()-2).getX()) {
				square.get(square.size()-3).setX((int)square.get(square.size()-2).getX()+squareSize);
				square.get(square.size()-3).setY((int)square.get(square.size()-2).getY());
				square.get(square.size()-4).setX((int)square.get(square.size()-2).getX());
				square.get(square.size()-4).setY((int)square.get(square.size()-2).getY()-squareSize);
				square.get(square.size()-1).setX((int)square.get(square.size()-2).getX()-squareSize);
				square.get(square.size()-1).setY((int)square.get(square.size()-2).getY()-squareSize);
			}else if ((square.get(square.size()-4).getY()+squareSize) == square.get(square.size()-2).getY()) {
				square.get(square.size()-3).setX((int)square.get(square.size()-2).getX());
				square.get(square.size()-3).setY((int)square.get(square.size()-2).getY()+squareSize);
				square.get(square.size()-4).setX((int)square.get(square.size()-2).getX()+squareSize);
				square.get(square.size()-4).setY((int)square.get(square.size()-2).getY());
				square.get(square.size()-1).setX((int)square.get(square.size()-2).getX()+squareSize);
				square.get(square.size()-1).setY((int)square.get(square.size()-2).getY()-squareSize);
			}else if ((square.get(square.size()-4).getX()-squareSize) == square.get(square.size()-2).getX()) {
				square.get(square.size()-3).setX((int)square.get(square.size()-2).getX()-squareSize);
				square.get(square.size()-3).setY((int)square.get(square.size()-2).getY());
				square.get(square.size()-4).setX((int)square.get(square.size()-2).getX());
				square.get(square.size()-4).setY((int)square.get(square.size()-2).getY()+squareSize);
				square.get(square.size()-1).setX((int)square.get(square.size()-2).getX()+squareSize);
				square.get(square.size()-1).setY((int)square.get(square.size()-2).getY()+squareSize);

			}
		}else if (shape == 4) {//TODO fix everything past this line
			//upside-down t
			// 2
			//031
			if((square.get(square.size()-2).getY()+squareSize) == square.get(square.size()-1).getY()) {

				square.get(square.size()-2).setX((int)square.get(square.size()-2).getX()+squareSize);
				square.get(square.size()-2).setY((int)square.get(square.size()-2).getY()+squareSize);
				square.get(square.size()-3).setX((int)square.get(square.size()-2).getX()-squareSize);
				square.get(square.size()-3).setY((int)square.get(square.size()-2).getY()+squareSize);
				square.get(square.size()-4).setX((int)square.get(square.size()-2).getX()-squareSize);
				square.get(square.size()-4).setY((int)square.get(square.size()-2).getY()-squareSize);
			}else if((square.get(square.size()-2).getX()-squareSize) == square.get(square.size()-1).getX()) {

				square.get(square.size()-2).setX((int)square.get(square.size()-2).getX()-squareSize);
				square.get(square.size()-2).setY((int)square.get(square.size()-2).getY()+squareSize);
				square.get(square.size()-3).setX((int)square.get(square.size()-2).getX()-squareSize);
				square.get(square.size()-3).setY((int)square.get(square.size()-2).getY()-squareSize);
				square.get(square.size()-4).setX((int)square.get(square.size()-2).getX()+squareSize);
				square.get(square.size()-4).setY((int)square.get(square.size()-2).getY()-squareSize);
			}else if((square.get(square.size()-2).getY()-squareSize) == square.get(square.size()-1).getY()) {

				square.get(square.size()-2).setX((int)square.get(square.size()-2).getX()-squareSize);
				square.get(square.size()-2).setY((int)square.get(square.size()-2).getY()-squareSize);
				square.get(square.size()-3).setX((int)square.get(square.size()-2).getX()+squareSize);
				square.get(square.size()-3).setY((int)square.get(square.size()-2).getY()-squareSize);
				square.get(square.size()-4).setX((int)square.get(square.size()-2).getX()+squareSize);
				square.get(square.size()-4).setY((int)square.get(square.size()-2).getY()+squareSize);
			}else if((square.get(square.size()-2).getX()+squareSize) == square.get(square.size()-1).getX()) {

				square.get(square.size()-2).setX((int)square.get(square.size()-2).getX()+squareSize);
				square.get(square.size()-2).setY((int)square.get(square.size()-2).getY()-squareSize);
				square.get(square.size()-3).setX((int)square.get(square.size()-2).getX()+squareSize);
				square.get(square.size()-3).setY((int)square.get(square.size()-2).getY()+squareSize);
				square.get(square.size()-4).setX((int)square.get(square.size()-2).getX()-squareSize);
				square.get(square.size()-4).setY((int)square.get(square.size()-2).getY()+squareSize);
			}
		}else if (shape == 5) {
			//L
			//2
			//0
			//31
			if((square.get(square.size()-4).getY()-squareSize) == (square.get(square.size()-2).getY())) {

				square.get(square.size()-2).setX((int)square.get(square.size()-4).getX()+squareSize);
				square.get(square.size()-2).setY((int)square.get(square.size()-4).getY());
				square.get(square.size()-1).setX((int)square.get(square.size()-4).getX()-squareSize);
				square.get(square.size()-1).setY((int)square.get(square.size()-4).getY());
				square.get(square.size()-3).setX((int)square.get(square.size()-4).getX()-squareSize);
				square.get(square.size()-3).setY((int)square.get(square.size()-4).getY()+squareSize);
			}
			else if((square.get(square.size()-4).getX()+squareSize) == (square.get(square.size()-2).getX())) {

				square.get(square.size()-2).setX((int)square.get(square.size()-4).getX());
				square.get(square.size()-2).setY((int)square.get(square.size()-4).getY()+squareSize);
				square.get(square.size()-1).setX((int)square.get(square.size()-4).getX());
				square.get(square.size()-1).setY((int)square.get(square.size()-4).getY()-squareSize);
				square.get(square.size()-3).setX((int)square.get(square.size()-4).getX()-squareSize);
				square.get(square.size()-3).setY((int)square.get(square.size()-4).getY()-squareSize);
			}
			else if((square.get(square.size()-4).getY()+squareSize) == (square.get(square.size()-2).getY())) {

				square.get(square.size()-2).setX((int)square.get(square.size()-4).getX()-squareSize);
				square.get(square.size()-2).setY((int)square.get(square.size()-4).getY());
				square.get(square.size()-1).setX((int)square.get(square.size()-4).getX()+squareSize);
				square.get(square.size()-1).setY((int)square.get(square.size()-4).getY());
				square.get(square.size()-3).setX((int)square.get(square.size()-4).getX()+squareSize);
				square.get(square.size()-3).setY((int)square.get(square.size()-4).getY()-squareSize);
			}
			else if((square.get(square.size()-4).getX()-squareSize) == (square.get(square.size()-2).getX())) {

				square.get(square.size()-2).setX((int)square.get(square.size()-4).getX());
				square.get(square.size()-2).setY((int)square.get(square.size()-4).getY()-squareSize);

				square.get(square.size()-1).setX((int)square.get(square.size()-4).getX());
				square.get(square.size()-1).setY((int)square.get(square.size()-4).getY()+squareSize);


				square.get(square.size()-3).setX((int)square.get(square.size()-4).getX()+squareSize);
				square.get(square.size()-3).setY((int)square.get(square.size()-4).getY()+squareSize);
			}
		}else if (shape == 6) {

			//inverted L
			if((square.get(square.size()-4).getY()-squareSize) == (square.get(square.size()-2).getY())) {

				square.get(square.size()-2).setX((int)square.get(square.size()-4).getX()+squareSize);
				square.get(square.size()-2).setY((int)square.get(square.size()-4).getY());
				square.get(square.size()-1).setX((int)square.get(square.size()-4).getX()-squareSize);
				square.get(square.size()-1).setY((int)square.get(square.size()-4).getY());
				square.get(square.size()-3).setX((int)square.get(square.size()-4).getX()-squareSize);
				square.get(square.size()-3).setY((int)square.get(square.size()-4).getY()-squareSize);
			}else if((square.get(square.size()-4).getX()+squareSize) == (square.get(square.size()-2).getX())) {

				square.get(square.size()-2).setX((int)square.get(square.size()-4).getX());
				square.get(square.size()-2).setY((int)square.get(square.size()-4).getY()+squareSize);
				square.get(square.size()-1).setX((int)square.get(square.size()-4).getX());
				square.get(square.size()-1).setY((int)square.get(square.size()-4).getY()-squareSize);
				square.get(square.size()-3).setX((int)square.get(square.size()-4).getX()+squareSize);
				square.get(square.size()-3).setY((int)square.get(square.size()-4).getY()-squareSize);
			}else if((square.get(square.size()-4).getY()+squareSize) == (square.get(square.size()-2).getY())) {

				square.get(square.size()-2).setX((int)square.get(square.size()-4).getX()-squareSize);
				square.get(square.size()-2).setY((int)square.get(square.size()-4).getY());
				square.get(square.size()-1).setX((int)square.get(square.size()-4).getX()+squareSize);
				square.get(square.size()-1).setY((int)square.get(square.size()-4).getY());
				square.get(square.size()-3).setX((int)square.get(square.size()-4).getX()+squareSize);
				square.get(square.size()-3).setY((int)square.get(square.size()-4).getY()+squareSize);
			}else if((square.get(square.size()-4).getX()-squareSize) == (square.get(square.size()-2).getX())) {

				square.get(square.size()-2).setX((int)square.get(square.size()-4).getX());
				square.get(square.size()-2).setY((int)square.get(square.size()-4).getY()-squareSize);


				square.get(square.size()-1).setX((int)square.get(square.size()-4).getX());
				square.get(square.size()-1).setY((int)square.get(square.size()-4).getY()+squareSize);

				square.get(square.size()-3).setX((int)square.get(square.size()-4).getX()-squareSize);
				square.get(square.size()-3).setY((int)square.get(square.size()-4).getY()+squareSize);
			}
		}
	}
	
	/**
	 * Drops the currently falling block.
	 * @param square
	 * @param squareSize
	 */
	public static void dropBlocks(ArrayList<Square> square, int squareSize) {
		for(int i = square.size()-4; i <square.size();i ++) {
			square.get(i).setY((int)(square.get(i).getY()+ squareSize));
		}
	}
	
	/**
	 * Drops every block on the screen.
	 * @param square
	 * @param squareSize
	 */
	public static void dropAllBlocks(ArrayList<Square> square, int squareSize) {
		for(int i = 0; i <square.size();i ++) {
			square.get(i).setY((int)square.get(i).getY()+ squareSize);
		}
	}
}
