package com.Woo.Ram.service;

import com.Woo.Ram.mapper.AdminMapper;
import com.Woo.Ram.model.BookVO;
import com.Woo.Ram.model.CateVO;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class AdminServiceImpl implements AdminService{
    @Autowired
    private AdminMapper adminMapper;

    /* 상품 등록 */
    @Override
    public void bookEnroll(BookVO book) {

        log.info("(srevice)bookEnroll........");

        adminMapper.bookEnroll(book);

    }
    /* 카테고리 리스트 */
    @Override
    public List<CateVO> cateList() {

        log.info("(service)cateList........");

        return adminMapper.cateList();
    }
}
