package test;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileReader;

import org.junit.Test;

import com.assignment.solution.Parser;
import com.assignment.solution.Solution;

public class JPMorganTest {

	@Test
	public void parseMessageType1() {
		Parser tester = new Parser("apple at 20p"); // MyClass is tested

		assertEquals("apples", tester.getType());
		assertEquals(1, 0, tester.getQuantity());
		assertEquals(0.2, 0, tester.getPrice());
	}

	@Test
	public void parseMessageType2() {
		Parser tester = new Parser("20 sales of apples at 10p each"); // MyClass is tested

		assertEquals("apples", tester.getType());
		assertEquals(20, 0, tester.getQuantity());
		assertEquals(0.1, 0, tester.getPrice());
	}

	@Test
	public void parseMessageType3() {
		Parser tester = new Parser("Add 20p apples"); // MyClass is tested

		assertEquals("apples", tester.getType());
		assertEquals(0, 0, tester.getQuantity());
		assertEquals(0.2, 0, tester.getPrice());
		assertEquals("add", tester.getOperation());
	}

	@Test
	public void parseMessages10() {
		String[] tenMessages = { "apple at 10p", "20 sales of apples at 10p each", "Add 20p apples", "apple at 15p",
				"18 sales of apples at 10p each", "Add 20p apples", "apple at 12p", "20 sales of bananas at 10p each",
				"banana at 10p", "10 sales of cherries at 5p each" };

		Solution sol = new Solution();
		for (String string : tenMessages) {
			sol.processMessage(string);
		}

		assertEquals(10, sol.getCount());
	}

	@Test
	public void parseMessages50() {
		Solution sol = new Solution();
		try {
			String message;
			BufferedReader inputFile = new BufferedReader(new FileReader("input.txt"));
			int count = 0;
			while ((message = inputFile.readLine()) != null && count < 50) {
				sol.processMessage(message);
				count++;
			}
			inputFile.close();
		} catch (java.io.IOException e) {
			e.printStackTrace();
		}

		assertEquals(50, sol.logMessage.getReports().size());
	}

}
