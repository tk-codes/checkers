package Model;

import EnumConstants.Checkers;

/**
 * Server Application -> Square
 * @author  Siyar
 * 
 * Square Model
 */
public class Square {
	
	private int SquareID;
	private int SquareRow;
	private int SquareCol;	
	private boolean filled;
	private int playerID;
	
	
	//Constructor
	public Square(int SquareID, int SquareRow, int SquareCol, boolean isFilled){
		this.SquareID=SquareID;
		this.SquareRow=SquareRow;
		this.SquareCol=SquareCol;
		this.setFilled(isFilled);
		
		if(this.filled){
			this.playerID = Checkers.EMPTY_SQUARE.getValue();
		}
	}

	public boolean getIsFilled() {
		return filled;
	}

	private void setFilled(boolean filled) {
		this.filled = filled;
	}
	
	public void setPlayerID(int ID){
		this.playerID=ID;
	}
	
	public int getPlayerID(){
		return this.playerID;
	}
	
	public int getSquareID(){
		return this.SquareID;
	}
	
	public int getSquareRow(){
		return this.SquareRow;
	}
	
	public int getSquareCol(){
		return this.SquareCol;
	}
	
}