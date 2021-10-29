package databaseAccess;

import java.util.HashMap;

import fileIOAccess.FileDatabaseMethods;


public class DatabaseAccess {

	private HashMap<String, String[]> localDataBase = null;
	private FileDatabaseMethods dataBase = null;
	
	public DatabaseAccess(String fileAddress) {
		this.dataBase = new FileDatabaseMethods(fileAddress);
		this.localDataBase = this.dataBase.getAllData();
	}
	
	
	
	
}
