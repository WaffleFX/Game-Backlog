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
 * This class is meant to handle files regarding the Games to Play csv file.
 * It will take the games, play time, and console to store into an Object.
 * Will also write to file to add or delete games.
 * 
 * @author Connor Barrett
 * @version 0.1.0
 * @since 2026-06-10
 */
public class FileHandler 
{
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
