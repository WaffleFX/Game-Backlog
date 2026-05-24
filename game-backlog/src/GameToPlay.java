
/**
 * This class is used to store information about a game needed to play.
 * Store Game Name, average hours taken to beat, and console
 */
public class GameToPlay 
{
	private String gameName;
	private short minTime;
	private short maxTime;
	private String console;
	
	public GameToPlay(String name, short min, short max, String console)
	{
		gameName = name;
		minTime = min;
		maxTime = max;
		this.console = console;
	}
	
	/**
	 * Gets the information of the game into a string.
	 * @return A string of the game, the time required to beat it, and the console.
	 */
	public String getGameComplete()
	{
		String fullName = parseConsole(console);
		
		if(maxTime == 0)
		{
			return gameName + "\n???-??? Hours on " + fullName + "\n";
		}
		else
		{
			return gameName + "\n" + minTime + "-" + maxTime + " Hours on " + fullName + "\n";
		}
	}
	
	private String parseConsole(String consoleName)
	{
		String fullName = "";
		if(consoleName.equals("COM"))
		{
			fullName = "Computer";
		}
		else if(consoleName.equals("EMU"))
		{
			fullName = "Emulator";
		}
		else if(consoleName.equals("SWI"))
		{
			fullName = "Switch 1";
		}
		else if(consoleName.equals("PS4"))
		{
			fullName = "Playstation 4";
		}
		else if(consoleName.equals("PS2"))
		{
			fullName = "Playstation 2";
		}
		else if(consoleName.equals("3DS"))
		{
			fullName = "3DS";
		}
		else if(consoleName.equals("WIU"))
		{
			fullName = "Wii U";
		}
		else if(consoleName.equals("SNS"))
		{
			fullName = "Super Nintendo";
		}
		else if(consoleName.equals("GBA"))
		{
			fullName = "GameBoy Advance";
		}
		return fullName;
	}
	
	/**
	 * @return the gameName
	 */
	public String getGameName() {
		return gameName;
	}

	/**
	 * @return the minTime
	 */
	public short getMinTime() {
		return minTime;
	}

	/**
	 * @return the maxTime
	 */
	public short getMaxTime() {
		return maxTime;
	}

	/**
	 * @return the console
	 */
	public String getConsole() {
		return console;
	}
}
