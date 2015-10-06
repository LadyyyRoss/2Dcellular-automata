
/**
 * @author dominiqueross
 *
 */

/**
 * Represents a single cell object in an array of cells
 * 
 */
public class Cell {
	/**
	   * The current integer value of the cell
	   */
	private int currentValue;
	/**
	   * The previous integer value of the cell
	   */
	private int preValue;
	/**
	   * Represents the amount of iterations that have passed since the current value has changed
	   */
	private int iterationCount;
	

	/**
	 * @param _currentValue
	 * @param _preValue
	 * @param _iterationCount
	 * Creates a new cell w/ a currentValue, a preValue, and an iterationCount
	 */
	public Cell(int _currentValue, int _preValue, int _iterationCount){
		this.currentValue = _currentValue;
		this.preValue = _preValue;
		this.iterationCount = _iterationCount;
		
	}
	
	/**
	 * @return the currentValue of the cell
	 * this method returns the current value of the given cell
	 */
	public int getCurrentValue() {
		return currentValue;
	}

	/**
	 * @param sets the current value of the cell
	 * this method sets the current value of the given cell
	 */
	public void setCurrentValue(int _currentValue) {
		this.currentValue = _currentValue;
	}

	/**
	 * @return the previous value of the cell
	 * this method returns the previous value of the given cell
	 */
	public int getPreValue() {
		return preValue;
	}

	/**
	 * @param sets the previous value of the cell
	 * this method sets the previous value of the given cell
	 */
	public void setPreValue(int _preValue) {
		this.preValue = _preValue;
	}

	/**
	 * @return the iteration count of the cell
	 * this method returns the the number of iteration count of the given cell
	 */
	public int getIterationCount() {
		return iterationCount;
	}

	/**
	 * @param sets the iteration count of the cell
	 * this method sets the the number of iteration count of the given cell
	 */
	public void setInterationCount(int _iterationCount) {
		this.iterationCount = _iterationCount;
	}
	
	/**
	 * @return a string representation of the cell
	 * this method returns a string representation of the given cells current value
	 */
	public String toString()
	{
		return "" + this.currentValue;
	}
}
