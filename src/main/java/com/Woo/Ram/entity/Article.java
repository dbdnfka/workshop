package com.Woo.Ram.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity // DB가 해당 객체를 인식 가능
@AllArgsConstructor
@NoArgsConstructor //디폴트 생성자 추가
@ToString
@Getter

public class Article {

    @Id //대표값을 지정 주민등록번호
    @GeneratedValue(strategy = GenerationType.IDENTITY) // DB가 id를 자동 생성 어노테이션

    private Long id;

    @Column
    private String title;
    @Column
    private String content;

    public void patch(Article article) {
        if (article.title != null)
            this.title = article.title;
        if (article.content != null)
            this.content = article.content;
    }

}
