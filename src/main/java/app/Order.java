package main.java.app;

import java.util.Date;

public class Order {
	public String orderName;
	public Date time;

	public Order (String orderName, Date time) {
		this.orderName = orderName;
		this.time = time;
	}
}
