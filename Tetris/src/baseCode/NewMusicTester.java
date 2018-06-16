package baseCode;

import java.util.Scanner;

public class NewMusicTester {
	
	static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args0) {
		test();
	}
	
	public static void test() {
		int i = scan.nextInt();
		MusicPlayer.play(SongENum.songClip(i));
	}
}
