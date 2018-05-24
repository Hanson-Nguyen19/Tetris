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
		//square = new Square(20, 20, 0, (int) canvas.getWidth(), 0, (int) canvas.getHeight());
		
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
		
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	public void draw(GraphicsContext gc) {
		gc.setFill(Color.BLACK);
		gc.fillRect(0, 0, gc.getCanvas().getWidth(), gc.getCanvas().getHeight());
		
			square.draw(gc);
	
		gc.drawImage(buffer, 0, 0); // double buffering
	}
	
public void createBlocks(int shape) {
	for(int i = 0; i <4; i ++) {
		if(shape == 0) {
			//2x2 square
			
		}else if (shape == 1) {
			//Line
			
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
public void removeRows() {
	for(int i = 0; i< square.size(); i ++) {
		
	}
}
public void dropBlocks() {
for(int i = square.size()-5; i <square.size();i ++) {
	
}
}
public void rotateBlock(int shape) {
	if(shape == 0) {
		//2x2 square
		
	}else if (shape == 1) {
		//Line
		
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