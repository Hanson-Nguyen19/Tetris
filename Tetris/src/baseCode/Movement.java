package baseCode;

import java.util.ArrayList;

public class Movement {

	public static void moveBlocks(String direction, ArrayList<Square> square, int squareSize) {
		if (direction =="Left"){
			for(int i = square.size()-4; i <square.size();i ++) {
				square.get(i).setX((int)(square.get(i).getX()- squareSize));
			}
			if(Game.isHit()) {
				for(int i = square.size()-4; i <square.size();i ++) {
					square.get(i).setX((int)(square.get(i).getX()+ squareSize));
				}
			}
		}else if (direction == "Right") {
			for(int i = square.size()-4; i <square.size();i ++) {
				square.get(i).setX((int)(square.get(i).getX()+ squareSize));
			}
			if(Game.isHit()) {
				for(int i = square.size()-4; i <square.size();i ++) {
					square.get(i).setX((int)(square.get(i).getX()- squareSize));
				}	
			}
		}else if (direction == "Down") {
			Game.dropBlocks();
		}
	}
}
