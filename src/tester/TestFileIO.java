package tester;

import java.util.Scanner;

import databaseAccess.LocalDBAccess;
import databaseTables.UsersTable;
import exceptions.ApplicationException;
import user.UserItem;

public class TestFileIO {

	public static void main(String[] args) throws ApplicationException { // USE JUnit testing to test the filIO 
		// TODO Auto-generated method stub
		UserItem user = UsersTable.login("admin", "password", "client");
		if(user != null) {			
			System.out.println(user.getUserID());
			System.out.println(user.getUserType());
		} else {
		}
		System.out.println(UsersTable.addUser("adminSard", "password", "client"));
		
		
		
		
//		LocalDBAccess DBTest = new LocalDBAccess("./src/tester/test_file.txt");
//		Scanner scan = new Scanner(System.in);
//		int ox = 1;
//		while(ox > 0) {
//			String[] addToDb = new String[3];
//			System.out.println("Enter ID");
//			addToDb[0] = scan.nextLine();
//			System.out.println("Enter Name");
//			addToDb[1] = scan.nextLine();
//			System.out.println("Enter Price");
//			addToDb[2] = scan.nextLine();
//			System.out.println("Continue Adding (enter 0 for NO)");
//			ox = scan.nextInt();
//			scan.nextLine();
//			DBTest.addEntry(addToDb);
//			
//		}
////		System.out.println(DBTest.getDBMap());
//		scan.close();
//		printDBContents(DBTest);
//		DBTest.deleteEntry("Samsung");
//		printDBContents(DBTest);
//

		
	}
	
	public static void printDBContents(LocalDBAccess out) {
		System.out.println("___________________");
		out.getDBMap().forEach((key, val) -> System.out.println(val[0] + " | " + val[1] + " | " + val[2]));
		System.out.println("___________________");
	}

}
