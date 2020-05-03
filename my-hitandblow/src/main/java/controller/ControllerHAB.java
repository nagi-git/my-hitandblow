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


@WebServlet("/hitandblow")
public class ControllerHAB extends HttpServlet {
	// 乱数を取得する
	int[] correctAnswer = Answer.createCorrectAnswer();

	private static final long serialVersionUID = 1L;
	private ResultDAO dao = new ResultDAO(); // 結果情報管理クラス
	private int turnCount = 0;

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

		String rowCount = request.getParameter("count");
		// リセットボタンのパラメーター値
		String resetBtn = request.getParameter("resetBtn");
		// 送信したinputAnswerの取得
		String inputAnswer = request.getParameter("inputAnswer");
		// 送信したinputAnswerに対するエラーコード(errorCode)の取得
		String errorCode = Error.errorIndicate(inputAnswer);

		if (String.valueOf(this.turnCount).equals(rowCount)) {
			if ("run".equals(resetBtn)) {
				turnCount = 0;
				correctAnswer = Answer.createCorrectAnswer();
				dao = new ResultDAO();
			// @NOTE エラーメッセージは画面に埋め込んでいるため、エラーコードのみセット
			} else if(!"0".equals(errorCode)) {
				request.setAttribute("errorCode", errorCode);

			} else {

				Play.playHAB(inputAnswer, correctAnswer);

				int hitCount;
				// セッションに値を保存
				dao.setWriting(turnCount, inputAnswer, hitCount, blowCount);
			}
		}

		// 書き込み内容追加後のリストを取得
		List<ResultDTO> list = dao.getResultList();

		// セッションオブジェクトの取得
		HttpSession session = request.getSession();

		// リストをセッションに保存
		session.setAttribute("results", list);

		RequestDispatcher dispatcher = request.getRequestDispatcher("playScreen.jsp");
		dispatcher.forward(request, response);
	}

}
