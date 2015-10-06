import java.util.Random;
/**
 * @author dominiqueross
 *
 */

public class Model {
	private Cell[][] board;
	private int rows;
	private int cols;
	
	
	
	/**
	 * @param _cols
	 * @param _rows
	 * @param _iterations
	 * 
	 */
	public Model(int _cols, int _rows, int _iterations)
	{
		this.cols=_cols;
		this.rows=_rows;
		board = getModel();
	}
	
	/**
	 * @return a cell array filled with random cell values
	 * Instantiates each cell in a cell array
	 */
	public Cell[][] getModel(){
		Cell[][] array = new Cell[cols][rows];
		for(int i = 0; i < cols; i++){
			for(int j = 0;j < rows; j++){
				Random rand = new Random();
				int num = rand.nextInt(3);
				array[i][j] = new Cell(num,num,0);
				}
			}
		return array;
	}
	
	/**
	 * updates each cell in board 
	 */
	public void updateModel(){
		for(int i = 0; i < cols; i++){
			for(int j = 0;j < rows; j++){
				board[i][j]=newCell(i,j);
			}
		}
		
	}
			    
	/**
	 * @param cols 
	 * @param rows
	 * @return a new (updated) cell
	 */
	private Cell newCell(int cols, int rows){
		int numNeighbors = getNeighbors(cols,rows);
		int liveCells = getliveCells(cols, rows);
		int deadCells = getdeadCells(cols,rows);
		int deseasedCells = getdeseasedCells(cols,rows);

		int currentValue=board[cols][rows].getCurrentValue();
		int previousValue=board[cols][rows].getPreValue();
		int iterationCount= board[cols][rows].getIterationCount();
		
		
		
			if(board[cols][rows].getCurrentValue()==0){
				if(((100*deadCells)/numNeighbors)+((100*deseasedCells)/numNeighbors) >= (26.00)){
					currentValue = 1;
					iterationCount = 0;
					previousValue = 0;
				}
				else{
					iterationCount++;
					previousValue = 0;
				}
				
			}
			else
				if(board[cols][rows].getCurrentValue()==1){
					if(board[cols][rows].getIterationCount()==4){
						currentValue = 2;
						previousValue = 1;
						iterationCount = 0;
					}
					else
						if((100*liveCells)/numNeighbors >= (75.00)){
							currentValue = 0;
							previousValue = 1;
							iterationCount = 0;
						}
						else
						{
							iterationCount++;
							previousValue = 1;
						}
				}
				else
					if(board[cols][rows].getCurrentValue() == 2){
						if(board[cols][rows].getIterationCount() == 4){
							currentValue = 0;
							previousValue = 2;
							iterationCount = 0;
						}
						else
							if((100*liveCells)/numNeighbors >= (75.00)){
								currentValue = 0;
								previousValue = 2;
								iterationCount = 0;
							}
							else
							{
								iterationCount++;
								previousValue = 2;
							}
					}
	
		Cell newCell = new Cell(currentValue, previousValue, iterationCount); 
		return newCell;		
				
	}
	
	/**
	 * @param x-coordinate of current cell
	 * @param y-coordinate of current cell
	 * @return number of diseased neighbors
	 */
	private int getdeseasedCells(int x, int y){
		 int deseasedCells=0;
		 try{
	    		if(board[x-1][y-1].getPreValue() == 1)
	    			deseasedCells++;
			}	
		    catch(ArrayIndexOutOfBoundsException e){}
			try{
				if(board[x-1][y].getPreValue() == 1)
					deseasedCells++;	
				}
			catch(ArrayIndexOutOfBoundsException e){}
			try{
				if(board[x-1][y+1].getPreValue()==1)
					deseasedCells++;	
			}
			catch(ArrayIndexOutOfBoundsException e){}
			try{
				if(board[x][y-1].getPreValue()==1)
					deseasedCells++;	
			}
			catch(ArrayIndexOutOfBoundsException e){}
			try{
				if(board[x][y+1].getCurrentValue()==1)
					deseasedCells++;	
			}
			catch(ArrayIndexOutOfBoundsException e){}
			try{
				if(board[x+1][y-1].getCurrentValue()==1)
					deseasedCells++;
			}
			catch(ArrayIndexOutOfBoundsException e){}
			try{
				if(board[x+1][y].getCurrentValue()==1)
					deseasedCells++;	
			}
			catch(ArrayIndexOutOfBoundsException e){}
			try{
				if(board[x+1][y+1].getCurrentValue()==1)
					deseasedCells++;
			}
			catch(ArrayIndexOutOfBoundsException e){}
			return deseasedCells;
		 
		 
	 }
		
	
	 /**
	 * @param x-coordinate of current cell
	 * @param y-coordinate of current cell
	 * @return number of dead neighbors
	 */
	private int getdeadCells(int x, int y){
		 int deadCells=0;
		    try{
	    		if(board[x-1][y-1].getPreValue() ==2)
	    			deadCells++;
		    }
				
		    catch(ArrayIndexOutOfBoundsException e){}
			try{
				if(board[x-1][y].getPreValue() == 2)
					deadCells++;	
				}
			catch(ArrayIndexOutOfBoundsException e){}
			try{
				if(board[x-1][y+1].getPreValue()==2)
					deadCells++;	
			}
			catch(ArrayIndexOutOfBoundsException e){}
			try{
				if(board[x][y-1].getPreValue()==2)
					deadCells++;	
			}
			catch(ArrayIndexOutOfBoundsException e){}
			try{
				if(board[x][y+1].getCurrentValue()==2)
					deadCells++;	
			}
			catch(ArrayIndexOutOfBoundsException e){}
			try{
				if(board[x+1][y-1].getCurrentValue()==2)
					deadCells++;
			}
			catch(ArrayIndexOutOfBoundsException e){}
			try{
				if(board[x+1][y].getCurrentValue()==2)
					deadCells++;	
			}
			catch(ArrayIndexOutOfBoundsException e){}
			try{
				if(board[x+1][y+1].getCurrentValue()==2)
					deadCells++;
			}
			catch(ArrayIndexOutOfBoundsException e){}
			return deadCells;
		 
		 
	 }
	
	 /**
	 * @param x-coordinate of current cell
	 * @param y-coordinate of current cell
	 * @return returns number of living neighbors
	 */
	private int getliveCells(int x, int y){
		int liveCells=0;
		try{
    		if(board[x-1][y-1].getPreValue()== 0)
    		liveCells++;
		}	
	    catch(ArrayIndexOutOfBoundsException e){}
		try{
			if(board[x-1][y].getPreValue()== 0)
			liveCells++;	
			}
		catch(ArrayIndexOutOfBoundsException e){}
		try{
			if(board[x-1][y+1].getPreValue()==0)
			liveCells++;	
		}
		catch(ArrayIndexOutOfBoundsException e){}
		try{
			if(board[x][y-1].getPreValue()==0)
			liveCells++;	
		}
		catch(ArrayIndexOutOfBoundsException e){}
		try{
			if(board[x][y+1].getCurrentValue()==0)
			liveCells++;	
		}
		catch(ArrayIndexOutOfBoundsException e){}
		try{
			if(board[x+1][y-1].getCurrentValue()==0)
			liveCells++;
		}
		catch(ArrayIndexOutOfBoundsException e){}
		try{
			if(board[x+1][y].getCurrentValue()==0)
			liveCells++;	
		}
		catch(ArrayIndexOutOfBoundsException e){}
		try{
			if(board[x+1][y+1].getCurrentValue()==0)
			liveCells++;	
		}
		catch(ArrayIndexOutOfBoundsException e){}
		return liveCells;
	}
				    	
	/**
	 * @param x-coordinate of current cell
	 * @param y-coordinate of current cell
	 * @return number of valid neighbors
	 */
	private int getNeighbors(int x, int y) {
		// TODO Auto-generated method stub
		int neighbors=0;
		try{
    		int num=board[x-1][y-1].getCurrentValue();
    		neighbors++;
		}	
	    catch(ArrayIndexOutOfBoundsException e){}
		try{
			int num=board[x-1][y].getCurrentValue();
			neighbors++;	
		}
		catch(ArrayIndexOutOfBoundsException e){}
		try{
			int num=board[x-1][y+1].getCurrentValue();
			neighbors++;	
		}
		catch(ArrayIndexOutOfBoundsException e){}
		try{
			int num=board[x][y-1].getCurrentValue();
			neighbors++;	
		}
		catch(ArrayIndexOutOfBoundsException e){}
		try{
			int num = board[x][y+1].getCurrentValue();
			neighbors++;	
		}
		catch(ArrayIndexOutOfBoundsException e){}
		try{
			int num = board[x+1][y-1].getCurrentValue();
			neighbors++;
		}
		catch(ArrayIndexOutOfBoundsException e){}
		try{
			int num=board[x+1][y].getCurrentValue();
			neighbors++;	
		}
		catch(ArrayIndexOutOfBoundsException e){}
		try{
			int num =board[x+1][y+1].getCurrentValue();
			neighbors++;	
		}
		catch(ArrayIndexOutOfBoundsException e){}
		
		    		
		    		
		
		return neighbors;
	}
	



	/**
	 * @return board
	 */
	public Cell[][] getBoard(){
	
		return this.board;
	}
}



