package salesOrders;

import java.util.HashMap;

public class SalesOrders {
	private HashMap <Integer, OrderItem> salesOrders = null;
	
	public SalesOrders() {
		this.salesOrders = new HashMap<Integer, OrderItem>();
	}
	
	public void addOrder(OrderItem newOrder) {
		this.salesOrders.put(newOrder.getOrderID(), newOrder);
	}
	
	public void deleteOrder(int orderID) {
		this.salesOrders.remove(orderID);
	}
	
	public void updateOrder(int orderID, OrderItem order) {
		this.salesOrders.put(orderID, order);
	}
	
	public OrderItem getOrder(int orderID) {
		return this.salesOrders.get(orderID);
	}
	
	public HashMap<Integer, OrderItem> getAllOrders(){
		return this.salesOrders;
	}
	
}
