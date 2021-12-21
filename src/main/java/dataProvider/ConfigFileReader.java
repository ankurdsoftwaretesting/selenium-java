package dataProvider;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {
	
	private Properties properties;
	private final String propertyFilePath= "configs//Configuration.properties";

	
	public ConfigFileReader(){
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
		}		
	}
	
	public String getDriverPath(){
		String driverPath = properties.getProperty("driverPath");
		if(driverPath!= null) return driverPath;
		else throw new RuntimeException("driverPath not specified in the Configuration.properties file.");		
	}
	
	public long getImplicitlyWait() {		
		String implicitlyWait = properties.getProperty("implicitlyWait");
		if(implicitlyWait != null) return Long.parseLong(implicitlyWait);
		else throw new RuntimeException("implicitlyWait not specified in the Configuration.properties file.");		
	}
	
	public String getApplicationUrl() {
		String url = properties.getProperty("url");
		if(url != null) return url;
		else throw new RuntimeException("url not specified in the Configuration.properties file.");
	}
	
	public String getApplicationPath() {
		String path = properties.getProperty("path");
		if(path != null) return path;
		else throw new RuntimeException("url not specified in the Configuration.properties file.");
	}
	
	public String getDriver() {
		String driver = properties.getProperty("driver");
		if(driver != null) return driver;
		else throw new RuntimeException("url not specified in the Configuration.properties file.");
	}
	
	public String getExcelFilePath() {
		String file = properties.getProperty("excelDataFilePath");
		if(file != null) return file;
		else throw new RuntimeException("url not specified in the Configuration.properties file.");
	}
	
	public String getExcelFileName() {
		String name = properties.getProperty("excelDataFileName");
		if(name != null) return name;
		else throw new RuntimeException("url not specified in the Configuration.properties file.");
	}
	
	public String getExcelSheetName() {
		String sName = properties.getProperty("excelDataFileSheetName");
		if(sName != null) return sName;
		else throw new RuntimeException("url not specified in the Configuration.properties file.");
	}


}