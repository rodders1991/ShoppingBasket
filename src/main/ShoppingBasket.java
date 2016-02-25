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
	
	public void addProduct(String name, double productValue, int quant)
	{
		items.add(new ItemOrder(name,productValue,quant));
		
	}
	
	
	
	
	public ArrayList<ItemOrder> getItems() {
		return items;
	}

	public void addProduct(String name, double productValue)
	{
		int i = findItemByName(name);
		items.get(i).addItems(productValue, 1);
		
		
	}
	
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
	
	public void removeProduct(String name)
	{
		int i = findItemByName(name);
		
		items.remove(i);
		
	}
	
	public void clearBasket()
	{
		items.clear();
	}
	
	//TODO:
	public String orderItems()
	{
		String result = "";
		
		for(ItemOrder item : items)
		{
			result += item.toString();
		}
		
		return result;
	}
	
	public int numberOfProducts()
	{
		return items.size();
	}
	
	public double basketTotal()
	{
		double result = 0;
		
		for(ItemOrder item : items)
		{
			result += item.getTotalOrder();
		}
		
		return result;
	}
	
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
	
	public boolean isProductInTheBasket(String name)
	{
		int index = findItemByName(name);
		
		if(index < 0) return false;
		else return true;
	}
	
	public boolean saveBasket(String fileName) throws IOException
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
