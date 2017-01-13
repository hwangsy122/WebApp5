package com.netsong7.web5.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.netsong7.web5.domain.Member;
import com.netsong7.web5.domain.RegisterRequest;
import com.netsong7.web5.exception.AlreadyExistingMemberException;
import com.netsong7.web5.persistence.MemberDao;

@Service
public class MemberRegisterService {
	@Autowired
	private MemberDao memberDao;
	
	public MemberRegisterService(){}
	public MemberRegisterService(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

	@Transactional
	public void regist(RegisterRequest req) {
		Member member = memberDao.selectByEmail(req.getEmail());
		if (member != null) {
			throw new AlreadyExistingMemberException("dup email " + req.getEmail());
		}
		Member newMember = new Member(
				req.getEmail(), req.getPassword(), req.getName(),
				new Date());
		memberDao.insert(newMember);
	}
}
