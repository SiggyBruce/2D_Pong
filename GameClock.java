/**
 * GameClock.java - APR-04-2016 - ITEC 220: Project 3 - 
 * This class contains methods and data for a clock for the game.
 * @author Tre Haga
 * @version 1.0
 */
public class GameClock
{
	/**
	 * The GameClock class instance variables.
	 */
	private int milliseconds, seconds, minutes;
	/**
	 * The GameClock class constructor.
	 */
	public GameClock()
	{
		milliseconds = 0;
		seconds = 0;
		minutes = 0;
	}
	/**
	 * The countMilliseconds method increments milliseconds.
	 */
	public void countMilliseconds()
	{
		milliseconds = milliseconds + 50;
	}
	/**
	 * The checkClock method checks to make sure that the game clock is displaying the correct time.
	 * If milliseconds reaches 1000, then seconds go up by one.
	 * If seconds reaches 60, then minutes go up by one.
	 */
	public void checkClock()
    {
    	if (milliseconds == 1000)
		{
			seconds++;
			milliseconds = 0;
		}
		if (seconds == 60)
		{
			minutes++;
			seconds = 0;
		}
    }
	/**
	 * The getSeconds method returns the seconds.
	 * @return seconds
	 */
	public int getSeconds()
	{
		return seconds;
	}
	/**
	 * The getMinutes method returns the minutes.
	 * @return minutes
	 */
	public int getMinutes()
	{
		return minutes;
	}
	/**
	 * The getCalculatedTime method returns an integer that has been converted from minutes and seconds into seconds.
	 * @return totalTime
	 */
	public int getCalculatedTime()
	{
		int totalTime = 0;
		for (int index = 0; index < minutes; index++)
		{
			totalTime += 60;
		}
		totalTime += seconds;
		return totalTime;
	}
	/**
	 * The setMilliseconds method takes in new milliseconds and replaces the existing milliseconds with these.
	 * @param newMilliseconds
	 * The new milliseconds.
	 */
	public void setMilliseconds(int newMilliseconds)
	{
		milliseconds = newMilliseconds;
	}
	/**
	 * The setSeconds method takes in new seconds and replaces the existing seconds with these.
	 * @param newSeconds
	 * The new seconds.
	 */
	public void setSeconds(int newSeconds)
	{
		seconds = newSeconds;
	}
	/**
	 * The setMinutes method takes in new minutes and replaces the existing minutes with these.
	 * @param newMinutes
	 * The new minutes.
	 */
	public void setMinutes(int newMinutes)
	{
		minutes = newMinutes;
	}
}