package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ResultDAO;
import dto.ResultDTO;


@WebServlet("/play")
public class PlayHAB extends HttpServlet {
	// 乱数を取得する
	int[] correctAnswer = Answer.createCorrectAnswer();

	private static final long serialVersionUID = 1L;
	private ResultDAO dbm = new ResultDAO(); // 結果情報管理クラス
	int turnCount = 0;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("playScreen.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		// 送信したinputAnswerの取得
		String inputAnswer = request.getParameter("result");

		RequestDispatcher dispatcher;

		// セッションオブジェクトの取得
		HttpSession session = request.getSession();

		// 送信したinputAnswerの取得
		int[] arrayinputAnswer = Input.inputAnswer(inputAnswer);
		if (Count.countHit(correctAnswer, arrayinputAnswer) == 4) {
			correctAnswer = Answer.createCorrectAnswer();
			dbm = new ResultDAO();
		}

		turnCount++;

		// ヒットの数を取得する
		int hitCount = Count.countHit(correctAnswer, arrayinputAnswer);
		// ブロウの数を取得する
		int blowCount = Count.countBlow(correctAnswer, arrayinputAnswer);

		// セッションに値を保存
		dbm.setWriting(turnCount, inputAnswer, hitCount, blowCount);

		// 書き込み内容追加後のリストを取得
		List<ResultDTO> list = dbm.getResultList();

		// リストをセッションに保存
		session.setAttribute("results", list);

		dispatcher = request.getRequestDispatcher("playScreen.jsp");
		dispatcher.forward(request, response);
	}

}
