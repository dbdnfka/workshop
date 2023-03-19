package com.Woo.Ram.repository;

import com.Woo.Ram.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    // 특정 게시글의 모든 댓글 조회
    @Query(value =
            "SELECT * " +
                    "FROM comment " +
                    "WHERE article_id = :articleId",
            nativeQuery = true)
    List<Comment> findByArticleId(Long articleId);
    List<Comment> findByNickname(String nickname);

//    @Modifying
//    @Transactional
//    @Query("select p from Comment where article= :AA")
//    List<Comment> deleteC(List AA);


}

