import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Will modify settings like switching between a GUI and Terminal working.
 * Works with a properties file.
 */
public class SettingsManager 
{	
	public static void createSettings()
	{
		try 
		{
			FileWriter settingsFile = new FileWriter("properties.txt", true);
			PrintWriter settingsPrinter = new PrintWriter(settingsFile);
			settingsPrinter.println("default_file:games_backlog.csv");
			settingsPrinter.println("mode:console");
			settingsPrinter.close();
		} 
		catch (IOException e) 
		{
			System.out.println("Input/Output Error");
			System.out.println(e.getMessage());
		}
	}//end createSettings
	
	
	/**
	 */
	public static CurrentSettings loadDefaultFile()
	{
		
		try 
		{
			File settingsFile = new File("properties.txt");
			Scanner settingsScanner = new Scanner(settingsFile);
			//System.out.println("Opened File.");
			
			
			String line = settingsScanner.nextLine();
			String[] defaultFile = line.split(":", 2);
			String defaultName = defaultFile[1];
			//System.out.println("Default File: (" + defaultName + ")");
			
			CurrentSettings settings = new CurrentSettings(defaultName,"console");
			settingsScanner.close();
			return settings;
		} 
		catch (FileNotFoundException e) 
		{
			System.out.println("Settings file not found. Creating properties.txt...");
			createSettings();
			return new CurrentSettings("games_backlog.csv","console");
		}
	}//end loadDefaultFile
	
	
	public static void finishSettings(CurrentSettings settings)
	{
		
		try 
		{
			FileWriter gameFile = new FileWriter("properties.txt");
			PrintWriter gameWriter = new PrintWriter(gameFile);
			gameWriter.println("default_file:" + settings.getDefaultFile());
			gameWriter.println("mode:" + settings.getCurrentMode());
			gameWriter.close();
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
}
