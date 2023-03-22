package com.Woo.Ram.controller;

import com.Woo.Ram.model.MemberVO;
import com.Woo.Ram.service.MemberService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.slf4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping(value = "/member")
public class MemberController {
    private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

    @Autowired
    private MemberService memberService;

    @RequestMapping(value ="/join",method = RequestMethod.GET)
    public void loginGet(){
        logger.info("회원가입 페이지 진입");
    }

    @RequestMapping(value="/join", method=RequestMethod.POST)
    public String joinPOST(MemberVO member) throws Exception{

        logger.info("join 진입");
        logger.info(member.toString());

        // 회원가입 서비스 실행
        memberService.memberJoin(member);

        logger.info("join Service 성공");

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
}

