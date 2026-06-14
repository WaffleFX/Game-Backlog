import java.util.ArrayList;

/**
 * This class will add or remove games from the given list of games.
 * 
 * @author Yungus Thugius
 * @version 0.1.0
 * @since 2026-06-11
 * @see GameToPlay
 */
public class ModifyGames 
{
	public static GameToPlay SelectGame(ArrayList<GameToPlay> gameList)
	{
		int gameListSize =  gameList.size();
		if(gameListSize <  1)
		{
			System.out.println("No games!");
			return null;
		}
		
		System.out.println("Please select a game:\n\n0)\tCancel");
		for(int i = 0; i < gameListSize; i++)
		{
			System.out.println((i + 1) + ")\t" + gameList.get(i).getGameName());
			if(gameList.get(i).isPlaying())
			{
				System.out.println("(Now Playing)");
			}
		}
		
		
		int gameChoice = ConsoleMenu.scannerInteger();
		while(gameChoice > gameListSize || gameChoice < 0)
		{
			System.out.println("Please choose a valid entry.");
			gameChoice = ConsoleMenu.scannerInteger();
		}
		if(gameChoice == 0)
		{
			System.out.println("Cancelled.");
			return null;
		}
			
		return gameList.get(gameChoice - 1);
	}
	/**
	 * Add a specified game from a given ArrayList.
	 * @param gameList
	 */
	public static void AddGameToPlaying(ArrayList<GameToPlay> gameList)
	{
		GameToPlay gameToAdd = SelectGame(gameList);
		if(gameToAdd == null)
		{
			return;
		}
		if(gameToAdd.isPlaying())
		{
			System.out.println("Already Currently Playing");
			return;
		}
		gameToAdd.startPlaying();
	}
	
	/**
	 * @Overload
	 * Overloads AddGameToPlaying(ArrayList<GameToPlay> gameList).
	 * 
	 * Adds a game to Currently Playing from a given GameToPlay object.
	 * 
	 * @param game The game to add to  Currently Playing list.
	 */
	public static void AddGameToPlaying(GameToPlay game)
	{
		if(game == null)
		{
			return;
		}
		if(game.isPlaying())
		{
			System.out.println("Already Currently Playing");
			return;
		}
		game.startPlaying();
	}
	
	public static GameToPlay AddNewGame()
	{
		boolean goodToGo = false;
		//game name setting
		System.out.println("Please enter new game name:");
		String newGameName = ConsoleMenu.scannerString();
		while(!goodToGo)
		{
			System.out.println("New game name is " + newGameName+". Is this okay?");
			goodToGo = ConsoleMenu.yesOrNo();
			if(!goodToGo)
			{
				System.out.println("Please enter new game name:");
				newGameName = ConsoleMenu.scannerString();
			}
		}
		//time setting
		System.out.println("Please Enter Minimum Time in Hours");
		short newMinTime = ConsoleMenu.scannerShort();
		System.out.println("Please Enter Maximum Time in Hours");
		short newMaxTime = ConsoleMenu.scannerShort();
		while(!goodToGo)
		{
			System.out.println("New game time is " + newMinTime + "-" + newMaxTime + " Hours. Is this okay?");
			goodToGo = ConsoleMenu.yesOrNo();
			if(!goodToGo)
			{
				System.out.println("Please Enter Minimum Time");
				newMinTime = ConsoleMenu.scannerShort();
				System.out.println("Please Enter Maximum Time");
				newMaxTime = ConsoleMenu.scannerShort();
			}
		}
		//Console Setting
		ConsoleMenu.ConsoleOptions(true);
		String tempConsole = ConsoleMenu.MenuConsole();
		goodToGo = false;
		while(tempConsole == null || tempConsole == "ALL")
		{
			if(tempConsole == "ALL")
			{
				System.out.println("Please choose an option in the list.\n");
			}
			ConsoleMenu.ConsoleOptions(true);
			tempConsole = ConsoleMenu.MenuConsole();
		}
		
		
		//Final check
		GameToPlay newGame = new GameToPlay(newGameName, newMinTime, newMaxTime, tempConsole, false);
		System.out.println("New game Data.\n");
		System.out.println(newGame.getGameComplete());
		System.out.println("Is this okay?.\n");
		if(!ConsoleMenu.yesOrNo())
		{
			newGame = AddNewGame();
		}
		return newGame;
	}
	
	public static GameToPlay RemoveGamePlaying(ArrayList<GameToPlay> gameList)
	{
		GameToPlay game= SelectGame(gameList);
		if(game == null)
		{
			return null;
		}
		System.out.println("About to Remove " + game.getGameName() + " from Now Playing.\n");
		game.stopPlaying();
		return game;
		
	}//end RemoveGamePlaying
	public static boolean RemoveGame(ArrayList<GameToPlay> gameList)
	{
		GameToPlay game= SelectGame(gameList);
		if(game == null)
		{
			return false;
		}
		
		boolean goodToGo = false;
		while(!goodToGo)
		{
			System.out.println("About to Remove " + game.getGameName() + ". Is that Okay?\n");
			goodToGo = ConsoleMenu.yesOrNo();
			if(!goodToGo)
			{
				game= SelectGame(gameList);
				if(game == null)
				{
					return false;
				}
			}
		}//end while loop
		gameList.remove(game);
		return true;
	}
	/**
	 * @Overload
	 * 
	 * @param gameList
	 * @param game
	 * @return
	 */
	public static boolean RemoveGame(ArrayList<GameToPlay> gameList, GameToPlay game)
	{
		if(game == null)
		{
			return false;
		}
		gameList.remove(game);
		return true;
	}
	public static void ModifyGameData(ArrayList<GameToPlay> gameList)
	{
		GameToPlay game= SelectGame(gameList);
		if(game == null)
		{
			return;
		}
		boolean finished = false;
		while(!finished)
		{
			ConsoleMenu.ModifyOptions(game);
			finished = ConsoleMenu.MenuModify(game);
		}
		//System.out.println("DEBUG: ModifyGameData - Console is " + game.getConsole());
	}
	/**
	 * @Overload
	 * @param game
	 */
	public static void ModifyGameData(GameToPlay game)
	{
		if(game == null)
		{
			return;
		}
		boolean finished = false;
		while(!finished)
		{
			ConsoleMenu.ModifyOptions(game);
			finished = ConsoleMenu.MenuModify(game);
		}
	}

}
