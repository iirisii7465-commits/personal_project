package controler;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import commend.notice.MusicBoardDelete;
import commend.notice.MusicBoardLike;
import commend.notice.MusicBoardList;
import commend.notice.MusicBoardSave;
import commend.notice.MusicBoardUpdate;
import commend.notice.MusicBoardView;
import dao.MusicBoardDao;
import dto.MusicBoardDto;
import dto.MusicDto;

@WebServlet("/Notice")
public class Notice extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public Notice() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");

		String gubun = request.getParameter("t_gubun");

		String viewPage = "";

		/*
		 * ========================= 게시판 목록 =========================
		 */
		if (gubun == null || "".equals(gubun) || "list".equals(gubun)) {

			MusicBoardList list = new MusicBoardList();

			list.execute(request);

			viewPage = "notice/notice.jsp";

			/*
			 * ========================= 글쓰기 화면 =========================
			 */
		} else if ("write".equals(gubun)) {

		    // 로그인 확인
		    String sessionId =
		            (String) request.getSession()
		                            .getAttribute("sessionId");

		    if (sessionId == null) {

		        request.setAttribute(
		                "t_msg",
		                "ログインが必要です。"
		        );

		        request.setAttribute(
		                "t_url",
		                "Notice"
		        );

		        viewPage =
		                "common_alert.jsp";

		    } else {

		        MusicBoardDao dao =
		                MusicBoardDao.getDao();

		        ArrayList<MusicDto> musicList =
		        		dao.getMusicList();

		        request.setAttribute(
		                "musicList",
		                musicList
		        );

		        viewPage =
		                "notice/notice_write.jsp";
		    }
		
			/*
			 * ========================= 게시글 저장 =========================
			 */
		}else if ("save".equals(gubun)) {

			MusicBoardSave save = new MusicBoardSave();

			save.execute(request);

			viewPage = "common_alert.jsp";

			/*
			 * ========================= 상세보기 조회수 증가 O =========================
			 */
		} else if ("view".equals(gubun)) {

			MusicBoardView view = new MusicBoardView();

			view.execute(request);

			viewPage = "notice/notice_view.jsp";

			/*
			 * ========================= 수정 화면 =========================
			 */
		} else if ("updateForm".equals(gubun)) {

			int board_no = Integer.parseInt(request.getParameter("t_board_no"));

			MusicBoardDao dao = MusicBoardDao.getDao();

			MusicBoardDto dto = dao.getBoardView(board_no);

			request.setAttribute("t_dto", dto);

			viewPage = "notice/notice_update.jsp";

			/*
			 * ========================= 실제 수정 =========================
			 */
		} else if ("update".equals(gubun)) {

			MusicBoardUpdate update = new MusicBoardUpdate();

			update.execute(request);

			/*
			 * 현재 MusicBoardUpdate가 알럿용 t_msg / t_url을 넣고 있다면 common_alert.jsp 사용
			 */
			viewPage = "common_alert.jsp";

			/*
			 * ========================= 삭제 =========================
			 */
		} else if ("delete".equals(gubun)) {

			MusicBoardDelete delete = new MusicBoardDelete();

			delete.execute(request);

			viewPage = "common_alert.jsp";

			/*
			 * ========================= 좋아요 =========================
			 */
		} else if ("like".equals(gubun)) {

			MusicBoardLike like = new MusicBoardLike();

			like.execute(request);

			int board_no = Integer.parseInt(request.getParameter("t_board_no"));

			/*
			 * 좋아요 누른 뒤 일반 view로 보내면 조회수가 또 +1 되므로 viewNoHit으로 redirect
			 */
			response.sendRedirect(request.getContextPath() + "/Notice?t_gubun=viewNoHit" + "&t_board_no=" + board_no);

			return;

			/*
			 * ========================= 조회수 증가 없는 상세보기 좋아요 처리 후 사용
			 * =========================
			 */
		} else if ("viewNoHit".equals(gubun)) {

			int board_no = Integer.parseInt(request.getParameter("t_board_no"));

			MusicBoardDao dao = MusicBoardDao.getDao();

			// 조회수 증가 없이 게시글만 조회
			MusicBoardDto dto = dao.getBoardView(board_no);

			// 좋아요 수
			int likeCount = dao.getLikeCount(board_no);

			request.setAttribute("t_dto", dto);

			request.setAttribute("likeCount", likeCount);

			viewPage = "notice/notice_view.jsp";

			/*
			 * ========================= 잘못된 접근 =========================
			 */
		} else {

			MusicBoardList list = new MusicBoardList();

			list.execute(request);

			viewPage = "notice/notice.jsp";
		}

		/*
		 * ========================= 화면 이동 =========================
		 */
		RequestDispatcher rd = request.getRequestDispatcher(viewPage);

		rd.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}