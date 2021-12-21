package Managers;

import dataProvider.ConfigFileReader;
import dataProvider.ExcelUtils;

public class FileReaderManager {

	private static FileReaderManager fileReaderManager = new FileReaderManager();
	private static ConfigFileReader configFileReader;
	private static ExcelUtils excelFileReader;

	private FileReaderManager() {
	}

	 public static FileReaderManager getInstance( ) {
	      return fileReaderManager;
	 }

	 public ConfigFileReader getConfigReader() {
		 return (configFileReader == null) ? new ConfigFileReader() : configFileReader;
	 }
	 
	 public ExcelUtils getExcelReader() {
		 return (excelFileReader == null) ? new ExcelUtils() : excelFileReader;
	 }
}
