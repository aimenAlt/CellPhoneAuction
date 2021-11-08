package user;

public class UserItem {
	
	private int userID = -1; //Default -1 to ensure that anything below 0 as an ID is invalid;
	private String username = null;
	private String password = null;
	private String userType = null;
	
	public UserItem(int userID, String username, String password, String userType) {
		this.userID = userID;
		this.username = username;
		this.password = password;
		this.userType = userType;
	}
	
//	//Constructor for creating a new user before getting an ID from the database
//	public UserItem(String username, String password, String userType) {
//		//Add methods for adding new user to database
////		this.userID = userID;
//		this.username = username;
//		this.password = password;
//		this.userType = userType;
//	}
	
	public int getUserID() {
		return this.userID;
	}
	public String getUsername() {
		return this.username;
	}
	public String getPassword() {
		return this.password;
	}
	public String getUserType() {
		return this.userType;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = username;
	}
	public void setUserType(String password) {
		this.userType = username;
	}
	
}
