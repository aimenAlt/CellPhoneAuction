package fileIOAccess;

import java.io.*;
import java.util.HashMap;


public class FileDatabaseMethods {
	
	private String fileAddress;
	
	public FileDatabaseMethods(String fileAddress) {
		this.fileAddress = fileAddress;
	}
	
	
	public HashMap<String, String[]> getAllData() {
		HashMap<String, String[]> allData = new HashMap<String, String[]>();
		BufferedReader lineReader = null;
		try {
			lineReader = new BufferedReader(new FileReader(this.fileAddress));
			String newLine = "";
			while((newLine = lineReader.readLine()) != null) {
				String[] temp = newLine.split("\\|"); //We use // to escape | as a special charecter
				allData.put(temp[0], temp);
			}
			
		} catch(IOException e) {
	        e.printStackTrace();
		} finally {
			try {
				lineReader.close();
			} catch(IOException e) {
		        e.printStackTrace();
			} 	
		}
		return allData;
	}
	
	public void setData(HashMap<String, String[]> allData) {
		BufferedWriter lineWriter = null;
		boolean writeInNewFile = true;
		try {
			lineWriter = new BufferedWriter(new FileWriter(this.fileAddress, writeInNewFile));//WriteInNewFile boolean is an optional bool parameter whether I want to append or write in new file
			for (String[] arr : allData.values()) {
				lineWriter.write(arrayToString(arr));
				lineWriter.newLine();
			}
		} catch(IOException e) {
	        e.printStackTrace();
		} finally {
			try {
				lineWriter.close();
			} catch(IOException e) {
		        e.printStackTrace();
			}
		}
	}
	
	private String arrayToString(String[] arr) {
		String finalString = "";
		int i = 0;
		for (String element : arr) {
			if (i < arr.length - 1) finalString = finalString + element + "|";
			else finalString = finalString + element;
			i++;
		};
		
		return finalString;
	}
	
	
		
}
	

