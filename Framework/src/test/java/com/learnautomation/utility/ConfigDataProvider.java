package com.learnautomation.utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigDataProvider {

	Properties pro;

	public ConfigDataProvider ()

	{
		File src = new File("/Users/goutham/eclipse-workspace/Framework/Framework/Config/Config.properties");
		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		} catch (Exception e) {
			System.out.println("Unable to read config file" + e.getMessage());

		}

	}

	public String getBrowser()

	{
		return pro.getProperty("Browser");
	}

	public String getURL()

	{
		return pro.getProperty("qaURL");
	}

}
