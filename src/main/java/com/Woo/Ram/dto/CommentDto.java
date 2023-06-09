package com.Woo.Ram.dto;

import com.Woo.Ram.entity.Article;
import com.Woo.Ram.entity.Comment;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.ManyToOne;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class CommentDto {
    private  Long id;

    @JsonProperty("article_id")
    private  Long articleId;
    private  String nickname;
    private  String body;

    public void setNickname(String nickname){
        this.nickname=nickname;

    }

    public static CommentDto createCommentDto(Comment comment) {
        return new CommentDto(
                comment.getId(),
                comment.getArticle().getId(),
                comment.getNickname(),
                comment.getBody()


        );
    }
}
