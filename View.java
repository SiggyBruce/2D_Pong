/**
 * View.java - APR-04-2016 - ITEC 220: Project 3 -
 * This class contains methods that prompt the user and show visual output.
 * Inherits methods from the JFrame class.
 * @author Tre Haga
 * @version 1.0
 */
import javax.swing.*;
public class View extends JFrame
{
	/**
	 * The View class instance variables.
	 */
	private PongPanel pongPanel;
	private final int WINDOW_WIDTH;
	private final int WINDOW_HEIGHT;
	/**
	 * The View class constructor.
	 */
	public View()
	{
		WINDOW_WIDTH = 1048;
		WINDOW_HEIGHT = 800;
		pongPanel = new PongPanel();
		setTitle("Project 3");
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);
        add(pongPanel);
	}
	/**
	 * The loadGameData method loads the program with existing data from a file.
	 * If there is no file, it will input a new set of records into the program.
	 */
	public void loadGameData()
	{
		boolean doesExist = pongPanel.getRecords().doesSaveFileExist();
		if (doesExist)
		{
			pongPanel.getRecords().loadRecords();
			pongPanel.getRecords().saveRecords();
		}
		else
		{
			pongPanel.getRecords().inputNewRecords();
			pongPanel.getRecords().saveRecords();
		}
	}
	/**
	 * The displayPlayerNames method prompts the user for input.
	 * Asks the user what name they wish to give to Player 1 and Player 2.
	 */
	public void displayPlayerNames()
	{
		String playerOneName = (String) JOptionPane.showInputDialog(this, "Enter a name for Player 1: ", "Player Name", 3, null, null, null);
		String playerTwoName = (String) JOptionPane.showInputDialog(this, "Enter a name for Player 2: ", "Player Name", 3, null, null, null);
		
		try
		{
			if (!playerOneName.equals(""))
			{
				pongPanel.setPlayerOneName(playerOneName);
			
			}
			if (!playerTwoName.equals(""))
			{
				pongPanel.setPlayerTwoName(playerTwoName);
			}
		}
		catch (NullPointerException exception)
		{
			JOptionPane.showMessageDialog(this, "WARNING: One or more player names were not set.", "Player Names", 2, null);
		}
	}
	/**
	 * The displayGame method displays the game for the user.
	 */
	public void displayGame()
	{
		pongPanel.startGame();
	}
}