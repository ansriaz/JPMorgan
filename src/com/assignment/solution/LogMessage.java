package com.assignment.solution;

import java.util.ArrayList;
import java.util.HashMap;

public class LogMessage {

	private HashMap<String, Product> products = new HashMap<>();
	private Double totalValueSale;
	private ArrayList<String> reports;
	private ArrayList<String> adjustedReports;

	public LogMessage() {
		this.reports = new ArrayList<>();
		this.adjustedReports = new ArrayList<>();
		this.totalValueSale = 0.0;
	}
	
	public HashMap<String, Product> getProducts() {
		return products;
	}

	public Product getProduct(String type) {
		return products.getOrDefault(type, new Product(type));
	}

	public void updateProduct(Product product) {
		products.put(product.getType(), product);
	}

	public ArrayList<String> getReports() {
		return reports;
	}

	public void setReports(String report) {
		this.reports.add(report);
	}

	public ArrayList<String> getAdjustedReports() {
		return adjustedReports;
	}

	public void setAdjustmentReports(String report) {
		this.adjustedReports.add(report);
	}

	public double getTotalSalesValue() {
		return totalValueSale;
	}

	public void addToTotalSalesValue(double productTotalPrice) {
		totalValueSale += productTotalPrice;
	}

	public void setTotalSalesValue(double productTotalPrice) {
		totalValueSale = productTotalPrice;
	}

}
