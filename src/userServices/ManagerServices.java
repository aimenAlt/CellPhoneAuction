package userServices;

import java.util.HashMap;

import databaseTables.UsersTable;
import exceptions.ApplicationException;
import salesOrders.OrderItem;
import user.UserItem;
import user.Users;

public class ManagerServices extends EmployeeServices {
	
	private Users users = null;
	
	private void refreshUsers() throws ApplicationException {
		this.users = new Users(UsersTable.getAllUsers());
	}

	public ManagerServices(UserItem user) throws ApplicationException {
		super(user);
	}
	
	public HashMap<Integer, UserItem> getUsers() {
		return this.users.getUsers();
	}
	
	public void addUser(String username, String password, String userType) throws ApplicationException {
		UsersTable.addUser(username, password, userType);
		this.refreshUsers();
	}
	
	public void removeUser(UserItem user) throws ApplicationException {
		UsersTable.removeUser(user);
		this.refreshUsers();
	}
	
	//get all orders
	//for manager
	public HashMap<Integer, OrderItem> getAllOrders() {
		return super.orders.getAllOrders();
	}
	
	
}
