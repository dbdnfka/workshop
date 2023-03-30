package com.Woo.Ram.service;

import com.Woo.Ram.model.AuthorVO;
import com.Woo.Ram.model.Criteria;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface AuthorService {
    /* 작가 등록 */
    public void authorEnroll(AuthorVO author) throws Exception;
    /* 작가 목록 */
    public List<AuthorVO> authorGetList(Criteria cri, Pageable pageable) throws Exception;
    /* 작가 총 수 */
    public int authorGetTotal(Criteria cri) throws Exception;
}
