package tester;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import databaseAccess.DatabaseAccess;

class JUnitTester {
	
	public static DatabaseAccess DBjUnit = new DatabaseAccess("./src/tester/jDB_file.txt");

	@Test
	void addData() {
		String[] testArr = new String[] {"5", "i", "0.0"};
		DBjUnit.addEntry(testArr);
		assertArrayEquals(testArr, DBjUnit.getEntry("5"));
	}

}
