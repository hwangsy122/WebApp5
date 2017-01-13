package com.netsong7.web5.mybatis;

import java.io.Reader;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.web.util.WebUtils;

import com.netsong7.web5.domain.Board;
import com.netsong7.web5.domain.Member;

public class MemberManager {
	private static SqlSessionFactory sqlSessionFactory;
	
	static{
		try{
			Reader reader = 
				Resources.getResourceAsReader("com/netsong7/web5/mybatis/mybatis_config.xml");
			sqlSessionFactory = 
					new SqlSessionFactoryBuilder().build(reader);
		}
		catch(Exception err){
			throw new RuntimeException("SqlSessionFactory 인스턴스 생성 실패 : " + err);
		}
	}
	
	public static Member getIdPw(Member member, HttpServletRequest req){
		Member mem = null;
		SqlSession session = sqlSessionFactory.openSession();
		mem = session.selectOne("getIdPw", member);
		
		if(mem != null){
			WebUtils.setSessionAttribute(req, "USER_EMAIL", mem.getEmail());
			return mem;
		}
		else{
			return null;
		}
	}
}






