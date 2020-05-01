package dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import dto.ResultDTO;

public class ResultDAO implements Serializable {
	private List<ResultDTO> resultList = new ArrayList<>();	// 登録ユーザ情報リスト

	// 書き込み内容リストの getter
	public List<ResultDTO> getResultList() {
		return resultList;
	}

	public void ResultDTO() {

	}

	// ログインユーザ情報と書き込み内容を受け取り、リストに追加する
	public void setWriting(int turnCount, String inputAnswer, int hitCount, int blowCount) {
		ResultDTO result = new ResultDTO();
		result.setTurnCount(turnCount);
		result.setInputAnswer(inputAnswer);
		result.setHitCount(hitCount);
		result.setBlowCount(blowCount);

		resultList.add(result);
	}
}
