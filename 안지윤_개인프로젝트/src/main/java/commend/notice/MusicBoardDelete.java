package commend.notice;

import javax.servlet.http.HttpServletRequest;

import common.CommonExcute;
import dao.MusicBoardDao;

public class MusicBoardDelete implements CommonExcute {

	@Override
	public void execute(HttpServletRequest request) {

		int board_no =
				Integer.parseInt(
						request.getParameter("t_board_no")
				);

		MusicBoardDao dao =
				MusicBoardDao.getDao();

		int result =
				dao.deleteBoard(board_no);


		if(result == 1) {

			request.setAttribute(
					"t_msg",
					"投稿を削除しました。"
			);

			request.setAttribute(
					"t_url",
					"Notice"
			);

		}else {

			request.setAttribute(
					"t_msg",
					"投稿の削除に失敗しました。"
			);

			request.setAttribute(
					"t_url",
					"Notice"
			);
		}
	}
}