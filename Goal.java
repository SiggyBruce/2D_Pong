/**
 * Goal.java - APR-04-2016 - ITEC 220: Project 3 - 
 * This class contains methods and data for a goal for the game.
 * @author Tre Haga
 * @version 1.0
 */
import java.awt.*;
public class Goal
{
	/**
	 * The Goal class instance variables.
	 */
	private int xPosition, yPosition;
	private final int GOAL_WIDTH;
	private final int GOAL_HEIGHT;
	/**
	 * The Goal class constructor.
	 * @param newXPosition
	 * The new x position.
	 * @param newYPosition
	 * The new y position.
	 */
	public Goal(int newXPosition, int newYPosition)
	{
		xPosition = newXPosition;
		yPosition = newYPosition;
		GOAL_WIDTH = 10;
		GOAL_HEIGHT = 130;
	}
	/**
	 * The paint method takes in graphics and visually displays the graphics for the goal.
	 * @param graphics
	 * The graphics.
	 */
	public void paint(Graphics graphics)
	{
		graphics.setColor(Color.GREEN);
		graphics.fillRect(xPosition, yPosition, GOAL_WIDTH, GOAL_HEIGHT);
	}
	/**
	 * The checkGoalCollistion method check to see if the puck touches or collides with the goal.
	 * @param puck
	 * Instance of puck.
	 * @return isHit
	 */
	public boolean checkGoalCollision(Puck puck)
	{
		boolean isHit = false;
		if ((xPosition + GOAL_WIDTH >= puck.getXPosition()) && 
        	(xPosition <= puck.getXPosition() + puck.getWidth()) && 
        	(yPosition + GOAL_HEIGHT >= puck.getYPosition()) && 
        	(yPosition <= puck.getYPosition() + puck.getHeight()))
        {
        	isHit = true;
        }
		return isHit;
	}
}
