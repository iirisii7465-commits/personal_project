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
import commend.notice.MusicBoardUpdateForm;
import commend.notice.MusicBoardView;
import dao.MusicBoardDao;
import dao.MusicDao;
import dto.MusicBoardDto;
import dto.MusicDto;

 
/**
 * Servlet implementation class Notice
 */
@WebServlet("/Notice")
public class Notice extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Notice() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String gubun = request.getParameter("t_gubun");
		String viewPage="";
		 if(gubun == null || "list".equals(gubun)) {

			 MusicBoardDao dao = MusicBoardDao.getDao();

			MusicBoardList list = new MusicBoardList();
list.execute(request);
			 

			 viewPage = "/notice/notice.jsp";
			 

		    }else if("write".equals(gubun)) {
		    	

		    		String sessionId =
		    				(String)request.getSession().getAttribute("sessionId");

		    		if(sessionId == null) {

		    			request.setAttribute(
		    					"msg",
		    					"ログイン後にご利用いただけます。"
		    			);

		    			MusicBoardList list =
		    					new MusicBoardList();

		    			list.execute(request);

		    			viewPage = "/notice/notice.jsp";

		    		}else {
		    	
		    	MusicDao dao = MusicDao.getDao();
		    	ArrayList<MusicDto> musicList = dao.getMusicList();
		    	request.setAttribute("musicList", musicList);
		    	
		    	viewPage="notice/notice_write.jsp";}
		    } else if("save".equals(gubun)) {

		        MusicBoardSave save = new MusicBoardSave();
		        save.execute(request);

		        response.sendRedirect(
		            request.getContextPath() + "/Notice?t_gubun=list"
		        );

		        return;
		    }else if("view".equals(gubun)) {

		    	String sessionId =
		    			(String)request.getSession().getAttribute("sessionId");

		    	if(sessionId == null) {

		    		request.setAttribute(
		    				"msg",
		    				"ログイン後にご利用いただけます。"
		    		);

		    		MusicBoardList list =
		    				new MusicBoardList();

		    		list.execute(request);

		    		viewPage =
		    				"/notice/notice.jsp";

		    	} else {

		    		MusicBoardView view =
		    				new MusicBoardView();

		    		view.execute(request);

		    		viewPage =
		    				"/notice/notice_view.jsp";
		    	}
		    }else if("updateForm".equals(gubun)) {

		    	MusicBoardUpdateForm updateForm =
		    			new MusicBoardUpdateForm();

		    	updateForm.execute(request);

		    	viewPage = "/notice/notice_update.jsp";
		 
		    }else if("update".equals(gubun)) {
		    	MusicBoardUpdate update = new MusicBoardUpdate();
		    	update.execute(request);
		    	
		    	viewPage="/notice/notice_view.jsp";
		    	
		    }else if("delete".equals(gubun)) {
		    	MusicBoardDelete delete = new MusicBoardDelete();
		    	delete.execute(request);
		    	
		    	
		    	MusicBoardList list = new MusicBoardList();
		    	list.execute(request);
		    	
		    	viewPage="/notice/notice.jsp";
		    }else if("like".equals(gubun)) {
		    	
		    	System.out.println("===== Notice like 들어옴 =====");

		    	MusicBoardLike like = new MusicBoardLike();
		    	like.execute(request);

		    	int board_no =
		    		Integer.parseInt(request.getParameter("t_board_no"));

		    	response.sendRedirect(
		    		request.getContextPath()
		    		+ "/Notice?t_gubun=viewNoHit&t_board_no="
		    		+ board_no
		    	);

		    	return;
		    }else if("viewNoHit".equals(gubun)) {

		    	int board_no =
		    			Integer.parseInt(request.getParameter("t_board_no"));

		    	MusicBoardDao dao = MusicBoardDao.getDao();

		    	MusicBoardDto dto =
		    			dao.getBoardView(board_no);

		    	int likeCount =
		    			dao.getLikeCount(board_no);

		    	request.setAttribute("dto", dto);
		    	request.setAttribute("likeCount", likeCount);

		    	viewPage = "/notice/notice_view.jsp";
		    }
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 

		 RequestDispatcher rd =
	                request.getRequestDispatcher(viewPage);

	        rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
