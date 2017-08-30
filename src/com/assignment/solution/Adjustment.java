package com.assignment.solution;

public class Adjustment {

	private Double newPrice;
	private Product product;

	public Adjustment(Product product) {
		this.product = product;
		this.newPrice = 0.0;
	}

	public double getNewPrice() {
		if (product.getAdjustmentOperation().equalsIgnoreCase("add")) {
			addPrice();
		} else if (product.getAdjustmentOperation().equalsIgnoreCase("subtract")) {
			subtractPrice();
		} else if (product.getAdjustmentOperation().equalsIgnoreCase("multiply")) {
			multiplyPrice();
		}

		return newPrice;
	}

	public void addPrice() {
		this.newPrice = this.product.getTotalPrice() + (this.product.getTotalQuantity() * this.product.getPrice());
	}

	public void subtractPrice() {
		this.newPrice = this.product.getTotalPrice() - (this.product.getTotalQuantity() * this.product.getPrice());
	}

	public void multiplyPrice() {
		this.newPrice = this.product.getTotalPrice() + (this.product.getTotalPrice() * this.product.getPrice())
				+ (this.product.getTotalQuantity() * this.product.getPrice());
	}

	public String getReport() {
		String report = String.format("%s operation performed %.2fp to %d %s and price adjustment from %.2fp to %.2fp",
				this.product.getAdjustmentOperation(), this.product.getPrice(), this.product.getTotalQuantity(),
				this.product.getType(), this.product.getTotalPrice(), this.newPrice);
		return report;
	}

}
