package controller;

import java.util.List;

import dto.ResultDTO;

/**
 * 正解を作るクラス
 */
public class Play {

	List<ResultDTO> list;
	int[] arrayinputAnswer;
	int[] correctAnswer;
	int hitCount;
	int blowCount;
	int turnCount;

	/**
	 * コンストラクタ
	 * @param arrayinputAnswer
	 * @param correctAnswer
	 * @param hitCount
	 * @param blowCount
	 * @param turnCount
	 */
	public Play(int[] arrayinputAnswer, int[] correctAnswer, int hitCount, int blowCount, int turnCount) {
		this.arrayinputAnswer = arrayinputAnswer;
		this.correctAnswer = correctAnswer;
		this.hitCount = hitCount;
		this.blowCount = blowCount;
		this.turnCount = 0;
	}

	public static void playHAB(int[] arrayinputAnswer, int[] correctAnswer, int hitCount) {
		for(int i = 1; !isFinished(hitCount); i++) {
			this.arrayinputAnswer = Input.inputAnswer(inputAnswer);
		}
	}

	/**
	 * ヒットアンドブローを実行する
	 * @return correctAnswer 正解の数字
	 */
	public static int countHitCount(int[] arrayinputAnswer, int[] correctAnswer, int hitCount) {

		// ヒットの数を取得する
		hitCount = Count.countHit(correctAnswer, arrayinputAnswer);

		// ブロウの数を取得する
		blowCount = Count.countBlow(correctAnswerNum, inputAnswerNum);


		turnCount += 1;

	}
	private static boolean isFinished(int hitCount) {
		if (hitCount >= Constant.DIGIT_COUNT) {
			return true;
		} else {
			return false;
		}
	}
}
