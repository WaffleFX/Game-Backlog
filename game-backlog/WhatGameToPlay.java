import java.util.ArrayList;

/**
 * TODO: 
 * Add GUI (future)
 * Add feature to enter/remove in current games playing.
 * -When removing games in current playing, prompt for change in game, or outright removal.
 * Add feature to remove/add games from list.
 * Add Settings support.
 * Add comments.
 * 
 * @author Yungus Thugius
 * @version 0.0.2 
 * @since 2026-05-24
 */
public class WhatGameToPlay
{

	public static void main(String[] args) 
	{
		ArrayList<GameToPlay> gameList = FileHandler.loadGameData("tempGames.csv");
		if(gameList == null || gameList.size() == 0)
		{
			System.out.println("Something Went Wrong!");
		}
		else
		{
			System.out.println("Success!!\n");
			testGameSelector(gameList);
			testMenus(gameList);
			testWriteOut("newTempGames.csv", gameList);
			//testSelectGame(gameList);
		}
		System.out.println("Quitting...");
		
	}
	
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
		
		//ArrayList<GameToPlay> tempConsoleList = GameSelector.GetGamesForConsole(gameList, "COM");
		//ArrayList<GameToPlay> tempRandomList = GameSelector.GetRandomGame(tempConsoleList, (short)2);
		//GameSelector.PrintAllGames(tempRandomList);
		
	}
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
	
	public static void testWriteOut(String fileName, ArrayList<GameToPlay> gameList)
	{
		FileHandler.writeGameData(fileName, gameList);
	}
	
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
