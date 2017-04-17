/**
 * Player.java - APR-04-2016 - ITEC 220: Project 3 - 
 * This class contains methods and data for a player for the game.
 * @author Tre Haga
 * @version 1.0
 */
import java.awt.*;
public class Player
{
	/**
	 * The Player class instance variables.
	 */
	private int xPosition, yPosition, yVelocity, score;
	private String name;
	private final int PADDLE_WIDTH;
	private final int PADDLE_HEIGHT;
	private final int PADDLE_SPEED;
	/**
	 * The Player class constructor.
	 * @param newXPosition
	 * The new x position.
	 * @param newYPosition
	 * The new y position.
	 * @param newName
	 * The new new name.
	 */
	public Player(int newXPosition, int newYPosition, String newName)
	{
		xPosition = newXPosition;
		yPosition = newYPosition;
		yVelocity = 0;
		name = newName;
		score = 0;
		PADDLE_WIDTH = 5;
		PADDLE_HEIGHT = 70;
		PADDLE_SPEED = 10;
	}
	/**
	 * The update method updates the position of the player.
	 */
	public void update()
	{
		yPosition = yPosition + yVelocity;
	}
	/**
	 * The paint method takes in graphics and visually displays the graphics for the player.
	 * @param graphics
	 * The graphics.
	 */
	public void paint(Graphics graphics)
	{
		graphics.setColor(Color.RED);
		graphics.fillRect(xPosition, yPosition, PADDLE_WIDTH, PADDLE_HEIGHT);
	}
	/**
	 * The checkPaddleCollision method checks to see if the puck touches or collides with the player.
	 * @param puck
	 * Instance of puck.
	 */
	public void checkPaddleCollision(Puck puck)
    {
        if ((xPosition + PADDLE_WIDTH >= puck.getXPosition()) && 
        	(xPosition <= puck.getXPosition() + puck.getWidth()) && 
        	(yPosition + PADDLE_HEIGHT >= puck.getYPosition()) && 
        	(yPosition <= puck.getYPosition() + puck.getHeight()))
        {
        	puck.reverseXVelocity();
        }
    }
	/**
	 * The getYPosition method returns the y position for the player.
	 * @return yPosition
	 */
	public int getYPosition()
	{
		return yPosition;
	}
	/**
	 * The getPaddleHeight method returns the paddle height for the player.
	 * @return PADDLE_HEIGHT
	 */
	public int getPaddleHeight()
	{
		return PADDLE_HEIGHT;
	}
	/**
	 * The getPaddleSpeed method returns the paddle speed for the player.
	 * @return PADDLE_SPEED
	 */
	public int getPaddleSpeed()
	{
		return PADDLE_SPEED;
	}
	/**
	 * The getName method returns a name for the player.
	 * @return name
	 */
	public String getName()
	{
		return name;
	}
	/**
	 * The getScore method returns a score for the player.
	 * @return score
	 */
	public int getScore()
	{
		return score;
	}
	/**
	 * The getCalculatedScore method takes in integer for score and time.
	 * Multiplies them to produce a final score.
	 * @param score
	 * The score.
	 * @param time
	 * The time.
	 * @return finalScore
	 */
	public int getCalculatedScore(int score, int time)
	{
		int finalScore = score * time;
		return finalScore;
	}
	/**
	 * The setYVelocity method takes in a new  y velocity and replaces the existing y velocity with this one.
	 * @param speed
	 * The new y velocity.
	 */
	public void setYVelocity(int speed)
	{
		yVelocity = speed;
	}
	/**
	 * The setYPosition method takes in a new y position and replaces the existing y position with this one.
	 * @param newYPosition
	 * The new y position.
	 */
	public void setYPosition(int newYPosition)
	{
		yPosition = newYPosition;
	}
	/**
	 * The setName method takes in a new name and replaces the existing name with this one.
	 * @param newName
	 * The new name.
	 */
	public void setName(String newName)
	{
		name = newName;
	}
	/**
	 * The setScore method takes in a new score and replaces the existing score with this one.
	 * @param newScore
	 * The new score.
	 */
	public void setScore(int newScore)
	{
		score = newScore;
	}
}