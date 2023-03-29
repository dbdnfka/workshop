package com.Woo.Ram.service;

import com.Woo.Ram.mapper.AuthorMapper;
import com.Woo.Ram.model.AuthorVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImpl implements AuthorService{
    @Autowired

    AuthorMapper authorMapper;
    @Override
    public void authorEnroll(AuthorVO author) throws Exception {

        authorMapper.authorEnroll(author);

    }
}
