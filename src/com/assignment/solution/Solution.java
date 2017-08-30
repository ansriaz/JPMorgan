package com.assignment.solution;

public class Solution {

	public LogMessage logMessage;
	private Adjustment adjustedPrice;
	private Product product;
	private int count;
	
	public int getCount() {
		return this.count;
	}

	public Solution() {
		this.logMessage = new LogMessage();
		this.count = 0;
	}

	public boolean processMessage(String saleNotice) {

		Parser parsedMessage;

		parsedMessage = new Parser(saleNotice);

		String productType = parsedMessage.getType();

		if (productType.isEmpty()) {
			return false;
		}
		this.count++;

		this.product = this.logMessage.getProduct(productType);

		this.adjustedPrice = new Adjustment(this.product);

		this.product.setQuantity(parsedMessage.getQuantity());
		this.product.setTotalQuantity(parsedMessage.getQuantity());
		this.product.setPrice(parsedMessage.getPrice());
		this.product.setAdjustmentOperation(parsedMessage.getOperation());

		setProductTotalPrice();

		this.logMessage.setReports(saleNotice);

		this.logMessage.updateProduct(this.product);

		if (this.count % 10 == 0) {
			displayReport();
		}

		if (this.count == 50) {
			displaySummary();
			this.count = 0;
		}

		return true;
	}

	private void setProductTotalPrice() {
		double newAdjustedPrice;

		if (!this.product.getAdjustmentOperation().isEmpty()) {
			newAdjustedPrice = this.adjustedPrice.getNewPrice();
			this.logMessage.setAdjustmentReports(this.adjustedPrice.getReport());
			this.product.setTotalPrice(newAdjustedPrice);
		} else {
			this.product.calculatePrice(this.product.getQuantity(), this.product.getPrice());
		}
	}

	public void displayReport() {

		if (!this.logMessage.getReports().isEmpty()) {
			this.logMessage.setTotalSalesValue(0.0);
			System.out.println("10 messages received and processed");
			System.out.println("*************** Report *****************");
			System.out.println("Product \t\t Quantity \t Value");
			System.out.println("----------------------------------------------");
			for (String key : this.logMessage.getProducts().keySet()) {

				Product product = this.logMessage.getProducts().get(key);
				System.out.println(String.format("%-18s %-10d %-11f", product.getType(), product.getTotalQuantity(),
						product.getTotalPrice()));
				this.logMessage.addToTotalSalesValue(product.getTotalPrice());
			}
			System.out.println("----------------------------------------------");
			System.out.println("Total Value \t\t" + this.logMessage.getTotalSalesValue());
			System.out.println("************* Report End ***************\n\n");
		}
	}

	private void displaySummary() {
		if (!this.logMessage.getReports().isEmpty()) {
			System.out.println(
					"50 messages processed and cannot process further. The adjustments made so far are following:\n");

			for (String string : this.logMessage.getAdjustedReports()) {
				System.out.println(string);
			}

			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
