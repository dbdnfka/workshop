package com.Woo.Ram.controller;

import com.Woo.Ram.Config.auth.dto.SessionUser;
import com.Woo.Ram.dto.ArticleForm;
import com.Woo.Ram.dto.CommentDto;
import com.Woo.Ram.entity.Article;
import com.Woo.Ram.entity.Comment;
import com.Woo.Ram.model.MemberVO;
import com.Woo.Ram.repository.ArticleRepository;
import com.Woo.Ram.repository.CommentRepository;
import com.Woo.Ram.service.ArticleService;
import com.Woo.Ram.service.CommentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@Slf4j
public class ArticleController {


    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private ArticleRepository commentRepository;
    @Autowired
    private CommentService commentService;
    @GetMapping("/articles/new")
    public String newArticleForm(){
        return "articles/new";
    }


    @RequestMapping(value= "/main", method = RequestMethod.GET)
    public String index2(Model model){
        return "articles/main";
    }

    @PostMapping("/articles/create")
    public String createArticle(ArticleForm form,HttpServletRequest request){

            HttpSession session = request.getSession();
            MemberVO mem = (MemberVO) session.getAttribute("member");
            if(mem.getMemberName()!=null) {
                form.setWriter(mem.getMemberName());
            }
        Article article = form.toEntity();
        Article saved = articleRepository.save(article);
        return "redirect:/articles/"+ saved.getId();
    }
    @GetMapping("/articles/{id}")
    public String show(@PathVariable Long id, Model model,HttpServletRequest request) {
        Article articleEntity = articleRepository.findById(id).orElse(null);
        List<CommentDto> commentDtos = commentService.comments(id);
        HttpSession session = request.getSession();
        MemberVO mem = (MemberVO) session.getAttribute("member");
        if (commentDtos != null && !commentDtos.isEmpty()) {
        model.addAttribute("commentDtos",commentDtos);
    }
        // 1: id로 데이터를 가져옴2
        if(mem !=null){
            model.addAttribute("user",mem);
            if(articleEntity.getWriter().equals(mem.getMemberName())){
                model.addAttribute("writer",true);
            }

        }
        articleRepository.updateView(id);
        // 2: 가져온 데이터를 모델에 등록
        model.addAttribute("article", articleEntity);

        // 3: 보여줄 페이지를 설정
        return "articles/show";
    }

    @GetMapping("/articles")
    public String index(Model model) throws Exception{

        // 1. 모든 Article 가져오기
        List<Article> articleEntityList = articleRepository.findAll();

        // 2. 가져온 article 묶음 뷰로 전달
        model.addAttribute("articleList", articleEntityList);
        log.info(articleEntityList.toString()+"11111");
        // 3. 뷰 페이지를 설정
        return "articles/index";
    }
    @GetMapping("/articles/{id}/edit")
    public String edit(@PathVariable Long id, Model model){
        // 수정할 데이터 가져오기
        Article articleEntity = articleRepository.findById(id).orElse(null);

        // 모델에 데이터 등록
        model.addAttribute("article", articleEntity);

        // 뷰 페이지 설정
        return "articles/edit";
    }

    @PostMapping("/articles/update")
    public String update(ArticleForm form,HttpServletRequest request){

        HttpSession session = request.getSession();
        MemberVO mem = (MemberVO) session.getAttribute("member");
        form.setWriter(mem.getMemberName());
        // 1. DTO를 엔티티로 변환
        Article articleEntity = form.toEntity();

        // 2. 엔티티를 DB로 저장
        // 2-1. DB에서 기존 데이터를 가져옴
        Article target = articleRepository.findById(articleEntity.getId()).orElse(null);

        // 2-2. 기존 데이터가 있다면, 값을 갱신
        if (target != null) {
            articleRepository.save(articleEntity);
        }
        // 3. 수정 결과 페이지로 리다이렉트
        return "redirect:/articles/" + articleEntity.getId();

    }

    @GetMapping("/articles/{id}/delete")
    public String delete(@PathVariable Long id, RedirectAttributes rttr) {
        log.info("삭제 요청이 들어왔습니다!!");

        Article target = articleRepository.findById(id).orElse(null);
        
        // 댓글 있는 게시물 삭제 금지
        List Commentlist = commentService.commentdelete(id);
        if(Commentlist.size()>0){
            rttr.addFlashAttribute("msg","댓글이 있는 게시글은 삭제할 수 없습니다.");
            return "redirect:/articles/{id}";
        }
        else{
        if (target != null) {
            articleRepository.delete(target);
            rttr.addFlashAttribute("msg","삭제가 완료되었습니다.");
        }}
        // 3: 결과 페이지로 리다이렉트
        return "redirect:/articles";
    }

    @GetMapping("/")
    public String Login(Model model,HttpServletRequest request) {
        HttpSession session = request.getSession();
        SessionUser user = (SessionUser) session.getAttribute("user");

        if (user != null) {
            model.addAttribute("userName", user.getName());
        }
        return "/";
    }
}
