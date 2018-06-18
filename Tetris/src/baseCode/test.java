//package baseCode;
//
//import javafx.application.Application;
//import javafx.event.ActionEvent;
//import javafx.event.EventHandler;
//import javafx.scene.Scene;
//import javafx.scene.control.Button;
//import javafx.scene.control.Label;
//import javafx.scene.layout.StackPane;
//import javafx.scene.layout.VBox;
//import javafx.stage.Stage;
//
//public class test extends Application {
//
//	Scene scene1, scene2, scene3;
//
//	@Override
//	public void start(Stage primaryStage) {
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
//		regu.setOnAction(e -> Game.startGame());
//		chal.setOnAction(e -> Game.startGame());
//		VBox layout2= new VBox(30);
//		layout2.getChildren().addAll(regu, chal, retu);
//		scene2= new Scene(layout2, 450, 600);
//
//		//Scene 3
//		VBox layout3= new VBox(30);
//		layout3.getChildren().addAll(retu);
//		scene3= new Scene(layout3, 450, 600);
//
//
//		primaryStage.setScene(scene1);
//		primaryStage.show();
//	}
//
//	public static void main(String[] args) {
//		launch(args);
//	}
//
//}
//
//
