
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
	int shape = (int) (Math.random() * 7)-1;
	ArrayList<Square> square = new ArrayList<Square>();
	final int squareSize = 25;
	int song = (int) (Math.random() * 6)-1;

	public static void main (String[] args) {

		launch(args);

	}

	Image buffer;

	@Override

	public void start(Stage primaryStage) throws Exception {

		// TODO Auto-generated method stub

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

		//Clip song7 = AudioSystem.getClip();

		//song7.open(AudioSystem.getAudioInputStream(new File("src/Resources/BalrogSF.wav")));

		if(song == 1) {

			song1.start();

		}else if (song ==2) {

			song2.start();

		}else if (song ==3) {

			song3.start();

		}else if (song ==4) {

			song4.start();

		}else if (song ==5) {

			song5.start();

		}else if (song ==6) {

			song6.start();

		}//else if (song ==7) {

	//		song7.start();

	//	}



		//	for (int i = 0; i < square.size(); i++) {

		//	for (int i = 0; i < (squareSize*2); i++) {

		//	square.add(new Square(squareSize, squareSize, 0, (int)canvas.getWidth(), 0, (int)canvas.getHeight()));

		//	square.get(i).setXSpeed(0);

		//	square.get(i).setYSpeed(0);

		//	square.get(i).setColor(Color.BLACK);

		//	}

		createBlocks(shape);





		//	Button start = new Button("Start");

		//	Button instructions= new Button("Rules");

		//	start.setLayoutX((squareSize*2)0);

		//	start.setLayoutY(270);

		//	instructions.setLayoutX((squareSize*2)0);

		//	instructions.setLayoutY(295);

		//	group.getChildren().add(start);

		//	group.getChildren().add(instructions);



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

			}

		});

		canvas.setOnKeyReleased(event -> {

			if(event.getCode() == KeyCode.A) {



			}else if(event.getCode() == KeyCode.D) {



			}

		});



		time.schedule(new TimerTask() {



			@Override

			public void run() {

				//Makes block drop one row every second.

				dropBlocks();

			}



		}, 1000, 1000);



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

		group.getChildren().add(canvas);

		primaryStage.setScene(scene);

		game.start();

		primaryStage.show();


		
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

				Square s = new Square(x,y,squareSize,squareSize,squareSize,squareSize);

				square.add(s);

				square.get(i).setColor(Color.RED);

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

				Square s = new Square(x,y,squareSize,squareSize,squareSize,squareSize);

				square.add(s);

				square.get(i).setColor(Color.BLACK);

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

				Square s = new Square(x,y,squareSize,squareSize,squareSize,squareSize);

				square.add(s);

				square.get(i).setColor(Color.GREEN);

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

				Square s = new Square(x,y,squareSize,squareSize,squareSize,squareSize);

				square.add(s);

				square.get(i).setColor(Color.ORANGE);

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

				Square s = new Square(x,y,squareSize,squareSize,squareSize,squareSize);

				square.add(s);

				square.get(i).setColor(Color.PURPLE);

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

				Square s = new Square(x,y,squareSize,squareSize,squareSize,squareSize);

				square.add(s);

				square.get(i).setColor(Color.BLUE);

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

				Square s = new Square(x,y,squareSize,squareSize,squareSize,squareSize);

				square.add(s);

				square.get(i).setColor(Color.GOLD);

				x=250;

				y=25;

			}

		}



	}

	public void removeRows() {

		for(int i = 0; i< square.size(); i ++) {

			square.get(i).getX();

			square.get(i).getY();
		}

	}

	public void dropBlocks() {

		for(int i = square.size()-4; i <square.size();i ++) {

			square.get(i).setY((int)(square.get(i).getY()+ squareSize));

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


}