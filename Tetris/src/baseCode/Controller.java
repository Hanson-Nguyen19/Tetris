package baseCode;

import java.util.ArrayList;

import javafx.scene.canvas.Canvas;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public class Controller {

	static int songNum;
	public static void keyEvent(Canvas canvas, int songNumc, ArrayList<Square> square, int squareSize) {

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

	}

	public static void mouseEvent(Canvas canvas, int shape, ArrayList<Square> square, int squareSize) {

		canvas.setOnMouseClicked(event ->{
			Movement.rotateBlock(shape, square, squareSize);
		});

	}
}
