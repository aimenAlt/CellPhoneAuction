package databaseTables;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import databaseAccess.PostgreSQLAccess;
import date.Date;
//import user.UserItem;
import exceptions.ApplicationException;
import lots.LotItem;

public class LotsTable {
	
	//getAllLots - done
	public static HashMap<Integer, LotItem> getAllLots() throws ApplicationException {
		HashMap<Integer, LotItem> lots = null;
		Connection conn = PostgreSQLAccess.makeConnection();
		PreparedStatement stmt;
		String query = "SELECT * FROM lots";
		
		try {
			stmt = conn.prepareStatement(query);
			ResultSet results = stmt.executeQuery();
			lots = new HashMap<Integer, LotItem>();
			while(results.next()) {
				LotItem tempLot = new LotItem(results.getInt(1), 
						results.getString(2), results.getDouble(3), 
						new Date(results.getString(4)), results.getString(5));;
				lots.put(tempLot.getLotID(), tempLot); 
			}
		} catch (SQLException e) {
			throw new ApplicationException(e.getMessage());
		}

		return lots;

	}

	public static HashMap<Integer, LotItem> openLots() throws ApplicationException {
		HashMap<Integer, LotItem> lots = null;
		Connection conn = PostgreSQLAccess.makeConnection();
		PreparedStatement stmt;
		String query = "SELECT * FROM lots WHERE status=?";
		
		try {
			stmt = conn.prepareStatement(query);
			stmt.setString(1, "open");
			ResultSet results = stmt.executeQuery();
			lots = new HashMap<Integer, LotItem>();
			while(results.next()) {
				LotItem tempLot = new LotItem(results.getInt(1), 
						results.getString(2), results.getDouble(3), 
						new Date(results.getString(4)), results.getString(5));;
				lots.put(tempLot.getLotID(), tempLot); 
			}
		} catch (SQLException e) {
			throw new ApplicationException(e.getMessage());
		}

		return lots;

	}

	//getLotsWithID - done
	public static LotItem getLot(int lotID) throws ApplicationException {
		LotItem lot = null;
		Connection conn = PostgreSQLAccess.makeConnection();
		PreparedStatement stmt;
		String query = "SELECT * FROM lots where id=?";
		
		try {
			stmt = conn.prepareStatement(query);
			stmt.setInt(1, lotID);
			
			ResultSet results = stmt.executeQuery();
			if(results.next()) {
				lot = new LotItem(results.getInt(1), results.getString(2), results.getDouble(3), new Date(results.getString(4)), results.getString(5));
			}
		} catch (SQLException e) {
			throw new ApplicationException(e.getMessage());
		}

		return lot;

	}

	//AddLot - done
	public static int addLot(String description, double askingPrice,
			   				Date endDate, String lotStatus) throws ApplicationException {
		int newID = -1;
		Connection conn = PostgreSQLAccess.makeConnection();
		PreparedStatement stmt;
		String query = "INSERT INTO lots (description, asking_price, end_date, status) VALUES (?, ?, ?, ?)";
		
		try {
			stmt = conn.prepareStatement(query);
			stmt.setString(1, description);
			stmt.setDouble(2, askingPrice);
			stmt.setString(3, endDate.toString());
			stmt.setString(4, lotStatus);
			
			ResultSet results = stmt.executeQuery();
			if(results.next()) {
				newID = results.getInt(1);
			}
		} catch (SQLException e) {
			throw new ApplicationException(e.getMessage());
		}

		return newID;

	}

	//updateLot - done
	public static void updateLot(LotItem lot) throws ApplicationException {
		Connection conn = PostgreSQLAccess.makeConnection();
		PreparedStatement stmt;
		String query = "UPDATE lots description=?, asking_price=?, end_date=?, status=? WHERE id=?";
		
		try {
			stmt = conn.prepareStatement(query);
			stmt.setString(1, lot.getDescription());
			stmt.setDouble(2, lot.getAskingPrice());
			stmt.setString(3, lot.getEndDate());
			stmt.setString(4, lot.getStatus());
			stmt.setInt(5, lot.getLotID());
			
			ResultSet results = stmt.executeQuery();
			if(results.next()) {
				
			}
		} catch (SQLException e) {
			throw new ApplicationException(e.getMessage());
		}

	}

	//deleteLot - undone
	public static void deleteLot() throws ApplicationException {
////		int newID = -1;
//		Connection conn = PostgreSQLAccess.makeConnection();
//		PreparedStatement stmt;
//		String query = "";
//		
//		try {
//			stmt = conn.prepareStatement(query);
//			
//			ResultSet results = stmt.executeQuery();
//			if(results.next()) {
//				
//			}
//		} catch (SQLException e) {
//			throw new ApplicationException(e.getMessage());
//		}
//
////		return newID;

	}

	
}
