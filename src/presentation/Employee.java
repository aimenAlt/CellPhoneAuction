package presentation;

import java.util.HashMap;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;


import date.Date;
import exceptions.ApplicationException;
import lots.LotItem;
import offers.OfferItem;
import salesOrders.OrderItem;
import user.UserItem;
import userServices.ClientServices;
import userServices.EmployeeServices;
import userServices.ManagerServices;

public class Employee {
	public static void employee(UserItem user, Scanner scan) throws ApplicationException {
		EmployeeServices employee = new EmployeeServices(user);;
//		if (user.getUserType() == "employee") employee = new EmployeeServices(user);
//		else if (user.getUserType() == "manager") employee = new ManagerServices(user);
	    LocalDate currentDate = LocalDate.now();

		boolean logout = false;
		int option = 0;
		while(!logout) {
			outs("Choose one of the following: (Input number)");
			outs("1 - Show lots");
			outs("2 - Add new Lot");
			if(user.getUserType().equals("manager")) {
				outs("3 - show users");
				outs("4 - show sales orders");
			}
			outs("0 - logout");
			
			int input = getInt(scan);
			if(input == 1) {
				HashMap<Integer, LotItem> lots = employee.getLots();
				outs("____________________________________");
				outs("Lot ID \t\t | Description \t\t | Asking Price \t\t | End Date");
				for(HashMap.Entry<Integer, LotItem> entry : lots.entrySet()) {
					LotItem val = entry.getValue();
					String output = val.getLotID() + "\t\t |" + val.getDescription() 
									+ "\t |" + val.getAskingPrice() + "\t\t |" + val.getEndDate();
					outs(output);
				}
				outs("____________________________________");
				option = -1;
				while(option != 0) {
					outs("What would you like to do?");
					outs("1 - Shows offers of Lot");
					outs("2 - Cancel Lot");
					outs("3 - Change Asking Price of Lot");
					outs("4 - Change Description of Lot");
					outs("0 - main menu");
					option = getInt(scan);
					// OPTION 1 ___________________________________________________________
					if(option == 1) {
						outs("input the Lot's ID: ");
						input = getInt(scan);
						LotItem lot = lots.get(input);
						if (lot != null) {
							outs("____________________________________");
							HashMap<Integer, OfferItem> offers = employee.offersOfLot(input);
							outs("Offer ID \t\t | Lot ID \t\t | Offer Price \t\t | Status");
							for (HashMap.Entry<Integer, OfferItem> entry : offers.entrySet()) {
								OfferItem val = entry.getValue();
								String output = val.getOfferID() + "\t\t |" + val.getLotID() 
												+ "\t |" + val.getOfferPrice() + "\t\t |" + val.offerStatus();
								outs(output);
							}
							outs("____________________________________");
							while(option != 0) {
								outs("What would you like to do?");
								outs("1 - Accept Offer");
								outs("2 - Reject Offer");
								outs("0 - main menu");
								option = getInt(scan);
								if(option == 1) {
									outs("input the Offer's ID: ");
									input = getInt(scan);
									OfferItem offer = offers.get(input);
									if (offer != null) {
										employee.acceptOffer(offer, lot, convertDate(currentDate));
										outs("Offer Accepted!!");
									} else {
										outs("ID doesn't exist");
									}
								} else if(option == 2) {
									outs("input the Offer's ID: ");
									input = getInt(scan);
									OfferItem offer = offers.get(input);
									if (offer != null) {
										employee.rejectOffer(offer);
										outs("offer rejected!");
									} else {
										outs("ID doesn't exist");
									}
								} else if (option == 0) {
									outs("going back to main menu");
									break;
								} else {
									outs("Invalid entry, please try again");
									option = -1;
								}

							}
							
						} else {
							outs("Invalid Entry");
						}
					// OPTION 2 ___________________________________________________________
					} else if (option == 2) {
						outs("input the Lot's ID: ");
						input = getInt(scan);
						LotItem lot = lots.get(input);
						if (lot != null) {
							employee.cancelLot(lot);
							outs("Lot Cancelled");
						}
					} else if (option == 3) {
						outs("input the Lot's ID: ");
						input = getInt(scan);
						LotItem lot = lots.get(input);
						if (lot != null) {
							employee.changeAskingPrice(lot, getDouble(scan));
							outs("Lot Asking Price Changed!");
						}

					} else if (option == 4) {
						outs("input the Lot's ID: ");
						input = getInt(scan);
						LotItem lot = lots.get(input);
						if (lot != null) {
							employee.changeDescription(lot, getString(scan));
							outs("Description changed");
						}

					} else if (option == 0) {
						continue;
					} else {
						outs("Invalid entry, please try again");
						option = -1;
					}

				}
				// OPTION 2 ___________________________________________________________
			} else if(input == 2) { // Add New Lot
				outs("Describe the Lot:");
				String desc = getString(scan);
				outs("Whats the asking price? (input price including cents)");
				Double askingPrice = getDouble(scan);
				outs("After how many days do you want the auction on this Lot to end?");
				int days = getInt(scan);
				employee.addLot(desc, input, addDaysToDate(currentDate, days));
				outs("Lot Added");

			} else if(input == 3 && user.getUserType().equals("manager")) { // manager only - show users
				ManagerServices manager = new ManagerServices(user);
				HashMap<Integer, UserItem> users = manager.getUsers();
				outs("____________________________________");
				outs("User ID \t | Username \t | User Type");
				for (HashMap.Entry<Integer, UserItem> entry : users.entrySet()) {
					UserItem val = entry.getValue();
					String output = val.getUserID() + "\t\t |" + val.getUsername()
									+ "\t |" + val.getUserType();
					outs(output);
				}
				outs("____________________________________");
				option = -1;
				while(option != 0) {
					outs("What would you like to do?");
					outs("1 - Add User");
					outs("2 - Delete User/ Fire Employee");
					outs("0 - main menu");
					option = getInt(scan);
					if(option == 1) {	//Add User
						outs("Enter username");
						String username = getString(scan);
						outs("Enter Password");
						String tempPassword = getString(scan);
						outs("select user type: ");
						outs("1 - client");
						outs("2 - employee");
						outs("3 - manager");
						String userType = null;
						option = -1;
						while(option < 1 || option > 3) {
							option = getInt(scan);
							if (option == 1) userType = "client";
							else if (option == 2) userType = "employee";
							else if (option == 3) userType = "manager";
							else outs("invalid input, please try again...");
						}
						manager.addUser(username, tempPassword, userType);
						outs("user added!");
					} else if(option == 2) {	//Remove User
						outs("Enter user ID: ");
						input = getInt(scan);
						UserItem tempUser = users.get(input);
						if (tempUser != null) {
							manager.removeUser(tempUser);
							outs(" User Removed");
						} else {
							outs("User doesn't exist");
						}

					} else if (option == 0) {
						break;
					} else {
						outs("Invalid entry, please try again");
						option = -1;
					}

				}
			} else if(input == 4 && user.getUserType().equals("manager")) { // Show Sales Orders
				ManagerServices manager = new ManagerServices(user);
				HashMap<Integer, OrderItem> orders = manager.getAllOrders();
				outs("____________________________________");
				outs("Order ID \t\t | Status \t\t | Balance \t\t |Purchase Price \t\t | Purchase Date");
				for (HashMap.Entry<Integer, OrderItem> entry : orders.entrySet()) {
					OrderItem val = entry.getValue();
					String output = val.getOrderID() + "\t\t |" + val.getStatus()
									+ "\t\t |" + val.getBalance()+ "\t\t |" + val.getPurchasePrice()
									+ "\t\t |" + val.getSellDate().toString();
					outs(output);
				}
				outs("____________________________________");

			} else if(input == 0) {
				logout = true;
			} else {
				outs("Invalid entry, please try again");
			}			
		}
	}
	public static void outs(String out) {
		System.out.println(out);
	}
	
	public static int getInt(Scanner scan) {
		return Integer.parseInt(scan.nextLine());
	}
	
	public static double getDouble(Scanner scan) {
		double number = Double.parseDouble(scan.nextLine());
		System.out.println("Double is: " + number);
		return number;
	}
	
	public static String getString(Scanner scan) {
		return scan.nextLine();
	}
	
	public static Date convertDate(LocalDate currentDate) {
		return new Date(currentDate.getMonthValue(), currentDate.getDayOfMonth(), currentDate.getYear());
	}
	
	public static Date addDaysToDate(LocalDate currentDate, int days) {
	    LocalDate result = currentDate.plus(days, ChronoUnit.DAYS);
		return new Date(result.getMonthValue(), result.getDayOfMonth(), result.getYear());
	}
	
	
	 

}
