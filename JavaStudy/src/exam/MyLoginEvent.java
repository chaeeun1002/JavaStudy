package exam;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

//다이얼로그를 띄워서 로그인 성공 여부를 확인.

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
//				String title = "계정과 암호를 확인하세요.";
//				title을 윈도우의 제목으로 출력
//				total.setTitle(title);
				JOptionPane.showMessageDialog(total, "ID와 암호를 확인하세요.");//swing컴포넌트 사용
			}else {//로그인 성공
//				String title = "환영합니다. "+id+"님!";
//				title을 윈도우의 제목으로 출력
//				total.setTitle(title);
				JOptionPane.showMessageDialog(total, "로그인되었습니다.");
				total.card.show(total.total_panel, "background");
				login.id_txt.setText(" ");
				login.id_txt.setText("");
				login.pwd_txt.setText(" ");
				login.pwd_txt.setText("");
				total.menu_logout.setEnabled(true);
				total.menu_fruit.setEnabled(true);
				total.menu_drink.setEnabled(true);
				total.menu_item.setEnabled(true);
				total.menu_home.setEnabled(true);
				total.menu_emp.setEnabled(true);
				total.menu_chart.setEnabled(true);
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
