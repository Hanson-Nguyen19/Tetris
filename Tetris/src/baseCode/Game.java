/**
 * @projectTetris
 * @createdMay252018 - @createdjune182018
 * @authorSimon, @authorHanson, @authorNavtej
 * Basic controls and display commands
 */

package baseCode;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Game extends Application{


	static long score;
	long[] highScore = new long[5];
	Timer time = new Timer();
	int delay = 0;
	static int shape;
	static ArrayList<Square> square = new ArrayList<Square>();
	final static int squareSize = 25;
	int songNum = (int) (Math.random() * 25)+1;
	static int backNum = (int)(Math.random()*6)+1;
	int dropSpeed = 1000;
	
	public static void main (String[] args) {
		launch(args);
	}

	@Override
	public void init() {
		MusicPlayer.play(SongENum.songClip(songNum));

	}

//	Scene scene1, scene2, scene3;
	//	public void titleScreen(Stage primaryStage) {
	//		
	//		primaryStage.setTitle("Tetris Title Screen");
	//
	//		//Scene 1
	//		Button start = new Button("Start");
	//		Button instr = new Button("Instructions");
	//		Button quit = new Button("Quit");
	//		start.setOnAction(e -> primaryStage.setScene(scene2));  
	//		instr.setOnAction(e -> primaryStage.setScene(scene3));
	//		VBox layout1 = new VBox(30);     
	//		layout1.getChildren().addAll(start, instr, quit);
	//		scene1= new Scene(layout1, 450, 600);
	//
	//		//Scene 2
	//		Button regu = new Button("Regular");
	//		Button chal = new Button("Chalange");
	//		Button retu= new Button("Return");
	//		retu.setOnAction(e -> primaryStage.setScene(scene1));
	//		regu.setOnAction(e -> {
	//			try {
	//				start(primaryStage);
	//			} catch (Exception e1) {
	//				// TODO Auto-generated catch block
	//				e1.printStackTrace();
	//			}
	//		});
	//		chal.setOnAction(e -> {
	//			try {
	//				start(primaryStage);
	//			} catch (Exception e1) {
	//				// TODO Auto-generated catch block
	//				e1.printStackTrace();
	//			}
	//		});
	//		VBox layout2= new VBox(30);
	//		layout2.getChildren().addAll(regu, chal, retu);
	//		scene2= new Scene(layout2, 450, 600);
	//d
	//		//Scene 3
	//		Label instrlbl = new Label("Controlls:\n\n\n\nA: Move Block Left.\nD: Move Block Right.\nS: Move Block Down.\n\nAudio Controlls:\n\n\n\n1-0: Selects Song Number1-10.\nP: Add 10 To The Currently Selected Song Number(up to 25)");
	//		instrlbl.setLayoutX(150);
	//		instrlbl.setLayoutY(25);
	//		VBox layout3= new VBox(30);
	//		layout3.getChildren().addAll(retu);
	//		scene3= new Scene(layout3, 450, 600);
	//		
	//
	//		primaryStage.setScene(scene1);
	//		primaryStage.show();
	//	}

	Image buffer;
	@Override
	public void start(Stage primaryStage) throws Exception {
		//		int initial = 0;
		//		
		//		if(initial == 0) {
		//			initial++;
		//			titleScreen(primaryStage);
		//		}

		Canvas canvas = new Canvas(450, 600);
		Group group = new Group();
		Scene scene = new Scene(group, 450, 600);
		primaryStage.setTitle("Tetris");
		group.getChildren().add(canvas);
		final GraphicsContext gc = canvas.getGraphicsContext2D();
		
//		ImageView iv = new ImageView();
//		iv.setImage(BackgroundENum.eNum(backNum));
//		iv.setFitWidth(450);
//		iv.setFitHeight(600);
//		iv.setPreserveRatio(true);
//		iv.setSmooth(true);
//        iv.setCache(true);
//		group.getChildren().add(iv);
		/**
		 * drops the blocks periodically
		 */
		time.schedule(new TimerTask() {
			@Override
			public void run() {
				Movement.dropBlocks(square, squareSize);
				score += 1;
			}	
		}, dropSpeed, dropSpeed);

		/**
		 * Timer for all things related to hit detection
		 */
		time.schedule(new TimerTask() {
			@Override
			public void run() {
				int end = -1;

				/**
				 * checks if there are any blocks made (to prevent errors)
				 */
				if(square.size() == 0) {
					CreateTetr.createBlocks(shape, square, squareSize);
				}

				/**
				 * checks if the block has not moved and it has collided
				 */
				if(Hit.isHit(square, squareSize) && square.get(square.size()-4).getY() <= 75) {
					end = 1;
					time.cancel();
				}

				/**
				 * plays the credit song if the game has ended
				 */
				if(end == 1) {

					MusicPlayer.stop();
					songNum = 26;
					MusicPlayer.play(SongENum.songClip(songNum));
					File records = new File("Records.txt");

					if(!records.exists()) {
						try {
							records.createNewFile();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
					PrintStream fps = null;
					try {
						fps = new PrintStream(records);
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					Scanner fscan = null;
					try {
						fscan = new Scanner(records);
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					if(records.exists()) {
						highScore[0] = score;
					}
					else {
						highScore[0] = fscan.nextLong();
						highScore[1] = fscan.nextLong();
						highScore[2] = fscan.nextLong();
						highScore[3] = fscan.nextLong();
						highScore[4] = fscan.nextLong();	

						if(score > highScore[0]) {
							highScore[4] = highScore[3];
							highScore[3] = highScore[2];
							highScore[2] = highScore[1];
							highScore[1] = highScore[0];
							highScore[0] = score;
						}
						else if(score > highScore[1]) {
							highScore[4] = highScore[3];
							highScore[3] = highScore[2];
							highScore[2] = highScore[1];
							highScore[1] = score;
						}
						else if(score > highScore[2]) {
							highScore[4] = highScore[3];
							highScore[3] = highScore[2];
							highScore[2] = score;
						}
						else if(score > highScore[3]) {
							highScore[4] = highScore[3];
							highScore[3] = score;
						}
						else if(score > highScore[4]) {
							highScore[4] = score;
						}
					}
					for(int i = 0; i < highScore.length; i++) {
						System.out.println("Place " + (i+1) + " High Score: " + highScore[i]);
					}
					System.out.println("Your Score: " + score);

					fps.println(highScore[0]);
					fps.println(highScore[1]);
					fps.println(highScore[2]);
					fps.println(highScore[3]);
					fps.println(highScore[4]);

					fps.close();
				}

				/**
				 * detects if the block collides anything
				 */
				if(Hit.isHit(square, squareSize) == true) {
					shape = CreateTetr.randomShape(shape);
					CreateTetr.createBlocks(shape, square, squareSize);
					score += 40;
				}
			}
		}, 0, 1);

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
		
		Controller.keyEvent(canvas, songNum, square, squareSize);
		canvas.setOnMouseClicked(event ->{
			Movement.rotateBlock(shape, square, squareSize);
		});
		primaryStage.setScene(scene);
		primaryStage.show();
		game.start();

	}

	/**
	 * Paints canvas white then draws all blocks
	 * @param gc
	 */
	public void draw(GraphicsContext gc) {
		gc.setFill(Color.WHITE);
		gc.fillRect(0, 0, gc.getCanvas().getWidth(), gc.getCanvas().getHeight());
		gc.fillText(("High Score: " + highScore[0]), 25, 0);
		gc.fillText(("your score: " + score), 25, 25);
		for (int i = 0; i < square.size(); i++) {
			square.get(i).draw(gc);
		}
	}

}