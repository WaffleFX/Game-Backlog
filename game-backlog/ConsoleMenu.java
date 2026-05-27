import java.util.ArrayList;

/**
 * Provides proper menus for use in the console.
 * Includes different text menus, as well as the scanner input options.
 */
public class ConsoleMenu 
{
	//System.out.print("\033[H\033[2J"); Clears console
	/*
	 * default correct menu is 0, or the main menu.
	 * z menu is set equal to 0.
	 * while(working)
		 * print correct menu
		 * if(menu = z)
		 * 		
		 * scan input
		 * set z menu to current menu
		 * send the input to correct menu panel, which will affect the list/menu as needed.
		 *  
		 * make own method
		 * switch statement
		 * if(menu = w)
		 * 		DEBUG: Showing Data...
		 * 		while(showing text)
		 * 			scan until q is entered.
		 * 		set correct menu to 0.
		 * else if(menu = z)
		 * 		set z menu to currnet menu
		 * else if(menu = q)
		 * 		working = false;
		 * case(?)
		 * 		Error message
		 * 		working = false
		 * case(*)
		 * 		Debug message for work in progress
		 * 		Set correct menu to 0.
		 * case(/)
		 * 		Array. Go back one.
		 * else
		 * 		clear the panel
	 */
	
	
	/**
	 * Takes in a menu option and limit of games, then prints the correct menu.
	 * @param menuOption The option to print.
	 * @param gameLimit The limit of games in the list.
	 */
	public static void PrintCorrectMenu(char menuOption)
	{
		switch(menuOption)
		{
			case('0'):
				MainMenuOptions();
				break;
			case('1'):
				ConsoleOptions();
				break;
			case('2'):
				AddOrRemoveOptions();
				break;
			case('3'):
				CurrentlyPlayingRemoveOptions();
				break;
			case('z'):
				System.out.println("Please input a menu option shown in the list.");
				break;
			default:
				System.out.println("ERROR: Menu not found!");
				break;
			
		}//end switch
	}//end method
	
	/**
	 * Sends input to the correct menu. Returns what needs to be printed next.
	 * @param menuOption
	 * @param gameList
	 * @return Whether a menu needs to be printed next, and if so what menu. 
	 * ? signifies that something has gone wrong.
	 * 
	 */
	public static char MenuHandler(char menuOption, char selectedOption, ArrayList<GameToPlay> gameList)
	{
		char newMenu = menuOption;
		//switch statements to the different menus.
		switch(menuOption)
		{
			case(0):
				newMenu = MainMenu(selectedOption, gameList);
				break;
			default:
				return '?';
		}
		return newMenu;
	}
	/**
	 * Prints options for main menu. Menu option code 0.
	 */
	public static void MainMenuOptions()
	{
		System.out.println("Please choose an Option."
				+ "\n1) Show List of Games"
				+ "\n2) Show Currently Playing"
				+ "\n3) Get Random Selection of Games"
				+ "\n4) Edit Currently Playing"
				+ "\n5) Edit List of Games"
				+ "\n6) Edit Settings"
				+ "\n7) Help"
				+ "\nq) Quit");
	}
	/**
	 * Menu Code 0.
	 * @param selectedOption
	 * @param gameList
	 * @return
	 */
	public static char MainMenu(char selectedOption, ArrayList<GameToPlay> gameList)
	{
		
		switch(selectedOption)
		{
			case('1'):
				return '1';
			case('2'):
				//show currently playing
				return 'w';
			case('3'):
				return '1';
			case('4'):
				return '?';
			case('5'):
				return '1';
			case('6'):
				return '?';
			case('7'):
				return '?';
			case('q'):
				return 'q';
			default:
				System.out.println("Please choose an option in the list.");
				break;
			
		}//end switch
		return '0';
	}
	/**
	 * Menu option code 1
	 */
	public static void ConsoleOptions()
	{
		System.out.println("Which Console?"
				+ "\n1) Computer"
				+ "\n2) Emulator"
				+ "\n3) Super Nintendo"
				+ "\n4) GameBoy Advance"
				+ "\n5) 3DS"
				+ "\n6) Wii U"
				+ "\n7) Switch"
				+ "\n8) Playstation 2"
				+ "\n9) Playstation 4"
				+ "\n0) All Consoles"
				+ "\n-) Back To Main");
	}
	/**
	 * Menu code 1. 0-1. Chooses which console to print the games from.
	 * @param selectedOption
	 * @param gameList
	 * @return
	 */
	public static char MenuZeroOne(char selectedOption, ArrayList<GameToPlay> gameList)
	{
		switch(selectedOption)
		{
			case('1'):
				GameSelector.PrintConsoleGames(gameList, "COM");
				break;
			case('2'):
				//show currently playing
				GameSelector.PrintConsoleGames(gameList, "EMU");
				break;
			case('3'):
				GameSelector.PrintConsoleGames(gameList, "SNS");
				break;
			case('4'):
				GameSelector.PrintConsoleGames(gameList, "GBA");
				break;
			case('5'):
				GameSelector.PrintConsoleGames(gameList, "3DS");
				break;
			case('6'):
				GameSelector.PrintConsoleGames(gameList, "WIU");
				break;
			case('7'):
				GameSelector.PrintConsoleGames(gameList, "SWI");
				break;
			case('8'):
				GameSelector.PrintConsoleGames(gameList, "PS2");
				break;
			case('9'):
				GameSelector.PrintConsoleGames(gameList, "PS4");
				break;
			case('0'):
				GameSelector.PrintAllGames(gameList);
				break;
			case('/'):
				return '/';
			default:
				System.out.println("Please choose an option in the list.");
				break;
			
		}//end switch
		return 'q';
	}
	/**
	 * Menu code 2. 0-3
	 * @param selectedOption
	 * @param gameList
	 * @return
	 */
	public static char MenuZeroThree(char selectedOption, ArrayList<GameToPlay> gameList)
	{
		ArrayList<GameToPlay> consoleGameList = gameList;
		switch(selectedOption)
		{
			case('1'):
				consoleGameList = GameSelector.GetGamesForConsole(gameList, "COM");
				break;
			case('2'):
				consoleGameList = GameSelector.GetGamesForConsole(gameList, "EMU");
				break;
			case('3'):
				consoleGameList = GameSelector.GetGamesForConsole(gameList, "SNS");
				break;
			case('4'):
				consoleGameList = GameSelector.GetGamesForConsole(gameList, "GBA");
				break;
			case('5'):
				consoleGameList = GameSelector.GetGamesForConsole(gameList, "3DS");
				break;
			case('6'):
				consoleGameList = GameSelector.GetGamesForConsole(gameList, "WIU");
				break;
			case('7'):
				consoleGameList = GameSelector.GetGamesForConsole(gameList, "SWI");
				break;
			case('8'):
				consoleGameList = GameSelector.GetGamesForConsole(gameList, "PS2");
				break;
			case('9'):
				consoleGameList = GameSelector.GetGamesForConsole(gameList, "PS4");
				break;
			case('0'):
				break;
			case('/'):
				return '/';
			default:
				System.out.println("Please choose an option in the list.");
				return '2';
		}//end switch
		RandomOptions((short)consoleGameList.size(), consoleGameList);
		return 'w';
	}
	/**
	 * Menu Option Code 2
	 * 0-1
	 * 0-2-3
	 * 0-4-5-6
	 * 0-7-8-9
	 * 0-s (own class)
	 * 
	 */
	public static void AddOrRemoveOptions()
	{
		System.out.println("Add, Remove, or Change?"
				+ "\n1) Add"
				+ "\n2) Remove"
				+ "\n3) Change"
				+ "\n/) Back");
	}
	/**
	 * Menu option Code 3
	 */
	public static void CurrentlyPlayingRemoveOptions()
	{
		System.out.println("Would you like to modify the game (such as another in the series) or remove it from the list?"
				+ "\n1) Modify"
				+ "\n2) Remove"
				+ "\n3) Do Nothing"
				+ "\n/) Cancel");
	}
	/**
	 *
	 * @param limit
	 */
	public static void RandomOptions(short limit, ArrayList<GameToPlay> gameList)
	{
		System.out.println("How many would you like to choose? (Limit is " + limit + " )");
		
		//scanner nonsense
		
		System.out.println("Selecting " + 2 + " games...");
		ArrayList<GameToPlay> tempRandomList = GameSelector.GetRandomGame(gameList, (short)2);
		GameSelector.PrintAllGames(tempRandomList);
		
	}
}
