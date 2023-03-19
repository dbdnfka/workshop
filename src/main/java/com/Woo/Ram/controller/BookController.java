package com.Woo.Ram.controller;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.slf4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BookController {
    private  static  final Logger logger = LoggerFactory.getLogger(BookController.class);
    @RequestMapping(value = "/member/loginmain", method = RequestMethod.GET)
    public void mainPageGET() {

        logger.info("메인 페이지 진입");

    }
}
