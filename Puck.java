/**
 * Puck.java - APR-04-2016 - ITEC 220: Project 3 - 
 * This class contains methods and data for a puck for the game.
 * @author Tre Haga
 * @version 1.0
 */
import java.awt.*;
public class Puck
{
	/**
	 * The Puck class instance variables.
	 */
	private int xPosition, yPosition, xVelocity, yVelocity, speed;
	private final int SIZE;
	/**
	 * The Puck class constructor.
	 */
	public Puck()
	{
		xPosition = 505;
		yPosition = 260;
		xVelocity = -10;
		yVelocity = 10;
		speed = 0;
		SIZE = 30;
	}
	/**
	 * The update method updates the position of the puck.
	 */
	public void update()
	{
		xPosition = xPosition + xVelocity;
        yPosition = yPosition + yVelocity;
        
        if (xPosition <= 21)
        {
            xVelocity = speed;
        }
        else if (xPosition + SIZE >= 1020)
        {
            xVelocity = -speed;
        }
        if (yPosition <= 20)
        {
            yVelocity = speed;
        }
        else if (yPosition + SIZE >= 520)
        {
            yVelocity = -speed;
        }
	}
	/**
	 * The paint method takes in graphics and visually displays the graphics for the puck.
	 * @param graphics
	 * The graphics.
	 */
	public void paint(Graphics graphics)
	{
		graphics.setColor(Color.BLACK);
        graphics.fillOval(xPosition, yPosition, SIZE, SIZE);
	}
	/**
	 * The getXPosition method returns the x position.
	 * @return xPosition
	 */
	public int getXPosition()
	{
		return xPosition;
	}
	/**
	 * The getYPosition method returns the y position of the puck.
	 * @return yPosition
	 */
	public int getYPosition()
	{
		return yPosition;
	}
	/**
	 * The getWidth method returns the width of the puck.
	 * @return SIZE
	 */
	public int getWidth()
	{
		return SIZE;
	}
	/**
	 * The getHeight method returns the height of the puck.
	 * @return SIZE
	 */
	public int getHeight()
	{
		return SIZE;
	}
	/**
	 * The getSpeed method returns the speed for the puck.
	 * @return speed
	 */
	public int getSpeed()
	{
		return speed;
	}
	/**
	 * The setXPosition method takes in a new x position and replaces the existing x position with this one.
	 * @param newXPosition
	 * The new x position.
	 */
	public void setXPosition(int newXPosition)
	{
		xPosition = newXPosition;
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
	 * The setXVelocity method takes in a new x velocity and replaces the existing x velocity with this one.
	 * @param newXVelocity
	 * The new x velocity.
	 */
	public void setXVelocity(int newXVelocity)
	{
		xVelocity = newXVelocity;
	}
	/**
	 * The setYVelocity method takes in a new y velocity and replaces the existing y velocity with this one.
	 * @param newYVelocity
	 * The new y velocity.
	 */
	public void setYVelocity(int newYVelocity)
	{
		yVelocity = newYVelocity;
	}
	/**
	 * The setSpeed method takes in a new speed and replaces the existing speed with this one.
	 * @param newSpeed
	 * The new speed.
	 */
	public void setSpeed(int newSpeed)
	{
		speed = newSpeed;
	}
	/**
	 * The reverseXVelocity method turns the x velocity into a negative.
	 */
	public void reverseXVelocity()
	{
		xVelocity = -xVelocity;
	}
}