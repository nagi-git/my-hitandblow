package controller;

/**
 * ヒットとブロウを数えるクラス
 */
public class Count {

	/**
	 * ヒットを数える
	 * @param correctAnswer 正解の数字
	 * @param inputAnswer 入力した数字
	 * @return hitCount ヒットの数
	 */
	public static int countHit(int[] correctAnswer, int[] inputAnswer) {
		int hitCount = 0;
		for (int i = 0; i < 4; i++) {
			if (correctAnswer[i] == inputAnswer[i]) {
				hitCount += 1;
			}
		}
		return hitCount;
	}

	/**
	 * ブロウを数える
	 * @param correctAnswer 正解の数字
	 * @param inputAnswer 入力した数字
	 * @return blowCount ブロウの数
	 */
	public static int countBlow(int[] correctAnswer, int[] inputAnswer) {
		int blowCount = 0;
		for (int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
				if (correctAnswer[i] == inputAnswer[j]) {
					blowCount += 1;
				}
			}
		}
		return blowCount - Count.countHit(correctAnswer, inputAnswer);
	}
}
