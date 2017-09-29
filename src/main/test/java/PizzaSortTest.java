package main.test.java;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import junit.framework.Assert;

import main.java.app.Order;
import main.java.app.PizzaSort;

import org.junit.Test;

public class PizzaSortTest {
	
	
	@Test
	public void testOrderByTime() throws IOException {
		Order o1 = new Order("cheese", new Date(Long.parseLong("1506176687")));
		Order o2 = new Order("meat", new Date(Long.parseLong("1506176699")));
		
		ArrayList<Order> orderRecords = new ArrayList<Order>();
		orderRecords.add(o1);
		orderRecords.add(o2);
		
		ArrayList<Order> expectedRecords = new ArrayList<Order>();
		expectedRecords.add(o1);
		expectedRecords.add(o2);
		
		orderRecords = PizzaSort.orderByTime(orderRecords);
		Assert.assertEquals(orderRecords, expectedRecords);
		
		
	}
	
	@Test
	public void testOrderBySameTime() throws IOException {
		Order o1 = new Order("meat", new Date(Long.parseLong("1506176687")));
		Order o2 = new Order("cheese", new Date(Long.parseLong("1506176687")));
		
		ArrayList<Order> orderRecords = new ArrayList<Order>();
		orderRecords.add(o1);
		orderRecords.add(o2);
		
		ArrayList<Order> expectedRecords = new ArrayList<Order>();
		expectedRecords.add(o2);
		expectedRecords.add(o1);
		
		orderRecords = PizzaSort.orderByTime(orderRecords);
		Assert.assertEquals(orderRecords, expectedRecords);
		
		
	}
	
	@Test
	public void testInputValidationWithNullTime() throws IOException {
		
		ArrayList<Order> orderRecords = new ArrayList<Order>();
		String[] s1 = new String[] {"meat"};
		
		orderRecords = PizzaSort.validateInput(s1);
		Assert.assertTrue(orderRecords.isEmpty());
				
	}
	
	@Test
	public void testInputValidationWithNoName() throws IOException {
		
		ArrayList<Order> orderRecords = new ArrayList<Order>();
		String[] s1 = new String[] {"" ,"1506176687"};
		
		orderRecords = PizzaSort.validateInput(s1);
		Assert.assertEquals(orderRecords.size() , 1);
				
	}
	
	@Test
	public void testInputValidationWithNullName() throws IOException {
		
		ArrayList<Order> orderRecords = new ArrayList<Order>();
		String[] s1 = new String[] {null ,"1506176687"};
		
		orderRecords = PizzaSort.validateInput(s1);
		Assert.assertEquals(orderRecords.size() , 0);
				
	}
	
	@Test
	public void testValidInput() throws IOException {
		
		ArrayList<Order> orderRecords = new ArrayList<Order>();
		String[] s1 = new String[] {"cheese" ,"1506176687"};
		
		orderRecords = PizzaSort.validateInput(s1);
		Assert.assertEquals(orderRecords.size() , 1);
				
	}

}
