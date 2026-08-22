package commend.notice;

import javax.servlet.http.HttpServletRequest;

import common.CommonExcute;
import dao.MusicBoardDao;
import dto.MusicBoardDto;

public class MusicBoardView implements CommonExcute {

	@Override
	public void execute(HttpServletRequest request) {
				
		int board_no = Integer.parseInt(request.getParameter("t_board_no"));
		
		MusicBoardDao dao = MusicBoardDao.getDao();
		
		
		
		dao.setHitCount(board_no);
		
		//히트수증가후에 상세조회보기
		MusicBoardDto dto = dao.getBoardView(board_no);
		int likeCount =dao.getLikeCount(board_no);
		
		
		//jsp로보내기
		request.setAttribute("dto", dto);
		request.setAttribute("likeCount", likeCount);
		
		
	}

}
