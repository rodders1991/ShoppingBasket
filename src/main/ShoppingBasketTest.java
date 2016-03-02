package main;

import static org.junit.Assert.*;

import org.junit.Test;

public class ShoppingBasketTest {

	@Test
	public void testConstructor() {
		
		ShoppingBasket sb = new ShoppingBasket();
		
		int i = sb.getItems().size();
		
		assertEquals("getItems().size() should equal to 0", i, 0);
		
		
	}
	
	@Test
	public void testAddProduct()
	{
		ShoppingBasket sb = new ShoppingBasket();
		
		sb.addProduct("Apple", 7.50);
		
		int i = sb.getItems().size();
		
		assertEquals("getItems().size() should equal to 1", i, 1);
		
	}
	
	@Test
	public void testAddProductWithQuantity()
	{
		ShoppingBasket sb = new ShoppingBasket();
		sb.addProduct("Apple", 7.50,5);

		int i = sb.getItems().get(0).getQuantity();
		
		assertEquals("The first record of Items quantity should be 5",i,5);
		
	}
	
	//TODO: Add to test plan
	@Test
	public void testRemoveProduct()
	{
		ShoppingBasket sb =  new ShoppingBasket();
		
		sb.addProduct("Apple", 7.50);
		sb.addProduct("Orange", 8);
		
		sb.removeProduct("Apple");
		
		int i = sb.getItems().size();
		
		assertEquals("The size of items should equal too 1",i,1);
		
	}
	
	//TODO:Add to test plan
	@Test
	public void testRemoveProductQuantity()
	{
		ShoppingBasket sb =  new ShoppingBasket();
		
		sb.addProduct("Apple", 7.50,5);
		
		sb.removeProduct("Apple", 3);
		
		int i = sb.getItems().get(0).getQuantity();
		
		assertEquals("The size of the quantity should equal too 3",i,3);
		
	}
	
	

}
