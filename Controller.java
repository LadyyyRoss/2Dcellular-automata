
/**
 * 
 */

/**
 * @author dominiqueross
 *
 */

public class Controller {
	
	/**
	 * int value representing the number of columns
	 */
	private final int COLS = 50;
	/**
	 * int value representing the number of rows
	 */
	private final int ROWS = 30;
	/**
	 * int value representing the number of iterations
	 */
	private final int ITERATIONS = 1000;
	/**
	 * int value representing what number iteration to begin at
	 */
	private final int START = 1;
	/**
	 * an instance of the View class
	 */
	private View begin;
	/**
	 * an instance of the Model class
	 */
	private Model start;
	
	/**
	 * 
	 */
	public Controller(){
		start = new Model(COLS,ROWS,ITERATIONS);
		begin = new View(start.getBoard());	
	}
	
	
	/**
	 * @throws InterruptedException
	 * starts the loop controlling iterations
	 */
	public void newSession() throws InterruptedException{
		begin.display();
		for(int i=START,j=ITERATIONS; i<=j;i++){
			start.updateModel();
			begin.display();
			Thread.sleep(500);
		}
		
	}
	
}
		
	
	

		

		
		
		
	
	

