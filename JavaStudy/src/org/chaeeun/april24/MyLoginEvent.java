package org.chaeeun.april24;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyLoginEvent implements ActionListener {
	LoginSystem login;
	TotalSystem total;
	public MyLoginEvent(LoginSystem login,TotalSystem total) {
		this.login = login;
		this.total = total;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == login.login) {//로그인 버튼을 누른 경우
			//DB에 접속한 후, manager_info 테이블에서 계정과 암호를 찾는다.
			//찾은 계정과 암호를 비교한다.
			String id = login.id_txt.getText();//입력한 ID를 id에 저장
			String pwd = login.pwd_txt.getText();//입력한 pwd를 pwd에 저장
			
			UserIdPwd idPwd = new UserIdPwd();
			idPwd.setId(id);
			idPwd.setPwd(pwd);
			
			CRUDprocess crud = new CRUDprocess();
			ManagerInfo info = crud.selectIdAndPwd(idPwd);
			
			if(info == null) {//로그인 실패
				String title = "계정과 암호를 확인하세요.";
				//title을 윈도우의 제목으로 출력
				total.setTitle(title);
			}else {//로그인 성공
				String title = "환영합니다. "+id+"님!";
				total.card.show(total.total_panel, "fruit");
				//title을 윈도우의 제목으로 출력
				total.setTitle(title);
				login.id_txt.setText(" ");
				login.id_txt.setText("");
				login.pwd_txt.setText(" ");
				login.pwd_txt.setText("");
				//로그아웃시 로그인 화면에 계정과 비밀번호가 남겨져 있으면 안되기 때문에,
				//로그인 성공 후 과일 소개 화면으로 넘어가면서 로그인 화면에 입력되어 있는 계정 및 비밀번호는 지워준다.
			}
			
		}else if(obj == login.cancel) {//다시입력 버튼을 누른 경우
			//계정 텍스트필드와 암호 텍스트필드를 지운다.
			login.id_txt.setText(" ");//계정 텍스트필드를 지움
			login.id_txt.setText("");
			login.pwd_txt.setText(" ");//암호 텍스트필드를 지움
			login.pwd_txt.setText("");
		}
	}
	
}
