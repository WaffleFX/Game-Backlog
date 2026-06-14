import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * File Handler
 * 
 * <p>This class is meant to handle files regarding the Game Backlog csv file.
 * 
 * <p>It has methods fileCheck() and loadGameData() to either read or create a file that stores game Data.
 * It reads the file and parses the data into objects, which are then stored within an ArrayList.
 * The class also contains methods to write the data back into the file.
 * 
 * 
 * @author Yungus Thugius
 * @version 0.1.0
 * @since 2026-06-11
 * @see GameToPlay
 */
public class FileHandler 
{
	
	/**
	 * This method is used to check the if there is a file currently available.
	 * If the given String does not correspond with a file within the current working directory, 
	 * it will prompt through the console if another one is desired. 
	 * The newly created file is closed, and the name is returned.
	 * 
	 * <p>Catches IOException then crashes.
	 * @param starterFileName The name of the file to check.
	 * @return The name of the correct file, or the incorrect if the user chooses to quit.
	 */
	public static String fileCheck(String starterFileName)
	{
		try
		{
			File gameFile = new File(starterFileName);
			Scanner gameScanner = new Scanner(gameFile);
			gameScanner.close();
		}
		catch(FileNotFoundException e)
		{
			System.out.println("File "+ starterFileName +" Not Found. Would you like to choose a different file/create a new empty file?");
			if(ConsoleMenu.yesOrNo())
			{
				try 
				{
					System.out.println("Please enter desired file name without file extension: (e.g. gameList, backlog, turron//not gameList.csv, backlog.csv...)");
					String newGameFile = ConsoleMenu.scannerString();
					newGameFile = newGameFile.strip();
					newGameFile = newGameFile + ".csv";
					FileWriter gameFile = new FileWriter(newGameFile, true);
					gameFile.close();
					return newGameFile;
				} 
				catch (IOException e1) 
				{
					System.out.println("Input/Output Error");
					System.out.println(e.getMessage());
				}
			}
		}
		return starterFileName;
	}
	
	
	/**
	 * This method takes in the name of file, and parses it according to the specifications of the GameToPlay object type.
	 * The method attempts to open the file (if exception is thrown, then returns null), then parses the data within.
	 * The method requires the given data to be in the format [Minimum Time]-[Maximum Time],[Game Name],[Console],[Playing] to be correctly parsed.
	 * When the data is parsed correctly, the information will be stored in a GameToPlay object, and then added to an ArrayList.
	 * 
	 * <p>After the file is finished being parsed, the method returns the ArrayList.
	 * @param fileName The name of the file to load data from.
	 * @return The ArrayList of GameToPlay objects given by the file; null if an error was encountered.
	 */
	public static ArrayList<GameToPlay> loadGameData(String fileName)
	{
		//Scanner scnr = new Scanner(System.in);
		System.out.println("Loading Game Data...");
		try
		{
			File gameFile = new File(fileName);
			Scanner gameScanner = new Scanner(gameFile);
			System.out.println("Found file, Loading Data...");
			ArrayList<GameToPlay> gameList = new ArrayList<GameToPlay>();
			while(gameScanner.hasNextLine())
			{
				String[] fileInput = gameScanner.nextLine().split(",");
				short lineLength  = (short)fileInput.length;
				
				//System.out.println("DEBUG: LINE LENGTH " + lineLength);
				if(lineLength == 0)
				{
					continue;
				}
				
				//checking if no game is there.
				if(!fileInput[0].equals("") || !fileInput[1].equals("") || !fileInput[2].equals(""))
				{
					short[] gameTime;
					short gameMin;
					short gameMax;
					String gameName;
					String gameConsole;
					boolean playing = false;
					
					for(int i = 0; i < lineLength  - 3; i+=3)
					{
						gameName = fileInput[i+1];
						gameConsole = fileInput[i+2];
						if(gameName.equals("Stop") || gameConsole.equals("Stop"))
						{
							break;
						}
						if(gameName.equals("") || gameConsole.equals("") )
						{
							continue;
						}
						gameTime = parseHours(fileInput[i]);
						if(gameTime == null)
						{
							System.out.println("Something went wrong with parseHours. Failing...");
							gameScanner.close();
							return null;
						}
						gameMin = gameTime[0];
						gameMax = gameTime[1];
						if(fileInput[i+3].equals("1"))
						{
							playing = true;
						}
						
						
						GameToPlay addedGame = new GameToPlay(gameName, gameMin, gameMax, gameConsole, playing);
						gameList.add(addedGame);
						//System.out.println(addedGame.getGameComplete());
						
					}//end for loop (one line)
				}//End if statement
				
			}//end while loop (whole file)
			if(gameList.size() == 0)
			{
				System.out.println("No Data found! Please add games or try another file.");
			}
			else{System.out.println("Data Loaded!");}
			gameScanner.close();
			return gameList;
		}
		catch(FileNotFoundException e)
		{
			
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	
	/**
	 * This method writes out the contents of a given ArrayList to a given file, creating it if it doesn't previously exist.
	 * The method writes each GameToPlay object in a format readable by loadGameData.
	 * @param fileName The given file to write to.
	 * @param gameList The list of game data to save.
	 */
	public static void writeGameData(String fileName, ArrayList<GameToPlay> gameList)
	{
		System.out.println("Saving Game Data...");
		try
		{
			FileWriter gameFile = new FileWriter(fileName);
			PrintWriter gameWriter = new PrintWriter(gameFile);
			short playingNum = 0;
			
			for(GameToPlay game: gameList)
			{
				if(game.isPlaying())
				{
					playingNum = 1;
				}
				else
				{
					playingNum = 0;
				}
				gameWriter.println(game.getMinTime() + "-" + game.getMaxTime() + "," + game.getGameName() + "," + game.getConsole() + "," + playingNum);
			}
			
			gameWriter.close();
			System.out.println("Saved!");
		}
		catch(IOException e)
		{
			System.out.println("Input/Output Error");
			System.out.println(e.getMessage());
		}
	}
	
	
	/**
	 * This method parses a string into an array of shorts, used in a games hours section.
	 * The method first splits the string into two by space, then takes the first of those to split into another two by the '-' characters.
	 * If the strings returned by the second split are not in the short data type, it will 0,0 or null if it is empty.
	 * @param hours The string to parse into hours format.
	 * @return The array of min and max hours. Null if empty.
	 */
	private static short[] parseHours(String hours)
	{
		String[] partsHrs = hours.split(" ", 2);
		String[] partsTime = partsHrs[0].split("-",2);
		short minTime;
		short maxTime;
		try
		{
			minTime = (short)Integer.parseInt(partsTime[0]);
			if(partsTime.length == 1)
			{
				maxTime = minTime;
			}
			else
			{
				maxTime = (short)Integer.parseInt(partsTime[1]);
			}
			short[] timeBlock = {minTime, maxTime};
			return timeBlock;
		}
		catch(NumberFormatException e)
		{
			if(partsTime[0].equals(""))
			{
				return null;
			}
			short[] timeBlock = {0, 0};
			return timeBlock;
		}
		
	}
}
