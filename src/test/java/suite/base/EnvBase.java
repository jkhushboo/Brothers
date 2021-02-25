package suite.base;

import suite.testdata.AppData;

/**
 * This Class contains environment variables for setting and getting environment
 * variables for automation framework
 */
public class EnvBase {

	private String env;

	/**
	 * get environment variable
	 * 
	 * @return baseurl of environment
	 */
	public String getEnv() {
		return env;
	}

	/**
	 * set environment variables
	 * 
	 * @param env
	 */
	public void setEnv(String env) {
		switch (env) {
		case "qa":
			this.env = AppData.QA;
			break;

		case "dev":
			this.env = AppData.DEV;
			break;

		case "prod":
			this.env = AppData.PROD;
			break;

		default:
			this.env = AppData.QA;
			break;
		}
	}
}
