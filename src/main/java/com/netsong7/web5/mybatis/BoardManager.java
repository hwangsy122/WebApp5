package com.netsong7.web5.mybatis;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class BoardManager {
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
	
	public static List getList(){
		List list = null;
		SqlSession session = sqlSessionFactory.openSession();
		list = session.selectList("getList");
		return list;
	}
}






