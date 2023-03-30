package com.Woo.Ram.service;

import com.Woo.Ram.mapper.AuthorMapper;
import com.Woo.Ram.model.AuthorVO;

import com.Woo.Ram.model.Criteria;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class AuthorServiceImpl implements AuthorService{
    @Autowired

    AuthorMapper authorMapper;
    @Override
    public void authorEnroll(AuthorVO author) throws Exception {

        authorMapper.authorEnroll(author);

    }
    /* 작가 목록 */
    @Override
    public List<AuthorVO> authorGetList(Criteria cri, Pageable pageable) throws Exception {

        return authorMapper.authorGetList(cri);
    }
    /* 작가 총 수 */
    @Override
    public int authorGetTotal(Criteria cri) throws Exception {
        log.info("(service)authorGetTotal()......." + cri);
        return authorMapper.authorGetTotal(cri);
    }
}
