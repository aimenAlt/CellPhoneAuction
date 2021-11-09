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
import offers.OfferItem;
import salesOrders.OrderItem;

public class SalesOrdersTable {

	public static HashMap<Integer, OrderItem> getAllOrders() throws ApplicationException {
		HashMap<Integer, OrderItem> offers = null;
		Connection conn = PostgreSQLAccess.makeConnection();
		PreparedStatement stmt;
		String query = "SELECT * FROM sales_orders";
		
		try {
			stmt = conn.prepareStatement(query);
			ResultSet results = stmt.executeQuery();
			offers = new HashMap<Integer, OrderItem>();
			while(results.next()) {
				OrderItem tempOrder = new OrderItem(results.getInt(1), results.getInt(2), 
						results.getInt(3), results.getInt(4), results.getString(5), 
						results.getDouble(6), results.getDouble(7), new Date(results.getString(8)));
				offers.put(tempOrder.getOrderID(), tempOrder); 
			}
		} catch (SQLException e) {
			throw new ApplicationException(e.getMessage());
		}

		return offers;

	}
	
	public static HashMap<Integer, OrderItem> ordersOfUser(int userID) throws ApplicationException {
		HashMap<Integer, OrderItem> offers = null;
		Connection conn = PostgreSQLAccess.makeConnection();
		PreparedStatement stmt;
		String query = "SELECT * FROM sales_orders WHERE client_id=?";
		
		try {
			stmt = conn.prepareStatement(query);
			stmt.setInt(1, userID);
			ResultSet results = stmt.executeQuery();
			offers = new HashMap<Integer, OrderItem>();
			while(results.next()) {
				OrderItem tempOrder = new OrderItem(results.getInt(1), results.getInt(2), 
						results.getInt(3), results.getInt(4), results.getString(5), 
						results.getDouble(6), results.getDouble(7), new Date(results.getString(8)));
				offers.put(tempOrder.getOrderID(), tempOrder); 
			}
		} catch (SQLException e) {
			throw new ApplicationException(e.getMessage());
		}

		return offers;

	}

	//getLotsWithID - done
	public static OrderItem getOrder(int orderID) throws ApplicationException {
		OrderItem order = null;
		Connection conn = PostgreSQLAccess.makeConnection();
		PreparedStatement stmt;
		String query = "SELECT * FROM sales_orders where id=?";
		
		try {
			stmt = conn.prepareStatement(query);
			stmt.setInt(1, orderID);
			
			ResultSet results = stmt.executeQuery();
			if(results.next()) {
				order = new OrderItem(results.getInt(1), results.getInt(2), 
						results.getInt(3), results.getInt(4), results.getString(5), 
						results.getDouble(6), results.getDouble(7), new Date(results.getString(8)));			}
		} catch (SQLException e) {
			throw new ApplicationException(e.getMessage());
		}

		return order;

	}

	//AddLot - done
	public static int addOrder(OfferItem offer, String status, Date sellDate) throws ApplicationException {
		int newID = -1;
		Connection conn = PostgreSQLAccess.makeConnection();
		PreparedStatement stmt;
		String query = 	"INSERT INTO sales_orders (client_id, lot_id, offer_id, status, "+
						"purchase_price, balance, sell_date) VALUES (?, ?, ?, ?, ?, ?, ?)";
		
		try {
			stmt = conn.prepareStatement(query);
			stmt.setInt(1, offer.getClientID());
			stmt.setInt(2, offer.getLotID());
			stmt.setInt(3, offer.getOfferID());
			stmt.setString(4, status);
			stmt.setDouble(5, offer.getOfferPrice());
			stmt.setDouble(6, offer.getOfferPrice());
			stmt.setString(7, sellDate.toString());
			
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
	public static void updateOrder(OrderItem order) throws ApplicationException {
		Connection conn = PostgreSQLAccess.makeConnection();
		PreparedStatement stmt;
		String query = 	"UPDATE sales_orders client_id=?, lot_id=?, offer_id=?, " +
						"status=?, purchase_price=?, balance=?, sell_date=? WHERE id=?";
		
		try {
			stmt = conn.prepareStatement(query);
			stmt.setInt(1, order.getClientID());
			stmt.setInt(2, order.getlotID());
			stmt.setInt(3, order.getOfferID());
			stmt.setString(4, order.getStatus());
			stmt.setDouble(5, order.getPurchasePrice());
			stmt.setDouble(6, order.getBalance());
			stmt.setString(7, order.getSellDate().toString());

			
			ResultSet results = stmt.executeQuery();
			if(results.next()) {
				
			}
		} catch (SQLException e) {
			throw new ApplicationException(e.getMessage());
		}

	}	
}
