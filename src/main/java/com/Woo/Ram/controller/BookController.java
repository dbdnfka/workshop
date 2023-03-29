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
    public void mainPageGET(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession();
        MemberVO mem = (MemberVO) session.getAttribute("member");


        if (mem != null) {

            int admin = mem.getAdminCk();
            logger.info(String.valueOf(admin));
            if(admin == 0 )
            {
                model.addAttribute("admin", admin);
            }

        }

    }
}
