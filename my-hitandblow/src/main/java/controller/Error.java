package controller;

import java.util.regex.Pattern;

/**
 * 正解を作るクラス
 */
public class Error {

	/**
	 * ERROR_PATTERN 不正な入力条件1
	 * 半角数字4桁
	 */
	private final static String ERROR_PATTERN_1 = "^(?!\\d{4}$).*";

	/**
	 * ERROR_PATTERN 不正な入力条件2
	 * 数字重複
	 */
	private final static String ERROR_PATTERN_2 = "^(?=.*(\\d)\\d*\\1).*";

	/**
	 * 条件を満たした入力値出ない場合、エラーメッセージが出る
	 * @param inputAnswer 入力値
	 * @return
	 */
	public static String errorIndicate(String inputAnswer) {
		if (Pattern.matches(ERROR_PATTERN_1, inputAnswer)) {
			return "1";
		} else if(Pattern.matches(ERROR_PATTERN_2, inputAnswer)) {
			return "2";
		}

		return "0";
	}
}
