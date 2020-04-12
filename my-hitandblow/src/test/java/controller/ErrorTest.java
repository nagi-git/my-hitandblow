package controller;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * 正解を作るクラス
 */
public class ErrorTest {

	private final static String CORRECT_CODE = "0";
	private final static String ERROR_CODE_1 = "1";
	private final static String ERROR_CODE_2 = "2";

	@Test
	public void testErrorIndicate_correct() {
		String[] inputCorrectArr = new String[] {
				"1234",
				"5678",
				"9012",
		};
		for (String input : inputCorrectArr) {
			String result = Error.errorIndicate(input);
			assertEquals("input: " + input, CORRECT_CODE, result);
		}
	}

	@Test
	public void testErrorIndicate_error1() {
		String[] inputErrorArr = new String[] {
				"",
				"12345",
				"ｱｲｳｴ",
				"１２３４",
				"12３４",
		};
		for (String input : inputErrorArr) {
			String result = Error.errorIndicate(input);
			assertEquals("input: " + input, ERROR_CODE_1, result);
		}
	}

	@Test
	public void testErrorIndicate_error2() {
		String[] inputErrorArr = new String[] {
				"1134",
				"1214",
				"1231",
				"1224",
				"1232",
				"1233",
		};
		for (String input : inputErrorArr) {
			String result = Error.errorIndicate(input);
			assertEquals("input: " + input, ERROR_CODE_2, result);
		}
	}

}
