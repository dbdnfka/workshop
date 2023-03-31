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
    public List<AuthorVO> authorGetList(Criteria cri) throws Exception {

        return authorMapper.authorGetList(cri);
    }
    /* 작가 총 수 */
    @Override
    public int authorGetTotal(Criteria cri) throws Exception {
        log.info("(service)authorGetTotal()......." + cri);
        return authorMapper.authorGetTotal(cri);
    }
    /* 작가 상세 페이지 */
    @Override
    public AuthorVO authorGetDetail(int authorId) throws Exception {
        log.info("authorGetDetail........" + authorId);
        return authorMapper.authorGetDetail(authorId);
    }
    /* 작가 정보 수정 */
    @Override
    public int authorModify(AuthorVO author) throws Exception {
        log.info("(service) authorModify........." + author);
        return authorMapper.authorModify(author);
    }
}
