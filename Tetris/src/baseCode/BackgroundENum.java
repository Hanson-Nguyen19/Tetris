package baseCode;

import javafx.scene.image.Image;

public class BackgroundENum {

	public static Image eNum(int i) {
		
		switch(i) {
		
		case 1: Image i1 = new Image("src/Resources/TetB1.png");
			return i1;
		
		case 2: Image i2 = new Image("src/Resources/TetB2.jpeg");
			return i2;
		
		case 3: Image i3 = new Image("src/Resources/TetB3.jpeg");
			return i3;
		
		case 4: Image i4 = new Image("src/Resources/TetB4.jpeg");
			return i4;

		case 5: Image i5 = new Image("src/Resources/TetB5.png");
			return i5;
		
		case 6: Image i6 = new Image("src/Resources/TetB6.jpeg");
			return i6;
		}
		return null;
	}
	
}
