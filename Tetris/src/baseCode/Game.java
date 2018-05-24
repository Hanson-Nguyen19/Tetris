package baseCode;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

public class Game extends Application{
	Timer time = new Timer();
	ArrayList <Square> square = new ArrayList<Square>();
	int shape = 0;
	public static void main (String[] args) {
		launch(args);
		
	}
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		
		Group group = new Group();
		Scene scene = new Scene(group, 450, 600);
		primaryStage.setTitle("Tetris");
		Canvas canvas = new Canvas(450, 600);
		final GraphicsContext gc = canvas.getGraphicsContext2D();
		
		//Makes 2 buttons
		Button start = new Button("Start");
		Button instructions= new Button("Rules");
		start.setLayoutX(200);
		start.setLayoutY(270);
		instructions.setLayoutX(200);
		instructions.setLayoutY(295);
		group.getChildren().add(start);
		group.getChildren().add(instructions);
		
		 GridPane gridpane = new GridPane();
	        for (int i = 0; i < 10; i++) {
	            RowConstraints row = new RowConstraints(60);
	            gridpane.getRowConstraints().add(row);
	        }
	    
	        
	        group.getChildren().add(gridpane);

		canvas.setFocusTraversable(true);
		primaryStage.setScene(scene);
		primaryStage.show();
		
		time.schedule(new TimerTask() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
			//Makes block drop one row every second.
				
			}
			
		}, 1000, 1000);
	}
	public void createBlocks(int shape) {
		for(int i = 0; i <4; i ++) {
			if(shape == 0) {
				
			}else if (shape == 1) {
				
			}else if (shape == 2) {
				
			}else if (shape == 3) {
				
			}else if (shape == 4) {
				
			}else if (shape == 5) {
				
			}else if (shape == 6) {
				
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
			
		}else if (shape == 1) {
			
		}else if (shape == 2) {
			
		}else if (shape == 3) {
			
		}else if (shape == 4) {
			
		}else if (shape == 5) {
			
		}else if (shape == 6) {
			
		}
	}

}
