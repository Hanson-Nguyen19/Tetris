/**
 * @authorHansonNguyen, @authorNavtejGhataure, @authorSimonCadieux
 */
package baseCode;

public class SongENum {

	/**
	 * Returns the name and path of a song based on the selec input.
	 * @param selec
	 * @return
	 */
	public static String songClip(int selec) {

		switch(selec) {

		case 1: return "src/Resources/Castle Rock.wav";

		case 2: return "src/Resources/TetrisDance.wav";

		case 3: return "src/Resources/Fever Dr. Mario.wav";

		case 4: return "src/Resources/Paper Mario.wav";

		case 5: return "src/Resources/Snow Bros.wav";

		case 6: return "src/Resources/Super Mario Bros.wav";

		case 7: return "src/Resources/Battletoads.wav";

		case 8: return "src/Resources/FlashManStage.wav";

		case 9: return "src/Resources/TheManWithTheMachineGun.wav";

		case 10: return "src/Resources/Balrog.wav";

		case 11: return "src/Resources/DuckTales.wav";

		case 12: return "src/Resources/BubbleBobble.wav";

		case 13: return "src/Resources/SuperMarioBrosUnderground.wav";

		case 14: return "src/Resources/Super Mario Bros. 3.wav";

		case 15: return "src/Resources/Dudley.wav";

		case 16: return "src/Resources/Spider Dance.wav";

		case 17: return "src/Resources/Spaceball.wav";

		case 18: return "src/Resources/PAC-MAN.wav";

		case 19: return "src/Resources/Excitebike Arena.wav";

		case 20: return "src/Resources/BrinstarDepths.wav";

		case 21: return "src/Resources/LuigisMansion.wav";

		case 22: return "src/Resources/BloodyPurity.wav";

		case 23: return "src/Resources/MaloMart.wav";

		case 24: return "src/Resources/TheBlocksWeLoved.wav";

		case 25: return "src/Resources/MechanicalRhythm.wav";

		case 26: return "src/Resources/AssassinsCreed III.wav";
		}

		return null;

	}
}
