package baseCode;

import java.util.ArrayList;

public class Grid {

	public static void rowCheck(ArrayList<Square> square) {
		int count =0;
		for(int y=0; y<=600;y=y+25) {
			for (int x = 0; x<=450;x=x+25) {
				for(int i =0;i <square.size();i ++) {
					if(((int)square.get(i).getX()) == x && y == ((int)square.get(i).getY())) {
						count ++;
					}
				}
				System.out.println(count);
				if(count == 18) {
					removeRows(y, square);
					
				}
			}
			count = 0;
		}
	}
	/**
	 * Removes One full row when it has been completed
	 * @param y
	 */
	public static void removeRows(int y, ArrayList<Square> square) {	
		for (int x = 0; x<=450;x=x+25) {
			for(int i =0;i <square.size();i ++) {
				if(((int)square.get(i).getX()) == x && y == ((int)square.get(i).getY())) {
					square.remove(i);
				}
			}
		}
		Movement.dropAllBlocks(square, 25);
	}
}
