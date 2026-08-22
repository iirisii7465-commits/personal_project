package commend.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import common.CommonExcute;
import dao.MemberDao;
import dto.MemberDto;

public class MemberMyInfo implements CommonExcute {

	@Override
	public void execute(HttpServletRequest request) {
	MemberDao dao = MemberDao.getDao();
	HttpSession session = request.getSession();
	String id = (String)session.getAttribute("sessionId");
	MemberDto dto = dao.getMemberInfo(id);
	request.setAttribute("t_dto", dto);
	

	}

}
