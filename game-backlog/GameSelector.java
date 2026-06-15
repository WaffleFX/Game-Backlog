import java.util.ArrayList;
import java.util.Random;


/**
 * Game Selector
 * 
 * <p>This class is used to sort and print {@code GameToPlay} objects in an {@code ArrayList} 
 * Methods include printing games in the list, and returning games in the list, based on console or if they're {@code Now Playing}.
 * 
 * <p>The methods used in this class help print out games for a specified console, including they are or are not currently {@code Now Playing},
 * with code to protect against empty lists, or no games in the current list that fit the criteria. There also exists {@code PrintAllGames},
 * which prints every game in the list regardless.
 * 
 * <p>A special method, {@code GetRandomGame}, works to get an {@code ArrayList} of pseduo-randomly chosen {@code GameToPlay} objects.
 * 
 * @author Yungus Thugius
 * @version 0.1.0 
 * @since 2026-06-11
 */
public class GameSelector 
{
	public static String[] consoles = {"COM","EMU","PS4","PS2","SNS","GBA","3DS","WIU","SWI"};
	
	
	/**
	 * Prints all {@code GameToPlay} objects with a specified console in a given list to the console.
	 * @param gameList The list of {@code GameToPlay} objects to sort through and print.
	 * @param console The console to print the {@code GameToPlay} objects from.
	 */
	public static void PrintConsoleGames(ArrayList<GameToPlay> gameList, String console)
	{
		ArrayList<GameToPlay> consoleList = GetGamesForConsole(gameList, console);
		if(consoleList.size() <  1)
		{
			System.out.println("No games!");
		}
		else
		{
			for(GameToPlay game: consoleList)
			{
				System.out.println(game.getGameComplete());
			}
		}
		
	}//end method
	
	/**
	 * Prints all {@code GameToPlay} objects in a given list to the console.
	 * @param gameList The list of {@code GameToPlay} objects to print.
	 */
	public static void PrintAllGames(ArrayList<GameToPlay> gameList)
	{
		if(gameList.size() <  1)
		{
			System.out.println("No games!");
		}
		else
		{
			for(GameToPlay game: gameList)
			{
				System.out.println(game.getGameComplete());
			}
		}
	}//end method
	
	/**
	 * Prints all {@code GameToPlay} objects with a specified console that are {@code Now Playing} in a given list to the console.
	 * @param gameList The list of {@code GameToPlay} objects to sort through and print.
	 * @param console The console to print the {@code GameToPlay} objects from.
	 */
	public static void PrintPlayingConsoleGames(ArrayList<GameToPlay> gameList, String console)
	{
		ArrayList<GameToPlay> consoleList = GetGamesForConsole(gameList, console);
		boolean found = false;
		for(GameToPlay game: consoleList)
		{
			if(game.isPlaying())
			{
				System.out.println(game.getGameComplete());
				found = true;
			}
		}
		if(!found)
		{
			System.out.println("No currnetly playing games!");
		}
	}//end method
	
	/**
	 * Prints all {@code GameToPlay} objects that are {@code Now Playing} in a given list to the console.
	 * @param gameList The list of {@code GameToPlay} objects to print.
	 */
	public static void PrintPlayingAllGames(ArrayList<GameToPlay> gameList)
	{
		boolean found = false;
		for(GameToPlay game: gameList)
		{
			if(game.isPlaying())
			{
				System.out.println(game.getGameComplete());
				found = true;
			}
		}
		if(!found)
		{
			System.out.println("No currnetly playing games!");
		}
	}
	
	/**
	 * Returns all {@code GameToPlay} objects with a specified console.
	 * @param gameList The list of {@code GameToPlay} objects to sort through and return.
	 * @param console The console to return the {@code GameToPlay} objects from.
	 */
	public static ArrayList<GameToPlay> GetGamesForConsole(ArrayList<GameToPlay> gameList, String console)
	{
		if(!ConsoleCheck(console))
		{
			return null;
		}
		ArrayList<GameToPlay> consoleList = new ArrayList<GameToPlay>();
		for(GameToPlay game: gameList)
		{
			if(game.getConsole().equals(console))
			{
				consoleList.add(game);
			}
		}
		return consoleList;
	}//end method
	
	/**
	 * Returns all {@code GameToPlay} objects with a specified console that are {@code Now Playing}.
	 * @param gameList The list of {@code GameToPlay} objects to sort through and return.
	 * @param console The console to return the {@code GameToPlay} objects from.
	 */
	public static ArrayList<GameToPlay> GetPlayingForConsole(ArrayList<GameToPlay> gameList, String console)
	{
		if(!ConsoleCheck(console))
		{
			return null;
		}
		ArrayList<GameToPlay> consoleList = new ArrayList<GameToPlay>();
		for(GameToPlay game: gameList)
		{
			if(game.getConsole().equals(console) && game.isPlaying())
			{
				consoleList.add(game);
			}
		}
		return consoleList;
	}
	
	/**
	 * Returns all {@code GameToPlay} objects that are {@code Now Playing} in a given list.
	 * @param gameList The list of {@code GameToPlay} objects to return.
	 */
	public static ArrayList<GameToPlay> GetPlayingAll(ArrayList<GameToPlay> gameList)
	{
		ArrayList<GameToPlay> consoleList = new ArrayList<GameToPlay>();
		for(GameToPlay game: gameList)
		{
			if(game.isPlaying())
			{
				consoleList.add(game);
			}
		}
		return consoleList;
	}
	
	/**
	 * Checks if the given console is accepted.
	 * <p>The method checks through the class's {@code consoles} array and checks if the given console code
	 * is present in the array. Returns a boolean based on if the console was found.
	 * @param console The console code to check.
	 * @return A boolean whether the console code is valid or not.
	 */
	public static boolean ConsoleCheck(String console)
	{
		boolean isConsole = false;
		short conAmount = (short)consoles.length;
		
		for(int i = 0; i < conAmount; i++)
		{
			if(console.equals(consoles[i]))
			{
				isConsole = true;
				break;
			}
		}
		if(!isConsole)
		{
			System.out.println("Invalid Console selected.");
		}
		return isConsole;
		
	}
	
	/**
	 * This method returns a list of randomly chosen {@code GameToPlay} objects.
	 * 
	 * <p>First, the method checks if the given amount chosen is higher than the amount in the list to choose from.
	 * If yes, the method returns null. Else it continues.
	 * 
	 * <p>Then, the method takes a set of random shorts (from {@code java.util.Random} and puts them into an array
	 * equal to the amount given. The method then takes a seperate array which compares itself with the first array
	 * to ensure that no duplicates were found. 
	 * 
	 * <p>Afterwords, the array of shorts are taken as individual indexes that are pulled from the given {@code ArrayList}, 
	 * and inserted into a new {@code ArrayList}. Once the new {@code ArrayList} is filled, it is then returned.
	 * 
	 * @param gameList  The {@code ArrayList} to pull the {@code GameToPlay} objects from.
	 * @param amount    The amount of random {@code GameToPlay} objects to pull.
	 * @return An {@code ArrayList} containing all of the randomly selected games. Null if the amount chosen is above the given amount.
	 */
	public static ArrayList<GameToPlay> GetRandomGame(ArrayList<GameToPlay> gameList, short amount)
	{
		short amountToUse = amount;
		short[] chosenIndex = new short[amountToUse];
		short gameCount = (short)gameList.size();
		//for loop variables
		short i = 0;
		short j = 0;
		
		//no honky nonsense.
		if(amount > gameCount)
		{
			System.out.println("ERROR: Amount chosen is larger than amount in list. Please try another amount.");
			return null;
		}
		
		
		Random rand = new Random();
		ArrayList<GameToPlay> chosenGames = new ArrayList<GameToPlay>();
		
		//enter in random numbers
		for(i = 0; i < amountToUse; i++)
		{
			chosenIndex[i] = (short)rand.nextInt(gameCount);
		}
		
		//check for duplicates, we only want one of each index
		short[] noDupes = chosenIndex;
		for(i = 0; i < amountToUse; i++)
		{
			//nested loop
			for(j = 0; j < amountToUse; j++)
			{
				if(i == j)
				{
					continue;
				}
				else if(chosenIndex[i] == noDupes[j])
				{
					chosenIndex[i] = (short)rand.nextInt(gameCount);
					noDupes[i] = chosenIndex[i];
					j = -1;
				}//12334
				 //12354
			}//end inner loop
		}//end outer loop
		
		//DEBUG
		/*
		for(short num: chosenGames)
		{
			System.out.println(num);
		}
		*/
		
		//finally, get those games from that array, and stick em into a nice list.
		for(i = 0; i < amountToUse; i++)
		{
			chosenGames.add(gameList.get(chosenIndex[i]));
		}
		return chosenGames;
	}
	
}
