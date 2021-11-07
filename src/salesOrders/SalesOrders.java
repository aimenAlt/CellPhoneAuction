package salesOrders;

import java.util.HashMap;

public class SalesOrders {
	private HashMap <String, OrderItem> salesOrders = null;
	
	public SalesOrders() {
		this.salesOrders = new HashMap<String, OrderItem>();
	}
	
	public void addOrder(OrderItem newOrder) {
		this.salesOrders.put(newOrder.getOrderID(), newOrder);
	}
	
	public void deleteOrder(String orderID) {
		this.salesOrders.remove(orderID);
	}
	
	public void updateOrder(String orderID, OrderItem order) {
		this.salesOrders.put(orderID, order);
	}
	
	public OrderItem getOrder(String orderID) {
		return this.salesOrders.get(orderID);
	}
	
	public HashMap<String, OrderItem> getAllOrders(){
		return this.salesOrders;
	}
	
}
