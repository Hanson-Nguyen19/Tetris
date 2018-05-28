package baseCode;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;


import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class Game extends Application{
	//Square square;
	Timer time = new Timer();
	int shape = 0;
	ArrayList<Square> square = new ArrayList<Square>();
	
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
	
		
//		for (int i = 0; i < square.size(); i++) {
		for (int i = 0; i < 20; i++) {
			square.add(new Square(50, 50, 0, (int)canvas.getWidth(), 0, (int)canvas.getHeight()));
			square.get(i).setXSpeed(0);
			square.get(i).setYSpeed(0);
			square.get(i).setColor(Color.WHITE);
		}


		//		Button start = new Button("Start");
		//		Button instructions= new Button("Rules");
		//		start.setLayoutX(200);
		//		start.setLayoutY(270);
		//		instructions.setLayoutX(200);
		//		instructions.setLayoutY(295);
		//		group.getChildren().add(start);
		//		group.getChildren().add(instructions);

		GridPane gridpane = new GridPane();
		for (int i = 0; i < 10; i++) {
			RowConstraints row = new RowConstraints(60);
			gridpane.getRowConstraints().add(row);
		}

		time.schedule(new TimerTask() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				//Makes block drop one row every second.
				//dropBlocks();
			}

		}, 500, 500);

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
		gc.setFill(Color.BLACK);
		gc.fillRect(0, 0, gc.getCanvas().getWidth(), gc.getCanvas().getHeight());
		for (int i = 0; i < square.size(); i++) {
			square.get(i).draw(gc);
		}
	}

	public void createBlocks(int shape) {
		double x = 200;
		double y = 0;
		if(shape == 0) {
			//2x2 square
			for(int i = 0; i < 4; i ++) {
				if(i == 1) {
					y = y +10;
				}else {
					if(i == 3) {
						x = x +10;
						y = y +10;
					}
					x = x +10;
				}
				Square s = new Square(x,y,10,10,10,10);
				square.add(s);
			}
		}else if (shape == 1) {
			//Line
			for(int i = 0; i < 4; i ++) {
				if(i <=1) {
					if(i == 0) {
						x= x-20;
					}
					x =x -10;
				}else if (i == 3) {
					x = x +10;
				}
				Square s = new Square(x,y,10,10,10,10);
				square.add(s);
			}
		}else if (shape == 2) {
			//s
			for(int i = 0; i < 4; i ++) {
				if(i ==0) {
					x =x +10;
				}else if (i == 1 ) {
					y =y +10;
				}else if (i == 3) {
					x = x -10;
					y =y +10;
				}
				Square s = new Square(x,y,10,10,10,10);
				square.add(s);
			}
		}else if (shape == 3) {
			//z
			for(int i = 0; i < 4; i ++) {
				if(i ==0) {
					x =x -10;
				}else if (i == 1 ) {
					y =y +10;
				}else if (i == 3) {
					x = x +10;
					y =y +10;
				}
				Square s = new Square(x,y,10,10,10,10);
				square.add(s);
			}
		}else if (shape == 4) {
			//upside-down t
			for(int i = 0; i < 4; i ++) {
				if(i != 2) {
					y = y +10;
					if(i == 0) {
						x = x +10;
					}else if (i == 3) {
						x = x -10;
					}
				}
				Square s = new Square(x,y,10,10,10,10);
				square.add(s);
			}
		}else if (shape == 5) {
			//L
			for(int i = 0; i < 4; i ++) {
				if(i < 3) {
					if(i == 1) {
						y = y +20;
					}else if(i ==2) {
						y = y +10;
					} 
				}else if (i ==3) {
					x = x +10;
					y = y +20;
				}
				Square s = new Square(x,y,10,10,10,10);
				square.add(s);
			}
		}else if (shape == 6) {
			//inverted L
			for(int i = 0; i < 4; i ++) {
				if(i < 3) {
					if(i == 1) {
						y = y +20;
					}else if(i ==2) {
						y = y +10;
					} 
				}else if (i ==3) {
					x = x -10;
					y = y +20;
				}
				Square s = new Square(x,y,10,10,10,10);
				square.add(s);
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
		for(int i = square.size()-5; i <square.size();i ++) {
			square.get(i).setX((int)square.get(i).getX());
			square.get(i).setY((int)square.get(i).getY());
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