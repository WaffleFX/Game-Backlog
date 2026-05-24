/**
 * Provides proper menus for use in the console.
 * Includes different text menus, as well as the scanner input options.
 */
public class ConsoleMenu 
{
	/**
	 * Prints options for main menu.
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
				+ "\n/) Quit");
	}
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
				+ "\n/) Back");
	}
	public static void AddOrRemoveOptions()
	{
		System.out.println("Add, Remove, or Change?"
				+ "\n1) Add"
				+ "\n2) Remove"
				+ "\n3) Change"
				+ "\n/) Back");
	}
	public static void CurrentlyPlayingRemoveOptions()
	{
		System.out.println("Would you like to modify the game (such as another in the series) or remove it from the list?"
				+ "\n1) Modify"
				+ "\n2) Remove"
				+ "\n/) Cancel");
	}
	public static void RandomOptions(short limit)
	{
		System.out.println("How many would you like to choose? (Limit is " + limit + " )");
	}
}
