/**
 * Controller.java - APR-04-2016 - ITEC 220: Project 3 -
 * This class contains the logic and controls the data flow for the program.
 * @author Tre Haga
 * @version 1.0
 */
public class Controller
{
	/**
	 * The Controller class instance variables.
	 */
	private View view;
	/**
     * The Controller class constructor.
     */
	public Controller()
	{
		view = new View();
	}
	/**
	 * The startProgram method begins the program.
	 * Calls several methods from the View class to prompt the user for input.
	 */
	public void startProgram()
	{
		view.displayPlayerNames();
		view.loadGameData();
		view.displayGame();
	}
}