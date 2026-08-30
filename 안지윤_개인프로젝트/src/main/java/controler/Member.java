package controler;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import commend.member.MemberDelete;
import commend.member.MemberLogin;
import commend.member.MemberLogout;
import commend.member.MemberMyInfo;
import commend.member.MemberSave;
import commend.member.MemberUpdate;
import dao.MemberDao;

@WebServlet("/Member")
public class Member extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public Member() {
		super();
	}


	@Override
	protected void doGet(
			HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");

		String gubun =
				request.getParameter("t_gubun");

		String viewPage = "";


		/* =========================
		   로그인 페이지
		========================= */
		if("login".equals(gubun)) {

			viewPage =
					"member/member_login.jsp";


		/* =========================
		   회원가입 페이지
		========================= */
		}else if("join".equals(gubun)) {

			viewPage =
					"member/member_join.jsp";


		/* =========================
		   회원가입 저장
		========================= */
		}else if("memberSave".equals(gubun)) {

			MemberSave mem =
					new MemberSave();

			mem.execute(request);

			viewPage =
					"common_alert.jsp";


		/* =========================
		   ID 중복확인
		========================= */
		}else if("checkId".equals(gubun)) {

			String id =
					request.getParameter("t_id");

			MemberDao dao =
					MemberDao.getDao();

			int result =
					dao.checkId(id);

			response.setContentType(
					"text/plain; charset=UTF-8");

			response.setCharacterEncoding(
					"UTF-8");

			if(result == 0) {

				response.getWriter()
						.print("使用可能");

			}else {

				response.getWriter()
						.print("使用不可");
			}

			return;


		/* =========================
		   로그인 처리
		========================= */
		}else if("memberLogin".equals(gubun)) {

			MemberLogin mem =
					new MemberLogin();

			mem.execute(request);

			viewPage =
					"common_alert.jsp";


		/* =========================
		   로그아웃
		========================= */
		}else if("logout".equals(gubun)) {

			MemberLogout mem =
					new MemberLogout();

			mem.execute(request);

			viewPage =
					"common_alert.jsp";


		/* =========================
		   마이페이지
		========================= */
		}else if("myinfo".equals(gubun)) {

			MemberMyInfo mem =
					new MemberMyInfo();

			mem.execute(request);

			viewPage =
					"member/member_myinfo.jsp";


		/* =========================
		   회원정보 수정 화면
		========================= */
		}else if("memberUpdateForm".equals(gubun)) {

			MemberMyInfo mem =
					new MemberMyInfo();

			mem.execute(request);

			viewPage =
					"member/member_update.jsp";


		/* =========================
		   회원정보 실제 수정
		========================= */
		}else if("memberUpdate".equals(gubun)) {

			MemberUpdate update = new MemberUpdate();
			update.execute(request);

			viewPage = "common_alert.jsp";

		/* =========================
		   회원탈퇴
		========================= */
		}else if("memberExit".equals(gubun)) {

			MemberDelete mem =
					new MemberDelete();

			mem.execute(request);

			viewPage =
					"common_alert.jsp";


		/* =========================
		   잘못된 접근
		========================= */
		}else {

			viewPage =
					"index.jsp";
		}


		/* =========================
		   화면 이동
		========================= */
		RequestDispatcher rd =
				request.getRequestDispatcher(
						viewPage
				);

		rd.forward(
				request,
				response
		);
	}


	@Override
	protected void doPost(
			HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {

		doGet(
				request,
				response
		);
	}

}