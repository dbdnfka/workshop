package com.Woo.Ram.model;

import com.Woo.Ram.entity.Date;

public class AuthorVO {
    /* 작가 아이디 */
    private int authorId;

    /* 작가 이름 */
    private String authorName;

    /* 국가 id */
    private String nationId;

    /* 작가 국가 */
    private String nationName;

    /* 작가 소개 */
    private String authorIntro;

    /*등록 날짜*/
    private Date regDate;

    /* 수정 날짜 */
    private Date updateDate;

    public int getAuthorId(){
        return authorId;
    }
    public void setAuthorId(int authorId){
        this.authorId = authorId;
    }

    public String getAuthorName(){
        return  authorName;
    }
    public  void setAuthorName(String authorName){
        this.authorName = authorName;
    }
    public  String getNationId(){
        return nationId;
    }
}
