package user;

public  class User {
	
	private UserItem user = null;
	
	public User(int userID, String username, String password, String userType) {
		this.user = new UserItem(userID,  username,  password, userType);
	}
	
	public int getuserID() {
		return this.user.getUserID();
	}
	
	public String getUsername() {
		return this.user.getUsername();
	}
	
	public String getpassword() {
		return this.user.getPassword();
	}
	
	public String getuserType() {
		return this.user.getUserType();
	}

	public void updateUsername(String username) {
		this.user.setUsername(username);
	}
	
	public void updatePassword(String password) {
		this.user.setPassword(password);
	}
	
	public void updateUserType(String userType) {
		this.user.setUserType(userType);
	}
	
}
