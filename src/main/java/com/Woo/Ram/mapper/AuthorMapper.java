package com.Woo.Ram.mapper;

import com.Woo.Ram.model.AuthorVO;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AuthorMapper {
    /* 작가 등록 */
    public void authorEnroll(AuthorVO author);
}
