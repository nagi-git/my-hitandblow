package controller;

/**
 * 正解を作るクラス
 */
public class Play {

	static int[] arrayinputAnswer;
	static int[] correctAnswer;
	static int hitCount;
	static int blowCount;
	static int turnCount;

	/**
	 * コンストラクタ
	 * @param arrayinputAnswer
	 * @param correctAnswer
	 * @param hitCount
	 * @param blowCount
	 * @param turnCount
	 */
	public Play(int[] arrayinputAnswer, int[] correctAnswer, int hitCount, int blowCount, int turnCount) {
		Play.arrayinputAnswer = getInputAnswer(inputAnswer, correctAnswer);
		Play.correctAnswer = correctAnswer;
		Play.hitCount = hitCount;
		Play.blowCount = blowCount;
		Play.turnCount = 0;
	}

	/**
	 * ヒットアンドブローを実行する
	 * @param inputAnswer
	 * @param correctAnswer
	 * @param hitCount
	 */
	public static int[] getInputAnswer(String inputAnswer, int[] correctAnswer) {

		arrayinputAnswer = Input.inputAnswer(inputAnswer);

		return arrayinputAnswer;
	}

	/**
	 * hit数を数える
	 * @param arrayinputAnswer
	 * @param correctAnswer
	 * @return hitCount
	 */
	public static int getHitCount(int[] arrayinputAnswer, int[] correctAnswer) {

		// ヒットの数を取得する
		hitCount = Count.countHit(correctAnswer, arrayinputAnswer);

		return hitCount;
	}

	public static int getBlowCount(int[] arrayinputAnswer, int[] correctAnswer) {

		// ヒットの数を取得する
		blowCount = Count.countHit(correctAnswer, arrayinputAnswer);

		return blowCount;
	}

}
