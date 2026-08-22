package commend.member;

import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import common.CommonExcute;
import dao.MemberDao;

public class MemberLogin implements CommonExcute {

	@Override
	public void execute(HttpServletRequest request) {
		// TODO Auto-generated method stub

	MemberDao dao = MemberDao.getDao();
		String id = request.getParameter("t_id");
		String password = request.getParameter("t_password");
		
		try {
			password= dao.encryptSHA256(password);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		String name = dao.getloginName(id,password);
		
		String msg ="",url="";
		if(!name.equals("")) {
			msg=name+"様、ログインしました。";
			url ="index";
			HttpSession session = request.getSession();
					
					session.setAttribute("sessionId", id);
					session.setAttribute("sessionName", name); //내정보를볼려면 id정보가있어야 내정보라는페이지를열어줄수있음,게시판등록등 작성자부분때매
					if(id.equals("manager")) {
						session.setAttribute("sessionLevel", "top");
					}
					session.setMaxInactiveInterval(60*60*1); //세션유지시간(초단위) 
		} else {

            msg = "IDまたはパスワードが正しくありません。";
            url = "index";
        
		}
		request.setAttribute("t_msg", msg);
		request.setAttribute("t_url", url);		
		
		
	}

}
