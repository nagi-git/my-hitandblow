package controller;

import java.util.regex.Pattern;

/**
 * 正解を作るクラス
 */
public class Error {

	private final static String CORRECT_PATTERN = "^\\d{4}$";

	/**
	 * 条件を満たした入力値出ない場合、エラーメッセージが出る
	 * @param inputAnswer 入力値
	 * @return
	 */
	public static String errorIndicate(String inputAnswer) {
		if (!Pattern.matches(CORRECT_PATTERN,inputAnswer)) {
			// inputAnswerが半角数字
			return "1";
		} else {
			return "0";
		}
	}
}
