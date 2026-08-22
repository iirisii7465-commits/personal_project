package commend.notice;

import javax.servlet.http.HttpServletRequest;

import common.CommonExcute;
import dao.MusicBoardDao;
import dto.MusicBoardDto;

public class MusicBoardSave implements CommonExcute {

	@Override
	public void execute(HttpServletRequest request) {
		// TODO Auto-generated method stub

		String id =(String)request.getSession().getAttribute("sessionId");
		
		int music_no = Integer.parseInt(request.getParameter("t_music_no"));
		
		
		String recommend_reason = request.getParameter("t_reason");
		String board_content = request.getParameter("t_content");
		
		MusicBoardDto dto = new MusicBoardDto();
		
		dto.setId(id);
		dto.setMusic_no(music_no);
		dto.setRecommend_reason(recommend_reason);
		dto.setBoard_content(board_content);
		
		MusicBoardDao dao = MusicBoardDao.getDao();
		dao.saveBoard(dto);
	}

}
