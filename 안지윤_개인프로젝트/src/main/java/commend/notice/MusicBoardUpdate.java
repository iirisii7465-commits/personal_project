package commend.notice;

import javax.servlet.http.HttpServletRequest;

import common.CommonExcute;
import dao.MusicBoardDao;
import dto.MusicBoardDto;

public class MusicBoardUpdate implements CommonExcute {

	@Override
	public void execute(HttpServletRequest request) {

		int board_no =
				Integer.parseInt(
						request.getParameter("t_board_no")
				);

		String recommend_reason =
				request.getParameter("t_recommend_reason");

		String board_content =
				request.getParameter("t_board_content");


		MusicBoardDto dto =
				new MusicBoardDto();

		dto.setBoard_no(board_no);
		dto.setRecommend_reason(recommend_reason);
		dto.setBoard_content(board_content);


		MusicBoardDao dao =
				MusicBoardDao.getDao();

		int result =
				dao.updateBoard(dto);


		if(result == 1) {

			request.setAttribute(
					"t_msg",
					"投稿を修正しました。"
			);

			request.setAttribute(
					"t_url",
					"Notice?t_gubun=viewNoHit&t_board_no=" + board_no
			);

		}else {

			request.setAttribute(
					"t_msg",
					"投稿の修正に失敗しました。"
			);

			request.setAttribute(
					"t_url",
					"Notice?t_gubun=viewNoHit&t_board_no=" + board_no
			);
		}
	}
}