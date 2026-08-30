package commend.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import common.CommonExcute;
import dao.MemberDao;

public class MemberDelete implements CommonExcute {

	@Override
	public void execute(HttpServletRequest request) {

		HttpSession session =
				request.getSession();

		String id =
				(String)session.getAttribute("sessionId");

		MemberDao dao =
				MemberDao.getDao();

		int result =
				dao.deleteMember(id);

		if(result == 1) {

			request.setAttribute(
					"t_msg",
					"退会が完了しました。"
			);

			request.setAttribute(
					"t_url",
					"index"
			);

			session.invalidate();

		}else {

			request.setAttribute(
					"t_msg",
					"退会に失敗しました。"
			);

			request.setAttribute(
					"t_url",
					"Member?t_gubun=myinfo"
			);
		}
	}
}