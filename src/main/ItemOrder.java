package main;

public class ItemOrder {

	private String productName;
	private double latestPrice;
	private int quantity;
	
	public ItemOrder(String productName, double latestPrice, int quantity) {
		
		this.productName = productName;
		this.latestPrice = latestPrice;
		this.quantity = quantity;
		
	}
	
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public double getLatestPrice() {
		return latestPrice;
	}
	public void setLatestPrice(double latestPrice) {
		this.latestPrice = latestPrice;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public void addItem()
	{
		quantity +=1;
	}

	public void removeItem()
	{
		quantity -= 1;
	}
	
}
