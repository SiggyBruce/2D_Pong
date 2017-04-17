/**
 * Driver.java - APR-04-2016 - ITEC 220: Project 3 - 
 * This class contains the main method for starting the program.
 * @author Tre Haga
 * @version 1.0
 */
public class Driver
{
	/**
     * The main method that starts the program. Calls a method from the controller to initiate the start.
     * @param args Takes in command line arguments.
     */
	public static void main(String[] args)
	{
		Controller controller = new Controller();
		controller.startProgram();
	}
}