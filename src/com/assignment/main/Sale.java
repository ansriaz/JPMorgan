package com.assignment.main;

import java.io.BufferedReader;
import java.io.FileReader;

import com.assignment.solution.Solution;

public class Sale {

	private Solution sol;

	public Sale() {
		this.sol = new Solution();
	}

	public void processMessages(String filename) {
		try {
			String message;
			BufferedReader inputFile = new BufferedReader(new FileReader(filename));
			while ((message = inputFile.readLine()) != null) {
				this.sol.processMessage(message);
				Thread.sleep(1000);
			}
			inputFile.close();
		} catch (java.io.IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.exit(1);
	}

}