package baseCode;

import java.io.File;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Game extends Application{
	Timer time = new Timer();
	int shape = (int) (Math.random() * 7);
	ArrayList<Square> square = new ArrayList<Square>();
	final int squareSize = 25;
	int songNum = (int) (Math.random() * 19)+1;
	int dropSpeed = 1000;
	int count = 0;
	public static void main (String[] args) {
		launch(args);
	}
	Image buffer;

	@Override
	public void start(Stage primaryStage) throws Exception {
		Group group = new Group();
		Scene scene = new Scene(group, 450, 600);
		primaryStage.setTitle("Tetris");
		Canvas canvas = new Canvas(450, 600);
		final GraphicsContext gc = canvas.getGraphicsContext2D();

		Clip song1 = AudioSystem.getClip();
		song1.open(AudioSystem.getAudioInputStream(new File("src/Resources/Castle Rock.wav")));
		Clip song2 = AudioSystem.getClip();
		song2.open(AudioSystem.getAudioInputStream(new File("src/Resources/TetrisDance.wav")));
		Clip song3 = AudioSystem.getClip();
		song3.open(AudioSystem.getAudioInputStream(new File("src/Resources/Fever Dr. Mario.wav")));
		Clip song4 = AudioSystem.getClip();
		song4.open(AudioSystem.getAudioInputStream(new File("src/Resources/Paper Mario.wav")));
		Clip song5 = AudioSystem.getClip();
		song5.open(AudioSystem.getAudioInputStream(new File("src/Resources/Snow Bros.wav")));
		Clip song6 = AudioSystem.getClip();
		song6.open(AudioSystem.getAudioInputStream(new File("src/Resources/Super Mario Bros.wav")));
		Clip song7 = AudioSystem.getClip();
		song7.open(AudioSystem.getAudioInputStream(new File("src/Resources/Battletoads.wav")));
		Clip song8 = AudioSystem.getClip();
		song8.open(AudioSystem.getAudioInputStream(new File("src/Resources/FlashManStage.wav")));
		Clip song9 = AudioSystem.getClip();
		song9.open(AudioSystem.getAudioInputStream(new File("src/Resources/TheManWithTheMachineGun.wav")));
		Clip song10 = AudioSystem.getClip();
		song10.open(AudioSystem.getAudioInputStream(new File("src/Resources/Balrog.wav")));
		Clip song11 = AudioSystem.getClip();
		song11.open(AudioSystem.getAudioInputStream(new File("src/Resources/DuckTales.wav")));
		Clip song12 = AudioSystem.getClip();
		song12.open(AudioSystem.getAudioInputStream(new File("src/Resources/BubbleBobble.wav")));
		Clip song13 = AudioSystem.getClip();
		song13.open(AudioSystem.getAudioInputStream(new File("src/Resources/SuperMarioBrosUnderground.wav")));
		Clip song14 = AudioSystem.getClip();
		song14.open(AudioSystem.getAudioInputStream(new File("src/Resources/Super Mario Bros. 3.wav")));
		Clip song15 = AudioSystem.getClip();
		song15.open(AudioSystem.getAudioInputStream(new File("src/Resources/Dudley.wav")));
		Clip song16 = AudioSystem.getClip();
		song16.open(AudioSystem.getAudioInputStream(new File("src/Resources/Spider Dance.wav")));
		Clip song17 = AudioSystem.getClip();
		song17.open(AudioSystem.getAudioInputStream(new File("src/Resources/Spaceball.wav")));
		Clip title = AudioSystem.getClip();
		title.open(AudioSystem.getAudioInputStream(new File("src/Resources/Excitebike Arena.wav")));
		Clip credit = AudioSystem.getClip();
		credit.open(AudioSystem.getAudioInputStream(new File("src/Resources/AssassinsCreed III.wav")));

//		boolean startPressed= true;
//		title.start();
//		Button start = new Button("Start");
//		Button instructions= new Button("Rules");
//		start.setLayoutX(200);
//		start.setLayoutY(270);
//		instructions.setLayoutX(200);
//		instructions.setLayoutY(295);
//		group.getChildren().add(start);
//		group.getChildren().add(instructions);
//		group.getChildren().add(canvas);
//		primaryStage.setScene(scene);
//		primaryStage.show();
//
//		do {
//			if(start.isPressed()) {
//				startPressed = true;
//			}else if(instructions.isPressed()) {
//				System.out.println("Rotate Blocks with a mouse click, move left or right with the 'A' and 'D' keys,");
//				System.out.println("Ad");
//			}
//		}while(startPressed == false);	
//		title.stop();

		if(songNum == 1) {

			song1.start();

		}else if (songNum ==2) {

			song2.start();

		}else if (songNum ==3) {

			song3.start();

		}else if (songNum ==4) {

			song4.start();

		}else if (songNum ==5) {

			song5.start();

		}else if (songNum ==6) {

			song6.start();

		}else if (songNum ==7) {
			song7.start();
		}else if (songNum ==8) {
			song8.start();
		}else if (songNum ==9) {
			song9.start();
		}else if (songNum ==10) {
			song10.start();
		}else if (songNum ==11) {
			song11.start();
		}else if (songNum ==12) {
			song12.start();
		}else if (songNum ==13) {
			song13.start();
		}else if (songNum ==14) {
			song14.start();
		}else if (songNum ==15) {
			song15.start();
		}else if (songNum ==16) {
			song16.start();
		}else if (songNum == 17) {
			title.start();
		}else if (songNum == 18) {
			credit.start();
		}

		//	for (int i = 0; i < square.size(); i++) {

		//	for (int i = 0; i < (squareSize*2); i++) {

		//	square.add(new Square(squareSize, squareSize, 0, (int)canvas.getWidth(), 0, (int)canvas.getHeight()));

		//	square.get(i).setXSpeed(0);

		//	square.get(i).setYSpeed(0);

		//	}




		GridPane gridpane = new GridPane();

		for (int i = 0; i < squareSize; i++) {

			RowConstraints row = new RowConstraints(60);

			gridpane.getRowConstraints().add(row);

		}

		canvas.setOnKeyPressed(event -> {

			String direction = " " ;

			if(event.getCode() == KeyCode.A) {

				direction = "Left";

				moveBlocks(direction);

			}else if(event.getCode() == KeyCode.D) {

				direction = "Right";

				moveBlocks(direction);

			}else if(event.getCode() == KeyCode.S) {
				direction = "Down";
				moveBlocks(direction);

			}

		});


		//Makes block drop one row every second.
		time.schedule(new TimerTask() {
			@Override
			public void run() {
				//Makes block drop one row every second.
				System.out.println(hit(square.size()-4));
				//TODO find out why hit does not trigger when blocks collide
				if(hit(square.size()-4)) {
					createBlocks(randomShape());
				}
				else {
					dropBlocks();
				}
			}	

		}, dropSpeed, dropSpeed);

		time.schedule(new TimerTask() {
			@Override
			public void run() {
				rowCheck();
			}
		}, 0,1);

		group.getChildren().add(gridpane);
		canvas.setFocusTraversable(true);

		Thread game = new Thread(new Runnable() {

			/**
			 * Repaints the canvas periodically.
			 */

			@Override
			public void run() {
				while (true) {
					draw(gc);
					try {
						Thread.sleep(40);
					} catch (InterruptedException e) {
					}
				}
			}
		});


		game.start();
	}

	public void draw(GraphicsContext gc) {

		gc.setFill(Color.WHITE);

		gc.fillRect(0, 0, gc.getCanvas().getWidth(), gc.getCanvas().getHeight());

		for (int i = 0; i < square.size(); i++) {

			square.get(i).draw(gc);

		}

	}

	public void moveBlocks(String direction) {
		if (direction =="Left"){
			for(int i = square.size()-4; i <square.size();i ++) {
				square.get(i).setX((int)(square.get(i).getX()- squareSize));
			}

		}else if (direction == "Right") {
			for(int i = square.size()-4; i <square.size();i ++) {
				square.get(i).setX((int)(square.get(i).getX()+ squareSize));
			}
		}else if (direction == "Down") {

			dropBlocks();
		}

	}

	public void createBlocks(int shape) {
		double x = 250;
		double y = 25;

		if(shape == 0) {
			//2x2 square
			for(int i = 0; i < 4; i ++) {
				if(i==0) {
					x=x+squareSize;
				}else if(i==1) {
					y=y+squareSize;
				}else if(i ==3) {
					y = y+squareSize;
					x=x + squareSize;
				}
				Square s = new Square(x,y,squareSize,squareSize,squareSize,squareSize,Color.RED);
				square.add(s);
				x = 250;
				y=25;
			}
		}else if (shape == 1) {
			//Line
			for(int i = 0; i < 4; i ++) {
				if(i <=1) {
					x =x -squareSize;
					if(i == 0) {
						x= x-squareSize;
					}
				}else if (i == 3) {
					x = x +squareSize;
				}
				Square s = new Square(x,y,squareSize,squareSize,squareSize,squareSize,Color.LIGHTGREEN);
				square.add(s);
				x=250;
				y=25;
			}
		}else if (shape == 2) {
			//s
			for(int i = 0; i < 4; i ++) {
				if(i ==0) {
					x =x +squareSize;
				}else if (i == 1 ) {
					y =y +squareSize;
				}else if (i == 3) {
					x = x -squareSize;
					y =y +squareSize;
				}
				Square s = new Square(x,y,squareSize,squareSize,squareSize,squareSize,Color.GREEN);
				square.add(s);
				x =250;
				y=25;
			}
		}else if (shape == 3) {
			//z
			for(int i = 0; i < 4; i ++) {
				if(i<2){
					if(i ==0) {
						y=y+squareSize;
					}else if(i==1) {
						x=x-squareSize;
					}
				}else if (i == 3) {
					x = x +squareSize;
					y =y +squareSize;
				}
				Square s = new Square(x,y,squareSize,squareSize,squareSize,squareSize,Color.ORANGE);
				square.add(s);
				x=250;
				y=25;
			}
		}else if (shape == 4) {
			//upside-down t
			for(int i = 0; i < 4; i ++) {
				if(i != 2) {
					y= y+squareSize;
					if(i==0) {
						x=x-squareSize;
					}else if(i == 1) {
						x=x +squareSize;
					}
				}else if(i==2) {

				}
				Square s = new Square(x,y,squareSize,squareSize,squareSize,squareSize,Color.PURPLE);
				square.add(s);
				x=250;
				y=25;
			}
		}else if (shape == 5) {
			//L
			for(int i = 0; i < 4; i ++) {
				if(i != 2) {
					if(i==0) {
						y=y+ squareSize;
					}else if(i==1) {
						x=x + squareSize;
						y=y+(2*squareSize);
					}else if(i==3) {
						y=y+(2*squareSize);
					}
				}
				Square s = new Square(x,y,squareSize,squareSize,squareSize,squareSize,Color.BLUE);
				square.add(s);
				x=250;
				y=25;
			}
		}else if (shape == 6) {
			//inverted L
			for(int i = 0; i < 4; i ++) {
				if(i != 2) {
					if(i==0) {
						y=y+ squareSize;
					}else if(i==1) {
						x=x -squareSize;
						y=y+(2*squareSize);
					}else if(i==3) {
						y=y+(2*squareSize);
					}
				}
				Square s = new Square(x,y,squareSize,squareSize,squareSize,squareSize,Color.GOLD);
				square.add(s);
				x=250;
				y=25;
			}
		}
	}
	public int randomShape() {
		return (int) (Math.random() * 7);
	}
	public void removeRows(int y) {	
		for (int x = 0; x<425;x=x+25) {
			for(int i =0;i <square.size();i ++) {
				if(square.get(i).getX() == x && y == square.get(i).getY()) {
					square.remove(i);
				}
			}
		}
	}
	public void dropBlocks() {
		for(int i = square.size()-4; i <square.size();i ++) {
			square.get(i).setY((int)(square.get(i).getY()+ squareSize));
		}

	}

	public void rowCheck() {


		for(int y=0; y<575;y=y+squareSize) {
			for (int x = 0; x<425;x=x+squareSize) {
				for(int i =0;i <square.size();i ++) {
					if(square.get(i).getX() == x && y == square.get(i).getY()) {
						count ++;
					}

				}
			}
			if(count == 18) {

				removeRows(y);
			}
			count = 0;
		}
	}
	public void rotateBlock(int shape) {

		if (shape == 1) {

			//Line

			double x = square.get(2).getX();
			double y =square.get(2).getY();

			for(int i = 0; i <4;i ++) {

				if(i == 2) {



				}

			}

		}else if (shape == 2) {

			//s



		}else if (shape == 3) {

			//z



		}else if (shape == 4) {

			//upside-down t

		}else if (shape == 5) {
			//L
		}else if (shape == 6) {
			//inverted L
		}

	}

	public boolean hit(int i) {


		if(square.get(i).getY()+squareSize == 625 || square.get(i+1).getY()+squareSize == 625 || square.get(i+2).getY()+squareSize == 625 || square.get(i+3).getY()+squareSize == 625) {
			return true;
		}

		for(int t = 0; t<square.size()-4; t++) {

			for(int l =square.size()-5;l<square.size();l++) {

				if(square.get(l).getY()+squareSize == square.get(t).getY()) {

					if(square.get(l).getX() <= square.get(t).getX() && square.get(l).getX()+squareSize <= square.get(t).getX()) {
						return true;
					}
				}
			}
		}

		return false;

	}

}