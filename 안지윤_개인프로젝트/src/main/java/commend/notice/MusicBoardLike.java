package commend.notice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import common.CommonExcute;
import dao.MusicBoardDao;

public class MusicBoardLike implements CommonExcute {

	@Override
	public void execute(HttpServletRequest request) {
		// TODO Auto-generated method stub

		
		int board_no =
				Integer.parseInt(request.getParameter("t_board_no"));

		HttpSession session = request.getSession();

		String id =
				(String)session.getAttribute("sessionId");

		MusicBoardDao dao = MusicBoardDao.getDao();

		// 이미 좋아요 눌렀는지 확인
		boolean liked =
				dao.checkLike(board_no, id);

		int result = 0;
		String msg = "";

		if(liked) {

			// 이미 좋아요 눌렀으면 취소
			result = dao.deleteLike(board_no, id);

			if(result == 1) {
				msg = "いいねを取り消しました。";
			} else {
				msg = "いいねの取り消しに失敗しました。";
			}

		} else {

			// 좋아요 안 눌렀으면 추가
			result = dao.insertLike(board_no, id);

			if(result == 1) {
				msg = "いいねしました。";
			} else {
				msg = "いいねに失敗しました。";
			}
		}
		
		System.out.println("===== 좋아요 실행 =====");
		System.out.println("board_no = " + board_no);
		System.out.println("id = " + id);

		request.setAttribute("msg", msg);
		
	}
	
	
	

}
