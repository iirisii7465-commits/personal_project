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

		MemberDao dao = MemberDao.getDao();

		String id = request.getParameter("t_id");
		String name = request.getParameter("t_name");
		String password = request.getParameter("t_password");

		// 암호화 전 비밀번호 길이
		String password_length =
				Integer.toString(password.length());

		// 비밀번호 암호화
		try {

			password = dao.encryptSHA256(password);

		} catch(NoSuchAlgorithmException e) {

			e.printStackTrace();
		}

		String email_1 =
				request.getParameter("t_email_1");

		String email_2 =
				request.getParameter("t_email_2");

		// 가입일
		String reg_date =
				CommonUtil.getTodayTime();


		// DTO 생성
		MemberDto dto = new MemberDto(
				id,
				name,
				password,
				password_length,
				email_1,
				email_2,
				reg_date,
				null,   // update_date
				null    // exit_date
		);


		int result =
				dao.memberSave(dto);


		String msg = result == 1
				? name + "様、会員登録が完了しました。"
				: "会員登録に失敗しました.";


		request.setAttribute("t_msg", msg);
		request.setAttribute("t_url", "index");
	}
}