package commend.notice;

import javax.servlet.http.HttpServletRequest;

import common.CommonExcute;
import dao.MusicBoardDao;
import dto.MusicBoardDto;

public class MusicBoardUpdate implements CommonExcute {

	@Override
	public void execute(HttpServletRequest request) {

	    System.out.println("===== update 들어옴 =====");

	    int board_no =
	        Integer.parseInt(request.getParameter("t_board_no"));

	    String recommend_reason =
	        request.getParameter("t_recommend_reason");

	    String board_content =
	        request.getParameter("t_board_content");

	    MusicBoardDto dto = new MusicBoardDto();

	    dto.setBoard_no(board_no);
	    dto.setBoard_content(board_content);
	    dto.setRecommend_reason(recommend_reason);

	    MusicBoardDao dao = MusicBoardDao.getDao();

	    int result = dao.updateBoard(dto);

	    System.out.println("result = " + result);

	    String msg = "修正に失敗しました。";

	    if(result == 1) {
	        msg = "修正されました。";
	    }

	    request.setAttribute("msg", msg);

	    MusicBoardDto viewDto = dao.getBoardView(board_no);
	    request.setAttribute("dto", viewDto);
	}
}