package com.Woo.Ram.controller;

import com.Woo.Ram.model.MemberVO;
import com.Woo.Ram.service.MemberService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.slf4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@Controller
@RequestMapping(value = "/member")
public class MemberController {
    private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

    @Autowired
    private MemberService memberService;

    @Autowired
    private PasswordEncoder pwEncoder;

    @RequestMapping(value ="/join",method = RequestMethod.GET)
    public void loginGet(){
        logger.info("회원가입 페이지 진입");
    }

    @RequestMapping(value="/join", method=RequestMethod.POST)
    public String joinPOST(MemberVO member) throws Exception{
        String rawPw = "";            // 인코딩 전 비밀번호
        String encodePw = "";        // 인코딩 후 비밀번호

        rawPw = member.getMemberPw();            // 비밀번호 데이터 얻음
        encodePw = pwEncoder.encode(rawPw);        // 비밀번호 인코딩
        member.setMemberPw(encodePw);            // 인코딩된 비밀번호 member객체에 다시 저장

        /* 회원가입 쿼리 실행 */
        memberService.memberJoin(member);
//        logger.info("join 진입");
//        logger.info(member.toString());
//        // 회원가입 서비스 실행
//        memberService.memberJoin(member);
//
//        logger.info("join Service 성공");

        return "redirect:/main";

    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public void joinGET() {
        logger.info("로그인 페이지 진입");

    }

    @RequestMapping(value = "/memberIdChk",method =RequestMethod.POST)
    @ResponseBody
    public String memberIdChkPOST(String memberId) throws Exception{
        logger.info("memberIdChk() 진입");

        int result = memberService.idCheck(memberId);

        logger.info("결과값 = " + result);

        if(result != 0) {

            return "fail";	// 중복 아이디가 존재

        } else {

            return "success";	// 중복 아이디 x

        }
    }
    /* 로그인 */
    @RequestMapping(value="/login.do", method=RequestMethod.POST)
    public String loginPOST(HttpServletRequest request, MemberVO member, RedirectAttributes rttr) throws Exception{

        HttpSession session = request.getSession();
        String rawPw = "";
        String encodePw = "";
        MemberVO members;
        MemberVO lvo = memberService.memberLogin(member);    // 제출한아이디와 일치하는 아이디 있는지

        if(lvo != null) {            // 일치하는 아이디 존재시

            rawPw = member.getMemberPw();        // 사용자가 제출한 비밀번호
            encodePw = lvo.getMemberPw();        // 데이터베이스에 저장한 인코딩된 비밀번호

            if(true == pwEncoder.matches(rawPw, encodePw)) {        // 비밀번호 일치여부 판단

                lvo.setMemberPw("");                    // 인코딩된 비밀번호 정보 지움
                members = lvo;

                int admin = members.getAdminCk();
                //logger.info(String.valueOf(admin));
                if (admin == 1) {
                    logger.info(lvo.toString());
                    rttr.addFlashAttribute("admin", admin);
                }
                rttr.addFlashAttribute("members", members);
                session.setAttribute("member", lvo);     // session에 사용자의 정보 저장

                return "redirect:/";        // 메인페이지 이동


            } else {

                rttr.addFlashAttribute("result", 0);
                return "redirect:/member/login";    // 로그인 페이지로 이동

            }

        } else {                    // 일치하는 아이디가 존재하지 않을 시 (로그인 실패)

            rttr.addFlashAttribute("result", 0);
            return "redirect:/member/login";    // 로그인 페이지로 이동

        }
    }
    /* 메인페이지 로그아웃 */
    @RequestMapping(value="logout.do", method=RequestMethod.GET)
    public String logoutMainGET(HttpServletRequest request) throws Exception{
        logger.info("logoutMainGET메서드 진입");

        HttpSession session = request.getSession();

        session.invalidate();

        return "redirect:/main";
    }

    /* 비동기방식 로그아웃 메서드 */
    @RequestMapping(value="logout.do", method=RequestMethod.POST)
    @ResponseBody
    public void logoutPOST(HttpServletRequest request) throws Exception{

        logger.info("비동기 로그아웃 메서드 진입");

        HttpSession session = request.getSession();

        session.invalidate();

    }
}