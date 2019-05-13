package org.chaeeun.may13;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class CRUDprocess {
//이 클래스의 목적 : MyBatis의 매퍼를 호출한다.
//무슨일을 하나?
//1. MyBatis 환경설정파일을 읽는다.
//2. 위의 1의 작업으로 매퍼를 호출할 객체(SqlSession)를 생성한다.
//특이사항 : --> SqlSession은 SqlSessionFactory가 생성한다.
//	         --> SqlSessionFactory는 SqlSessionFactoryBuilder가 생성한다.
	
/////////////////////SqlSession을 만드는 메서드//////////////////////
	private SqlSession getSession() {
		String path = "chaeeun/mybatis_config.xml";//환경설정파일의 경로
		InputStream is = null;//파일의 내용을 읽을 객체
		//파일프로그램(네트워크,DB연동,스레드)은 반드시 예외처리를 해야한다.
		try {
			is = Resources.getResourceAsStream(path);//파일마다 InputStream을 생성하는 방식이 틀림(XML파일-->Resources)
		}catch(Exception e) {//Exception은 모든 예외의 조상클래스
			System.out.println("환경설정 파일을 읽는 중 예외발생");
		}//예외처리
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		SqlSessionFactory factory = builder.build(is);//factory를 생성할때 환경설정 파일의 경로가 필요.
		SqlSession session = factory.openSession();
		return session;
	}
	
	public List<Customer_info> SelectCusInfo() {
		SqlSession s = getSession();
		List<Customer_info> info = null;
		try {
			info = s.selectList("loginmapper.SelectCusInfo");
			return info;
		}finally {
			s.close();
		}
	}

	public List<EmpInfo> SelectEmpInfo(){
		SqlSession s = getSession();
		List<EmpInfo> info = null;
		try {
			info = s.selectList("loginmapper.SelectEmpInfo");
			return info;
		}finally {
			s.close();
		}
	}
	
	public List<ItemInfo> SelectItemImfo(){
		SqlSession s = getSession();
		List<ItemInfo> info = null;
		try {
			info = s.selectList("loginmapper.SelectItemImfo");
			return info;
		}finally {
			s.close();
		}
	}
	
	public List<ItemInfo> SelectItemInfoCondition(Map<String,Object> condition){
		SqlSession s = getSession();
		List<ItemInfo> info = null;
		try {
			info = s.selectList("loginmapper.SelectItemInfoCondition",condition);
			return info;
		}finally {
			s.close();
		}
	}
}
