/**
 * ScoreRecords.java - APR-04-2016 - ITEC 220: Project 3 - 
 * This class contains methods and data to manipulate a collection of score records.
 * Implements the Serializable interface.
 * @author Tre Haga
 * @version 1.0
 */
import java.io.*;
import java.util.*;
public class ScoreRecords implements Serializable
{
	/**
	 * The ScoreRecords class instance variables.
	 */
	private ArrayList<Score> playerRecords;
	/**
	 * The ScoreRecords class constructor.
	 */
	public ScoreRecords()
	{
		playerRecords = new ArrayList<Score>();
	}
	/**
	 * The addScore method adds a score record to the collection of score records.
	 * @param score
	 * Instance of score.
	 */
	public void addScore(Score score)
	{
		playerRecords.add(score);
		Collections.sort(playerRecords);
	}
	/**
	 * The getPlayerRecords returns an array list of score records.
	 * @return playerRecords
	 */
	public ArrayList<Score> getPlayerRecords()
	{
		return playerRecords;
	}
	/**
	 * The inputNewRecords method adds 10 placeholder scores to the collection of score records.
	 */
	public void inputNewRecords()
	{
		Score score = new Score("<EMPTY>", 999999);
		
		for (int index = 0; index < 10; index++)
		{
			playerRecords.add(score);
		}
		
		Collections.sort(playerRecords);
	}
	/**
	 * The saveRecords method outputs all of the score records in the score record collection to a file.
	 */
	public void saveRecords()
	{
		Collections.sort(playerRecords);
		FileOutputStream fileOutput;
		ObjectOutputStream objectOutput;
		
		try
		{
			fileOutput = new FileOutputStream("gameSave.sav");
			objectOutput = new ObjectOutputStream(fileOutput);
			objectOutput.writeObject(playerRecords);
			objectOutput.close();
		}
		catch (IOException exception)
		{
			
		}
	}
	/**
	 * The loadRecords method inputs all of the score records from a file and loads it into the program.
	 */
	public void loadRecords()
	{
		FileInputStream fileInput = null;
        ObjectInputStream objectInput = null;
        
		try
        {
            fileInput = new FileInputStream("gameSave.sav");
            objectInput = new ObjectInputStream(fileInput);
            playerRecords = (ArrayList<Score>) objectInput.readObject();
            Collections.sort(playerRecords);
            objectInput.close();
            fileInput.close();
        }
        catch (IOException | ClassNotFoundException exception)
        {
        	
        }
	}
	/**
	 * The doesSaveFileExist method checks to see if an already existing save file is available.
	 * @return exists
	 */
	public boolean doesSaveFileExist()
	{
		boolean exists = false;
		File file = new File("gameSave.sav");
		
		if(file.exists() && !file.isDirectory())
		{ 
		    exists = true;
		}
		return exists;
	}
	/**
	 * The toString method returns a single string for the collection of score records.
	 * @return result
	 */
	public String toString()
	{
		String result = "";
		int count = 0;
		for (int index = 0; index < 10; index++)
		{
			count++;
			result += count + ". " + playerRecords.get(index) + "\n";
		}
		return result;
	}
}