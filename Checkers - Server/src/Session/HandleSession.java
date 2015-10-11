package Session;
import javax.swing.*;

import EnumConstants.Checkers;
import Model.Game;
import Model.Player;
import Model.Square;

import java.io.*;
import java.net.*;
import java.awt.*;

/**
 * Server Application --> Handle Session
 * @author keerthikan
 * 
 * Handle Game Logic and Player requests
 */
public class HandleSession implements Runnable {
	
	private Game checkers;
	private Player player1;
	private Player player2;
	
	private boolean continueToPlay = true;
	
	//Construct thread
	public HandleSession(Socket p1, Socket p2){
		player1 = new Player(Checkers.PLAYER_ONE.getValue(), p1);
		player2 = new Player(Checkers.PLAYER_TWO.getValue(), p2);
		
		checkers = new Game();
	}
	
	public void run() {		
		
		//Send Data back and forth		
		try{
				//notify Player 1 to start
				player1.sendData(1);				
				
				while(continueToPlay){
					//wait for player 1's Action
					int from = player1.receiveData();
					int to = player1.receiveData();
					checkStatus(from, to);
					updateGameModel(from, to);
							
					//Send Data back to 2nd Player
					if(checkers.isOver())
						player2.sendData(Checkers.YOU_LOSE.getValue());		//Game Over notification
					int fromStatus = player2.sendData(from);
					int toStatus = player2.sendData(to);
					checkStatus(fromStatus,toStatus);
					
					//IF game is over, break
					if(checkers.isOver()){
						player1.sendData(Checkers.YOU_WIN.getValue());
						continueToPlay=false;
						break;
					}
					
					System.out.println("after break");
					
					//wait for player 2's Action
					from = player2.receiveData();
					to = player2.receiveData();
					checkStatus(from, to);
					updateGameModel(from, to);					
					
					//Send Data back to 1st Player
					if(checkers.isOver()){
						player1.sendData(Checkers.YOU_LOSE.getValue());		//Game Over notification
					}					
					fromStatus = player1.sendData(from);
					toStatus = player1.sendData(to);
					checkStatus(fromStatus,toStatus);
					
					//IF game is over, break
					if(checkers.isOver()){
						player2.sendData(Checkers.YOU_WIN.getValue());
						continueToPlay=false;
						break;
					}
					
					System.out.println("second break");
				}
				
				
				
		}catch(Exception ex){
			System.out.println("Connection is being closed");
			
			if(player1.isOnline())
				player1.closeConnection();
			
			if(player2.isOnline())
				player2.closeConnection();
			
			return;
		}
	}
	
	private void checkStatus(int status, int status2) throws Exception{
		if(status==99 || status2==99){
			throw new Exception("Connection is lost");
		}
	}
	
	private void updateGameModel(int from, int to){
		Square fromSquare = checkers.getSquare(from);
		Square toSquare = checkers.getSquare(to);
		toSquare.setPlayerID(fromSquare.getPlayerID());
		fromSquare.setPlayerID(Checkers.EMPTY_SQUARE.getValue());
		
		checkCrossJump(fromSquare, toSquare);
	}
	
	private void checkCrossJump(Square from, Square to){		
		if(Math.abs(from.getSquareRow()-to.getSquareRow())==2){		
			int middleRow = (from.getSquareRow() + to.getSquareRow())/2;
			int middleCol = (from.getSquareCol() + to.getSquareCol())/2;
			
			Square middleSquare = checkers.getSquare((middleRow*8)+middleCol+1);
			middleSquare.setPlayerID(Checkers.EMPTY_SQUARE.getValue());
		}
	}
}