package commend.notice;

import javax.servlet.http.HttpServletRequest;

import common.CommonExcute;
import dao.MusicBoardDao;

public class MusicBoardDelete implements CommonExcute {

	@Override
	public void execute(HttpServletRequest request) {
			int board_no = Integer.parseInt(request.getParameter("t_board_no"));
			MusicBoardDao dao = MusicBoardDao.getDao();
			
			int result = dao.deleteBoard(board_no);
			 String msg = "削除に失敗しました。";

		        if(result == 1) {
		            msg = "削除されました。";
		        }

		        request.setAttribute("msg", msg);
		    }

}
