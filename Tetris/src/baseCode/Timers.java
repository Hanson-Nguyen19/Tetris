package baseCode;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Timers {
	int delay = 0;
	Timer time = new Timer();
	static long score;
	static long[] highScore = new long[5];
	static int dropSpeed = 1000;
	static int songNum = (int) (Math.random() * 25)+1;
	
	public void timerStart(ArrayList<Square> square, int squareSize) {
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
					CreateTetr.createBlocks(Game.shape, square, squareSize);
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
					songNum = 25;
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
					Game.shape = CreateTetr.randomShape(Game.shape);
					CreateTetr.createBlocks(Game.shape, square, squareSize);
					score += 40;
				}
			}
		}, 0, 1);

		/**
		 * checks for a completed row every 200 milliseconds
		 */
		time.schedule(new TimerTask() {
			@Override
			public void run() {
				score = Grid.rowCheck(square, score);
			}
		}, 0,200);
	}
}
