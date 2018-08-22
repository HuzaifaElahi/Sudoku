package view;

import javax.swing.JFrame;
import javax.swing.JTextField;

import model.Board;
import model.BoardPiece;

public class BoardView extends JFrame {
	Board board = new Board();

	public BoardView(){
		generateTiles();
	}
	//Create Buttons and Squares and add to HashMaps and ArrayList
	private void generateTiles() {
		for(int row=1;row<=9;row++) {
			for(int column=1;column<=8;column++) {
				JTextField button = new JTextField();	
				BoardPiece square = new BoardPiece(row, column, 0, board);
			}
		}
	}
}
