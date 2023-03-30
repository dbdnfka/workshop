package com.Woo.Ram.mapper;

import com.Woo.Ram.model.AuthorVO;

import com.Woo.Ram.model.Criteria;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AuthorMapper {
    /* 작가 등록 */
    public void authorEnroll(AuthorVO author);

    public List<AuthorVO> authorGetList(Criteria cri);
    /* 작가 총 수 */
    public int authorGetTotal(Criteria cri);

}
