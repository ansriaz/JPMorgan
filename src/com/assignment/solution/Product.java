package com.assignment.solution;

public class Product {

	private Double price;
	private Integer quantity;
	private String adjustmentOperation;
	private String type;
	private Integer totalQuantity;
	private Double totalPrice;
	private Adjustment adjustedPrice;

	public Product(String type) {
		this.totalPrice = 0.0;
		this.totalQuantity = 0;
		this.type = type;
		this.adjustmentOperation = null;
	}
	
	public Adjustment getAdjustedPrice() {
		return this.adjustedPrice;
	}
	
	public void setAdjustedPrice(Adjustment adPrice) {
		this.adjustedPrice = new Adjustment(this);
	}

	public double calculatePrice(int quantity, double price) {
		 double p = quantity * price;
		 return this.totalPrice += p;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public void setTotalQuantity(int quantity) {
		this.totalQuantity += quantity;
	}

	public int getTotalQuantity() {
		return this.totalQuantity;
	}

	public double getTotalPrice() {
		return this.totalPrice;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getAdjustmentOperation() {
		return adjustmentOperation;
	}

	public void setAdjustmentOperation(String adjustmentOperation) {
		this.adjustmentOperation = adjustmentOperation;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public static String getProduct(String word) {
		String pro = "";
		String noun = word.substring(0, word.length() - 1);
		if (word.endsWith("o")) {
			pro = String.format("%soes", noun);
		} else if (word.endsWith("y") && !word.equalsIgnoreCase("multiply")) {
			pro = String.format("%sies", noun);
		} else if (word.endsWith("h")) {
			pro = String.format("%shes", noun);
		} else if (!word.endsWith("s")) {
			pro = String.format("%ss", word);
		} else {
			pro = String.format("%s", word);
		}
		return pro.toLowerCase();
	}

}
