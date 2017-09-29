package main.java.app;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

import main.java.comparator.DateCompare;
import main.java.comparator.NameCompare;

public class PizzaSort {

	public static String name = null;
	public static Date time = new Date();

	public static void main(String[] args) throws IOException {
		String inputFilePath = args[0];
		String outputFilePath = args[1];

		ArrayList<Order> orderRecords = new ArrayList<Order>();
		BufferedReader reader = new BufferedReader(
				new FileReader(inputFilePath));

		try {
			String headerLine = reader.readLine();
			String currentLine = reader.readLine();

			while (currentLine != null) {
				String[] orderDetail = currentLine.split("\t");
				orderRecords.addAll(validateInput(orderDetail));
				currentLine = reader.readLine();
			}

			orderByTime(orderRecords);
			writeToFile(orderRecords, headerLine, outputFilePath);
		}

		catch (Exception ex) {
			System.out.println("Exception is :" + ex);
		}

		finally {
			// Closing the resources
			reader.close();
		}
	}

	public static ArrayList<Order> validateInput(String[] orderDetail) {
		ArrayList<Order> records = new ArrayList<Order>();
		// Input length should be equal to 2, else return empty list
		if (orderDetail.length > 1) {
			name = orderDetail[0];
			time = new Date(Long.parseLong(orderDetail[orderDetail.length - 1]));
		}

		if (name != null && time != null) {
			records.add(new Order(name, time));
		}

		return records;
	}

	public static ArrayList<Order> orderByTime(ArrayList<Order> orderRecords)
			throws IOException {
		Collections.sort(orderRecords, new DateCompare());

		return orderRecords;
	}

	public static void writeToFile(ArrayList<Order> orderRecords,
			String headerLine, String outputFilePath) throws IOException {
		// Creating BufferedWriter object to write into output text file
		BufferedWriter writer = new BufferedWriter(new FileWriter(
				outputFilePath));
		try {
			writer.write(headerLine);
			writer.newLine();
			// Writing every orderRecords into output text file
			for (Order order : orderRecords) {
				writer.write(order.orderName);
				writer.write("\t\t" + order.time.getTime());
				writer.newLine();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			writer.close();
		}
	}
}
