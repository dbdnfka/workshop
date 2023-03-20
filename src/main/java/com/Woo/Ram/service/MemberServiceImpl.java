package com.Woo.Ram.service;

import com.Woo.Ram.mapper.MemberMapper;
import com.Woo.Ram.model.MemberVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MemberServiceImpl implements MemberService{
    @Autowired
    MemberMapper membermapper;

    @Override
    public void memberJoin(MemberVO member) throws Exception{
        membermapper.memberJoin(member);
    }

    @Override
    public int idCheck(String memberId) throws Exception {

        return membermapper.idCheck(memberId);
    }
}
