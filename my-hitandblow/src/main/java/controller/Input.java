package controller;

/**
 * ユーザー入力させるクラス
 */
public class Input {
	/**
	 * ユーザーが入力する
	 * @return inputNum ユーザーが入力した値
	 */
	public static int[] inputAnswer(String inputAnswer) {
		int[] arrayinputAnswer = new int[4];
		for(int i = 0; i < inputAnswer.length(); i++) {
			arrayinputAnswer[i] = Integer.valueOf(inputAnswer.substring(i, i + 1));
		}
		return arrayinputAnswer;
	}
}
