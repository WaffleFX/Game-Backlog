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
		for(GameToPlay game: consoleList)
		{
			System.out.println(game.getGameComplete());
		}
		
	}//end method
	
	
	public static void PrintAllGames(ArrayList<GameToPlay> gameList)
	{
		for(GameToPlay game: gameList)
		{
			System.out.println(game.getGameComplete());
		}
	}//end method
	
	
	public static ArrayList<GameToPlay> GetGamesForConsole(ArrayList<GameToPlay> gameList, String console)
	{
		boolean isConsole = false;
		short conAmount = (short)consoles.length;
		ArrayList<GameToPlay> consoleList = new ArrayList<GameToPlay>();
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
			return null;
		}
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
		
		//check for duplicates
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
