import java.util.ArrayList;

/**
 * TODO:
 * <ol> 
 * <li>Add comments.
 * <li>Add Settings support.
 * 		<ol>
 * 		<li>(Default File)
 * 		</ol>
 * </ol>
 * 
 * 
 * <p>FUTURE IMPLEMENTATIONS:
 * <ol>
 * 		<li>Add support for Steam game export
 * 		<li>Add support for "Add/Remove Another?"
 * 		<li>Add GUI 
 * </ol>
 * 
 * @author Yungus Thugius
 * @version 0.0.3 
 * @since 2026-06-11
 */
public class WhatGameToPlay
{

	/**
	 * Main method.
	 * @param args Terminal input.
	 */
	public static void main(String[] args) 
	{
		String gameFileName = FileHandler.fileCheck("newTempGames.csv");
		ArrayList<GameToPlay> gameList = FileHandler.loadGameData(gameFileName);
		if(gameList == null)
		{
			System.out.println("Something Went Wrong!");
		}
		else
		{
			System.out.println("Success!!\n");
			testGameSelector(gameList);
			testMenus(gameList);
			testWriteOut(gameFileName, gameList);
			//testSelectGame(gameList);
		}
		System.out.println("Quitting...");
		
	}
	
	/**
	 * Method tests various methods within the GameSelector Class.
	 * Takes input of an ArrayList of GameToPlay type to test with.
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
	 * Takes input of an ArrayList of GameToPlay type to test with.
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
 * Takes input of an ArrayList of GameToPlay type to test with, and the name of a file to write out to.
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

}
