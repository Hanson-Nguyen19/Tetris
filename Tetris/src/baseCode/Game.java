package baseCode;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

public class Game extends Application{
	
	
	
	
	final int pauseDuration = 40;
	static long numBlocks = 0;
	
	public static void main (String[] args) {
		launch(args);
		
	}
	
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		Group group = new Group();
		Scene scene = new Scene(group, 450, 600);
		primaryStage.setTitle("Tetris");
		Canvas canvas = new Canvas(450, 600);
		final GraphicsContext gc = canvas.getGraphicsContext2D();
		
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
	        for (int i = 0; i < 10; i++) {
	            ColumnConstraints col = new ColumnConstraints(60);
	            gridpane.getColumnConstraints().add(col);
	        }
	        
	        group.getChildren().add(gridpane);

	        Thread game = new Thread(new Runnable() {
				
				/**
				 * Repaints the canvas periodically.
				 */
				@Override
				public void run() {
					while (true) {
						for(int i = 0; i > numBlocks; i++) {
							
						}
						draw(gc);
						try {
							Thread.sleep(pauseDuration);
						} catch (InterruptedException e) {
						}
					}
				}
			});
	        
	        
		canvas.setFocusTraversable(true);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public void draw(GraphicsContext gc) {
		
		
		
	}

}
