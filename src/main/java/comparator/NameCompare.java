package main.java.comparator;

import java.util.Comparator;

import main.java.app.Order;

public class NameCompare implements Comparator<Order>{

	@Override
    public int compare(Order o1, Order o2)
    {
        return o1.orderName.compareTo(o2.orderName);
    }
}
