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
	int songNum = (int) (Math.random() * 24)+1;
	int dropSpeed = 1000;
	public static void main (String[] args) {
		launch(args);
	}
	
	@Override
	public void init() {
		/**
		 * All the songs in the code
		 */
		Clip s1ong1 = AudioSystem.getClip();
		s1ong1.open(AudioSystem.getAudioInputStream(new File("src/Resources/Castle Rock.wav")));
		
		
		Clip s2ong2 = AudioSystem.getClip();
		s2ong2.open(AudioSystem.getAudioInputStream(new File("src/Resources/TetrisDance.wav")));
		
		
		Clip s3ong3 = AudioSystem.getClip();
		s3ong3.open(AudioSystem.getAudioInputStream(new File("src/Resources/Fever Dr. Mario.wav")));
		
		
		Clip s4ong4 = AudioSystem.getClip();
		s4ong4.open(AudioSystem.getAudioInputStream(new File("src/Resources/Paper Mario.wav")));
		
		
		Clip s5ong5 = AudioSystem.getClip();
		s5ong5.open(AudioSystem.getAudioInputStream(new File("src/Resources/Snow Bros.wav")));
		
		
		Clip s6ong6 = AudioSystem.getClip();
		s6ong6.open(AudioSystem.getAudioInputStream(new File("src/Resources/Super Mario Bros.wav")));
		
		
		Clip s7ong7 = AudioSystem.getClip();
		s7ong7.open(AudioSystem.getAudioInputStream(new File("src/Resources/Battletoads.wav")));
		
		
		Clip s8ong8 = AudioSystem.getClip();
		s8ong8.open(AudioSystem.getAudioInputStream(new File("src/Resources/FlashManStage.wav")));
		
		
		Clip s9ong9 = AudioSystem.getClip();
		s9ong9.open(AudioSystem.getAudioInputStream(new File("src/Resources/TheManWithTheMachineGun.wav")));
		
		
		Clip s0ong10 = AudioSystem.getClip();
		s0ong10.open(AudioSystem.getAudioInputStream(new File("src/Resources/Balrog.wav")));
		
		
		Clip s1ong11 = AudioSystem.getClip();
		s1ong11.open(AudioSystem.getAudioInputStream(new File("src/Resources/DuckTales.wav")));
		
		
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
		
		
		Clip song18 = AudioSystem.getClip();
		song18.open(AudioSystem.getAudioInputStream(new File("src/Resources/PAC-MAN.wav")));
		
		
		Clip song19 = AudioSystem.getClip();
		song19.open(AudioSystem.getAudioInputStream(new File("src/Resources/Excitebike Arena.wav")));
		
		
		Clip song20 = AudioSystem.getClip();
		song20.open(AudioSystem.getAudioInputStream(new File("src/Resources/BrinstarDepths.wav")));
		
		
		Clip song21 = AudioSystem.getClip();
		song21.open(AudioSystem.getAudioInputStream(new File("src/Resources/LuigisMansion.wav")));
		
		
		Clip song22 = AudioSystem.getClip();
		song22.open(AudioSystem.getAudioInputStream(new File("src/Resources/BloodyPurity.wav")));
		
		
		Clip song23 = AudioSystem.getClip();
		song23.open(AudioSystem.getAudioInputStream(new File("src/Resources/MaloMart.wav")));
		
		
		Clip song24 = AudioSystem.getClip();
		song24.open(AudioSystem.getAudioInputStream(new File("src/Resources/TheBlocksWeLoved.wav")));
		
		
		Clip credit = AudioSystem.getClip();
		credit.open(AudioSystem.getAudioInputStream(new File("src/Resources/AssassinsCreed III.wav")));

		
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


		/**
		 * All the songs in the code
		 */
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
		Clip song18 = AudioSystem.getClip();
		song18.open(AudioSystem.getAudioInputStream(new File("src/Resources/PAC-MAN.wav")));
		Clip song19 = AudioSystem.getClip();
		song19.open(AudioSystem.getAudioInputStream(new File("src/Resources/Excitebike Arena.wav")));
		Clip song20 = AudioSystem.getClip();
		song20.open(AudioSystem.getAudioInputStream(new File("src/Resources/BrinstarDepths.wav")));
		Clip song21 = AudioSystem.getClip();
		song21.open(AudioSystem.getAudioInputStream(new File("src/Resources/LuigisMansion.wav")));
		Clip song22 = AudioSystem.getClip();
		song22.open(AudioSystem.getAudioInputStream(new File("src/Resources/BloodyPurity.wav")));
		Clip song23 = AudioSystem.getClip();
		song23.open(AudioSystem.getAudioInputStream(new File("src/Resources/MaloMart.wav")));
		Clip song24 = AudioSystem.getClip();
		song24.open(AudioSystem.getAudioInputStream(new File("src/Resources/TheBlocksWeLoved.wav")));
		Clip credit = AudioSystem.getClip();
		credit.open(AudioSystem.getAudioInputStream(new File("src/Resources/AssassinsCreed III.wav")));

				boolean startPressed= true;
				title.start();
				Button start = new Button("Start");
				Button instructions= new Button("Rules");
				start.setLayoutX(200);
				start.setLayoutY(270);
				instructions.setLayoutX(200);
				instructions.setLayoutY(295);
				group.getChildren().add(start);
				group.getChildren().add(instructions);
				group.getChildren().add(canvas);
				primaryStage.setScene(scene);
				primaryStage.show();
				do {
					if(start.isPressed()) {
						startPressed = true;
					}else if(instructions.isPressed()) {
						System.out.println("Rotate Blocks with a mouse click, move left or right with the 'A' and 'D' keys,");
						System.out.println("Ad");
					}
				}while(startPressed == false);	
				title.stop();
						gc.setFill( Color.WHITE );
						gc.setStroke( Color.WHITE );
						gc.setLineWidth(2);
						Font theFont = Font.font( "", FontWeight.BOLD, 50 );
						Font buttonFont = Font.font( "", FontWeight.BOLD, 20 );
						gc.setFont( theFont );
						gc.fillText( "Welcome To Tetris", 100, 200 );//this is the text that will be printed to the screen
						gc.strokeText( "Welcome To Tetris", 100, 200 );
						Button start = new Button("START");//this button will lead to the game mode selection screen
						//Button highscores = new Button("HIGHSCORES");//this button will prompt the high scores menu to appear
						Button instructions = new Button ("Instructions");// this button will display the controls and objective of the game.
						start.setLayoutX(200);
						start.setLayoutY(270);
						instructions.setLayoutX(200);
						instructions.setLayoutY(295);
						start.setStyle("-fx-background-color: white; -fx-text-fill: black;"); 
						//highscores.setStyle("-fx-background-color: white; -fx-text-fill: black;"); 
						instructions.setStyle("-fx-background-color: white; -fx-text-fill: black;"); 
						start.setFont(buttonFont);
						//highscores.setFont(buttonFont);
						instructions.setFont(buttonFont);
						group.getChildren().add(start);
						group.getChildren().add(instructions);
						group.getChildren().add(canvas);
						primaryStage.setScene(scene);
						start.setOnAction(new EventHandler<ActionEvent>() {
							@Override 
							public void handle(ActionEvent e) {
								gc.clearRect(0, 0, gc.getCanvas().getWidth(), gc.getCanvas().getHeight());
							}});

		if(songNum == 1) {
			song1.start();
			song1.loop(song1.LOOP_CONTINUOUSLY);
		}else if (songNum ==2) {
			song2.start();
			song2.loop(song2.LOOP_CONTINUOUSLY);
		}else if (songNum ==3) {
			song3.start();
			song3.loop(song3.LOOP_CONTINUOUSLY);
		}else if (songNum ==4) {
			song4.start();
			song4.loop(song4.LOOP_CONTINUOUSLY);
		}else if (songNum ==5) {
			song5.start();
			song5.loop(song5.LOOP_CONTINUOUSLY);
		}else if (songNum ==6) {
			song6.start();
			song6.loop(song6.LOOP_CONTINUOUSLY);
		}else if (songNum ==7) {
			song7.start();
			song7.loop(song7.LOOP_CONTINUOUSLY);
		}else if (songNum ==8) {
			song8.start();
			song8.loop(song8.LOOP_CONTINUOUSLY);
		}else if (songNum ==9) {
			song9.start();
			song9.loop(song9.LOOP_CONTINUOUSLY);
		}else if (songNum ==10) {
			song10.start();
			song10.loop(song10.LOOP_CONTINUOUSLY);
		}else if (songNum ==11) {
			song11.start();
			song11.loop(song11.LOOP_CONTINUOUSLY);
		}else if (songNum ==12) {
			song12.start();
			song12.loop(song12.LOOP_CONTINUOUSLY);
		}else if (songNum ==13) {
			song13.start();
			song13.loop(song13.LOOP_CONTINUOUSLY);
		}else if (songNum ==14) {
			song14.start();
			song14.loop(song14.LOOP_CONTINUOUSLY);
		}else if (songNum ==15) {
			song15.start();
			song15.loop(song15.LOOP_CONTINUOUSLY);
		}else if (songNum ==16) {
			song16.start();
			song16.loop(song16.LOOP_CONTINUOUSLY);
		}else if (songNum ==17) {
			song17.start();
			song17.loop(song17.LOOP_CONTINUOUSLY);
		}else if (songNum ==18) {
			song18.start();
			song18.loop(song18.LOOP_CONTINUOUSLY);
		}else if (songNum == 19) {
			song19.start();
			song19.loop(song19.LOOP_CONTINUOUSLY);
		}else if (songNum == 20) {
			song20.start();
			song20.loop(song20.LOOP_CONTINUOUSLY);
		}else if (songNum == 21) {
			song21.start();
			song21.loop(song21.LOOP_CONTINUOUSLY);
		}else if (songNum == 22) {
			song22.start();
			song22.loop(song22.LOOP_CONTINUOUSLY);
		}else if (songNum == 23) {
			song23.start();
			song23.loop(song23.LOOP_CONTINUOUSLY);
		}else if (songNum == 24) {
			song24.start();
			song24.loop(song24.LOOP_CONTINUOUSLY);
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
			}else if(event.getCode() == KeyCode.DIGIT1) {
				if (songNum ==2) {
					song2.stop();
				}else if (songNum ==3) {
					song3.stop();
				}else if (songNum ==4) {
					song4.stop();
				}else if (songNum ==5) {
					song5.stop();
				}else if (songNum ==6) {
					song6.stop();
				}else if (songNum ==7) {
					song7.stop();
				}else if (songNum ==8) {
					song8.stop();
				}else if (songNum ==9) {
					song9.stop();
				}else if (songNum ==10) {
					song10.stop();
				}else if (songNum ==11) {
					song11.stop();
				}else if (songNum ==12) {
					song12.stop();
				}else if (songNum ==13) {
					song13.stop();
				}else if (songNum ==14) {
					song14.stop();
				}else if (songNum ==15) {
					song15.stop();
				}else if (songNum ==16) {
					song16.stop();
				}else if (songNum ==17) {
					song17.stop();
				}else if (songNum ==18) {
					song18.stop();
				}else if (songNum == 19) {
					song19.stop();
				}else if (songNum == 20) {
					song20.stop();
				}else if (songNum == 21) {
					song21.stop();
				}else if (songNum == 22) {
					song22.stop();
				}else if (songNum == 23) {
					song23.stop();
				}else if (songNum == 24) {
					song24.stop();
				}
				song1.start();
				song1.loop(song1.LOOP_CONTINUOUSLY);
				songNum = 1;
			}else if(event.getCode() == KeyCode.DIGIT2) {
				if(songNum == 1) {
					song1.stop();
				}else if (songNum ==3) {
					song3.stop();
				}else if (songNum ==4) {
					song4.stop();
				}else if (songNum ==5) {
					song5.stop();
				}else if (songNum ==6) {
					song6.stop();
				}else if (songNum ==7) {
					song7.stop();
				}else if (songNum ==8) {
					song8.stop();
				}else if (songNum ==9) {
					song9.stop();
				}else if (songNum ==10) {
					song10.stop();
				}else if (songNum ==11) {
					song11.stop();
				}else if (songNum ==12) {
					song12.stop();
				}else if (songNum ==13) {
					song13.stop();
				}else if (songNum ==14) {
					song14.stop();
				}else if (songNum ==15) {
					song15.stop();
				}else if (songNum ==16) {
					song16.stop();
				}else if (songNum ==17) {
					song17.stop();
				}else if (songNum ==18) {
					song18.stop();
				}else if (songNum == 19) {
					song19.stop();
				}else if (songNum == 20) {
					song20.stop();
				}else if (songNum == 21) {
					song21.stop();
				}else if (songNum == 22) {
					song22.stop();
				}else if (songNum == 23) {
					song23.stop();
				}else if (songNum == 24) {
					song24.stop();
				}
				song2.start();
				song2.loop(song2.LOOP_CONTINUOUSLY);
				songNum = 2;
			}else if(event.getCode() == KeyCode.DIGIT3) {
				if(songNum == 1) {
					song1.stop();
				}else if (songNum ==2) {
					song2.stop();
				}else if (songNum ==4) {
					song4.stop();
				}else if (songNum ==5) {
					song5.stop();
				}else if (songNum ==6) {
					song6.stop();
				}else if (songNum ==7) {
					song7.stop();
				}else if (songNum ==8) {
					song8.stop();
				}else if (songNum ==9) {
					song9.stop();
				}else if (songNum ==10) {
					song10.stop();
				}else if (songNum ==11) {
					song11.stop();
				}else if (songNum ==12) {
					song12.stop();
				}else if (songNum ==13) {
					song13.stop();
				}else if (songNum ==14) {
					song14.stop();
				}else if (songNum ==15) {
					song15.stop();
				}else if (songNum ==16) {
					song16.stop();
				}else if (songNum ==17) {
					song17.stop();
				}else if (songNum ==18) {
					song18.stop();
				}else if (songNum == 19) {
					song19.stop();
				}else if (songNum == 20) {
					song20.stop();
				}else if (songNum == 21) {
					song21.stop();
				}else if (songNum == 22) {
					song22.stop();
				}else if (songNum == 23) {
					song23.stop();
				}else if (songNum == 24) {
					song24.stop();
				}
				song3.start();
				song3.loop(song3.LOOP_CONTINUOUSLY);
				songNum = 3;
			}else if(event.getCode() == KeyCode.DIGIT4) {
				if(songNum == 1) {
					song1.stop();
				}else if (songNum ==2) {
					song2.stop();
				}else if (songNum ==3) {
					song3.stop();
				}else if (songNum ==5) {
					song5.stop();
				}else if (songNum ==6) {
					song6.stop();
				}else if (songNum ==7) {
					song7.stop();
				}else if (songNum ==8) {
					song8.stop();
				}else if (songNum ==9) {
					song9.stop();
				}else if (songNum ==10) {
					song10.stop();
				}else if (songNum ==11) {
					song11.stop();
				}else if (songNum ==12) {
					song12.stop();
				}else if (songNum ==13) {
					song13.stop();
				}else if (songNum ==14) {
					song14.stop();
				}else if (songNum ==15) {
					song15.stop();
				}else if (songNum ==16) {
					song16.stop();
				}else if (songNum ==17) {
					song17.stop();
				}else if (songNum ==18) {
					song18.stop();
				}else if (songNum == 19) {
					song19.stop();
				}else if (songNum == 20) {
					song20.stop();
				}else if (songNum == 21) {
					song21.stop();
				}else if (songNum == 22) {
					song22.stop();
				}else if (songNum == 23) {
					song23.stop();
				}else if (songNum == 24) {
					song24.stop();
				}
				song4.start();
				song4.loop(song4.LOOP_CONTINUOUSLY);
				songNum = 4;
			}else if(event.getCode() == KeyCode.DIGIT5) {
				if(songNum == 1) {
					song1.stop();
				}else if (songNum ==2) {
					song2.stop();
				}else if (songNum ==3) {
					song3.stop();
				}else if (songNum ==4) {
					song4.stop();
				}else if (songNum ==6) {
					song6.stop();
				}else if (songNum ==7) {
					song7.stop();
				}else if (songNum ==8) {
					song8.stop();
				}else if (songNum ==9) {
					song9.stop();
				}else if (songNum ==10) {
					song10.stop();
				}else if (songNum ==11) {
					song11.stop();
				}else if (songNum ==12) {
					song12.stop();
				}else if (songNum ==13) {
					song13.stop();
				}else if (songNum ==14) {
					song14.stop();
				}else if (songNum ==15) {
					song15.stop();
				}else if (songNum ==16) {
					song16.stop();
				}else if (songNum ==17) {
					song17.stop();
				}else if (songNum ==18) {
					song18.stop();
				}else if (songNum == 19) {
					song19.stop();
				}else if (songNum == 20) {
					song20.stop();
				}else if (songNum == 21) {
					song21.stop();
				}else if (songNum == 22) {
					song22.stop();
				}else if (songNum == 23) {
					song23.stop();
				}else if (songNum == 24) {
					song24.stop();
				}
				song5.start();
				song5.loop(song5.LOOP_CONTINUOUSLY);
				songNum = 5;
			}else if(event.getCode() == KeyCode.DIGIT6) {
				if(songNum == 1) {
					song1.stop();
				}else if (songNum ==2) {
					song2.stop();
				}else if (songNum ==3) {
					song3.stop();
				}else if (songNum ==4) {
					song4.stop();
				}else if (songNum ==5) {
					song5.stop();
				}else if (songNum ==7) {
					song7.stop();
				}else if (songNum ==8) {
					song8.stop();
				}else if (songNum ==9) {
					song9.stop();
				}else if (songNum ==10) {
					song10.stop();
				}else if (songNum ==11) {
					song11.stop();
				}else if (songNum ==12) {
					song12.stop();
				}else if (songNum ==13) {
					song13.stop();
				}else if (songNum ==14) {
					song14.stop();
				}else if (songNum ==15) {
					song15.stop();
				}else if (songNum ==16) {
					song16.stop();
				}else if (songNum ==17) {
					song17.stop();
				}else if (songNum ==18) {
					song18.stop();
				}else if (songNum == 19) {
					song19.stop();
				}else if (songNum == 20) {
					song20.stop();
				}else if (songNum == 21) {
					song21.stop();
				}else if (songNum == 22) {
					song22.stop();
				}else if (songNum == 23) {
					song23.stop();
				}else if (songNum == 24) {
					song24.stop();
				}
				song6.start();
				song6.loop(song6.LOOP_CONTINUOUSLY);
				songNum = 6;
			}else if(event.getCode() == KeyCode.DIGIT7) {
				if(songNum == 1) {
					song1.stop();
				}else if (songNum ==2) {
					song2.stop();
				}else if (songNum ==3) {
					song3.stop();
				}else if (songNum ==4) {
					song4.stop();
				}else if (songNum ==5) {
					song5.stop();
				}else if (songNum ==6) {
					song6.stop();
				}else if (songNum ==8) {
					song8.stop();
				}else if (songNum ==9) {
					song9.stop();
				}else if (songNum ==10) {
					song10.stop();
				}else if (songNum ==11) {
					song11.stop();
				}else if (songNum ==12) {
					song12.stop();
				}else if (songNum ==13) {
					song13.stop();
				}else if (songNum ==14) {
					song14.stop();
				}else if (songNum ==15) {
					song15.stop();
				}else if (songNum ==16) {
					song16.stop();
				}else if (songNum ==17) {
					song17.stop();
				}else if (songNum ==18) {
					song18.stop();
				}else if (songNum == 19) {
					song19.stop();
				}else if (songNum == 20) {
					song20.stop();
				}else if (songNum == 21) {
					song21.stop();
				}else if (songNum == 22) {
					song22.stop();
				}else if (songNum == 23) {
					song23.stop();
				}else if (songNum == 24) {
					song24.stop();
				}
				song7.start();
				song7.loop(song7.LOOP_CONTINUOUSLY);
				songNum = 7;
			}else if(event.getCode() == KeyCode.DIGIT8) {
				if(songNum == 1) {
					song1.stop();
				}else if (songNum ==2) {
					song2.stop();
				}else if (songNum ==3) {
					song3.stop();
				}else if (songNum ==4) {
					song4.stop();
				}else if (songNum ==5) {
					song5.stop();
				}else if (songNum ==6) {
					song6.stop();
				}else if (songNum ==7) {
					song7.stop();
				}else if (songNum ==9) {
					song9.stop();
				}else if (songNum ==10) {
					song10.stop();
				}else if (songNum ==11) {
					song11.stop();
				}else if (songNum ==12) {
					song12.stop();
				}else if (songNum ==13) {
					song13.stop();
				}else if (songNum ==14) {
					song14.stop();
				}else if (songNum ==15) {
					song15.stop();
				}else if (songNum ==16) {
					song16.stop();
				}else if (songNum ==17) {
					song17.stop();
				}else if (songNum ==18) {
					song18.stop();
				}else if (songNum == 19) {
					song19.stop();
				}else if (songNum == 20) {
					song20.stop();
				}else if (songNum == 21) {
					song21.stop();
				}else if (songNum == 22) {
					song22.stop();
				}else if (songNum == 23) {
					song23.stop();
				}else if (songNum == 24) {
					song24.stop();
				}
				song8.start();
				song8.loop(song8.LOOP_CONTINUOUSLY);
				songNum = 8;
			}else if(event.getCode() == KeyCode.DIGIT9) {
				if(songNum == 1) {
					song1.stop();
				}else if (songNum ==2) {
					song2.stop();
				}else if (songNum ==3) {
					song3.stop();
				}else if (songNum ==4) {
					song4.stop();
				}else if (songNum ==5) {
					song5.stop();
				}else if (songNum ==6) {
					song6.stop();
				}else if (songNum ==7) {
					song7.stop();
				}else if (songNum ==8) {
					song8.stop();
				}else if (songNum ==10) {
					song10.stop();
				}else if (songNum ==11) {
					song11.stop();
				}else if (songNum ==12) {
					song12.stop();
				}else if (songNum ==13) {
					song13.stop();
				}else if (songNum ==14) {
					song14.stop();
				}else if (songNum ==15) {
					song15.stop();
				}else if (songNum ==16) {
					song16.stop();
				}else if (songNum ==17) {
					song17.stop();
				}else if (songNum ==18) {
					song18.stop();
				}else if (songNum == 19) {
					song19.stop();
				}else if (songNum == 20) {
					song20.stop();
				}else if (songNum == 21) {
					song21.stop();
				}else if (songNum == 22) {
					song22.stop();
				}else if (songNum == 23) {
					song23.stop();
				}else if (songNum == 24) {
					song24.stop();
				}
				song9.start();
				song9.loop(song9.LOOP_CONTINUOUSLY);
				songNum = 9;
			}else if(event.getCode() == KeyCode.DIGIT0) {
				if(songNum == 1) {
					song1.stop();
				}else if (songNum ==2) {
					song2.stop();
				}else if (songNum ==3) {
					song3.stop();
				}else if (songNum ==4) {
					song4.stop();
				}else if (songNum ==5) {
					song5.stop();
				}else if (songNum ==6) {
					song6.stop();
				}else if (songNum ==7) {
					song7.stop();
				}else if (songNum ==8) {
					song8.stop();
				}else if (songNum ==9) {
					song9.stop();
				}else if (songNum ==11) {
					song11.stop();
				}else if (songNum ==12) {
					song12.stop();
				}else if (songNum ==13) {
					song13.stop();
				}else if (songNum ==14) {
					song14.stop();
				}else if (songNum ==15) {
					song15.stop();
				}else if (songNum ==16) {
					song16.stop();
				}else if (songNum ==17) {
					song17.stop();
				}else if (songNum ==18) {
					song18.stop();
				}else if (songNum == 19) {
					song19.stop();
				}else if (songNum == 20) {
					song20.stop();
				}else if (songNum == 21) {
					song21.stop();
				}else if (songNum == 22) {
					song22.stop();
				}else if (songNum == 23) {
					song23.stop();
				}else if (songNum == 24) {
					song24.stop();
				}
				song10.start();
				song10.loop(song10.LOOP_CONTINUOUSLY);
				songNum = 10;
			}else if (event.getCode() == KeyCode.P) {
				if(songNum <=14) {
					songNum = songNum + 10;
				}
				if(songNum== 11){
					song1.stop();
					song11.start();
					song11.loop(song11.LOOP_CONTINUOUSLY);
					songNum = 11;
				}else if (songNum==12) {
					song2.stop();
					song12.start();
					song12.loop(song12.LOOP_CONTINUOUSLY);
					songNum = 12;
				}else if (songNum==13) {
					song3.stop();
					song13.start();
					song13.loop(song13.LOOP_CONTINUOUSLY);
					songNum = 13;
				}else if (songNum ==14) {
					song4.stop();
					song14.start();
					song14.loop(song14.LOOP_CONTINUOUSLY);
					songNum = 14;
				}else if (songNum ==15) {
					song5.stop();
					song15.start();
					song15.loop(song15.LOOP_CONTINUOUSLY);
					songNum = 15;
				}else if (songNum ==16) {
					song6.stop();
					song16.start();
					song16.loop(song16.LOOP_CONTINUOUSLY);
					songNum = 16;
				}else if (songNum ==17) {
					song7.stop();
					song17.start();
					song17.loop(song17.LOOP_CONTINUOUSLY);
					songNum = 17;
				}else if (songNum==18) {
					song8.stop();
					song18.start();
					song18.loop(song18.LOOP_CONTINUOUSLY);
					songNum = 18;
				}else if (songNum==19) {
					song9.stop();
					song19.start();
					song19.loop(song19.LOOP_CONTINUOUSLY);
					songNum = 19;
				}else if (songNum==20) {
					song10.stop();
					song20.start();
					song20.loop(song20.LOOP_CONTINUOUSLY);
					songNum = 20;
				}else if (songNum==21) {
					song11.stop();
					song21.start();
					song21.loop(song21.LOOP_CONTINUOUSLY);
					songNum = 21;
				}else if (songNum==22) {
					song12.stop();
					song22.start();
					song22.loop(song22.LOOP_CONTINUOUSLY);
					songNum = 22;
				}else if (songNum==23) {
					song13.stop();
					song23.start();
					song23.loop(song23.LOOP_CONTINUOUSLY);
					songNum = 23;
				}else if (songNum==24) {
					song14.stop();
					song24.start();
					song24.loop(song24.LOOP_CONTINUOUSLY);
					songNum = 24;
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
		
					if(songNum == 1) {
						song1.stop();
					}else if (songNum ==2) {
						song2.stop();
					}else if (songNum ==3) {
						song3.stop();
					}else if (songNum ==4) {
						song4.stop();
					}else if (songNum ==5) {
						song5.stop();
					}else if (songNum ==6) {
						song6.stop();
					}else if (songNum ==7) {
						song7.stop();
					}else if (songNum ==8) {
						song8.stop();
					}else if (songNum ==9) {
						song9.stop();
					}else if (songNum ==10) {
						song10.stop();
					}else if (songNum ==11) {
						song11.stop();
					}else if (songNum ==12) {
						song12.stop();
					}else if (songNum ==13) {
						song13.stop();
					}else if (songNum ==14) {
						song14.stop();
					}else if (songNum ==15) {
						song15.stop();
					}else if (songNum ==16) {
						song16.stop();
					}else if (songNum ==17) {
						song17.stop();
					}else if (songNum ==18) {
						song18.stop();
					}else if (songNum == 19) {
						song19.stop();
					}else if (songNum == 20) {
						song20.stop();
					}else if (songNum == 21) {
						song21.stop();
					}else if (songNum == 22) {
						song22.stop();
					}else if (songNum == 23) {
						song23.stop();
					}else if (songNum == 24) {
						song24.stop();
					}

					credit.start();
					credit.loop(credit.LOOP_CONTINUOUSLY);
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