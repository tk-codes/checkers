package EnumConstants;

/**
 * Client Application -> Enum Checkers
 * @author Siyar
 * 
 * Checker Constants
 */
public enum Checkers {	
	
	NUM_ROWS(8),
	NUM_COLS(8),
	TOTAL_PIECES(12),
	TOTAL_SQUARES(64),
	PLAYABLE_SQUARES(32),
	EMPTY_SQUARE(0),
	PLAYER_ONE(1),
	PLAYER_TWO(2),
	YOU_WIN(90),
	YOU_LOSE(91),
	DOUBLE_JUMP(92);
	
	private int value;
	
	private Checkers(int value) {
		this.value = value;
	}
	
	public int getValue(){
		return this.value;
	}	
}
