package com.Woo.Ram.controller;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Slf4j
@Controller
@RequestMapping("/member")
public class AdminController {

    private static final Logger logger = LoggerFactory.getLogger(AdminController.class);

    /* 관리자 메인 페이지 이동 */
    @RequestMapping(value="/admin/main", method = RequestMethod.GET)
    public void adminMainGET() throws Exception{

        logger.info("관리자 페이지 이동");

    }
}