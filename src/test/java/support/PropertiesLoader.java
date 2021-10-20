package support;

import config.Environment;
import config.ExecutionSettings;

public class PropertiesLoader {
	
	public static Environment loadAll(){
				
		ExecutionSettings.loadSettings(Constants.EXECUTION_SETTINGS_PATH);
		Environment env = Environment.getEnvironment(Constants.EXECUTION_ENV_PATH);
		
		return env;
	}

}
