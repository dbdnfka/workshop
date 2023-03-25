package com.Woo.Ram.interceptor;

import com.Woo.Ram.model.MemberVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Slf4j
public class AdminInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        HttpSession session = request.getSession();
        System.out.println("adminInterceptor preHandle 작동");
        MemberVO lvo = (MemberVO)session.getAttribute("member");
        if(lvo == null || lvo.getAdminCk() == 0) {    // 관리자 계정 아닌 경우
            log.info(lvo.toString());
            session.setAttribute("member", lvo);     // session에 사용자의 정보 저장
            response.sendRedirect("/main");    // 메인페이지로 리다이렉트

            return false;

        }

        return true;    // 관리자 계정 로그인 경우(lvo != null && lvo.getAdminCk() == 1)


    }
}
