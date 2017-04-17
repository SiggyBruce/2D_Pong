/**
 * PongPanel.java - APR-04-2016 - ITEC 220: Project 3 - 
 * This class contains the main game elements for the program.
 * Inherits methods from the JPanel class.
 * Implements the ActionListener and KeyListener interfaces.
 * @author Tre Haga
 * @version 1.0
 */
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class PongPanel extends JPanel implements ActionListener, KeyListener
{
	/**
	 * The PongPanel class instance variables.
	 */
	private Player playerOne, playerTwo;
	private Puck puck;
	private Goal leftGoal, rightGoal;
	private GameClock gameClock;
	private ScoreRecords records;
	private Timer timer;
	private final int FIELD_BOUNDARY;
	private final int X_FIELD_SIZE;
	private final int Y_FIELD_SIZE;
	/**
	 * The PongPanel class constructor.
	 */
	public PongPanel()
	{
		playerOne = new Player(140, 230, "Player 1");
		playerTwo = new Player(890, 230, "Player 2");
		puck = new Puck();
		leftGoal = new Goal(20, 200);
		rightGoal = new Goal(1010, 200);
		gameClock = new GameClock();
		records = new ScoreRecords();
		timer = new Timer(50, this);
		FIELD_BOUNDARY = 20;
		X_FIELD_SIZE = 1000;
		Y_FIELD_SIZE = 500;
		addKeyListener(this);
		setFocusable(true);
	}
	/**
	 * The update method contains updates all of the components for the game.
	 */
	public void update()
	{
		checkGameOver();
		playerOne.update();
		playerTwo.update();
		puck.update();
		playerOne.checkPaddleCollision(puck);
		playerTwo.checkPaddleCollision(puck);
		
		if (leftGoal.checkGoalCollision(puck))
		{
			puck.setXPosition(505);
			puck.setYPosition(260);
			puck.setXVelocity(-puck.getSpeed());
			puck.setXVelocity(puck.getSpeed());
			playerTwo.setScore(playerTwo.getScore() + 1);
		}
		else if (rightGoal.checkGoalCollision(puck))
		{
			puck.setXPosition(505);
			puck.setYPosition(260);
			puck.setXVelocity(puck.getSpeed());
			puck.setXVelocity(-puck.getSpeed());
			playerOne.setScore(playerOne.getScore() + 1);
		}
		gameClock.countMilliseconds();
		gameClock.checkClock();
	}
	/**
	 * The paintComponent method visually paints all of the graphical components for the game.
	 */
	public void paintComponent(Graphics graphics)
	{
		graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, 1043, 765);
		playerOne.paint(graphics);
		playerTwo.paint(graphics);
		puck.paint(graphics);
		leftGoal.paint(graphics);
		rightGoal.paint(graphics);
		graphics.setColor(Color.BLACK);
		graphics.setFont(new Font("default", Font.BOLD, 25));
        graphics.drawLine(X_FIELD_SIZE / 2 + 20, FIELD_BOUNDARY, X_FIELD_SIZE / 2 + 20, Y_FIELD_SIZE + 20);
        graphics.drawLine(FIELD_BOUNDARY, FIELD_BOUNDARY, X_FIELD_SIZE + 20, FIELD_BOUNDARY);
        graphics.drawLine(FIELD_BOUNDARY, FIELD_BOUNDARY, 20, Y_FIELD_SIZE + 240);
        graphics.drawLine(X_FIELD_SIZE + 20, FIELD_BOUNDARY, X_FIELD_SIZE + 20, Y_FIELD_SIZE + 240);
        graphics.drawLine(FIELD_BOUNDARY, Y_FIELD_SIZE + 20, X_FIELD_SIZE + 20, Y_FIELD_SIZE + 20);
        graphics.drawOval(X_FIELD_SIZE / 2 - 5, Y_FIELD_SIZE / 2, 50, 50);
        graphics.drawLine(FIELD_BOUNDARY, Y_FIELD_SIZE + 240, X_FIELD_SIZE + 20, Y_FIELD_SIZE + 240);
        graphics.drawString(playerOne.getName(), 150, 590);
        graphics.drawString(Integer.toString(playerOne.getScore()), 190, 690);
        graphics.drawString(playerTwo.getName(), 780, 590);
        graphics.drawString(Integer.toString(playerTwo.getScore()), 820, 690);
        graphics.drawString(String.format("%02d:%02d", gameClock.getMinutes(), gameClock.getSeconds()), 490, 590);
	}
	/**
     * The startGame method initiates the start of the game.
     * Gives the puck velocity and starts the game timer.
     */
    public void startGame()
    {
    	puck.setSpeed(10);
    	timer.start();
    }
	/**
	 * The actionPerformed method takes in an event parameter and executes an action whenever an event occurs.
	 */
	public void actionPerformed(ActionEvent event)
	{
		update();
		repaint();
	}
	/**
	 * The keyPressed method takes in an event parameter that detects if a key was pressed on the keyboard.
	 * Executes an action whenever a specific key on the keyboard is pressed.
	 */
	public void keyPressed(KeyEvent event)
	{
		if (event.getKeyCode() == KeyEvent.VK_W)
        {
        	playerOne.setYVelocity(-playerOne.getPaddleSpeed());
			
			if (playerOne.getYPosition() <= FIELD_BOUNDARY)	
			{
				playerOne.setYVelocity(0);
			}
        }
        else if (event.getKeyCode() == KeyEvent.VK_S)
        {
            playerOne.setYVelocity(playerOne.getPaddleSpeed());
            
            if (playerOne.getYPosition() >= (Y_FIELD_SIZE + FIELD_BOUNDARY) - playerOne.getPaddleHeight())
			{
				playerOne.setYVelocity(0);
			}
        }
        if (event.getKeyCode() == KeyEvent.VK_UP)
        {
			playerTwo.setYVelocity(-playerTwo.getPaddleSpeed());
			
			if (playerTwo.getYPosition() <= FIELD_BOUNDARY)	
			{
				playerTwo.setYVelocity(0);
			}
        }
        else if (event.getKeyCode() == KeyEvent.VK_DOWN)
        {
            playerTwo.setYVelocity(playerTwo.getPaddleSpeed());
            
            if (playerTwo.getYPosition() >= (Y_FIELD_SIZE + FIELD_BOUNDARY) - playerTwo.getPaddleHeight())
			{
				playerTwo.setYVelocity(0);
			}
        } 
	}
	/**
	 * The keyReleased method takes in an event parameter that detects if a key was released on the keyboard.
	 * Executes an action whenever a specific key on the keyboard is released.
	 */
	public void keyReleased(KeyEvent event)
    {
		if (event.getKeyCode() == KeyEvent.VK_W || event.getKeyCode() == KeyEvent.VK_S)
        {
            playerOne.setYVelocity(0);
        }
        if (event.getKeyCode() == KeyEvent.VK_UP || event.getKeyCode() == KeyEvent.VK_DOWN)
        {
            playerTwo.setYVelocity(0);
        }
    }
	/**
	 * The keyTyped method takes in an event parameter that detects if a key was typed on the keyboard.
	 * Executes an action whenever a specific key on the keyboard is typed.
	 */
    public void keyTyped(KeyEvent event)
    {
        
    }
    /**
     * The getRecords method returns an instance of ScoreRecords.
     * @return records
     */
    public ScoreRecords getRecords()
    {
    	return records;
    }
    /**
     * The setPlayerOneName gives an instance of Player a new name.
     * @param newName
     * The new name.
     */
    public void setPlayerOneName(String newName)
    {
    	playerOne.setName(newName);
    }
    /**
     * The setPlayerTwoName gives an instance of Player a new name.
     * @param newName
     * The new name.
     */
    public void setPlayerTwoName(String newName)
    {
    	playerTwo.setName(newName);
    }
    /**
     * The checkGameOver method checks to see if the game is over.
     * If one of the players reaches a score of 7, then the game will end.
     */
    private void checkGameOver()
    {
    	Score score;
    	
    	if (playerOne.getScore() == 7)
		{
    		JOptionPane.showMessageDialog(this, "Game Over! " + playerOne.getName() + " wins!", "Game Winner", 2, null);
    		playerOne.setName(playerOne.getName());
    		timer.stop();
			puck.setSpeed(0);
			score = new Score(playerOne.getName(), playerOne.getCalculatedScore(playerOne.getScore(), gameClock.getCalculatedTime()));
			records.addScore(score);
			records.saveRecords();
			showScoreboard();
			continueGameOption();
		}
    	else if (playerTwo.getScore() == 7)
    	{
    		JOptionPane.showMessageDialog(this, "Game Over! " + playerTwo.getName() + " wins!", "Game Winner", 2, null);
			playerTwo.setName(playerTwo.getName());
			timer.stop();
			puck.setSpeed(0);
			score = new Score(playerTwo.getName(), playerTwo.getCalculatedScore(playerTwo.getScore(), gameClock.getCalculatedTime()));
			records.addScore(score);
			records.saveRecords();
			showScoreboard();
			continueGameOption();
    	}
    }
    /**
     * The resetGame method resets the timer, the scores, the position of the puck, and the position of the player.
     */
    private void resetGame()
    {
    	timer.restart();
    	playerOne.setScore(0);
    	playerOne.setYVelocity(0);
    	playerOne.setYPosition(230);
    	playerTwo.setScore(0);
    	playerTwo.setYVelocity(0);
    	playerTwo.setYPosition(230);
    	puck.setSpeed(10);
    	gameClock.setMilliseconds(0);
    	gameClock.setSeconds(0);
    	gameClock.setMinutes(0);
    	records.loadRecords();
    }
    /**
     * The continueGameOption method prompts the user for input.
     * Asks the user if they would like to continue playing or if they wish to quit the game.
     */
    private void continueGameOption()
    {
    	int choice = JOptionPane.showOptionDialog(this, 
    			     "Would you like to play again?", 
    			     "Continue Game", 
    			     JOptionPane.YES_NO_OPTION,
    		         JOptionPane.QUESTION_MESSAGE,
    		         null, null, null);
    	
    	if (choice == JOptionPane.YES_OPTION)
    	{
    		resetGame();
    	}
    	else
    	{
    		System.exit(0);
    	}
    }
    /**
     * The showScoreBoard method displays the top ten lowest scores at the end of a game.
     */
    private void showScoreboard()
    {
    	JOptionPane.showMessageDialog(this, records.toString(), "Scoreboard", 2, null);
    }
}