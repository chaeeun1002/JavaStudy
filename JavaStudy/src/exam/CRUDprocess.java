package exam;

import java.io.InputStream;

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
		String path = "org.chaeeun.exam/mybatis_config.xml";//환경설정파일의 경로
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
	
//화면에서 입력한 아이디와 패스워드를 사용해서 쿼리를 실행하는 메서드//
	public ManagerInfo selectIdAndPwd(UserIdPwd uip){//mapper의 resultType 클래스 리턴	
		SqlSession s = getSession();
		try {
			ManagerInfo info = s.selectOne("loginmapper.SelectIdAndPwd",uip);//매퍼이름.매퍼의 쿼리 이름
			//selectOne : 검색결과가 1건일 때 사용하는 메서드
			//selectList : 검색결과가 여러건일 때 사용하는 메서드
			return info;
		//catch는 mybatis 자체에서 수행
		}finally {//예외발생 여부에 상관없이 반드시 처리해야 할 작업 수행
			s.close();//실행중인 모든 프로그램 종료
		}
	}//DB의 manager_info테이블의 ID와 암호를 찾아서 리턴
	
	public Integer insertIntoItemInfo(ItemInfo info) {
		//insert는 삽입 성공시 1, 실패시 -1을 리턴하므로 Integer타입 리턴 메서드를 생성한다.
		SqlSession s = getSession();
		int result = -1;
		try {
			result = s.insert("loginmapper.insertIntoItemInfo", info);
			if(result > 0) {
				s.commit();
			}else {
				s.rollback();
			}
			return result;
		}finally {
			s.close();
		}
	}
	
	public Integer insertIntoEmpInfo(EmpInfo info) {
		SqlSession s = getSession();
		int result = -1;
		try {
			result = s.insert("loginmapper.insertIntoEmpInfo", info);
			if(result > 0) {
				s.commit();
			}else {
				s.rollback();
			}
			return result;
		}finally {
			s.close();
		}
	}
	
	public ItemInfo SelectItemCode(String code) {//중복된 상품코드를 찾는 메서드
		SqlSession s = getSession();
		ItemInfo info = null;
		try {
			info = s.selectOne("loginmapper.SelectItemCode", code);
			return info;
		}finally {
			s.close();
		}
	}
	
	public EmpInfo SelectEmpId(String id) {
		SqlSession s = getSession();
		EmpInfo info = null;
		try {
			info = s.selectOne("loginmapper.SelectEmpId", id);
			return info;
		}finally {
			s.close();
		}
	}
	
	public Integer deleteItemByCode(String code) {
		SqlSession s = getSession();
		int result = -1;
		try {
			result = s.delete("loginmapper.deleteItemByCode", code);
			if(result > 0) {
				s.commit();
			}else {
				s.rollback();
			}
			return result;
		}finally {
			s.close();
		}
	}
	
	public Integer updateItemByCode(ItemInfo info) {
		SqlSession s = getSession();
		int result = 0;
		try {
			result = s.update("loginmapper.updateItemByCode", info);
			if(result > 0) {
				s.commit();
			}else {
				s.rollback();
			}
			return result;
		}finally {
			s.close();
		}
	}
}
