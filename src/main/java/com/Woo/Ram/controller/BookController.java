package com.Woo.Ram.controller;

import com.Woo.Ram.model.MemberVO;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.slf4j.Logger;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class BookController {
    private  static  final Logger logger = LoggerFactory.getLogger(BookController.class);
    @RequestMapping(value = "/member/loginmain", method = RequestMethod.GET)
    public void mainPageGET() {

        logger.info("메인 페이지 진입");

    }
}
