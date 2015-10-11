package View;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.LinkedList;

import javax.sound.midi.ControllerEventListener;
import javax.swing.*;
import Model.Board;
import Model.Square;
import EnumConstants.SessionVariable;
import Handler.*;

/**
 * Client Application -> ClientApp
 * @author Keerthikan
 * 
 * ClientApp
 */
public class BoardPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private Dimension panelSize = new Dimension(720,720);
	private Board boardModel;
	private MyMouseListener listener;
	private LinkedList<SquarePanel> panels;
	private Square[][] squares;

	public BoardPanel(MyMouseListener listener){
		setPreferredSize(panelSize);
		setLayout(new GridLayout(8,8));
		
		boardModel = new Board();
		squares = boardModel.getSquares();
		this.listener = listener;		
		panels = new LinkedList<SquarePanel>();		
		
		initializeSquarePanels();
		
		System.out.println(boardModel.getTotlaSquares());		
	}
	
	private void initializeSquarePanels() {
		for(int i=0;i<8;i++){
			for(int k=0;k<8;k++){
				SquarePanel sPanel = new SquarePanel(squares[i][k]);
				if(sPanel.getSquare().isPossibleToMove() || sPanel.getSquare().getPlayerID()==SessionVariable.myID.getValue()){
					sPanel.addMouseListener(listener);
				}
				panels.add(sPanel);
				add(sPanel);				
			}			
		}
	}
	
	public void repaintPanels(){
		for(SquarePanel panel : panels){
			panel.setListner(listener);	
		}
		
		repaint();
	}

	public LinkedList<Square> getPlayableSquares(Square s){
		return boardModel.findPlayableSquares(s);		
	}
	
	public Square getSquare(int ID){
		return panels.get(ID-1).getSquare();
	}
}
