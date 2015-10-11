package Model;

import EnumConstants.Checkers;
import EnumConstants.SessionVariable;

/**
 * Client Application -> ClientApp
 * @author Siyar
 * 
 * ClientApp
 */
public class Square {
	
	private int SquareID;
	private int SquareRow;
	private int SquareCol;	
	private boolean isKing;
	private boolean filled;
	private boolean selected;
	private boolean isPossibleToMove;
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
		
		this.isKing = false;
		this.selected = false;
		this.isPossibleToMove = false;
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

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	public boolean isPossibleToMove() {
		return isPossibleToMove;
	}

	public void setPossibleToMove(boolean isPossibleToMove) {
		this.isPossibleToMove = isPossibleToMove;
	}
	
	public boolean isOpponentSquare(){
		if(playerID!=SessionVariable.myID.getValue() && playerID!=Checkers.EMPTY_SQUARE.getValue())
			return true;
		else
			return false;
	}

	public boolean isKing() {
		return isKing;
	}

	public void setKing() {
		this.isKing = true;
	}
	
	public void removeKing(){
		this.isKing = false;
	}
}
