package commend.notice;

import javax.servlet.http.HttpServletRequest;

import common.CommonExcute;
import dao.MusicBoardDao;
import dto.MusicBoardDto;

public class MusicBoardView implements CommonExcute {

	@Override
	public void execute(HttpServletRequest request) {

		int board_no =
				Integer.parseInt(
						request.getParameter("t_board_no")
				);

		MusicBoardDao dao =
				MusicBoardDao.getDao();


		// 조회수 증가
		dao.setHitCount(board_no);


		// 조회수 증가 후 상세조회
		MusicBoardDto dto =
				dao.getBoardView(board_no);


		// 좋아요 수
		int likeCount =
				dao.getLikeCount(board_no);


		// JSP로 전달
		request.setAttribute(
				"t_dto",
				dto
		);

		request.setAttribute(
				"likeCount",
				likeCount
		);
	}

}