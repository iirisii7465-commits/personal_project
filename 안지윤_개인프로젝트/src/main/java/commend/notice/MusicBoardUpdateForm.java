package commend.notice;

import javax.servlet.http.HttpServletRequest;

import common.CommonExcute;
import dao.MusicBoardDao;
import dto.MusicBoardDto;

public class MusicBoardUpdateForm implements CommonExcute {

	@Override
	public void execute(HttpServletRequest request) {
		int board_no =
				Integer.parseInt(
					request.getParameter("t_board_no")
				);

			MusicBoardDao dao = MusicBoardDao.getDao();

			MusicBoardDto dto =
				dao.getBoardView(board_no);

			request.setAttribute("dto", dto);
	}

}
