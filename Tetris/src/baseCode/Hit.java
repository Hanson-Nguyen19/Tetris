/**
 * @authorHansonNguyen, @authorNavtejGhataure, @authorSimonCadieux
 */
package baseCode;

import java.util.ArrayList;

public class Hit {

	/**
	 * checks if the block that is currently moving has collided with anything
	 * @param square
	 * @param squareSize
	 * @return
	 */
	public static boolean isHit(ArrayList<Square> square, int squareSize) {
		if(square.get(square.size()-4).getY()+squareSize == 625 || square.get(square.size()-3).getY()+squareSize == 625 || square.get(square.size()-2).getY()+squareSize == 625 || square.get(square.size()-1).getY()+squareSize == 625) {
			return true;
		}
		for(int i = square.size()-4; i<square.size(); i++) {
			if(square.get(i).getX()-squareSize < 0) {
				return true;
			}
			if(square.get(i).getX()+squareSize > 475) {
				return true;
			}
		}
		for(int t = 0; t<square.size()-4; t++) {
			for(int l =square.size()-4;l<square.size();l++) {
				if(square.get(l).getY()+squareSize == square.get(t).getY()) {
					if(square.get(l).getX() == square.get(t).getX()) {
						System.out.println("Block: " + l + " is coliding with Block: " + t);
						Grid.rowCheck(square);
						return true;
					}
				} 	
			}	
		}
		return false;
	}

}
