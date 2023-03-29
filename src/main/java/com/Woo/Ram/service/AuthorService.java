package com.Woo.Ram.service;

import com.Woo.Ram.model.AuthorVO;


public interface AuthorService {
    /* 작가 등록 */
    public void authorEnroll(AuthorVO author) throws Exception;
}
