package dto;

import java.io.Serializable;

//書き込み内容を保持するクラス
public class ResultDTO implements Serializable {
	private int turnCount;	// 回数
	private String inputAnswer;		// 入力した回答
	private int hitCount;		// ヒット数
	private int blowCount;		// ブロー数


	public ResultDTO(int turnCount, String inputAnswer, int hitCount, int blowCount) {
		this.turnCount = turnCount;
		this.inputAnswer = inputAnswer;
		this.hitCount = hitCount;
		this.blowCount = blowCount;
	}

	public ResultDTO() {

	}

	public void setTurnCount(int turnCount) {
		this.turnCount = turnCount;
	}

	public String getInputAnswer() {
		return inputAnswer;
	}

	public void setInputAnswer(String inputAnswer) {
		this.inputAnswer = inputAnswer;
	}

	public int getHitCount() {
		return hitCount;
	}

	public void setHitCount(int hitCount) {
		this.hitCount = hitCount;
	}

	public int getBlowCount() {
		return blowCount;
	}

	public void setBlowCount(int blowCount) {
		this.blowCount = blowCount;
	}
}