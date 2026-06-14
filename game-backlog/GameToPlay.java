
/**
 * GameToPlay
 * 
 * <p>This class is used to store information about a game needed to play.
 * It stores the game Name, average hours taken to beat, console.
 * 
 * <p>{@code parseConsole} allows for the Console Code to be written as a full console name,
 * and {@code getGameComplete}getGameComplete() returns a full String of information regarding the current game,
 * used for printing out the game.
 * 
 * <p>Class includes getters and setters for each value.
 * 
 * @author Yungus Thugius
 * @version 0.1.0
 * @since 2026-06-11
 */
public class GameToPlay 
{
	private String gameName;
	private short minTime;
	private short maxTime;
	private String console;
	private boolean playing;
	
	/**
	 * Constructor Method, takes in parameters and sets them into the object.
	 */
	public GameToPlay(String name, short min, short max, String console, boolean nowPlaying)
	{
		gameName = name;
		minTime = min;
		maxTime = max;
		this.console = console;
		playing = nowPlaying;
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
	
	/**
	 * Takes the console code as a String, and returns the full name of the console the code is linked to.
	 * @param consoleName The console code to get the full name of.
	 * @return The full name of the console code. Unknown otherwise.
	 */
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
		else
		{
			fullName = "Unknown";
		}
		return fullName;
	}
	/**
	 * Sets playing variable to true.
	 */
	public void startPlaying()
	{
		playing = true;
	}
	/**
	 * Sets playing variable to false.
	 */
	public void stopPlaying()
	{
		playing = false;
	}
	/**
	 * Getter method for playing variable.
	 * @return The boolean playing of the current object.
	 */
	public boolean isPlaying()
	{
		return playing;
	}
	/**
	 * Getter method for gameName variable.
	 * @return the gameName of the current object.
	 */
	public String getGameName() {
		return gameName;
	}

	/**
	 * Getter method for minTime variable.
	 * @return the minTime of the current object.
	 */
	public short getMinTime() {
		return minTime;
	}

	/**
	 * Getter method for maxTime variable.
	 * @return the maxTime of the current object.
	 */
	public short getMaxTime() {
		return maxTime;
	}

	/**
	 * Getter method for console variable.
	 * @return the console variable of the current object.
	 */
	public String getConsole() {
		return console;
	}

	/**
	 * Setter method for gameName variable.
	 * @param gameName the gameName to set
	 */
	public void setGameName(String gameName) {
		this.gameName = gameName;
	}

	/**
	 * Setter method for minTime variable.
	 * @param minTime the minTime to set
	 */
	public void setMinTime(short minTime) {
		this.minTime = minTime;
	}

	/**
	 * Setter method for maxTime variable.
	 * @param maxTime the maxTime to set
	 */
	public void setMaxTime(short maxTime) {
		this.maxTime = maxTime;
	}

	/**
	 * Setter method for console variable.
	 * @param console the console to set
	 */
	public void setConsole(String console) {
		this.console = console;
	}
}
