import java.util.ArrayList;

/**
 * TODO:
 * <ol> 
 * <li>Add Settings support.
 * 		<ol>
 * 		<li>Add inner menu loop for settings.
 * 		<li>Add change current default file.
 * 		</ol>
 * <li>Add More Comments
 * </ol>
 * 
 * 
 * 
 * Game Backlog Project
 * 
 * <p>This project is to create, and maintain a proper backlog of video games. This class acts as the main method for the project.
 * 
 * <p>The main backlog is preserved through a .csv file, up to the <i>(currently hard coded to look for one specific file)</i> 
 * user's choice. If the file check fails, it will prompt the user for a new file, if it exists, the file opens, otherwise creating a new file.
 * At the end of the program, the program will write back to the file.
 * 
 * <p>The project first takes input through the {@code FileHandler} class, which goes through an initial check of the file, then properly reading the
 * information into separate {@code GameToPlay} objects. The class also includes a method to write the information back into the file.
 * 
 * <p>Through an {@code ArrayList}, this program takes games and their information and stores them within 
 * a {@code GameToPlay} object, which stores the name, console, a range of time to beat in hours, and whether the game is currently being played.
 * <br>The {@code GameToPlay} class includes methods for returning a string of the game, meant for printing to the console, as well as getting each 
 * individual component of the game.
 * 
 * <p>Once all of the data is loaded into an {@code ArrayList}, the program loads into the {@code ConsoleMenu} class, which allows the user to 
 * choose between multiple options, allowing them to display or modify the list of games. Also included in the menu is a {@code HelpMenu}, and
 * a <i>(unimplemented)</i> settings menu.
 * 
 * <p>This class contains several method that exist for testing purposes.
 * 
 * <p>FUTURE IMPLEMENTATIONS:
 * <ol>
 * 		<li>Add support for Steam game export
 * 		<li>Add support for "Add/Remove Another?"
 * 		<li>Add GUI 
 * </ol>
 * 
 * 
 * @author Yungus Thugius
 * @version 0.0.3 
 * @since 2026-06-15
 * @see FileHandler
 * @see GameToPlay
 * @see ConsoleMenu
 */
public class WhatGameToPlay
{

	/**
	 * Main method.
	 * @param args Terminal input.
	 */
	public static void main(String[] args) 
	{
		CurrentSettings settings = SettingsManager.loadDefaultFile();
		String settingsGame = settings.getDefaultFile();
		String gameFileName = FileHandler.fileCheck(settingsGame);
		
		//for changes in file name from settings
		if(!settingsGame.equals(gameFileName))
		{
			System.out.println("Would you like to update the default file?");
			if(ConsoleMenu.yesOrNo())
			{
				System.out.println("Changing default file to " + gameFileName + "...");
				settings.setDefaultFile(gameFileName);
			}
		}//end if
		
		ArrayList<GameToPlay> gameList = FileHandler.loadGameData(gameFileName);
		if(gameList == null)
		{
			System.out.println("Something Went Wrong!");
		}
		//games have been loaded correctly and everything has gone correctly
		else
		{
			System.out.println("Success!!\n");
			ConsoleMenu.MenuLoop(gameList);
			FileHandler.writeGameData("games_backlog.csv", gameList);
			//testGameSelector(gameList);
			//testMenus(gameList);
			//testWriteOut(gameFileName, gameList);
			//testSelectGame(gameList);
			
		}
		SettingsManager.finishSettings(settings);
		System.out.println("Quitting...");
		
	}
	
	/**
	 * Method tests various methods within the GameSelector Class.
	 * <br>Takes input of an ArrayList of GameToPlay type to test with.
	 * @param gameList The ArrayList of GameToPlay objects to test with.
	 */
	public static void testGameSelector(ArrayList<GameToPlay> gameList)
	{
		//GameSelector.PrintAllGames(gameList);
		//4GameSelector.PrintConsoleGames(gameList, "COM");
		//GameSelector.PrintConsoleGames(gameList, "EMU");
		//GameSelector.PrintConsoleGames(gameList, "SWI");
		//GameSelector.PrintConsoleGames(gameList, "PS2");
		//GameSelector.PrintConsoleGames(gameList, "PS4");
		//GameSelector.PrintConsoleGames(gameList, "SNS");
		//GameSelector.PrintConsoleGames(gameList, "GBA");
		//GameSelector.PrintConsoleGames(gameList, "3DS");
		//GameSelector.PrintConsoleGames(gameList, "WIU");
		
		//ArrayList<GameToPlay> tempConsoleList = GameSelector.GetGamesForConsole(gameList, "COotM");
		//ArrayList<GameToPlay> tempRandomList = GameSelector.GetRandomGame(tempConsoleList, (short)2);
		//GameSelector.PrintAllGames(tempRandomList);
		
	}
	/**
	 * Method tests various menus found in the ConsoleMenu Class.
	 * <br>Takes input of an ArrayList of GameToPlay type to test with.
	 * @param gameList The ArrayList of GameToPlay objects to test with.
	 */
	public static void testMenus(ArrayList<GameToPlay> gameList)
	{
		//ConsoleMenu.MenuZeroOne('0', gameList);
		//ConsoleMenu.MenuZeroOne('1', gameList);
		//ConsoleMenu.MenuZeroOne('2', gameList);
		//ConsoleMenu.MenuZeroOne('3', gameList);
		//ConsoleMenu.MenuZeroOne('4', gameList);
		//ConsoleMenu.MenuZeroOne('5', gameList);
		//ConsoleMenu.MenuZeroOne('6', gameList);
		//ConsoleMenu.MenuZeroOne('7', gameList);
		//ConsoleMenu.MenuZeroOne('8', gameList);
		//ConsoleMenu.MenuZeroOne('9', gameList);
		
		ConsoleMenu.MenuLoop(gameList);
		//ConsoleMenu.MenuZeroThree('1', gameList);
		
	}
	
/**
 * 
 * Menu tests the write out method found in the FileHandler Class.
 * <br>Takes input of an ArrayList of GameToPlay type to test with, and the name of a file to write out to.
 * @param fileName The name of the file to write out to.
 * @param gameList The ArrayList of GameToPlay objects to test with.
 */
	public static void testWriteOut(String fileName, ArrayList<GameToPlay> gameList)
	{
		FileHandler.writeGameData(fileName, gameList);
	}
	/**
	 * Method tests the SelectGame method found in the ModifyGames class.
	 * Also tests the overloaded method.
	 * Takes input of an ArrayList of GameToPlay type to test with.
	 * @param gameList The ArrayList of GameToPlay objects to test with.
	 */
	public static void testSelectGame(ArrayList<GameToPlay> gameList)
	{
		GameToPlay temp = ModifyGames.SelectGame(gameList);
		if(temp != null) 
		{
			System.out.println(temp.getGameName());
			ModifyGames.AddGameToPlaying(temp);
			
		}
		//ModifyGames.AddGameToPlaying(gameList);
		GameSelector.PrintPlayingAllGames(gameList);
	}
	
	
	public static void testSettingsManager()
	{
		CurrentSettings settings = SettingsManager.loadDefaultFile();
		String gameFileName = FileHandler.fileCheck(settings.getDefaultFile());
		settings.setDefaultFile(gameFileName);
		//System.out.println(settings.getDefaultFile());
		SettingsManager.finishSettings(settings);
	}

}
