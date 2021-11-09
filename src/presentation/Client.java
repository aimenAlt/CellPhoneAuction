package presentation;

import java.util.HashMap;
import java.util.Scanner;

import exceptions.ApplicationException;
import lots.LotItem;
import offers.OfferItem;
import salesOrders.OrderItem;
import user.UserItem;
import userServices.ClientServices;

public class Client {
	public static void client(UserItem user, Scanner scan) throws ApplicationException {
		ClientServices client = new ClientServices(user);
		boolean logout = false;
		int option = 0;
		while(!logout) {
			outs("Choose one of the following: (Input number)");
			outs("1 - display open lots");
			outs("2 - show my current offers");
			outs("3 - show my sales orders");
			outs("0 - logout");
			
			int input = getInt(scan);
			if(input == 1) {
				outs("");
				HashMap<Integer, LotItem> lots = client.getAvailableLots();
				outs("Lot ID \t\t | Description \t\t | Asking Price \t\t | End Date");
				for(HashMap.Entry<Integer, LotItem> entry : lots.entrySet()) {
					LotItem val = entry.getValue();
					String output = val.getLotID() + "\t\t |" + val.getDescription() 
									+ "\t |" + val.getAskingPrice() + "\t\t |" + val.getEndDate();
					outs(output);
				}
				outs("");
				option = -1;
				while(option != 0) {
					outs("What would you like to do?");
					outs("1 - Make an offer");
					outs("0 - main menu");
					option = getInt(scan);
					if(option == 1) {
						outs("input the Lot's ID: ");
						input = getInt(scan);
						LotItem lot = lots.get(input);
						if (lot != null) {
							outs("Whats your offer?");
							client.newOffer(lot.getLotID(), user.getUserID(), getDouble(scan));
							outs("offer made!");
						}
					} else if (option == 0) {
						break;
					} else {
						outs("Invalid entry, please try again");
						option = -1;
					}

				}
			} else if(input == 2) {
				HashMap<Integer, OfferItem> offers = client.getClientOffers();
				outs("");
				outs("Offer ID \t\t | Lot ID \t\t | Offer Price \t\t | Status");
				for (HashMap.Entry<Integer, OfferItem> entry : offers.entrySet()) {
					OfferItem val = entry.getValue();
					String output = val.getOfferID() + "\t\t |" + val.getLotID() 
									+ "\t |" + val.getOfferPrice() + "\t\t |" + val.offerStatus();
					outs(output);
				}
				outs("");
				option = -1;
				while(option != 0) {
					outs("What would you like to do?");
					outs("1 - Withdraw Offer");
					outs("0 - main menu");
					option = getInt(scan);
					if(option == 1) {
						outs("input the Offer's ID: ");
						input = getInt(scan);
						OfferItem offer = offers.get(input);
						if (offer != null) {
							client.withdrawOffer(input);
							outs("offer withdrawn!");
						} else {
							outs("ID doesn't exist");
						}
					} else if (option == 0) {
						break;
					} else {
						outs("Invalid entry, please try again");
						option = -1;
					}

				}
				

			} else if(input == 3) {
				HashMap<Integer, OrderItem> orders = client.getClientOrders();
				outs("");
				outs("Offer ID \t\t | Lot ID \t\t | Offer Price \t\t | Status");
				for (HashMap.Entry<Integer, OrderItem> entry : orders.entrySet()) {
					OrderItem val = entry.getValue();
					String output = val.getOrderID() + "\t\t |" + val.getStatus()
									+ "\t |" + val.getPurchasePrice() + "\t\t |" + 
									val.getBalance() + "\t\t |" + val.getSellDate();
					outs(output);
				}
				outs("");
				option = -1;
				while(option != 0) {
					outs("What would you like to do?");
					outs("1 - Make a Payment");
					outs("0 - main menu");
					option = getInt(scan);
					if(option == 1) {
						outs("input the Order's ID: ");
						input = getInt(scan);
						OrderItem order = orders.get(input);
						if (order != null) {
							option = -1;
							double weeklyAmount = order.getPurchasePrice() / 26.0;
							outs("How much would you like to pay?");
							outs("1 - Weekly payment amount (over 6 months): " + weeklyAmount);
							outs("2 - Different Ammount");
							option = getInt(scan);
							if(option == 1) {
								if (weeklyAmount > order.getBalance()) weeklyAmount = order.getBalance();
								client.pay(order.getOrderID(), weeklyAmount);
								outs("A payment with the amount of " + weeklyAmount + " has been recieved");
							} else if(option == 2) {
								double inputtedAmount = getDouble(scan);
								if (inputtedAmount > order.getBalance()) weeklyAmount = order.getBalance();
								else if (inputtedAmount < 0) {
									outs("We can't give you money! We only take it!");
									break;
								}
								client.pay(order.getOrderID(), weeklyAmount);
								outs("A payment with the amount of " + inputtedAmount + " has been recieved");
							}

							
						} else {
							outs("ID doesn't exist");
						}
					} else if (option == 0) {
						break;
					} else {
						outs("Invalid entry, please try again");
						option = -1;
					}

				}
				
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
		return Double.parseDouble(scan.nextLine());
	}
	
	public static String getString(Scanner scan) {
		return scan.nextLine();
	}

}
