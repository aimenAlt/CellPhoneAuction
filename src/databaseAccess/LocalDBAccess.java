package databaseAccess;

import java.util.HashMap;
import java.util.Map;

import fileIOAccess.FileDatabaseMethods;


public class LocalDBAccess {

	private HashMap<String, String[]> localDB = null;
	private FileDatabaseMethods dataBase = null;
	
	public LocalDBAccess(String fileAddress) {
		this.dataBase = new FileDatabaseMethods(fileAddress);
		this.localDB = this.dataBase.getAllData();
	}
	
	public HashMap<String, String[]> getDBMap() {
		return this.localDB;
	}
	
	public String[] getEntry(String key) {
		return this.localDB.get(key);
	}
		
	public void addEntry(String[] data) {
		this.dataBase.addSingleEntry(data);
		this.updateLocalDB();
	}
	
	public void deleteEntry(String key) {
		this.localDB.remove(key);
		this.pushLocal();
	}
	
	private void deleteEntryLocally(String key) { // For 
		this.localDB.remove(key);
	}
	
	public void deleteMultiple(String keyword, int colIndex) {
		for (Map.Entry<String, String[]> entry : localDB.entrySet()) {
			String key = entry.getKey();
			String[] value = entry.getValue();
			if(value[colIndex] == keyword) this.deleteEntryLocally(key);
		}
		this.pushLocal();
	}
	
	public void updateEntry(String[] newArr) {
		this.localDB.put(newArr[0], newArr);
		this.pushLocal();
	}
	
	public void updateEntries(String[][] newEntries) {
		for(int i = 0; i < newEntries.length; i++) {
			this.localDB.put(newEntries[i][0], newEntries[i]);
		}
		this.pushLocal();
	}
	
	private void updateLocalDB() {
		this.localDB = this.dataBase.getAllData();
	}
	
	private void pushLocal() {
		this.dataBase.setData(this.localDB);
	}
	
	
	
	
}
