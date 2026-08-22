package commend.member;

import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpServletRequest;

import common.CommonExcute;
import common.CommonUtil;
import dao.MemberDao;
import dto.MemberDto;

public class MemberSave implements CommonExcute {

	@Override
	public void execute(HttpServletRequest request) {
		// TODO Auto-generated method stub
		//dto만들어야되고 저장하는dao에다가보내줘야됨
		//받아온값 파라미터로 저장준비 저장하고나서 담아주고>알럿으로이동하는거
		MemberDao dao = MemberDao.getDao();
		String id = request.getParameter("t_id");
		String name = request.getParameter("t_name");
		String password = request.getParameter("t_password");
		//패스워드길이알고나서, 패스워드암호화해주기
		String password_length = Integer.toString(password.length());
		try {
			password = dao.encryptSHA256(password);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		String email_1 = request.getParameter("t_email_1");
		String email_2 = request.getParameter("t_email_2");
		

		
		String reg_date = CommonUtil.getTodayTime();
		MemberDto dto = new MemberDto(id, name, password, password_length, email_1, email_2, reg_date, "탈퇴일");
			  
		int result =dao.memberSave(dto);
		String msg = result == 1
		        ? name + "様、会員登録が完了しました。"
		        : "会員登録に失敗しました。";
		request.setAttribute("t_msg", msg);
		request.setAttribute("t_url", "index");
				
		
		
	}

}
