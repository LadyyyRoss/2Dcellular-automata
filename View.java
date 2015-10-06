import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.UIManager;

/**
 * 
 */

/**
 * @author dominiqueross
 *
 */


public class View {
	Cell[][] board;
	private JButton[][] btnArray;
	private JFrame frame;
	
	
	/**
	 * @param _board
	 * creates a window for the application and an array of JButtons
	 */
	public View(Cell[][] _board){
		try {
		    UIManager.setLookAndFeel( UIManager.getCrossPlatformLookAndFeelClassName() );
		 } catch (Exception e) {
		            e.printStackTrace();
		 }
		this.board = _board;
		this.btnArray = new JButton[_board.length][_board[0].length];
		this.frame = new JFrame("2D Cellular Automata");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600,600);
		frame.getContentPane().setLayout(new GridLayout(_board.length, _board[0].length));
		for( int i = 0; i < btnArray.length; i++){
			for(int j = 0; j <btnArray[i].length; j++){
				btnArray[i][j] = new JButton();
				frame.getContentPane().add(btnArray[i][j]);
			}
		}
		frame.setVisible(true);
	}

	/**
	 * changes the color of a JButton based on the current value of the cell in the same position
	 */
	public void display(){
		for(int i = 0; i < board.length; i++){
			for(int j = 0; j < board[i].length; j++){
				btnArray[i][j].setOpaque(true);
				/*switch(board[i][j].getCurrentValue()){
				case 0:
					btnArray[i][j].setBackground(Color.GREEN);
					break;
				case 1:
					btnArray[i][j].setBackground(Color.RED);
					break;
				case 2:
					btnArray[i][j].setBackground(Color.BLACK);
					break;*/
				if (board[i][j].getCurrentValue() == 0)
					btnArray[i][j].setBackground(Color.GREEN);
				else if (board[i][j].getCurrentValue() == 1)
					btnArray[i][j].setBackground(Color.RED);
				else if (board[i][j].getCurrentValue() == 2)
					btnArray[i][j].setBackground(Color.BLACK);
						
				frame.repaint();
			}
		}
	}
}
				
			
				
			
			
			
		
					
		
	
	
