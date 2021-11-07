package tester;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import databaseAccess.LocalDBAccess;

class JUnitTester {
	
	public static LocalDBAccess DBjUnit = new LocalDBAccess("./src/tester/jDB_file.txt");

	@Test
	void addData() {
		String[] testArr = new String[] {"5", "i", "0.0"};
		DBjUnit.addEntry(testArr);
		assertArrayEquals(testArr, DBjUnit.getEntry("5"));
	}

}
