package com.Woo.Ram.model;

import com.Woo.Ram.dto.CommentDto;
import com.Woo.Ram.entity.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class AuthorVO {

    /* 작가 아이디 */
    private int authorId;

    /* 작가 이름 */
    private String authorName;

    public void setNationId(String nationId) {
        this.nationId = nationId;
        if(nationId.equals("01")) {
            this.nationName = "국내";
        } else {
            this.nationName = "국외";
        }
    }

    /* 국가 id */
    private String nationId;

    /* 작가 국가 */
    private String nationName;


    /* 작가 소개 */
    private String authorIntro;

    /*등록 날짜*/
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private LocalDate regDate;


    /* 수정 날짜 */
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private LocalDate updateDate;
    public String getAuthorName() {
        return authorName;
    }
    public String getNationId() {
        return nationId;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }
    public String getNationName() {
        return nationName;
    }

    public void setNationName(String nationName) {
        this.nationName = nationName;
    }

    public String getAuthorIntro() {
        return authorIntro;
    }

    public void setAuthorIntro(String authorIntro) {
        this.authorIntro = authorIntro;
    }
    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }


}
