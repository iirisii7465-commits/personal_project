package commend.member;

import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpServletRequest;

import common.CommonExcute;
import dao.MemberDao;
import dto.MemberDto;

public class MemberUpdate implements CommonExcute {

	@Override
	public void execute(HttpServletRequest request) {

		String id = request.getParameter("t_id");
		String name = request.getParameter("t_name");
		String password = request.getParameter("t_password");
		String email_1 = request.getParameter("t_email_1");
		String email_2 = request.getParameter("t_email_2");

		MemberDao dao = MemberDao.getDao();


		// 비밀번호 길이
		String password_length =
				Integer.toString(password.length());


		// 비밀번호 암호화
		String encryptPassword = "";

		try {

			encryptPassword =
					dao.encryptSHA256(password);

		} catch(NoSuchAlgorithmException e) {

			e.printStackTrace();
		}


		// DTO 생성
		MemberDto dto = new MemberDto(
				id,
				name,
				encryptPassword,
				password_length,
				email_1,
				email_2,
				null,   // reg_date
				null,   // update_date
				null    // exit_date
		);


		// DB 수정
		int result =
				dao.updateMember(dto);


		// 수정 성공
		if(result == 1) {

			// 헤더에 보이는 이름도 변경
			request.getSession()
					.setAttribute(
							"sessionName",
							name
					);

			// 알럿 메시지
			request.setAttribute(
					"t_msg",
					"会員情報を修正しました。"
			);

			// 알럿 확인 후 마이페이지로 이동
			request.setAttribute(
					"t_url",
					"Member?t_gubun=myinfo"
			);


		// 수정 실패
		}else {

			request.setAttribute(
					"t_msg",
					"会員情報の修正に失敗しました。"
			);

			request.setAttribute(
					"t_url",
					"Member?t_gubun=myinfo"
			);
		}
	}
}