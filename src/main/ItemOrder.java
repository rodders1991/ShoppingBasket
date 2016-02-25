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
	
	public ItemOrder(String productName, double latestPrice) {
		
		this.productName = productName;
		this.latestPrice = latestPrice;
		quantity = 1;
		
	}
	
	public String getProductName() {
		return productName;
	}
	
	public double getLatestPrice() {
		return latestPrice;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public double getTotalOrder() {
		return latestPrice * quantity;
	}
	
	public int addItems(double lPrice, int numItems)
	{
		latestPrice = lPrice;
		quantity += numItems;
		
		return quantity;
	}
	
	public int addItems(int numItems)
	{
		quantity += numItems;
		return quantity;
	}
	
	public void editItem(int quantity, double latestPrice)
	{
	
		this.quantity = quantity;
		this.latestPrice = latestPrice;
		
	}
	
	public int addItem()
	{
		quantity +=1;
		return quantity;
	}

	public int removeItems(int numItems)
	{
		quantity -= numItems;
		
		if(quantity < 0) quantity = 0;
		
		return quantity;
	}
	
	public int removeItem()
	{
		quantity -= 1;
		
		if(quantity < 0) quantity = 0;
		
		return quantity;
	}
	
	@Override
	public String toString()
	{
		return productName + "\t\t" + latestPrice + "\t\t" + quantity + "\n";
	}
	
}
