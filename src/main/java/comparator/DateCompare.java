package main.java.comparator;

import java.util.Comparator;

import main.java.app.Order;

public class DateCompare implements Comparator<Order>{

	@Override
    public int compare(Order o1, Order o2)
    {
        if (o1.time.compareTo(o2.time) == 0) {
        	return o1.orderName.compareTo(o2.orderName);
        } else {
        	return o1.time.compareTo(o2.time);
        }		
    }
}
