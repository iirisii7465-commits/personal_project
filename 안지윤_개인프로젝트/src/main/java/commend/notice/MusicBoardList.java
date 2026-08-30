package commend.notice;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import common.CommonExcute;
import common.CommonUtil;
import dao.MusicBoardDao;
import dto.MusicBoardDto;

public class MusicBoardList implements CommonExcute {

	@Override
	public void execute(HttpServletRequest request) {

		MusicBoardDao dao = MusicBoardDao.getDao();
		
		String select = request.getParameter("t_select");
		String search = request.getParameter("t_search");
		
		
		if(select == null) {
			select="m.title";
			search="";
		}
		if(search == null) {
			search = "";
		}
		
		/* paging 설정 start */

		// 검색 결과 전체 게시글 수
		int totalCount = dao.getTotalCount(select, search);

		int list_setup_count = 4;  // 한 페이지당 게시글 4개
		int pageNumber_count = 3;  // 화면에 보여줄 페이지 번호 개수

		String nowPage = request.getParameter("t_nowPage");

		int current_page = 0;  // 현재 페이지
		int total_page = 0;    // 전체 페이지 수

		if(nowPage == null || nowPage.equals("")) {
			current_page = 1;
		} else {
			current_page = Integer.parseInt(nowPage);
		}

		// 전체 페이지 수 계산
		total_page = totalCount / list_setup_count;

		int rest = totalCount % list_setup_count;

		if(rest != 0) {
			total_page = total_page + 1;
		}

		// 현재 페이지에서 가져올 DB  범위
		int start = (current_page - 1) * list_setup_count + 1;
		int end = current_page * list_setup_count;

		/* paging 설정 end */

		int order = totalCount - (start - 1);

		String pageDisplay =
				CommonUtil.getPageSetting(
						current_page,
						total_page,
						pageNumber_count
				);

		// 검색 + 페이징 목록 가져오기
		ArrayList<MusicBoardDto> boardList =
				dao.getBoardList(
						select,
						search,
						start,
						end
				);

		// JSP로 전달
		request.setAttribute("boardList", boardList);

		request.setAttribute("select", select);
		request.setAttribute("search", search);

		request.setAttribute("pageDisplay", pageDisplay);
		request.setAttribute("totalCount", totalCount);
		request.setAttribute("order", order);
		
		
	}

}
