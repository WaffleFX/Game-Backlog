import java.util.ArrayList;

/**
 * TODO: 
 * Add Terminal/GUI (future)
 * Add feature to enter/remove in current games playing.
 * -When removing games in current playing, prompt for change in game, or outright removal.
 * Add feature to remove/add games from list.
 * Add Settings support.
 * Add comments.
 */
public class WhatGameToPlay
{

	public static void main(String[] args) 
	{
		ArrayList<GameToPlay> gameList = FileHandler.loadGameData("GamestoPlay.csv");
		if(gameList == null || gameList.size() == 0)
		{
			System.out.println("Something Went Wrong!");
		}
		else
		{
			System.out.println("Success!!\n");
			testGameSelector(gameList);
		}
		
	}
	
	public static void testGameSelector(ArrayList<GameToPlay> gameList)
	{
		//GameSelector.PrintAllGames(gameList);
		//GameSelector.PrintConsoleGames(gameList, "COM");
		//GameSelector.PrintConsoleGames(gameList, "EMU");
		//GameSelector.PrintConsoleGames(gameList, "SWI");
		//GameSelector.PrintConsoleGames(gameList, "PS2");
		//GameSelector.PrintConsoleGames(gameList, "PS4");
		//GameSelector.PrintConsoleGames(gameList, "SNS");
		//GameSelector.PrintConsoleGames(gameList, "GBA");
		//GameSelector.PrintConsoleGames(gameList, "3DS");
		//GameSelector.PrintConsoleGames(gameList, "WIU");
		
		ArrayList<GameToPlay> tempConsoleList = GameSelector.GetGamesForConsole(gameList, "COM");
		ArrayList<GameToPlay> tempRandomList = GameSelector.GetRandomGame(tempConsoleList, (short)2);
		GameSelector.PrintAllGames(tempRandomList);
		
	}

}
