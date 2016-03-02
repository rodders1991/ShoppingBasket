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
	
	/**
	 * Adds quantity to the item whilst updating the latest Price
	 * @param lPrice new updated price
	 * @param numItems number of items to add
	 * @return updated quantity
	 */
	public int addItems(double lPrice, int numItems)
	{
		latestPrice = lPrice;
		quantity += numItems;
		
		return quantity;
	}
	
	/**
	 * Adds an addition quantity to the item
	 * @param numItems number of items to add
	 * @return updated quantity
	 */
	public int addItems(int numItems)
	{
		quantity += numItems;
		return quantity;
	}
	
	/**
	 * Edits the item by directly changing the quantity and the latest price with new values
	 * @param quantity new quantity
	 * @param latestPrice new latest price
	 */
	public void editItem(int quantity, double latestPrice)
	{
	
		this.quantity = quantity;
		this.latestPrice = latestPrice;
		
	}
	
	/**
	 * Adds one to the quantity
	 * @return the new quantity
	 */
	public int addItem()
	{
		quantity +=1;
		return quantity;
	}

	/**
	 * Removes a number from the quantity based on a parameter
	 * @param numItems number to remove
	 * @return the new quantity
	 */
	public int removeItems(int numItems)
	{
		quantity -= numItems;
		
		if(quantity < 0) quantity = 0;
		
		return quantity;
	}
	
	/**
	 * Removes one from quantity
	 * @return the new quantity
	 */
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
