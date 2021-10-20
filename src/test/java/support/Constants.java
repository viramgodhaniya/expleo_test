package support;

import config.ExecutionSettings;

public class Constants {
	
	
	public static String EXECUTION_ENV_PATH;
	
	static{
		
		String env = ExecutionSettings.EXECUTION_ENV;
		
		switch (env) {
		case "CurrencyConvertorProd":
			EXECUTION_ENV_PATH = "src/test/resources/environments/currencyConvertor.properties";
			break;

		default:
			break;
		}
	}
	
	public static final String EXECUTION_SETTINGS_PATH = "src/test/resources/execution.properties";

}
