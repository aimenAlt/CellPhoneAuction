package databaseTables;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import databaseAccess.PostgreSQLAccess;
import user.UserItem;
import exceptions.ApplicationException;

public class UsersTable {
	
	public static UserItem getUserInfo(int userID) throws ApplicationException {
		UserItem user = null;
		Connection conn = PostgreSQLAccess.makeConnection();
		PreparedStatement stmt;
		String query = "SELECT * FROM users WHERE id=?";

		try {
			stmt = conn.prepareStatement(query);
			stmt.setInt(1, userID);
			ResultSet results = stmt.executeQuery();
			if (results.next()) {
				user = new UserItem(results.getInt(1), results.getString(2), results.getString(3), results.getString(4));
			}			
		} catch(SQLException e) {
			throw new ApplicationException(e.getMessage());
		}
		return user;
	}
	
	public static UserItem login(String username, String password, String userType) throws ApplicationException {
		UserItem user = null;
		Connection conn = PostgreSQLAccess.makeConnection();
		PreparedStatement stmt;
		String query = "SELECT * FROM users WHERE username=? AND password=? AND user_type=?";
		
		try {
			stmt = conn.prepareStatement(query);
			stmt.setString(1, username);
			stmt.setString(2, password);
			stmt.setString(3, userType);
			ResultSet results = stmt.executeQuery();
			if(results.next()) {
				user = new UserItem(results.getInt(1), results.getString(2), results.getString(3), results.getString(4));
			}
		} catch (SQLException e) {
			throw new ApplicationException(e.getMessage());
		}

		return user;
	}
	
	public static int addUser(String username, String password, String userType) throws ApplicationException {
		int newUserID = -1;
		Connection conn = PostgreSQLAccess.makeConnection();
		PreparedStatement stmt;
		String query = "INSERT INTO users (username, password, user_type) VALUES (?,?,?) RETURNING id";
		
		try {
			stmt = conn.prepareStatement(query);
			stmt.setString(1, username);
			stmt.setString(2, password);
			stmt.setString(3, userType);
			
			ResultSet results = stmt.executeQuery();
			if(results.next()) {
//				System.out.println(results.getInt(1));
				newUserID = results.getInt(1);
				
			}
		} catch (SQLException e) {
			throw new ApplicationException(e.getMessage());
		}

		return newUserID;

	}
	
	public static void removeUser() {
		
	}
	
}
