package com.netsong7.web5.persistence;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Repository;

import com.netsong7.web5.domain.Member;
import com.netsong7.web5.mybatis.MemberManager;

@Repository
public class LoginDaoImpl {
	public Member getIdPw(Member member, HttpServletRequest req){
		Member mem = MemberManager.getIdPw(member, req);
		return mem;
	}
}
