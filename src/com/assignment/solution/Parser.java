package com.assignment.solution;

import java.util.Arrays;

public class Parser {

	private String type;
	private Double price;
	private Integer quantity;
	private String operation;

	public Parser(String message) {
		this.type = "";
		this.price = 0.0;
		this.quantity = 0;
		this.operation = "";
		parse(message);
	}

	// Getter and Setters
	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Integer getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getOperation() {
		return this.operation.toLowerCase();
	}

	public void setOperation(String operation) {
		this.operation = operation.toLowerCase();
	}

	// operations
	private String[] getOperations() {
		return new String[] { "add", "subtract", "multiply" };
	}

	private boolean parse(String message) {
		if (message == null || message.equals("")) {
			return false;
		}

		String[] words = message.trim().split(" ");
		String firstWord = words[0].toLowerCase();
		if (isProduct(firstWord)) {
			return messageType1(words);
		} else if (Arrays.asList(getOperations()).contains(firstWord)) {
			return messageType3(words);
		} else if (Arrays.asList(words).contains("sales")) {
			return messageType2(words);
		}
		return true;
	}

	private boolean isProduct(String word) {
		if (!Arrays.asList(getOperations()).contains(word) && !word.matches("\\d+")) {
			return true;
		}
		return false;
	}

	private boolean messageType1(String[] words) {
		this.type = Product.getProduct(words[0]);
		this.price = price(words);
		this.quantity = 1;
		return true;
	}

	// Strictly follows the rule
	// 20 sales of apples at 10p each
	// Sentence doesn't contain more than 7 words and should have same pattern
	private boolean messageType2(String[] words) {
		if (words.length > 7 || words.length < 7)
			return false;
		this.type = Product.getProduct(words[3]);
		this.price = price(words);
		this.quantity = Integer.parseInt(words[0]);
		return true;
	}

	private boolean messageType3(String[] words) {
		this.operation = words[0];
		this.type = Product.getProduct(words[2]);
		this.quantity = 0;
		this.price = price(words);
		return true;
	}

	public Double price(String[] words) {
		String selected = null;
		for (String string : words) {
			if (string.matches("\\d+p")) {
				selected = string;
				break;
			}
		}
		selected = selected.substring(0, selected.length() - 1);
		Double p = Double.parseDouble(selected);
		if (!selected.contains(".")) {
			p = p / 100.0;
		}
		return p;
	}

}