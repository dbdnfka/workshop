package com.Woo.Ram.dto;

import com.Woo.Ram.entity.Article;
import lombok.AllArgsConstructor;
import lombok.ToString;
import com.Woo.Ram.entity.Comment;

import javax.persistence.CascadeType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@ToString
public class ArticleForm {

    private Long id;

    private String title;
    private String content;
    private String writer;
    public String getWriter(){
        return writer;
    }
    public  void setWriter(String writer){
        this.writer=writer;
    }

    public Article toEntity() {
        return new Article(id, title, content,writer);
    }

}
