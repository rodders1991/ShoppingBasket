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
	
	

}
