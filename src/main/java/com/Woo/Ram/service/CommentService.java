package com.Woo.Ram.service;


import com.Woo.Ram.dto.CommentDto;
import com.Woo.Ram.entity.Article;
import com.Woo.Ram.entity.Comment;
import com.Woo.Ram.repository.ArticleRepository;
import com.Woo.Ram.repository.CommentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private ArticleRepository articleRepository;

    public List<CommentDto> comments(Long articleId) {
        return commentRepository.findByArticleId(articleId)
                .stream()
                .map(comment -> CommentDto.createCommentDto(comment))
                .collect(Collectors.toList());
    }

    @Transactional
    public CommentDto create(Long articleId, CommentDto dto) {

        //게시글 조회 및 예외 발생
        Article article = articleRepository.findById(articleId)
                .orElseThrow(() -> new IllegalArgumentException("댓글 생성 실패. 대상 게시글이 없습니다."));
        //댓글 엔티티 생성
        Comment comment = Comment.createComment(dto,article);
        //댓글 엔티티 DB로 저장
        Comment created = commentRepository.save(comment);

        //DTO로 변경하여 반환
        return CommentDto.createCommentDto(created);
    }

    @Transactional
    public CommentDto update(Long id, CommentDto dto) {
        // 댓글 조회 및 예외 발생
        Comment target = commentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("댓글 수정 실패. 대상 댓글이 없습니다."));
        // 댓글 수정
        target.patch(dto);
        // DB로 갱신
        Comment updated = commentRepository.save(target);
        // 댓글 엔티티를 DTO로 변환 및 반환
        return CommentDto.createCommentDto(updated);
    }

    @Transactional
    public CommentDto delete(Long id) {
        // 댓글 조회 및 예외 발생
        Comment target = commentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("댓글 삭제 실패. 대상이 없습니다."));
//        Comment target2 = commentRepository.findById()
        // 댓글 DB에서 삭제
        commentRepository.delete(target);
        // 삭제 댓글을 DTO로 반환
        return CommentDto.createCommentDto(target);
    }
    @Transactional
    public List<Comment> delete2(Long id) {
        // 댓글 조회 및 예외 발생

        List<Comment> target2 = commentRepository.findByArticleId(id);
        log.info(target2.toString());log.info(target2.toString());log.info(target2.toString());log.info(target2.toString());
//        Comment target = commentRepository.findById(id)
//                .orElseThrow(() -> new IllegalArgumentException("댓글 삭제 실패. 대상이 없습니다."));
//        Comment target2 = commentRepository.findById()
        // 댓글 DB에서 삭제

        // 삭제 댓글을 DTO로 반환
        return target2;
    }
}
