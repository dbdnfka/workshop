package com.Woo.Ram.mapper;

import com.Woo.Ram.model.BookVO;
import com.Woo.Ram.model.CateVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdminMapper {
    /* 상품 등록 */
    public void bookEnroll(BookVO book);
    /* 카테고리 리스트 */
    public List<CateVO> cateList();
}
