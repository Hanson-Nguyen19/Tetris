/**
 * @authorHansonNguyen, @authorNavtejGhataure, @authorSimonCadieux
 */
package baseCode;

import java.util.ArrayList;

public class Grid {

	/**
	 * checks every row for a completed row.
	 * @param square
	 */
	public static long rowCheck(ArrayList<Square> square, long score) {
		int count =0;
		for(int y=0; y<=600;y=y+25) {
			for (int x = 0; x<=450;x=x+25) {
				for(int i =0;i <square.size();i ++) {
					if(((int)square.get(i).getX()) == x && y == ((int)square.get(i).getY())) {
						count ++;
					}
				}
				if(count == 18) {
					return removeRows(y, square, score);
					
				}
			}
			count = 0;
		}
		return score;
	}
	
	/**
	 * Removes one full row when it has been completed
	 * @param y
	 */
	public static long removeRows(int y, ArrayList<Square> square, long score) {	
		for (int x = 0; x<=450;x=x+25) {
			for(int i =0;i <square.size();i ++) {
				if(((int)square.get(i).getX()) == x && y == ((int)square.get(i).getY())) {
					square.remove(i);
				}
			}
		}
		Movement.dropAllBlocks(square, 25);
		return score += 180;
	}
}
