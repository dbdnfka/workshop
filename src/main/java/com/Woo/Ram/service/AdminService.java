package com.Woo.Ram.service;

import com.Woo.Ram.model.BookVO;
import com.Woo.Ram.model.CateVO;

import java.util.List;

public interface AdminService {
    /* 상품 등록 */
    public void bookEnroll(BookVO book);
    /* 카테고리 리스트 */
    public List<CateVO> cateList();
}
