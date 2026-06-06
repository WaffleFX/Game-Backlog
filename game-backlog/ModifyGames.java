import java.util.ArrayList;

/**
 * This class will add or remove games from the given list of games.
 * 
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
				System.out.print("(Already Playing)");
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

}
