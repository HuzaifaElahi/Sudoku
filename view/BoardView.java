package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.IntStream;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import controller.controller;
import model.Board;
import model.BoardPiece;

public class BoardView extends JFrame {
	Board board = new Board();
	JPanel panel;
	JButton saveButton = new JButton("Save");
	int [][] data = new int[9][9];

	//Button action listener
	ActionListener boardListener = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton button = (JButton) e.getSource();
			checkMoves();
		}


	};

	// Listen for changes in the text
	DocumentListener docListner = new DocumentListener() {
		public void changedUpdate(DocumentEvent e) {
			
		}
		public void removeUpdate(DocumentEvent e) {
		}
		public void insertUpdate(DocumentEvent e) {
		}
	};



	//Add HashMaps and Arrays
	HashMap<JTextField, BoardPiece> tiles = new HashMap<JTextField, BoardPiece>();
	HashMap<BoardPiece, JTextField> fields = new HashMap<BoardPiece, JTextField>(); 
	ArrayList<JTextField> fieldsList = new ArrayList<JTextField>();

	//Constructor
	public BoardView(){
		generateTiles();
		initComponents();
	}

	private BoardPiece getRowGetCol(int row, int col) {
		List<BoardPiece> pieces = new ArrayList<>();
		pieces = board.getBoardPieces();
		for (BoardPiece piece: pieces) {
			if (piece.getRow() == row && piece.getColumn() == col){
				return piece;
			}
		}
		return null;
	}

	private void checkMoves() {
		for(int row=1;row<=9;row++) {
			for(int column=1;column<=9;column++) {
				BoardPiece piece = getRowGetCol(row, column);
				data [row-1][column-1] = piece.getNumber();
			}	
		}
		controller controller = new controller(data);
	}
	

	//Create Text Fields and Squares and add to HashMaps and ArrayList
	private void generateTiles() {
		saveButton.addActionListener(boardListener);
		for(int row=1;row<=9;row++) {
			for(int column=1;column<=9;column++) {
				JTextField field = new JTextField();
				field.getDocument().addDocumentListener(new DocumentListener() {
				    @Override
				    public void insertUpdate(DocumentEvent e) {
				    }

				    @Override
				    public void removeUpdate(DocumentEvent e) {
				    }

				    @Override
				    public void changedUpdate(DocumentEvent e) {
				    }
				});
				BoardPiece square = new BoardPiece(row, column, 0, board);
				tiles.put(field, square);
				fields.put(square, field);
				fieldsList.add(field);
				field.setText("0");
			}
		}
	}

	private void initComponents() {
		// Set Group Layout
		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		panel = new JPanel(layout);
		panel.setLayout(layout);
		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);
		layout.setHorizontalGroup(
				layout.createParallelGroup()
				.addGroup(layout.createSequentialGroup()
						.addComponent(fields.get(board.getBoardPiece(0)))
						.addComponent(fields.get(board.getBoardPiece(1)))
						.addComponent(fields.get(board.getBoardPiece(2)))
						.addComponent(fields.get(board.getBoardPiece(3)))
						.addComponent(fields.get(board.getBoardPiece(4)))
						.addComponent(fields.get(board.getBoardPiece(5)))
						.addComponent(fields.get(board.getBoardPiece(6)))
						.addComponent(fields.get(board.getBoardPiece(7)))
						.addComponent(fields.get(board.getBoardPiece(8)))
						.addComponent(saveButton))
				.addGroup(layout.createSequentialGroup()
						.addComponent(fields.get(board.getBoardPiece(9)))
						.addComponent(fields.get(board.getBoardPiece(10)))
						.addComponent(fields.get(board.getBoardPiece(11)))
						.addComponent(fields.get(board.getBoardPiece(12)))
						.addComponent(fields.get(board.getBoardPiece(13)))
						.addComponent(fields.get(board.getBoardPiece(14)))
						.addComponent(fields.get(board.getBoardPiece(15)))
						.addComponent(fields.get(board.getBoardPiece(16)))
						.addComponent(fields.get(board.getBoardPiece(17))))
				.addGroup(layout.createSequentialGroup()
						.addComponent(fields.get(board.getBoardPiece(18)))
						.addComponent(fields.get(board.getBoardPiece(19)))
						.addComponent(fields.get(board.getBoardPiece(20)))
						.addComponent(fields.get(board.getBoardPiece(21)))
						.addComponent(fields.get(board.getBoardPiece(22)))
						.addComponent(fields.get(board.getBoardPiece(23)))
						.addComponent(fields.get(board.getBoardPiece(24)))
						.addComponent(fields.get(board.getBoardPiece(25)))
						.addComponent(fields.get(board.getBoardPiece(26))))
				.addGroup(layout.createSequentialGroup()
						.addComponent(fields.get(board.getBoardPiece(27)))
						.addComponent(fields.get(board.getBoardPiece(28)))
						.addComponent(fields.get(board.getBoardPiece(29)))
						.addComponent(fields.get(board.getBoardPiece(30)))
						.addComponent(fields.get(board.getBoardPiece(31)))
						.addComponent(fields.get(board.getBoardPiece(32)))
						.addComponent(fields.get(board.getBoardPiece(33)))
						.addComponent(fields.get(board.getBoardPiece(34)))
						.addComponent(fields.get(board.getBoardPiece(35))))
				.addGroup(layout.createSequentialGroup()
						.addComponent(fields.get(board.getBoardPiece(36)))
						.addComponent(fields.get(board.getBoardPiece(37)))
						.addComponent(fields.get(board.getBoardPiece(38)))
						.addComponent(fields.get(board.getBoardPiece(39)))
						.addComponent(fields.get(board.getBoardPiece(40)))
						.addComponent(fields.get(board.getBoardPiece(41)))
						.addComponent(fields.get(board.getBoardPiece(42)))
						.addComponent(fields.get(board.getBoardPiece(43)))
						.addComponent(fields.get(board.getBoardPiece(44))))
				.addGroup(layout.createSequentialGroup()
						.addComponent(fields.get(board.getBoardPiece(45)))
						.addComponent(fields.get(board.getBoardPiece(46)))
						.addComponent(fields.get(board.getBoardPiece(47)))
						.addComponent(fields.get(board.getBoardPiece(48)))
						.addComponent(fields.get(board.getBoardPiece(49)))
						.addComponent(fields.get(board.getBoardPiece(50)))
						.addComponent(fields.get(board.getBoardPiece(51)))
						.addComponent(fields.get(board.getBoardPiece(52)))
						.addComponent(fields.get(board.getBoardPiece(53))))
				.addGroup(layout.createSequentialGroup()
						.addComponent(fields.get(board.getBoardPiece(54)))
						.addComponent(fields.get(board.getBoardPiece(55)))
						.addComponent(fields.get(board.getBoardPiece(56)))
						.addComponent(fields.get(board.getBoardPiece(57)))
						.addComponent(fields.get(board.getBoardPiece(58)))
						.addComponent(fields.get(board.getBoardPiece(59)))
						.addComponent(fields.get(board.getBoardPiece(60)))
						.addComponent(fields.get(board.getBoardPiece(61)))
						.addComponent(fields.get(board.getBoardPiece(62))))
				.addGroup(layout.createSequentialGroup()
						.addComponent(fields.get(board.getBoardPiece(63)))
						.addComponent(fields.get(board.getBoardPiece(64)))
						.addComponent(fields.get(board.getBoardPiece(65)))
						.addComponent(fields.get(board.getBoardPiece(66)))
						.addComponent(fields.get(board.getBoardPiece(67)))
						.addComponent(fields.get(board.getBoardPiece(68)))
						.addComponent(fields.get(board.getBoardPiece(69)))
						.addComponent(fields.get(board.getBoardPiece(70)))
						.addComponent(fields.get(board.getBoardPiece(71))))
				.addGroup(layout.createSequentialGroup()
						.addComponent(fields.get(board.getBoardPiece(72)))
						.addComponent(fields.get(board.getBoardPiece(73)))
						.addComponent(fields.get(board.getBoardPiece(74)))
						.addComponent(fields.get(board.getBoardPiece(75)))
						.addComponent(fields.get(board.getBoardPiece(76)))
						.addComponent(fields.get(board.getBoardPiece(77)))
						.addComponent(fields.get(board.getBoardPiece(78)))
						.addComponent(fields.get(board.getBoardPiece(79)))
						.addComponent(fields.get(board.getBoardPiece(80)))));
		layout.linkSize(SwingConstants.VERTICAL, new java.awt.Component[] {
				fields.get(board.getBoardPiece(0)),fields.get(board.getBoardPiece(1)),fields.get(board.getBoardPiece(2)),fields.get(board.getBoardPiece(3)), fields.get(board.getBoardPiece(4)), fields.get(board.getBoardPiece(5)), fields.get(board.getBoardPiece(6)), fields.get(board.getBoardPiece(7)),
				fields.get(board.getBoardPiece(8)),fields.get(board.getBoardPiece(9)),fields.get(board.getBoardPiece(10)),fields.get(board.getBoardPiece(11)), fields.get(board.getBoardPiece(12)), fields.get(board.getBoardPiece(13)), fields.get(board.getBoardPiece(14)), fields.get(board.getBoardPiece(15)),
				fields.get(board.getBoardPiece(16)),fields.get(board.getBoardPiece(17)),fields.get(board.getBoardPiece(18)),fields.get(board.getBoardPiece(19)), fields.get(board.getBoardPiece(20)), fields.get(board.getBoardPiece(21)), fields.get(board.getBoardPiece(22)), fields.get(board.getBoardPiece(23)),
				fields.get(board.getBoardPiece(24)),fields.get(board.getBoardPiece(25)),fields.get(board.getBoardPiece(26)),fields.get(board.getBoardPiece(27)), fields.get(board.getBoardPiece(28)), fields.get(board.getBoardPiece(29)), fields.get(board.getBoardPiece(30)), fields.get(board.getBoardPiece(31)),
				fields.get(board.getBoardPiece(32)),fields.get(board.getBoardPiece(33)),fields.get(board.getBoardPiece(34)),fields.get(board.getBoardPiece(35)), fields.get(board.getBoardPiece(36)), fields.get(board.getBoardPiece(37)), fields.get(board.getBoardPiece(38)), fields.get(board.getBoardPiece(39)),
				fields.get(board.getBoardPiece(40)),fields.get(board.getBoardPiece(41)),fields.get(board.getBoardPiece(42)),fields.get(board.getBoardPiece(43)), fields.get(board.getBoardPiece(44)), fields.get(board.getBoardPiece(45)), fields.get(board.getBoardPiece(46)), fields.get(board.getBoardPiece(47)),
				fields.get(board.getBoardPiece(48)),fields.get(board.getBoardPiece(49)),fields.get(board.getBoardPiece(50)),fields.get(board.getBoardPiece(51)), fields.get(board.getBoardPiece(52)), fields.get(board.getBoardPiece(53)), fields.get(board.getBoardPiece(54)), fields.get(board.getBoardPiece(55)),
				fields.get(board.getBoardPiece(56)),fields.get(board.getBoardPiece(57)),fields.get(board.getBoardPiece(58)),fields.get(board.getBoardPiece(59)), fields.get(board.getBoardPiece(60)), fields.get(board.getBoardPiece(61)), fields.get(board.getBoardPiece(62)), fields.get(board.getBoardPiece(63)),
				fields.get(board.getBoardPiece(64)),fields.get(board.getBoardPiece(65)),fields.get(board.getBoardPiece(66)),fields.get(board.getBoardPiece(67)), fields.get(board.getBoardPiece(68)), fields.get(board.getBoardPiece(69)), fields.get(board.getBoardPiece(70)), fields.get(board.getBoardPiece(71)),
				fields.get(board.getBoardPiece(72)),fields.get(board.getBoardPiece(73)),fields.get(board.getBoardPiece(74)),fields.get(board.getBoardPiece(75)), fields.get(board.getBoardPiece(76)), fields.get(board.getBoardPiece(77)), fields.get(board.getBoardPiece(78)), fields.get(board.getBoardPiece(79)),
				fields.get(board.getBoardPiece(80)), saveButton});
		layout.linkSize(SwingConstants.HORIZONTAL, new java.awt.Component[] {fields.get(board.getBoardPiece(0)),fields.get(board.getBoardPiece(1)),fields.get(board.getBoardPiece(2)),fields.get(board.getBoardPiece(3)), fields.get(board.getBoardPiece(4)), fields.get(board.getBoardPiece(5)), fields.get(board.getBoardPiece(6)), fields.get(board.getBoardPiece(7)),
				fields.get(board.getBoardPiece(8)),fields.get(board.getBoardPiece(9)),fields.get(board.getBoardPiece(10)),fields.get(board.getBoardPiece(11)), fields.get(board.getBoardPiece(12)), fields.get(board.getBoardPiece(13)), fields.get(board.getBoardPiece(14)), fields.get(board.getBoardPiece(15)),
				fields.get(board.getBoardPiece(16)),fields.get(board.getBoardPiece(17)),fields.get(board.getBoardPiece(18)),fields.get(board.getBoardPiece(19)), fields.get(board.getBoardPiece(20)), fields.get(board.getBoardPiece(21)), fields.get(board.getBoardPiece(22)), fields.get(board.getBoardPiece(23)),
				fields.get(board.getBoardPiece(24)),fields.get(board.getBoardPiece(25)),fields.get(board.getBoardPiece(26)),fields.get(board.getBoardPiece(27)), fields.get(board.getBoardPiece(28)), fields.get(board.getBoardPiece(29)), fields.get(board.getBoardPiece(30)), fields.get(board.getBoardPiece(31)),
				fields.get(board.getBoardPiece(32)),fields.get(board.getBoardPiece(33)),fields.get(board.getBoardPiece(34)),fields.get(board.getBoardPiece(35)), fields.get(board.getBoardPiece(36)), fields.get(board.getBoardPiece(37)), fields.get(board.getBoardPiece(38)), fields.get(board.getBoardPiece(39)),
				fields.get(board.getBoardPiece(40)),fields.get(board.getBoardPiece(41)),fields.get(board.getBoardPiece(42)),fields.get(board.getBoardPiece(43)), fields.get(board.getBoardPiece(44)), fields.get(board.getBoardPiece(45)), fields.get(board.getBoardPiece(46)), fields.get(board.getBoardPiece(47)),
				fields.get(board.getBoardPiece(48)),fields.get(board.getBoardPiece(49)),fields.get(board.getBoardPiece(50)),fields.get(board.getBoardPiece(51)), fields.get(board.getBoardPiece(52)), fields.get(board.getBoardPiece(53)), fields.get(board.getBoardPiece(54)), fields.get(board.getBoardPiece(55)),
				fields.get(board.getBoardPiece(56)),fields.get(board.getBoardPiece(57)),fields.get(board.getBoardPiece(58)),fields.get(board.getBoardPiece(59)), fields.get(board.getBoardPiece(60)), fields.get(board.getBoardPiece(61)), fields.get(board.getBoardPiece(62)), fields.get(board.getBoardPiece(63)),
				fields.get(board.getBoardPiece(64)),fields.get(board.getBoardPiece(65)),fields.get(board.getBoardPiece(66)),fields.get(board.getBoardPiece(67)), fields.get(board.getBoardPiece(68)), fields.get(board.getBoardPiece(69)), fields.get(board.getBoardPiece(70)), fields.get(board.getBoardPiece(71)),
				fields.get(board.getBoardPiece(72)),fields.get(board.getBoardPiece(73)),fields.get(board.getBoardPiece(74)),fields.get(board.getBoardPiece(75)), fields.get(board.getBoardPiece(76)), fields.get(board.getBoardPiece(77)), fields.get(board.getBoardPiece(78)), fields.get(board.getBoardPiece(79)),
				fields.get(board.getBoardPiece(80)), saveButton});
		layout.setVerticalGroup(
				layout.createSequentialGroup()
				.addGroup(layout.createParallelGroup()
						.addComponent(fields.get(board.getBoardPiece(0)))
						.addComponent(fields.get(board.getBoardPiece(1)))
						.addComponent(fields.get(board.getBoardPiece(2)))
						.addComponent(fields.get(board.getBoardPiece(3)))
						.addComponent(fields.get(board.getBoardPiece(4)))
						.addComponent(fields.get(board.getBoardPiece(5)))
						.addComponent(fields.get(board.getBoardPiece(6)))
						.addComponent(fields.get(board.getBoardPiece(7)))
						.addComponent(fields.get(board.getBoardPiece(8)))
						.addComponent(saveButton))
				.addGroup(layout.createParallelGroup()
						.addComponent(fields.get(board.getBoardPiece(9)))
						.addComponent(fields.get(board.getBoardPiece(10)))
						.addComponent(fields.get(board.getBoardPiece(11)))
						.addComponent(fields.get(board.getBoardPiece(12)))
						.addComponent(fields.get(board.getBoardPiece(13)))
						.addComponent(fields.get(board.getBoardPiece(14)))
						.addComponent(fields.get(board.getBoardPiece(15)))
						.addComponent(fields.get(board.getBoardPiece(16)))
						.addComponent(fields.get(board.getBoardPiece(17))))
				.addGroup(layout.createParallelGroup()
						.addComponent(fields.get(board.getBoardPiece(18)))
						.addComponent(fields.get(board.getBoardPiece(19)))
						.addComponent(fields.get(board.getBoardPiece(20)))
						.addComponent(fields.get(board.getBoardPiece(21)))
						.addComponent(fields.get(board.getBoardPiece(22)))
						.addComponent(fields.get(board.getBoardPiece(23)))
						.addComponent(fields.get(board.getBoardPiece(24)))
						.addComponent(fields.get(board.getBoardPiece(25)))
						.addComponent(fields.get(board.getBoardPiece(26))))
				.addGroup(layout.createParallelGroup()
						.addComponent(fields.get(board.getBoardPiece(27)))
						.addComponent(fields.get(board.getBoardPiece(28)))
						.addComponent(fields.get(board.getBoardPiece(29)))
						.addComponent(fields.get(board.getBoardPiece(30)))
						.addComponent(fields.get(board.getBoardPiece(31)))
						.addComponent(fields.get(board.getBoardPiece(32)))
						.addComponent(fields.get(board.getBoardPiece(33)))
						.addComponent(fields.get(board.getBoardPiece(34)))
						.addComponent(fields.get(board.getBoardPiece(35))))
				.addGroup(layout.createParallelGroup()
						.addComponent(fields.get(board.getBoardPiece(36)))
						.addComponent(fields.get(board.getBoardPiece(37)))
						.addComponent(fields.get(board.getBoardPiece(38)))
						.addComponent(fields.get(board.getBoardPiece(39)))
						.addComponent(fields.get(board.getBoardPiece(40)))
						.addComponent(fields.get(board.getBoardPiece(41)))
						.addComponent(fields.get(board.getBoardPiece(42)))
						.addComponent(fields.get(board.getBoardPiece(43)))
						.addComponent(fields.get(board.getBoardPiece(44))))
				.addGroup(layout.createParallelGroup()
						.addComponent(fields.get(board.getBoardPiece(45)))
						.addComponent(fields.get(board.getBoardPiece(46)))
						.addComponent(fields.get(board.getBoardPiece(47)))
						.addComponent(fields.get(board.getBoardPiece(48)))
						.addComponent(fields.get(board.getBoardPiece(49)))
						.addComponent(fields.get(board.getBoardPiece(50)))
						.addComponent(fields.get(board.getBoardPiece(51)))
						.addComponent(fields.get(board.getBoardPiece(52)))
						.addComponent(fields.get(board.getBoardPiece(53))))
				.addGroup(layout.createParallelGroup()
						.addComponent(fields.get(board.getBoardPiece(54)))
						.addComponent(fields.get(board.getBoardPiece(55)))
						.addComponent(fields.get(board.getBoardPiece(56)))
						.addComponent(fields.get(board.getBoardPiece(57)))
						.addComponent(fields.get(board.getBoardPiece(58)))
						.addComponent(fields.get(board.getBoardPiece(59)))
						.addComponent(fields.get(board.getBoardPiece(60)))
						.addComponent(fields.get(board.getBoardPiece(61)))
						.addComponent(fields.get(board.getBoardPiece(62))))
				.addGroup(layout.createParallelGroup()
						.addComponent(fields.get(board.getBoardPiece(63)))
						.addComponent(fields.get(board.getBoardPiece(64)))
						.addComponent(fields.get(board.getBoardPiece(65)))
						.addComponent(fields.get(board.getBoardPiece(66)))
						.addComponent(fields.get(board.getBoardPiece(67)))
						.addComponent(fields.get(board.getBoardPiece(68)))
						.addComponent(fields.get(board.getBoardPiece(69)))
						.addComponent(fields.get(board.getBoardPiece(70)))
						.addComponent(fields.get(board.getBoardPiece(71))))
				.addGroup(layout.createParallelGroup()
						.addComponent(fields.get(board.getBoardPiece(72)))
						.addComponent(fields.get(board.getBoardPiece(73)))
						.addComponent(fields.get(board.getBoardPiece(74)))
						.addComponent(fields.get(board.getBoardPiece(75)))
						.addComponent(fields.get(board.getBoardPiece(76)))
						.addComponent(fields.get(board.getBoardPiece(77)))
						.addComponent(fields.get(board.getBoardPiece(78)))
						.addComponent(fields.get(board.getBoardPiece(79)))
						.addComponent(fields.get(board.getBoardPiece(80)))));
		pack();
	}
}

