package main;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class ShoppingBasket {
	/*
	 * TODO: Cannot use ItemOrder item, need to find a method to search for the item by the product name...
	 */
	
	
	private ArrayList<ItemOrder> items;
	
	public ShoppingBasket()
	{
		items = new ArrayList<ItemOrder>();
	}
	
	/**
	 * Adds a product to the array list 'items'
	 * @param name the name of the product
	 * @param productValue the product value of the product 
	 * @param quant the quantity of the product
	 */
	public void addProduct(String name, double productValue, int quant)
	{
		items.add(new ItemOrder(name,productValue,quant));
		
	}
	
	
	public ArrayList<ItemOrder> getItems() {
		return items;
	}

	/**
	 * Adds a product to the area list 'items' based on just the name and product value
	 * @param name the name of the product
	 * @param productValue the product value of the product
	 */
	public void addProduct(String name, double productValue)
	{
		
		items.add(new ItemOrder(name,productValue));
		
		
	}
	
	/**
	 * Edits an existing item, changing its latest price and quantity
	 * @param name the name of the existing product
	 * @param latestPrice the new latest price
	 * @param quantity the new quantity
	 */
	public void editItem (String name, double latestPrice, int quantity)
	{
		int i = findItemByName(name);
		
		if (i < 0)
		{
			JOptionPane.showMessageDialog(null, "Not a Item");
			
		}
		else
		
		{
			items.get(i).editItem(quantity, latestPrice);
		}
		
	}
	
	/**
	 * Removes a quantity from an existing product 
	 * @param name the name of the existing product
	 * @param quantity the quantity to remove
	 */
	public void removeProduct(String name, int quantity)
	{
		int i = findItemByName(name);
		
		if(i < 0){
			JOptionPane.showMessageDialog(null, "Item not there");
		}else
		{
		int quantOfItem = items.get(i).getQuantity();
		items.get(i).removeItems(quantity);
		
		if((quantOfItem - quantity) <= 0) items.remove(i);
		}
	}
	
	/**
	 * Remove one quantity from an existing product
	 * @param name the name of a existing product
	 */
	public void removeProduct(String name)
	{
		int i = findItemByName(name);
		
		items.remove(i);
		
	}
	
	/**
	 * Clears the array list items which clears the basket.
	 */
	public void clearBasket()
	{
		items.clear();
	}
	
	/**
	 * Displays a full list of the items within the basket that has been made easily readable
	 * @return full list of items
	 */
	public String orderItems()
	{
		String result = "";
		
		for(ItemOrder item : items)
		{
			result += item.toString();
		}
		
		return result;
	}
	
	/**
	 * 
	 * @return the number of products
	 */
	public int numberOfProducts()
	{
		return items.size();
	}
	
	/**
	 * 
	 * @return the total cost of the basket
	 */
	public double basketTotal()
	{
		double result = 0;
		
		for(ItemOrder item : items)
		{
			result += item.getTotalOrder();
		}
		
		return result;
	}
	
	/**
	 * 
	 * @return returns the total number of items (combines all the quantities)
	 */
	public int numberOfItems()
	{
		int result = 0;
		
		for(ItemOrder item: items)
		{
			result += item.getQuantity();
		}
		
		return result;
	}
	
	//TODO: Create Exception
	/**
	 * Display the current price of an existing product (throws an exception if the product is not found)
	 * @param name
	 * @return the latest Price of a product
	 */
	public double currentPrice(String name)
	{
		int index = findItemByName(name);
		
		if(index < 0)
		{
			return  0;
		}
		else
		{
			return items.get(index).getLatestPrice();
		}
		
		
	}
	
	/**
	 * Checks whether a product is within the basket
	 * @param name of existing product
	 * @return true or false based on if product exists 
	 */
	public boolean isProductInTheBasket(String name)
	{
		int index = findItemByName(name);
		
		if(index < 0) return false;
		else return true;
	}
	
	/**
	 * Saves the basket too a file
	 * @param fileName the name of the output file
	 * @return a boolean based on whether the write has succeeded
	 */
	public boolean saveBasket(String fileName)
	{
		
		try{
		
		File file = new File(fileName);
		FileWriter fw = new FileWriter(file.getAbsoluteFile());
		BufferedWriter bw = new BufferedWriter(fw);
		
		for (ItemOrder item : items)
			bw.write(item.getProductName() + "\t\t" + item.getLatestPrice() + "\t\t" + item.getQuantity() + "\n");
		
		
		return true;
		
		}
		catch(IOException e)
		{
			return false;
		}
		
	}
	
	/**
	 * Finds an item based on its name
	 * @param name the name of the existing item
	 * @return the index of the item or -1 if it cannot be found
	 */
	public int findItemByName(String name)
	{
		int index = -1;
		
		for(int i = 0; i < items.size(); i++)
		{
			if(name.equals(items.get(i).getProductName()))
			{
				index = i;
				break;
			}
		}
		
		return index;
	}
	
	
}
