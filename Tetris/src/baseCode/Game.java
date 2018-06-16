package baseCode;

import java.io.File;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Game extends Application{
	Timer time = new Timer();
	int delay = 0;
	int shape;
	ArrayList<Square> square = new ArrayList<Square>();
	final int squareSize = 25;
	int songNum = (int) (Math.random() * 25)+1;
	int dropSpeed = 1000;
	public static void main (String[] args) {
		launch(args);
	}
	
	@Override
	public void init() {
		MusicPlayer.play(SongENum.songClip(songNum));
	}
	
	Image buffer;
	@SuppressWarnings("static-access")
	@Override
	public void start(Stage primaryStage) throws Exception {
		Group group = new Group();
		Scene scene = new Scene(group, 450, 600);
		primaryStage.setTitle("Tetris");
		Canvas canvas = new Canvas(450, 600);
		final GraphicsContext gc = canvas.getGraphicsContext2D();


		

//				boolean startPressed= true;
//				title.start();
//				Button start = new Button("Start");
//				Button instructions= new Button("Rules");
//				start.setLayoutX(200);
//				start.setLayoutY(270);
//				instructions.setLayoutX(200);
//				instructions.setLayoutY(295);
//				group.getChildren().add(start);
//				group.getChildren().add(instructions);
//				group.getChildren().add(canvas);
//				primaryStage.setScene(scene);
//				primaryStage.show();
//				do {
//					if(start.isPressed()) {
//						startPressed = true;
//					}else if(instructions.isPressed()) {
//						System.out.println("Rotate Blocks with a mouse click, move left or right with the 'A' and 'D' keys,");
//						System.out.println("Ad");
//					}
//				}while(startPressed == false);	
//				title.stop();
//						gc.setFill( Color.WHITE );
//						gc.setStroke( Color.WHITE );
//						gc.setLineWidth(2);
//						Font theFont = Font.font( "", FontWeight.BOLD, 50 );
//						Font buttonFont = Font.font( "", FontWeight.BOLD, 20 );
//						gc.setFont( theFont );
//						gc.fillText( "Welcome To Tetris", 100, 200 );//this is the text that will be printed to the screen
//						gc.strokeText( "Welcome To Tetris", 100, 200 );
//						Button start = new Button("START");//this button will lead to the game mode selection screen
//						//Button highscores = new Button("HIGHSCORES");//this button will prompt the high scores menu to appear
//						Button instructions = new Button ("Instructions");// this button will display the controls and objective of the game.
//						start.setLayoutX(200);
//						start.setLayoutY(270);
//						instructions.setLayoutX(200);
//						instructions.setLayoutY(295);
//						start.setStyle("-fx-background-color: white; -fx-text-fill: black;"); 
//						//highscores.setStyle("-fx-background-color: white; -fx-text-fill: black;"); 
//						instructions.setStyle("-fx-background-color: white; -fx-text-fill: black;"); 
//						start.setFont(buttonFont);
//						//highscores.setFont(buttonFont);
//						instructions.setFont(buttonFont);
//						group.getChildren().add(start);
//						group.getChildren().add(instructions);
//						group.getChildren().add(canvas);
//						primaryStage.setScene(scene);
//						start.setOnAction(new EventHandler<ActionEvent>() {
//							@Override 
//							public void handle(ActionEvent e) {
//								gc.clearRect(0, 0, gc.getCanvas().getWidth(), gc.getCanvas().getHeight());
//							}});

		
		
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
			}else if(event.getCode() == KeyCode.DIGIT1) {
				
				MusicPlayer.stop();
				songNum = 1;
				MusicPlayer.play(SongENum.songClip(songNum));
			}else if(event.getCode() == KeyCode.DIGIT2) {
				MusicPlayer.stop();
				songNum = 2;
				MusicPlayer.play(SongENum.songClip(songNum));
			}else if(event.getCode() == KeyCode.DIGIT3) {
				MusicPlayer.stop();
				songNum = 3;
				MusicPlayer.play(SongENum.songClip(songNum));
			}else if(event.getCode() == KeyCode.DIGIT4) {
				MusicPlayer.stop();
				songNum = 4;
				MusicPlayer.play(SongENum.songClip(songNum));
			}else if(event.getCode() == KeyCode.DIGIT5) {
				MusicPlayer.stop();
				songNum = 5;
				MusicPlayer.play(SongENum.songClip(songNum));
			}else if(event.getCode() == KeyCode.DIGIT6) {
				MusicPlayer.stop();
				songNum = 6;
				MusicPlayer.play(SongENum.songClip(songNum));
			}else if(event.getCode() == KeyCode.DIGIT7) {
				MusicPlayer.stop();
				songNum = 7;
				MusicPlayer.play(SongENum.songClip(songNum));
			}else if(event.getCode() == KeyCode.DIGIT8) {
				MusicPlayer.stop();
				songNum = 8;
				MusicPlayer.play(SongENum.songClip(songNum));
			}else if(event.getCode() == KeyCode.DIGIT9) {
				MusicPlayer.stop();
				songNum = 9;
				MusicPlayer.play(SongENum.songClip(songNum));
			}else if(event.getCode() == KeyCode.DIGIT0) {
				MusicPlayer.stop();
				songNum = 10;
				MusicPlayer.play(SongENum.songClip(songNum));
			}else if (event.getCode() == KeyCode.P) {
				if(songNum <=15) {
					songNum = songNum + 10;
				}
				if(songNum== 11){
					MusicPlayer.stop();
					songNum = 11;
					MusicPlayer.play(SongENum.songClip(songNum));
				}else if (songNum==12) {
					MusicPlayer.stop();
					songNum = 12;
					MusicPlayer.play(SongENum.songClip(songNum));
				}else if (songNum==13) {
					MusicPlayer.stop();
					songNum = 13;
					MusicPlayer.play(SongENum.songClip(songNum));
				}else if (songNum ==14) {
					MusicPlayer.stop();
					songNum = 14;
					MusicPlayer.play(SongENum.songClip(songNum));
				}else if (songNum ==15) {
					MusicPlayer.stop();
					songNum = 15;
					MusicPlayer.play(SongENum.songClip(songNum));
				}else if (songNum ==16) {
					MusicPlayer.stop();
					songNum = 16;
					MusicPlayer.play(SongENum.songClip(songNum));
				}else if (songNum ==17) {
					MusicPlayer.stop();
					songNum = 17;
					MusicPlayer.play(SongENum.songClip(songNum));
				}else if (songNum==18) {
					MusicPlayer.stop();
					songNum = 18;
					MusicPlayer.play(SongENum.songClip(songNum));
				}else if (songNum==19) {
					MusicPlayer.stop();
					songNum = 19;
					MusicPlayer.play(SongENum.songClip(songNum));
				}else if (songNum==20) {
					MusicPlayer.stop();
					songNum = 20;
					MusicPlayer.play(SongENum.songClip(songNum));
				}else if (songNum==21) {
					MusicPlayer.stop();
					songNum = 21;
					MusicPlayer.play(SongENum.songClip(songNum));
				}else if (songNum==22) {
					MusicPlayer.stop();
					songNum = 22;
					MusicPlayer.play(SongENum.songClip(songNum));
				}else if (songNum==23) {
					MusicPlayer.stop();
					songNum = 23;
					MusicPlayer.play(SongENum.songClip(songNum));
				}else if (songNum==24) {
					MusicPlayer.stop();
					songNum = 24;
					MusicPlayer.play(SongENum.songClip(songNum));
				}else if (songNum==25) {
					MusicPlayer.stop();
					songNum = 25;
					MusicPlayer.play(SongENum.songClip(songNum));
				}

			}
		});
		/**
		 * On click your block will rotate except the square no rotations for square
		 */
		canvas.setOnMouseClicked(event ->{
			rotateBlock(shape);
		});
		//Makes block drop one row every second.
		time.schedule(new TimerTask() {
			@Override
			public void run() {
				//Makes block drop one row every second.
				dropBlocks();
			}	
		}, dropSpeed, dropSpeed);
		//TODO fix multiplying bug when spawning blocks on hit
		time.schedule(new TimerTask() {
			@Override
			public void run() {
				int end = -1;
				if(square.size() == 0) {
					createBlocks(shape);
				}
				if(isHit() && square.get(square.size()-4).getY() <= 75) {
					end = 1;
					time.cancel();
				}
				if(end == 1) {
		
					MusicPlayer.stop();
					songNum = 25;
					MusicPlayer.play(SongENum.songClip(songNum));
				}
				if(isHit() == true) {
					shape = randomShape(shape);
					createBlocks(shape);
				}
			}
		}, 0, 1);
		time.schedule(new TimerTask() {
			@Override
			public void run() {
				rowCheck();
			}
		}, 0,200);
		//TODO fix multiplying bug when spawning blocks on hit
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
		group.getChildren().add(canvas);
		primaryStage.setScene(scene);
		primaryStage.show();
		game.start();
	}
	public void draw(GraphicsContext gc) {
		gc.setFill(Color.WHITE);
		gc.fillRect(0, 0, gc.getCanvas().getWidth(), gc.getCanvas().getHeight());
		for (int i = 0; i < square.size(); i++) {
			square.get(i).draw(gc);
		}
	}
	/**
	 * Allows the Tetris objects to move around
	 * @param direction
	 */
	public void moveBlocks(String direction) {
		if (direction =="Left"){
			for(int i = square.size()-4; i <square.size();i ++) {
				square.get(i).setX((int)(square.get(i).getX()- squareSize));
			}
			if(isHit()) {
				for(int i = square.size()-4; i <square.size();i ++) {
					square.get(i).setX((int)(square.get(i).getX()+ squareSize));
				}
			}
		}else if (direction == "Right") {
			for(int i = square.size()-4; i <square.size();i ++) {
				square.get(i).setX((int)(square.get(i).getX()+ squareSize));
			}
			if(isHit()) {
				for(int i = square.size()-4; i <square.size();i ++) {
					square.get(i).setX((int)(square.get(i).getX()- squareSize));
				}	
			}
		}else if (direction == "Down") {
			dropBlocks();
		}
	}
	/**
	 * Creates the different types of Tetris blocks in the game
	 * @param shape
	 */
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
					x =x +squareSize;
					if(i == 0) {
						x= x+squareSize;
					}
				}else if (i == 3) {
					x = x -squareSize;
				}
				Square s = new Square(x,y,squareSize,squareSize,squareSize,squareSize,Color.LIGHTGREEN);
				square.add(s);
				x=250;
				y=25;
			}
		}else if (shape == 2) {
			//s
			// 20
			//31
			for(int i = 0; i < 4; i ++) {
				if(i ==0) {
					x =x +squareSize;
				}else if (i == 1 ) {
					y =y +squareSize;
				}else if (i == 3) {
					//bottom left
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
			//12
			// 03
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
			// 2
			//031
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
			//2
			//0
			//31
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
			// 2
			// 0
			//13
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
	/**
	 * Checks each row to see if it is completed. If completed it then calls the removeRow method.
	 * @return
	 */
	public void rowCheck() {
		int count =0;
		for(int y=0; y<=600;y=y+25) {
			for (int x = 0; x<=450;x=x+25) {
				for(int i =0;i <square.size();i ++) {
					if(((int)square.get(i).getX()) == x && y == ((int)square.get(i).getY())) {
						count ++;
					}
				}
				System.out.println(count);
				if(count == 17) {
					removeRows(y);
					
				}
			}
			count = 0;
		}
	}
	/**
	 * Removes One full row when it has been completed
	 * @param y
	 */
	public void removeRows(int y) {	
		for (int x = 0; x<=450;x=x+25) {
			for(int i =0;i <square.size();i ++) {
				if(((int)square.get(i).getX()) == x && y == ((int)square.get(i).getY())) {
					square.remove(i);
				}
			}
		}
		dropAllBlocks();
	}
	/**
	 * Generates a random shape from Square.java
	 * @param shape
	 * @return
	 */
	public int randomShape(int shape) {
		shape =	(int) (Math.random() * 7);
		return shape;
	}

	/**
	 * Drops the blocks
	 */
	public void dropBlocks() {
		for(int i = square.size()-4; i <square.size();i ++) {
			square.get(i).setY((int)(square.get(i).getY()+ squareSize));
		}
	}
	/**
	 * Drops all the different types of blocks
	 */
	public void dropAllBlocks() {
		for(int i = 0; i <square.size();i ++) {
			square.get(i).setY((int)square.get(i).getY()+ squareSize);
		}
	}
	/**
	 * Allows User to rotate the random block to fit a certain area
	 * @param shape
	 */
	public void rotateBlock(int shape) {

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
	 * Hit Detection to determine if the random blocks can stack on top of each other
	 * @return
	 */
	public boolean isHit() {
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
						return true;
					}
				} 	
			}	
		}
		return false;
	}
}