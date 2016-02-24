package main;

import java.util.ArrayList;

public class ShoppingBasket {

	private ArrayList<ItemOrder> orderItems = new ArrayList<ItemOrder>();
	private int numberOfProducts, numberOfItems;
	private double basketTotal;
	
	public ArrayList<ItemOrder> getOrderItems() {
		return orderItems;
	}
	public void setOrderItems(ArrayList<ItemOrder> orderItems) {
		this.orderItems = orderItems;
	}
	public int getNumberOfProducts() {
		return numberOfProducts;
	}
	public int getNumberOfItems() {
		return numberOfItems;
	}
	public double getBasketTotal() {
		return basketTotal;
	}
	
	public ShoppingBasket() {
		
	}
	
	public void addItem(ItemOrder item) {
		
		
		if(orderItems.indexOf(item) > -1)
		{
		orderItems.add(item);
		numberOfProducts++;
		}
		
		
	}
	

	
}
