import java.util.ArrayList;

/**
 * ModifyGames
 * 
 * <p>This class's purpose is to modify an {@code ArrayList} of {@code GameToPlay} objects.
 * It has several methods to select, remove, or add a game to the {@code ArrayList}.
 * 
 * <p>The {@code SelectGame} method will take the given {@code ArrayList} and allow the user to select a given
 * {@code GameToPlay} object. This method is used in conjunction with other methods such as
 * {@code AddGameToPlaying} or {@code RemoveGame}. However, multiple overloads exist within the
 * class to take input as a {@code GameToPlay} object rather than the full {@code ArrayList}.
 * 
 * <p>The method {@code ModifyGameData} is used in conjunction with the {@code MenuModify} method in {@code ConsoleMenu}.
 * This method simply acts as a outer loop to keep the menu running.
 * 
 * 
 * @author Yungus Thugius
 * @version 0.1.0
 * @since 2026-06-11
 * @see GameToPlay
 * @see ConsoleMenu
 */
public class ModifyGames 
{
	/**
	 * This method take the given {@code ArrayList} and displays all of the options within.
	 * It then takes input from the user, asking again for wrong input, and selects a game based on the
	 * user's decision. It then returns the corresponding {@code GameToPlay} object. 
	 * If 0 is chosen, it will cancel and return null.
	 * @param gameList The {@code ArrayList} to select from.
	 * @return The chosen {@code GameToPlay} object; null if empty or cancelled.
	 */
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
	 * Add a specified game from a given {@code ArrayList} to {@code Now Playing}. This method utilizes {@code SelectGame}.
	 * @param gameList The {@code ArrayList} to add from.
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
	
	 * 
	 * <p>Adds a game to Currently Playing from a given {@code GameToPlay} object.
	 * @Overload
	 * Overloads AddGameToPlaying(ArrayList<GameToPlay> gameList).
	 * @param game The {@code GameToPlay} object to add to  Currently Playing list.
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
	
	/**
	 * Allows the user to enter data for a new {@code GameToPlay} object.
	 * 
	 * <p>Individually allows the user to enter in the Game Name, minimum time, maximum time, and console.
	 * Any available String is usable for the Game Name, while time requires specific short type numbers. 
	 * Entering 0 for maximum time will cause the program to display the time as "???" for both maximum and minimum time.
	 * Console choice only allows for the given choices.
	 * 
	 * <p>After inputting the information, the inputted information will be displayed
	 * and the program will prompt the user if it is okay. Selecting no resets the method, 
	 * and the eventual selection of yes will return the new {@code GameToPlay} object.
	 * 
	 * @return The newly created {@code GameToPlay} object.
	 */
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
	
	/**
	 * Selects a {@code GameToPlay} object from the given {@code ArrayList}, and removes it from {@code Now Playing}.
	 * Returns the {@code GameToPlay} object that was stopped playing.
	 * @param gameList The {@code ArrayList} to select the game from.
	 * @return The {@code GameToPlay} object that was removed from {@code Now Playing}.
	 */
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
	
	/**
	 * Selects a {@code GameToPlay} object from the given {@code ArrayList}, and removes it from the list.
	 * Returns a boolean whether the object was removed or not.
	 * @param gameList The {@code ArrayList} to select the game from.
	 * @return A boolean whether the object was removed or not.
	 */
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
	 * Removes a given {@code GameToPlay} object from the given {@code ArrayList}.
	 * Returns a boolean whether the object was removed or not.
	 * 
	 * @Overload Overloads {@code RemoveGame(ArrayList<GameToPlay> gameList)} .
	 * @param gameList The {@code ArrayList} to remove the game from.
	 * @param game The {@code GameToPlay} object to remove.
	 * @return A boolean whether the object was removed or not.
	 * 
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
	/**
	 * Works as a outer loop to {@code ConsoleMenu.MenuModify}. 
	 * <p>Will modify a selected {@code GameToPlay} object within the given {@code ArrayList}.
	 * Will loop until the inner method returns true.
	 * @param gameList The {@code ArrayList} to select the {@code GameToPlay} object from.
	 * @see ConsoleMenu.MenuModify
	 */
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
	 *  Works as a outer loop to {@code ConsoleMenu.MenuModify}. 
	 * <p>Will modify a given {@code GameToPlay} object.
	 * Will loop until the inner method returns true.
	 * @Overload Overloads {@code ModifyGameData(ArrayList<GameToPlay> gameList)}.
	 * @param game The {@code GameToPlay} object to modify.
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
