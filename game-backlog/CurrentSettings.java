
public class CurrentSettings 
{
	private String defaultFile;
	private String currentMode;
	
	public CurrentSettings(String defaultFile, String currentMode) 
	{
		this.defaultFile = defaultFile;
		this.currentMode = currentMode;
	}

	/**
	 * @return the defaultFile
	 */
	public String getDefaultFile() {
		return defaultFile;
	}

	/**
	 * @return the currentMode
	 */
	public String getCurrentMode() {
		return currentMode;
	}

	/**
	 * @param defaultFile the defaultFile to set
	 */
	public void setDefaultFile(String defaultFile) {
		this.defaultFile = defaultFile;
	}

	/**
	 * @param currentMode the currentMode to set
	 */
	public void setCurrentMode(String currentMode) {
		this.currentMode = currentMode;
	}
	
	
}
