package com.Woo.Ram.dto;

import com.Woo.Ram.entity.Article;
import lombok.AllArgsConstructor;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@AllArgsConstructor
@ToString
public class ArticleForm {

    private Long id;

    private String title;
    private String content;

    public Article toEntity() {
        return new Article(id, title, content);
    }
}
