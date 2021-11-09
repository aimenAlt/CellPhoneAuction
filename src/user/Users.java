package user;

import java.util.HashMap;

public  class Users {
	
	private HashMap<Integer, UserItem> users = null;
	
	public Users() {
		this.users = new HashMap<Integer,UserItem>();
	}

	public Users(HashMap<Integer, UserItem> users) {
		this.users = users;
	}
	
	public HashMap<Integer, UserItem> getUsers() {
		return this.users;
	}
	
}
