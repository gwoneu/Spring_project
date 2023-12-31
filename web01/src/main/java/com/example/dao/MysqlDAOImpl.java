package com.example.dao;

import org.apache.ibatis.session.SqlSession; //SqlSession import
import org.springframework.beans.factory.annotation.Autowired; //Autowired import
import org.springframework.stereotype.Repository; //Repository import

@Repository
public class MysqlDAOImpl implements MysqlDAO {
	//MySqlDAO를 구현한 구현체
	
	@Autowired //자동으로 주입
	SqlSession session; //SqlSession을 session에 주입
	String namespace="com.example.mapper.MysqlMapper";
	
	@Override
	public String now() {
		return session.selectOne(namespace + ".now"); //하나를 가져올때 (여러개는 list)
	}
}
