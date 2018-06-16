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
	static ArrayList<Square> square = new ArrayList<Square>();
	final static int squareSize = 25;
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
				Movement.moveBlocks(direction, square, squareSize);
			}else if(event.getCode() == KeyCode.D) {
				direction = "Right";
				Movement.moveBlocks(direction, square, squareSize);
			}else if(event.getCode() == KeyCode.S) {
				direction = "Down";
				Movement.moveBlocks(direction, square, squareSize);
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
			Movement.rotateBlock(shape, square, squareSize);
		});
		
		//Makes block drop one row every second.
		time.schedule(new TimerTask() {
			@Override
			public void run() {
				Movement.dropBlocks(square, squareSize);
			}	
		}, dropSpeed, dropSpeed);
		
		time.schedule(new TimerTask() {
			@Override
			public void run() {
				int end = -1;
				if(square.size() == 0) {
					CreateTetr.createBlocks(shape, square, squareSize);
				}
				if(Hit.isHit(square, squareSize) && square.get(square.size()-4).getY() <= 75) {
					end = 1;
					time.cancel();
				}
				if(end == 1) {
		
					MusicPlayer.stop();
					songNum = 25;
					MusicPlayer.play(SongENum.songClip(songNum));
				}
				if(Hit.isHit(square, squareSize) == true) {
					shape = CreateTetr.randomShape(shape);
					CreateTetr.createBlocks(shape, square, squareSize);
				}
			}
		}, 0, 1);
		
		time.schedule(new TimerTask() {
			@Override
			public void run() {
				Grid.rowCheck(square);
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
	
}