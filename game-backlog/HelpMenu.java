/**
 * 
 * Help Menu.
 * <p>This class is used in tandem with the Game Backlog Project.
 * 
 * <p>The purpose of this class is to provide help through the terminal regarding the project.
 * The class is comprised of a menu with several options that each go to their own unique text box to display helpful text.
 * Several methods exist within the class to print out the correct text for each option.<p>
 * 
 * @author Yungus Thugius
 * @version 0.1.0 
 * @since 2026-06-11
 */
public class HelpMenu 
{
	/**
	 * The main backbone for the Help Menu. Made for use with a loop.
	 * The method first prints out the options available, then takes the input as a singular character.
	 * Several options print different information, with '/' being a "quit" option for the current menu.
	 * Returns a boolean regarding if the menu is done and the call should cease.
	 * @return A boolean regarding if the menu is done and the call should cease.
	 */
	public static boolean MainHelpMenu()
	{
		MainHelpOptions();
		
		char selectedOption = ConsoleMenu.scannerChar();
		boolean done = false;
		
		switch(selectedOption)
		{
			case('1'):
				HelpOptionOne();
				break;
			case('2'):
				HelpOptionTwo();
				break;
			case('3'):
				HelpOptionThree();
				break;
			case('4'):
				HelpOptionFour();
				break;
			case('5'):
				HelpOptionFive();
				break;
			case('/'):
				done = true;
			default:
				System.out.println("Please choose an option in the list.");
				return done;
			}//end switch
		System.out.println("\nWould you like to continue in the help menu?");
		if(!ConsoleMenu.yesOrNo())
		{
			done = true;
		}
		return done;
	}//end MainHelpMenu
	
	/**
	 * Prints out options for the help menu.
	 */
	public static void MainHelpOptions()
	{
		System.out.println("Please Choose a Help Option:\n"
				+ "1) How does the program work?\n"
				+ "2) Adding Games\n"
				+ "3) File Setup\n"
				+ "4) Currently Playing\n"
				+ "5) Other Consoles\n"
				+ "/) Back ");
	}
	/**
	 * Prints out what the program does.
	 */
	public static void HelpOptionOne()
	{
		System.out.println("This program is made to help create a backlog of video games.\n"
				+ "The program allows to add games from several consoles, and the time required to beat them.\n"
				+ "It takes information from a file either given or created.\n"
				+ "It also allows to have a select group of games that are currently being played.\n"
				+ "Most importantly, the program has an option to randomly choose games for a given conosle.\n");
	}
	/**
	 * Prints out how to add games, and what the different parameters mean.
	 */
	public static void HelpOptionTwo()
	{
		System.out.println("Adding games into the program is done throught the \"Edit List of Games\" options.\n"
				+ "The games require a Game Name (which can be just about anything),\n"
				+ "A range of average time to beat the game in hours\n"
				+ "(Minimum time being 20, and Maximum time being 30 for a time range of 20-30)\n"
				+ "and a console which the game will be played on.\n"
				+ "Inputting 0 for min and max time will result in time being ???\n");
	}
	/**
	 * Prints out how the file handling the backlog is formatted.
	 */
	public static void HelpOptionThree()
	{
		System.out.println("The file used to hold backlog information requires the information to be formatted in a specific way.\n"
				+ "The backlog file requires the follwing format\n"
				+ "[Minimum Time]-[Maximum Time],[Game Name],[Console],[Playing]\n"
				+ "An example would be:\n"
				+ "10-20,Ace Combat 7,COM,0\n"
				+ "(Each console requires a special 3 lettered Code to be recognized)\n");
	}
	/**
	 * Prints out information regarding the Currently Playing.
	 */
	public static void HelpOptionFour()
	{
		System.out.println("The list of Currently Playing is used to wittle down the game backlog.\n"
				+ "Games chosen by random selection can be automatically added to Currentout.println(\"\");ly Playing\n"
				+ "While removing games from Currently Playing, the program allows to either remove the game from the list or change the information.\n");
	}
	/**
	 * Prints out the information regarding other consoles.
	 */
	public static void HelpOptionFive()
	{
		System.out.println("Currently, there are only a select amount of consoles.\n"
				+ "Future implementations will include more consoles as well as the option to add new consoles.\n");
	}
}//end Class
