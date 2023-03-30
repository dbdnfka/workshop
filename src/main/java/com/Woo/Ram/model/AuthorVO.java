package com.Woo.Ram.model;

import com.Woo.Ram.entity.Date;

public class AuthorVO {
    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    /* 작가 아이디 */
    private int authorId;

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    /* 작가 이름 */
    private String authorName;

    public void setNationId(String nationId) {
        this.nationId = nationId;
    }

    public String getNationId() {
        return nationId;
    }

    /* 국가 id */
    private String nationId;

    /* 작가 국가 */
    private String nationName;

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

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    /* 작가 소개 */
    private String authorIntro;

    /*등록 날짜*/
    private Date regDate;

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /* 수정 날짜 */
    private Date updateDate;


}
