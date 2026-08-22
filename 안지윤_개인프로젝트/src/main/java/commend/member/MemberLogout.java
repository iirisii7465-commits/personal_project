package commend.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import common.CommonExcute;

public class MemberLogout implements CommonExcute {

    @Override
    public void execute(HttpServletRequest request) {

        HttpSession session = request.getSession(false);

        String name = null;

        if(session != null) {
            name = (String) session.getAttribute("sessionName");
            session.invalidate();
        }

        String msg;

        if(name != null) {
            msg = name + "様、ログアウトしました。";
        } else {
            msg = "ログアウトしました。";
        }

        request.setAttribute("t_msg", msg);
        request.setAttribute(
            "t_url",
            request.getContextPath() + "/index"
        );
    }
}