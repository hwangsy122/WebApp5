package com.netsong7.web5.service;

import org.springframework.transaction.annotation.Transactional;

import com.netsong7.web5.domain.Member;
import com.netsong7.web5.exception.MemberNotFoundException;
import com.netsong7.web5.persistence.MemberDao;

public class ChangePasswordService {

	private MemberDao memberDao;

	public ChangePasswordService(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

	@Transactional
	public void changePassword(String email, String oldPwd, String newPwd) {
		Member member = memberDao.selectByEmail(email);
		if (member == null)
			throw new MemberNotFoundException();
		
		member.changePassword(oldPwd, newPwd);
		
		memberDao.update(member);
	}
}
