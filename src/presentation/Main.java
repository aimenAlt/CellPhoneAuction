package presentation;

import java.util.Scanner;

import databaseTables.UsersTable;
import exceptions.ApplicationException;
import user.UserItem;

public class Main {
	public static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) throws ApplicationException {
		// TODO Auto-generated method stub
		
		outs("Welcome to the Phone Auction!");
		boolean exit = false;
		while(!exit) {
			int option = 0;
			String userType = "";
			while(option <= 0) {
				outs("select user type: (input number of option)");
				outs("1 - Client");
				outs("2 - Employee");
				outs("3 - Manager");
				option = getInt();
				if(option < 1|| option > 3) {
					outs("invalid entry, please try again");
					option = 0;
				} else {
					switch(option) {
					case 1:
						userType = "client";
						break;
					case 2:
						userType = "employee";
						break;
					case 3:
						userType = "manager";
						break;
					}
				}
			}
			UserItem user = null;
			while(user == null) {
				outs("input username: ");
				String tempUser = getString();
				outs("input password: ");
				String tempPassword = getString();
				user = UsersTable.login(tempUser, tempPassword, userType);
				if(user == null) outs("login failed!");
			}
			outs("login success!");
			
			if(option == 1) {
				Client.client(user, scan);
			} else if(option == 2) {
				Employee.employee(user, scan);
			} else if(option == 3) {
				Employee.employee(user, scan);
			} else outs("something wrong happend");
			outs("would you like to quit (or go back to sign in)? (enter 0 to quit)");
			if(getInt() == 0) exit = true;
		}
		scan.close();
	}
	
	public static void outs(String out) {
		System.out.println(out);
	}
	
	public static int getInt() {
		return Integer.parseInt(scan.nextLine());
	}
	
	public static String getString() {
		return scan.nextLine();
	}

}
