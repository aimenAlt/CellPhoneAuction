package databaseTables;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import databaseAccess.PostgreSQLAccess;
//import user.UserItem;
import exceptions.ApplicationException;

public class SalesOrdersTable {

	public static int add() throws ApplicationException {
		int newID = -1;
		Connection conn = PostgreSQLAccess.makeConnection();
		PreparedStatement stmt;
		String query = "";
		
		try {
			stmt = conn.prepareStatement(query);
			
			ResultSet results = stmt.executeQuery();
			if(results.next()) {
				
			}
		} catch (SQLException e) {
			throw new ApplicationException(e.getMessage());
		}

		return newID;

	}
	
}
