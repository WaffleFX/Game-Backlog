import java.util.ArrayList;
import java.util.Random;


/**
 * Class handles selecting games.
 */
public class GameSelector 
{
	public static String[] consoles = {"COM","EMU","PS4","PS2","SNS","GBA","3DS","WIU","SWI"};
	
	
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
	 * @param console
	 * @return
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
	 * To be used with a list with all the games you want included in your randomization.
	 * @param gameList  The list to pull the game from.
	 * @param amount    The amount of random game to pull.
	 * @return An ArrayList containing all of the randomly selected games.
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
