import java.util.ArrayList;
import java.util.Scanner;

/**
 * ConsoleMenu
 * 
 * <p>This class is used in tandem with the Game Backlog Project.
 * 
 * <p>Provides proper menus for use in the console. The {@code MenuLoop} method is used as the main menu loop
 * to go in and out from the different methods and menus.
 * <p> Several methods exist only to print out the options available to the user 
 * to the console. They are used with the menu methods so that they are
 * printed out accordingly.
 * 
 * <p>The main menu includes several options that lead to other menus,
 * each which loop until returning a specified character to quit.
 * <br><i>Note: Should change this to return a boolean in the future. </i>
 * 
 * <p>Interior menus include code for working with GameToPlay objects to 
 * modify them, or display them. Most menus work with {@code ModifyGames} and ({@code GameSelector}
 * ,however some have the code written directly in them, or even go to their own class
 * such as the case for {@code HelpMenu} and {@code SettingsManager}.
 * 
 * <p>
 * {@code MenuConsole()} is used for specifying types of console to various menus
 * and {@code MenuModify()} is used for options regarding the Modify game options.
 * <br><i>Note: Should change this to be utilized more in the future. </i>
 * 
 * <p>Class also includes methods for looping inputs from the console.
 * <br>Methods will only allow input of specific types, and will continue until the correct
 * input type is given.
 * 
 * @author Yungus Thugius
 * @version 0.1.0
 * @since 2026-06-11
 * @see GameToPlay
 * @see GameSelector
 * @see ModifyGames
 * @see SettingsManager
 * @see HelpMenu
 */
public class ConsoleMenu 
{
	/**
	 * Main menu loop for the program. 
	 * <p>Keeps going until {@code MainMenu} returns a value signifying it has completed.
	 * Takes in an ArrayList filled with game data to send to the different menus. 
	 * Returns a boolean based on whether the list has been changed or not (unimplemented).
	 * 
	 * @param gameList The list of games to display/modify.
	 * @return A boolean if the list has changed or not (unimplemented)
	 */
	public static boolean MenuLoop(ArrayList<GameToPlay> gameList)
	{
		char menuOption = 'a';
		boolean changed = false;
		while(menuOption != 'q')
		{
			if(menuOption != '0') {MainMenuOptions();}
			menuOption = MainMenu(gameList);
		}
		
		return changed;
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
	 * <p>Takes the {@code ArrayList} of  {@code GameToPlay} objects, and based on user input, sends it to different inner menus.
	 * The inner menus then modify/display information within the {@code gameList}.
	 * <p>Whenever the user inputs the character {@code q}, the menu will return {@code 'q'}, 
	 * {@code '0'} if the input was not in the list, and {@code '1'} elsewise.
	 * @param gameList The list of games to display/modify.
	 * @return A character based on the input.
	 */
	public static char MainMenu(ArrayList<GameToPlay> gameList)
	{
		char selectedOption = scannerChar();
		switch(selectedOption)
		{
			case('1'):
				ConsoleOptions();
			//scan method
				while(selectedOption != '0')
				{
					selectedOption = MenuZeroOne(gameList);
				}
				break;
			case('2'):
				//show currently playing
				ConsoleOptions();
				while(selectedOption != '0')
				{
					selectedOption = MenuZeroTwo(gameList);
				}
				break;
			case('3'):
				ConsoleOptions();
				while(selectedOption != '0')
				{
					selectedOption = MenuZeroThree(gameList);
				}
				break;
			case('4'):
				ConsoleOptions();
				while(selectedOption != '0')
				{
					selectedOption = MenuZeroFour(gameList);
				}
				break;
			case('5'):
				//Edit List of Games
				AddOrRemoveOptions();
				while(selectedOption != '0')
				{
					selectedOption = MenuZeroFive(gameList);
				}
				break;
			case('6'):
				//Settings Menu
				System.out.println("DEBUG: Not yet implemented.");
				break;
			case('7'):
				//Help Menu
				while(!HelpMenu.MainHelpMenu()) {}
				
				break;
			case('q'):
			
				return 'q';
			default:
				System.out.println("Please choose an option in the list.");
				return '0';
			
		}//end switch
		return '1';
	}
	/**
	 * Menu option code 1
	 * <p>Displays the options for console selection to the console.
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
				+ "\n/) Back To Main");
	}//
	/**
	 * Menu option code 1
	 * <p>Displays the options for console selection.
	 * @Overload Overloads {@code ConsoleOptions()}.
	 * @param noConsole A boolean based on whether or not the options should have the {@code All Consoles} option.
	 */
	public static void ConsoleOptions(boolean noConsole)
	{
		if(!noConsole)
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
				+ "\n/) Back To Main");
		}
		else
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
					+ "\n/) Back");
			
		}
	}//end ConsoleOptions overload
	/**
	 * Menu code Zero One. 
	 * <p>Lets the user choose which console to print the games from.
	 * Returns '1' if the user chooses an option outside of the list.
	 * <i>Note: Should Utilize {@code MenuConsole} for this method.</i>
	 * @param gameList The list of games to display/modify.
	 * @return A character based on the input.
	 */
	public static char MenuZeroOne(ArrayList<GameToPlay> gameList)
	{
		char selectedOption = scannerChar();
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
				break;
			default:
				System.out.println("Please choose an option in the list.");
				return '1';
			
		}//end switch
		return '0';
	}
	/**
	 * Menu Code Zero Two.
	 * <p>Lets the user choose which console to print the {@code Now Playing} from.
	 * Returns '1' if the user chooses an option outside of the list.
	 * <i>Note: Should Utilize {@code MenuConsole} for this method.</i>
	 * @param gameList The list of games to display/modify.
	 * @return A character based on the input.
	 */
	public static char MenuZeroTwo(ArrayList<GameToPlay> gameList)
	{
		char selectedOption = scannerChar();
		switch(selectedOption)
		{
			case('1'):
				GameSelector.PrintPlayingConsoleGames(gameList, "COM");
				break;
			case('2'):
				//show currently playing
				GameSelector.PrintPlayingConsoleGames(gameList, "EMU");
				break;
			case('3'):
				GameSelector.PrintPlayingConsoleGames(gameList, "SNS");
				break;
			case('4'):
				GameSelector.PrintPlayingConsoleGames(gameList, "GBA");
				break;
			case('5'):
				GameSelector.PrintPlayingConsoleGames(gameList, "3DS");
				break;
			case('6'):
				GameSelector.PrintPlayingConsoleGames(gameList, "WIU");
				break;
			case('7'):
				GameSelector.PrintPlayingConsoleGames(gameList, "SWI");
				break;
			case('8'):
				GameSelector.PrintPlayingConsoleGames(gameList, "PS2");
				break;
			case('9'):
				GameSelector.PrintPlayingConsoleGames(gameList, "PS4");
				break;
			case('0'):
				GameSelector.PrintPlayingAllGames(gameList);
				break;
			case('/'):
				break;
			default:
				System.out.println("Please choose an option in the list.");
				return '1';
			
		}//end switch
		return '0';
	}
	/**
	 * Menu code Zero Three.
	 * <p>Lets the user choose the console for selecting random games.
	 * Returns '2' if the user chooses an option outside of the list.
	 * <i>Note: Should Utilize {@code MenuConsole} for this method.</i>
	 * @param gameList The list of games to display/modify.
	 * @return A character based on the input.
	 */
	public static char MenuZeroThree(ArrayList<GameToPlay> gameList)
	{
		char selectedOption = scannerChar();
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
				return '0';
			default:
				System.out.println("Please choose an option in the list.");
				return '2';
		}//end switch
		RandomOptions((short)consoleGameList.size(), consoleGameList);
		return '0';
	}
	
	/**
	 * Menu Code Zero Four.
	 * <p>Let's the user choose the console for editing the games in the {@code Now Playing} list.
	 * Returns '2' if the user chooses an option outside of the list.
	 * <i>Note: Should Utilize {@code MenuConsole} for this method.</i>
	 * @param gameList The list of games to edit.
	 * @return A character based on the input.
	 */
	public static char MenuZeroFour(ArrayList<GameToPlay> gameList)
	{
		char selectedOption = scannerChar();
		String consoleName = "ALL";
		switch(selectedOption)
		{
			case('1'):
				consoleName = "COM";
				break;
			case('2'):
				consoleName = "EMU";
				break;
			case('3'):
				consoleName = "SNS";
				break;
			case('4'):
				consoleName = "GBA";
				break;
			case('5'):
				consoleName = "3DS";
				break;
			case('6'):
				consoleName = "WIU";
				break;
			case('7'):
				consoleName = "SWI";
				break;
			case('8'):
				consoleName = "PS2";
				break;
			case('9'):
				consoleName = "PS4";
				break;
			case('0'):
				break;
			case('/'):
				return '0';
			default:
				System.out.println("Please choose an option in the list.");
				return '2';
		}//end switch
		while(selectedOption != '/')
		{
			AddOrRemoveOptions();
			selectedOption = MenuFourOne(gameList, consoleName);
		}
		return '0';
	}//end method
	
	
	/**
	 * Menu Code Four One.
	 * <p>Allows the user to select options for modifying game data that is {@code Now Playing}.
	 * Returns '2' if the user chooses an option outside of the list.
	 * <i>Note: Should make this before the console selection.</i>
	 * <p>Three options are in this menu:<ol>
	 * <li>Add Game: Changes the {@code playing} boolean in the {@code GameToPlay} object to true.
	 * <li>Remove Game: Changes the {@code playing} boolean in the {@code GameToPlay} object to false, as well sending the {@code GameToPlay} object
	 * to the {@code MenuFourOneTwo} method.
	 * <li>Modify Game: Sends the {@code GameToPlay} object to the {@code ModifyGameData} method.</ol>
	 * 
	 * @param gameList The list of games to edit.
	 * @param consoleName The console which to filter the games from.
	 * @return A character based on the input.
	 */
	public static char MenuFourOne(ArrayList<GameToPlay> gameList, String consoleName)
	{
		char selectedOption = scannerChar();
		ArrayList<GameToPlay> consoleGameList = gameList;
		if(!consoleName.equals("ALL"))
		{
			consoleGameList = GameSelector.GetGamesForConsole(gameList, consoleName);
		}
		switch(selectedOption)
		{
		case('1'):
			ModifyGames.AddGameToPlaying(consoleGameList);
			break;
		case('2'):
			GameToPlay tempGame = ModifyGames.RemoveGamePlaying(GameSelector.GetPlayingAll(consoleGameList));
			if(tempGame != null)
			{
				ConsoleMenu.CurrentlyPlayingRemoveOptions();
				char menuChoice = '2';
				while(menuChoice == '2')
				{
					menuChoice = ConsoleMenu.MenuFourTwo(gameList, tempGame);
					if(menuChoice == 't')
					{
						tempGame.startPlaying();
					}	
				}//end while
			}//end if
			break;
		case('3'):
			ArrayList<GameToPlay> playingGames = GameSelector.GetPlayingAll(consoleGameList);
			ModifyGames.ModifyGameData(playingGames);
			break;
		case('/'):
			break;
		default:
			System.out.println("Please choose an option in the list.");
			return '2';
		}//end switch
		return '/';
	}
	
	
	/**
	 * Menu Code Zero Five.
	 * <p>Lets the user choose whether they want to add, remove, or change games within the list.
	 * <p>Three options are in this menu:<ol>
	 * <li>Add Game: Creates a brand new {@code GameToPlay} object then adds it into the list.
	 * <li>Remove Game: Removes a selected game from the given list.
	 * <li>Modify Game: Sends the {@code GameToPlay} object to the {@code ModifyGameData} method.</ol>
	 * 
	 * @param gameList The list of games to edit.
	 * @return A character based on the input.
	 */
	public static char MenuZeroFive(ArrayList<GameToPlay> gameList)
	{
		char selectedOption = scannerChar();
		ArrayList<GameToPlay> consoleGameList = gameList;
		//to prevent null calls
		GameToPlay tempGame;
		String consoleChoice = "ALL";
		
		switch(selectedOption)
		{
		case('1'):
			tempGame = ModifyGames.AddNewGame();
			gameList.add(tempGame);
			break;
		case('2'):
			ConsoleOptions();
			consoleChoice = MenuConsole();
			while(consoleChoice == null)
			{
				consoleChoice = MenuConsole();
			}
			if(!consoleChoice.equals(""))
			{
				if(!consoleChoice.equals("ALL")) 
				{consoleGameList = GameSelector.GetGamesForConsole(gameList, consoleChoice);}
	
				tempGame = ModifyGames.SelectGame(consoleGameList);
				//System.out.println("DEBUG: consoleChoice " + consoleChoice);
				ModifyGames.RemoveGame(gameList, tempGame);
			}
			break;
		case('3'):
			ConsoleOptions();
			consoleChoice = MenuConsole();
			while(consoleChoice == null)
			{
				consoleChoice = MenuConsole();
			}
			if(!consoleChoice.equals(""))
			{
				if(!consoleChoice.equals("ALL")) 
				{consoleGameList = GameSelector.GetGamesForConsole(gameList, consoleChoice);}
				ModifyGames.ModifyGameData(consoleGameList);
			}
			break;
		case('/'):
			break;
		default:
			System.out.println("Please choose an option in the list.");
			return '2';
		}//end switch
		return '0';
	}
	
	
	/**
	 * Menu Option Code 3.
	 * <p>Prints out the options for modifying a {@code GameToPlay} object.
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
	 * Menu option Code 4
	 * <p>Prints out the options for after removing a game from {@code Now Playing}.
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
	 * Menu Code Four Two
	 * <p>Allows the user to choose options after {@code MenuFourOne}, whether they wish to do with the {@code GameToPlay}
	 * object, after it is removed from {@code Now Playing}.
	 * <p>The Options are:
	 * <ol>
	 * <li>Modify Game: Sends the {@code GameToPlay} object to the {@code ModifyGameData} method.
	 * <li>Remove Game: Removes a selected game from the given list.
	 * <li>Do Nothing: Returns to the main menu with no changes to the main list.
	 * <li>Cancel: Doesn't remove the {@code GameToPlay} object from {@code Now Playing}.
	 * </ol>
	 * 
	 * @param game The {@code GameToPlay} object to edit.
	 * @param gameList The list of games to edit.
	 * @return A character based on the input.
	 */
	public static char MenuFourTwo(ArrayList<GameToPlay> gameList, GameToPlay game)
	{
		char selectedOption = scannerChar();
		switch(selectedOption)
		{
		case('1'):
			ModifyGames.ModifyGameData(game);
			break;
		case('2'):
			System.out.println("Removing " + game.getGameName() + "...");
			ModifyGames.RemoveGame(gameList, game);
			break;
		case('3'):
			break;
		case('/'):
			System.out.println("Not Removing " + game.getGameName() + " from Now Playing...");
			return 't';
		default:
			System.out.println("Please choose an option in the list.");
			return '2';
		}
		return 'r';
	}
	
	
	/**
	 * Prints out options for modifying a {@code GameToPlay} object. 
	 * Takes in a {@code GameToPlay} object to show the current object.
	 * @param game The {@code GameToPlay} to modify.
	 */
	public static void ModifyOptions(GameToPlay game)
	{
		System.out.println("What would you like to modify?"
				+ "\n1) Game Name (Current is " + game.getGameName() + ")"
				+ "\n2) Game Time (Current is " + game.getMinTime() + "-" + game.getMaxTime() + " Hours)"
				+ "\n3) Console (Current is " + game.getConsole() + ")"
				+ "\n/) Cancel");
	}
	
	
	/**
	 * Menu Code Two.
	 * <p>This method allows for the user to select between multiple options to modify a {@code GameToPlay} object.
	 * Returns a boolean if the user is done modifying the {@code GameToPlay} object.
	 * 
	 * <p>Three options are in this menu for the {@code GameToPlay} that allows the user to:
	 * <li>Game Name: Input a new Name for the object.
	 * <li>Game Time: Input a new Minimum and Maximum time for the object.
	 * <li>Console: Chooses a new {@code console} for the object.
	 * @param game The {@code GameToPlay} object to modify.
	 * @return A boolean if the user is done modifying the object.
	 */
	public static boolean MenuModify(GameToPlay game)
	{
		char selectedOption = scannerChar();
		boolean goodToGo = false;
		switch(selectedOption)
		{
		case('1'):
			System.out.println("Please enter new game name:");
			String newGameName = scannerString();
			goodToGo = false;
			while(!goodToGo)
			{
				System.out.println("New game name is " + newGameName+". Is this okay?");
				goodToGo = yesOrNo();
				if(!goodToGo)
				{
					System.out.println("Please enter new game name:");
					newGameName = scannerString();
				}
			}
			game.setGameName(newGameName);
			break;
		case('2'):
			System.out.println("Please Enter Minimum Time in Hours");
			short newMinTime = scannerShort();
			System.out.println("Please Enter Maximum Time in Hours");
			short newMaxTime = scannerShort();
			goodToGo = false;
			while(!goodToGo)
			{
				System.out.println("New game time is " + newMinTime + "-" + newMaxTime + " Hours. Is this okay?");
				goodToGo = yesOrNo();
				if(!goodToGo)
				{
					System.out.println("Please Enter Minimum Time");
					newMinTime = scannerShort();
					System.out.println("Please Enter Maximum Time");
					newMaxTime = scannerShort();
				}
			}
			game.setMinTime(newMinTime);
			game.setMaxTime(newMaxTime);
			break;
		case('3'):
			ConsoleOptions(true);
			String tempConsole = MenuConsole();
			while(tempConsole == null || tempConsole == "ALL")
			{
				if(tempConsole == "ALL")
				{
					System.out.println("Please choose an option in the list.\n");
				}
				ConsoleOptions(true);
				tempConsole = MenuConsole();
			}
			//System.out.println("DEBUG: MenuModify - Console is " + tempConsole);
			game.setConsole(tempConsole);
			break;
		case('/'):
			return true;
		default:
			System.out.println("Please choose an option in the list.");
			return false;
		}
		System.out.println("Would you like to change something else?");
		return !yesOrNo();
	}
	
	/**
	 * Takes in input from the user, and lets them pick from the choices to choose a console.
	 * Returns the console code of the corresponding console code, or null if an incorrect choice.
	 * @return The console code based on input. Null if incorrect choice chosen.
	 * @see GameToPlay
	 */
	public static String MenuConsole()
	{
		char selectedOption = scannerChar();
		String consoleName = "";
		switch(selectedOption)
		{
			case('1'):
				consoleName = "COM";
				break;
			case('2'):
				consoleName = "EMU";
				break;
			case('3'):
				consoleName = "SNS";
				break;
			case('4'):
				consoleName = "GBA";
				break;
			case('5'):
				consoleName = "3DS";
				break;
			case('6'):
				consoleName = "WIU";
				break;
			case('7'):
				consoleName = "SWI";
				break;
			case('8'):
				consoleName = "PS2";
				break;
			case('9'):
				consoleName = "PS4";
				break;
			case('0'):
				consoleName = "ALL";
				break;
			case('/'):
				return "";
			default:
				System.out.println("Please choose an option in the list.");
				return null;
		}//end switch
		return consoleName;
	}
	
	/**
	 * This method gets the user as many random games as they wish as long as is lies within the given {@code limit}.
	 * <p>The method first prompts the user for the amount they want, while using the given {@code limit} to display the limit,
	 * continuing to prompt if the user inputs something above the limit. 
	 * The method then prints out the randomly chosen games.
	 * 
	 * <p>The method also prompts if the user wants to add the randomly chosen games to {@code Now Playing}.
	 * @param limit The amount of game in the list, to be used as the limit for the amount of random games.
	 * @param gameList The list from which to choose the random {@code GameToPlay} objects.
	 */
	public static void RandomOptions(short limit, ArrayList<GameToPlay> gameList)
	{
		System.out.println("How many would you like to choose? (Limit is " + limit + " )");
		
		//scanner nonsense
		int choose = scannerInteger();
		while(choose > limit)
		{
			System.out.println("Please chose a number below " + limit);
			choose = scannerInteger();
		}
		short chosenAmount = (short)choose;
		//Scanner
		
		System.out.println("Selecting " + chosenAmount + " games...");
		ArrayList<GameToPlay> tempRandomList = GameSelector.GetRandomGame(gameList, chosenAmount);
		GameSelector.PrintAllGames(tempRandomList);
		if(tempRandomList.size() != 0)
		{
			System.out.println("Would you like to add these to Now Playing?");
			if(yesOrNo())
			{
				for(GameToPlay game: tempRandomList)
				{
					game.startPlaying();
				}
			}
	}
		
	}
	
	/**
	 * A method that takes in input from the user, and returns a boolean based on the user's input.
	 * Will prompt the user until 1 or 0 is inputed by the user.
	 * @return A boolean based on whether the user selected yes or no.
	 */
	public static boolean yesOrNo()
	{
		System.out.println("\n0) Yes\n1) No");
		char selectedOption = scannerChar();
		while(selectedOption != '0' && selectedOption != '1')
		{
			System.out.println("Please select 0 or 1.");
			//System.out.println("DEBUG: " + selectedOption);
			selectedOption = scannerChar();
		}
		if(selectedOption == '0')
		{
			return true;
		}
		return false;
		
	}
	
	/**
	 * A method that takes console input as a string and returns it.
	 * @return A String inputed by the User.
	 */
	public static String scannerString()
	{
		@SuppressWarnings("resource")
		Scanner scnr = new Scanner(System.in);
		return scnr.nextLine();
	}
	/**
	 * A method that takes console input as a string and  makes certain that it is a char then returns it.
	 * @return A Char inputed by the User.
	 */
	public static char scannerChar()
	{
		@SuppressWarnings("resource")
		Scanner scnr = new Scanner(System.in);
		String input = scnr.next();
		char inputC;
		if(input.length() != 1)
		{
			System.out.println("Invalid Input! Please Input a Single Character:");
			inputC = scannerChar();
		}
		else
		{
			inputC = input.charAt(0);
		}
		return inputC;
	}
	/**
	 * A method that takes input as a double and returns it. Only allows input of doubles,
	 * and will run until a double has been inputed.
	 * @return A double inputed by the User.
	 */
	public static double scannerDouble()
	{
		@SuppressWarnings("resource")
		Scanner scnr = new Scanner(System.in);
		double input;
		if(!scnr.hasNextDouble())
		{
			System.out.println("Invalid Input! Please Input a Double:");
			input = scannerDouble();
		}
		else
		{
			input = scnr.nextDouble();
		}
		return input ;
	}
	/**
	 * A method that takes input as a integer and returns it. Only allows input of integer,
	 * and will run until a integer has been inputed.
	 * @return A integer inputed by the User.
	 */
	public static int scannerInteger()
	{
		@SuppressWarnings("resource")
		Scanner scnr = new Scanner(System.in);
		int input;
		if(!scnr.hasNextInt())
		{
			System.out.println("Invalid Input! Please Input a Integer:");
			input = scannerInteger();
		}
		else
		{
			input = scnr.nextInt();
		}
		return input ;
	}
	/**
	 * A method that takes input as a short and returns it. Only allows input of short data type,
	 * and will run until a short has been inputed.
	 * @return A short inputed by the User.
	 */
	public static short scannerShort()
	{
		@SuppressWarnings("resource")
		Scanner scnr = new Scanner(System.in);
		short input;
		if(!scnr.hasNextShort())
		{
			System.out.println("Invalid Input! Please Input a Short (Max 32767):");
			input = scannerShort();
		}
		else
		{
			input = scnr.nextShort();
		}
		return input;
	}
	///
	//// Unused Methods ////
	/// 
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
		 * Takes in a menu option, then prints the correct menu.
		 * @param menuOption The option to print.
		 */
		/*
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
		*/
		/**
		 * Sends input to the correct menu. Returns what needs to be printed next.
		 * @param menuOption
		 * @param gameList
		 * @return Whether a menu needs to be printed next, and if so what menu. 
		 * ? signifies that something has gone wrong.
		 * 
		 */
		/*
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
		*/
		
}
