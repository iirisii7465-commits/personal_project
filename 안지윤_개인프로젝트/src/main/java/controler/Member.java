package controler;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import commend.member.MemberLogin;
import commend.member.MemberLogout;
import commend.member.MemberMyInfo;
import commend.member.MemberSave;
import dao.MemberDao;

/**
 * Servlet implementation class Member
 */
@WebServlet("/Member")
public class Member extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Member() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String gubun = request.getParameter("t_gubun");
		String viewPage ="";
		
		if ("login".equals(gubun)) {
			viewPage="member/member_login.jsp";
		}else if("join".equals(gubun)) {
			viewPage="member/member_join.jsp";
		}else if("memberSave".equals(gubun)) {
			//저장하는메소드를 실행시키면됨,여기에있어야됨 commend.member에다가 메소드만들기 저장,업데이트,삭제,수정 ..
			//jsp>구분값으로 여기 doGet으로 보냄,>구분값으로받아서 메소드실행시킴
			//버튼누르면 request안에 담김 membersave에다가 request에담은 정보들 보내주기
			MemberSave mem = new MemberSave();
			mem.execute(request);
			
			viewPage="common_alert.jsp";
			

		}else if("checkId".equals(gubun)) {

		    String id = request.getParameter("t_id");

		    MemberDao dao = MemberDao.getDao();
		    int result = dao.checkId(id);

		    response.setContentType("text/plain; charset=UTF-8");
		    response.setCharacterEncoding("UTF-8");

		    if(result == 0) {
		        response.getWriter().print("使用可能");
		    }else {
		        response.getWriter().print("使用不可");
		    }

		    return;
		}else if("memberLogin".equals(gubun)) {

		    MemberLogin mem = new MemberLogin();
		    mem.execute(request);

		    viewPage = "common_alert.jsp";
		}else if("logout".equals(gubun)) {

		    MemberLogout mem = new MemberLogout();
		    mem.execute(request);

		    viewPage = "common_alert.jsp";
		}else if("myinfo".equals(gubun)) {

		    MemberMyInfo mem = new MemberMyInfo();
		    mem.execute(request);

		    viewPage = "member/member_myinfo.jsp";
		}
			RequestDispatcher rd = request.getRequestDispatcher(viewPage);
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
