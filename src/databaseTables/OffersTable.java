package databaseTables;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import databaseAccess.PostgreSQLAccess;
//import user.UserItem;
import exceptions.ApplicationException;
import offers.OfferItem;

public class OffersTable {

	public static HashMap<Integer, OfferItem> getAllOffers(int offerID) throws ApplicationException {
		HashMap<Integer, OfferItem> offers = null;
		Connection conn = PostgreSQLAccess.makeConnection();
		PreparedStatement stmt;
		String query = "SELECT * FROM offers";
		
		try {
			stmt = conn.prepareStatement(query);
			ResultSet results = stmt.executeQuery();
			offers = new HashMap<Integer, OfferItem>();
			while(results.next()) {
				OfferItem tempOffer = new OfferItem(results.getInt(1), results.getInt(2), 
						results.getInt(3), results.getDouble(4), results.getString(5));
				offers.put(tempOffer.getOfferID(), tempOffer); 
			}
		} catch (SQLException e) {
			throw new ApplicationException(e.getMessage());
		}

		return offers;

	}
	
	public static HashMap<Integer, OfferItem> offersOfLot(int lotID) throws ApplicationException {
		HashMap<Integer, OfferItem> offers = null;
		Connection conn = PostgreSQLAccess.makeConnection();
		PreparedStatement stmt;
		String query = "SELECT * FROM offers WHERE lot_id=?";
		
		try {
			stmt = conn.prepareStatement(query);
			stmt.setInt(1, lotID);
			ResultSet results = stmt.executeQuery();
			offers = new HashMap<Integer, OfferItem>();
			while(results.next()) {
				OfferItem tempOffer = new OfferItem(results.getInt(1), results.getInt(2), 
						results.getInt(3), results.getDouble(4), results.getString(5));
				offers.put(tempOffer.getOfferID(), tempOffer); 
			}
		} catch (SQLException e) {
			throw new ApplicationException(e.getMessage());
		}

		return offers;

	}

	public static HashMap<Integer, OfferItem> offersOfUser(int clientID) throws ApplicationException {
		HashMap<Integer, OfferItem> offers = null;
		Connection conn = PostgreSQLAccess.makeConnection();
		PreparedStatement stmt;
		String query = "SELECT * FROM offers WHERE client_id=?";
		
		try {
			stmt = conn.prepareStatement(query);
			stmt.setInt(1, clientID);
			ResultSet results = stmt.executeQuery();
			offers = new HashMap<Integer, OfferItem>();
			while(results.next()) {
				OfferItem tempOffer = new OfferItem(results.getInt(1), results.getInt(2), 
						results.getInt(3), results.getDouble(4), results.getString(5));
				offers.put(tempOffer.getOfferID(), tempOffer); 
			}
		} catch (SQLException e) {
			throw new ApplicationException(e.getMessage());
		}

		return offers;

	}

	//getLotsWithID - done
	public static OfferItem getOffer(int offerID) throws ApplicationException {
		OfferItem offer = null;
		Connection conn = PostgreSQLAccess.makeConnection();
		PreparedStatement stmt;
		String query = "SELECT * FROM offers where id=?";
		
		try {
			stmt = conn.prepareStatement(query);
			stmt.setInt(1, offerID);
			
			ResultSet results = stmt.executeQuery();
			if(results.next()) {
				offer = new OfferItem(results.getInt(1), results.getInt(2), 
						results.getInt(3), results.getDouble(4), results.getString(5));
			}
		} catch (SQLException e) {
			throw new ApplicationException(e.getMessage());
		}

		return offer;

	}

	//AddLot - done
	public static int addOffer(int lotID, int clientID, double offerPrice, String offerStatus) throws ApplicationException {
		int newID = -1;
		Connection conn = PostgreSQLAccess.makeConnection();
		PreparedStatement stmt;
		String query = "INSERT INTO offers (lot_id, client_id, offer_price, status) VALUES (?, ?, ?, ?)";
		
		try {
			stmt = conn.prepareStatement(query);
			stmt.setInt(1, lotID);
			stmt.setInt(2, clientID);
			stmt.setDouble(3, offerPrice);
			stmt.setString(4, offerStatus);
			
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
	public static void updateOffer(OfferItem offer) throws ApplicationException {
		Connection conn = PostgreSQLAccess.makeConnection();
		PreparedStatement stmt;
		String query = "UPDATE offers lot_id=?, client_id=?, offer_price=?, status=? WHERE id=?";
		
		try {
			stmt = conn.prepareStatement(query);
			stmt.setInt(1, offer.getLotID());
			stmt.setInt(2, offer.getClientID());
			stmt.setDouble(3, offer.getOfferPrice());
			stmt.setString(4, offer.offerStatus());
			stmt.setInt(5, offer.getLotID());
			
			ResultSet results = stmt.executeQuery();
			if(results.next()) {
				
			}
		} catch (SQLException e) {
			throw new ApplicationException(e.getMessage());
		}

	}
	
	public static void updateLotOffers(int lotID, String newStatus) throws ApplicationException {
		Connection conn = PostgreSQLAccess.makeConnection();
		PreparedStatement stmt;
		String query = "UPDATE offers status=? WHERE lot_id=?";
		
		try {
			stmt = conn.prepareStatement(query);
			stmt.setString(1, newStatus);
			stmt.setInt(2, lotID);
			
			ResultSet results = stmt.executeQuery();
			if(results.next()) {
				
			}
		} catch (SQLException e) {
			throw new ApplicationException(e.getMessage());
		}

	}
	
}
