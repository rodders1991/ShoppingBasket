package main;

import static org.junit.Assert.*;

import org.junit.Test;

public class ItemOrderTest {

	@Test
	public void testConstructor() {
		
		ItemOrder i = new ItemOrder("Apple",12,2);
		ItemOrder i2 = new ItemOrder("Apple",12);
		
		assertEquals("getName() should be Apple","Apple",i.getProductName());
		assertEquals("getName() should be equal to Apple","Apple", i2.getProductName());
	
	}
	
	@Test
	public void testAddItem()
	{
		ItemOrder i = new ItemOrder("Apple",12);
		
		int i2 = i.addItem();
		
		assertEquals("The ItemOrder Should have a Quantity of 2",2,i2);
		
	}
	
	@Test
	public void testRemoveItem()
	{
		ItemOrder i = new ItemOrder("Apple",12,2);
		
		int i2 = i.removeItem();
		
		assertEquals("The ItemOrder should have a quantity of 1",1,i2);
		
	}
	
	@Test
	public void testAddMoreThanOneItem()
	{
		ItemOrder i = new ItemOrder("Apple",12,3);
		
		int i2 = i.addItems(2);
		
		assertEquals("The ItemOrder should have a quantity of 5",5,i2);
		
	}
	
	@Test
	public void testRemoveMoreThanOneItem()
	{
		ItemOrder i = new ItemOrder ("Apple",12,5);
		
		int i2 = i.removeItems(2);
		
		assertEquals("The ItemOrder should have a quantity of 3",3,i2);
		
	}


}
