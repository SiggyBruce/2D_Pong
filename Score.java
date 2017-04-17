/**
 * Score.java - APR-04-2016 - ITEC 220: Project 3 - 
 * This class contains methods for a score record.
 * Implements the Serializable and Comparable interfaces.
 * @author Tre Haga
 * @version 1.0
 */
import java.io.*;
public class Score implements Serializable, Comparable<Score>
{
	/**
	 * The Score class instance variables.
	 */
	private String name;
	private int score;
	/**
	 * The Score class constructor.
	 * @param newName
	 * The new name.
	 * @param newScore
	 * The new score.
	 */
	public Score(String newName, int newScore)
	{
		name = newName;
		score = newScore;
	}
	/**
	 * The getScore method returns the score for the score record.
	 * @return score
	 */
	public int getScore()
	{
		return score;
	}
	/**
	 * THe getName method returns the name for the score record.
	 * @return name
	 */
	public String getName()
	{
		return name;
	}
	/**
	 * The toString method returns a single string for a single score record.
	 * @return result
	 */
	public String toString()
	{
		String result = "";
		if (score < 999999)
		{
			result = name + ": " + score;
		}
		else
		{
			result = name;
		}
		return result;
	}
	/**
	 * The compareTo method returns an integer and compares two numbers.
	 * Returns 0 if the numbers are the same.
	 * Returns 1 if the number being compared is greater.
	 * Returns -1 if the number being compared is less.
	 * @param
	 * Instance of score.
	 * @return result
	 */
	public int compareTo(Score score)
	{
		int result = 0;
		
	    if (this.score < score.getScore()) 
	    {
	    	result = -1;
	    }
	    else if (this.score > score.getScore()) 
	    {
	    	result = 1;
	    }
	    
	    return result;
	}
}