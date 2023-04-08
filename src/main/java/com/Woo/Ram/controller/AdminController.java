package com.Woo.Ram.controller;

import com.Woo.Ram.model.AuthorVO;
import com.Woo.Ram.model.BookVO;
import com.Woo.Ram.model.Criteria;
import com.Woo.Ram.model.PageDTO;
import com.Woo.Ram.service.AdminService;
import com.Woo.Ram.service.AuthorService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/member")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @Autowired
    private AuthorService authorService;

    /* 관리자 메인 페이지 이동 */
    @RequestMapping(value="/admin/main", method = RequestMethod.GET)
    public void adminMainGET() throws Exception{

        log.info("관리자 페이지 이동");

    }
    /* 상품 등록 페이지 접속 */
    @RequestMapping(value = "/admin/goodsManage", method = RequestMethod.GET)
    public void goodsManageGET() throws Exception{
        log.info("상품 등록 페이지 접속");
    }

    /* 상품 등록 페이지 접속 */
    @RequestMapping(value = "/admin/goodsEnroll", method = RequestMethod.GET)
    public void goodsEnrollGET(Model model) throws Exception{
        log.info("상품 등록 페이지 접속");
        ObjectMapper objm = new ObjectMapper();
        List list = adminService.cateList();
        String cateList = objm.writeValueAsString(list);
        model.addAttribute("cateList", cateList);
        log.info("변경 전.........." + list);
        log.info("변경 후.........." + cateList);
    }

    /* 작가 등록 페이지 접속 */
    @RequestMapping(value = "/admin/authorEnroll", method = RequestMethod.GET)
    public void authorEnrollGET() throws Exception{
        log.info("작가 등록 페이지 접속");
    }

    /* 작가 관리 페이지 접속 */
    @RequestMapping(value = "/admin/authorManage", method = RequestMethod.GET)
    public void authorManageGET(Criteria cri, Model model) throws Exception {
        log.info("작가 관리 페이지 접속.........." + cri);
        /* 작가 목록 출력 데이터 */
        List list = authorService.authorGetList(cri);

        /* 페이지 이동 인터페이스 데이터 */
        int total = authorService.authorGetTotal(cri);
        PageDTO pageMaker = new PageDTO(cri, total);
        model.addAttribute("pageMaker", pageMaker);

        if(!list.isEmpty()) {
            model.addAttribute("list",list);	// 작가 존재 경우
        } else {
            model.addAttribute("listCheck", "empty");	// 작가 존재하지 않을 경우
        }
        model.addAttribute("amount",cri.getAmount());
        cri.setKeyword("");

        model.addAttribute("keyword",cri.getKeyword());
        model.addAttribute("total",pageMaker.getTotal());
        model.addAttribute("pageNum", cri.getPageNum());
        /* 페이지 이동 인터페이스 데이터 */

    }

    @RequestMapping(value="/admin/authorEnroll.do", method = RequestMethod.POST)
    public String authorEnrollPOST(AuthorVO author, RedirectAttributes rttr) throws Exception{
        log.info("authorEnroll :" +  author.toString());

        authorService.authorEnroll(author);      // 작가 등록 쿼리 수행
        rttr.addFlashAttribute("enroll_result", author.getAuthorName());
        return "redirect:/member/admin/authorManage";
    }
    /* 작가 상세 페이지 */
    @GetMapping("/admin/authorDetail/{authorId}")
    public String authorGetInfoGET(Criteria cri, Model model, @PathVariable int authorId) throws Exception {

        log.info("authorDetail......." + authorId);
        cri.setKeyword("");
        /* 작가 관리 페이지 정보 */
        model.addAttribute("cri", cri);
        /* 선택 작가 정보 */
        model.addAttribute("authorInfo", authorService.authorGetDetail(authorId));
        return "/member/admin/authorDetail";
    }

    @GetMapping ("/admin/authorModify")
    public void authorGetInfoGET2(Criteria cri, Model model, int authorId) throws Exception {

        log.info("2......." + authorId);
        cri.setKeyword("");
        /* 작가 관리 페이지 정보 */
        model.addAttribute("cri2", cri);
        /* 선택 작가 정보 */
        model.addAttribute("authorInfo2", authorService.authorGetDetail(authorId));
    }
    /* 작가 정보 수정 */
    @PostMapping("/admin/authorModify")
    public String authorModifyPOST(AuthorVO author, RedirectAttributes rttr) throws Exception{

        log.info("authorModifyPOST......." + author);

        int result = authorService.authorModify(author);

        rttr.addFlashAttribute("modify_result", result);

        return "redirect:/member/admin/authorManage";

    }
    /* 상품 등록 */
    @PostMapping("/admin/goodsEnroll")
    public String goodsEnrollPOST(BookVO book, RedirectAttributes rttr) {

        log.info("goodsEnrollPOST......" + book);

        adminService.bookEnroll(book);

        rttr.addFlashAttribute("enroll_result", book.getBookName());

        return "redirect:/member/admin/goodsManage";
    }
    /* 작가 검색 팝업창 */
    @GetMapping("/admin/authorPop")
    public void authorPopGET(Criteria cri, Model model) throws Exception{
        cri.setAmount(5);
        log.info("authorPopGET.......");
        List list = authorService.authorGetList(cri);
        int total = authorService.authorGetTotal(cri);
        PageDTO pageMaker = new PageDTO(cri, total);
        model.addAttribute("pageMaker", pageMaker);

        if(!list.isEmpty()) {
            model.addAttribute("list",list);	// 작가 존재 경우
        } else {
            model.addAttribute("listCheck", "empty");	// 작가 존재하지 않을 경우
        }
        model.addAttribute("amount",cri.getAmount());
        cri.setKeyword("");

        model.addAttribute("keyword",cri.getKeyword());
        model.addAttribute("total",pageMaker.getTotal());
        model.addAttribute("pageNum", cri.getPageNum());
    }
}